/**
 * Copyright (C) 2018 Jan Schäfer (jansch@users.sourceforge.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jskat.ai.nn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.jskat.control.JSkatEventBus;
import org.jskat.control.command.table.CreateTableCommand;
import org.jskat.data.JSkatViewType;
import org.jskat.util.CardList;
import org.jskat.util.GameType;
import org.jskat.util.Player;

/**
 * Simulates games for {@link AIPlayerNN}
 */
class GameSimulator {

	Map<GameType, GameSimulationThread> simThreads;

	GameSimulator() {
		simThreads = new HashMap<GameType, GameSimulationThread>();
	}

	void resetGameSimulator(List<GameType> gameTypes, Player playerPosition, CardList playerCards) {
		resetGameSimulator(gameTypes, playerPosition, playerCards, new CardList());
	}

	void resetGameSimulator(List<GameType> gameTypes, Player playerPosition, CardList playerCards, CardList skatCards) {

		simThreads.clear();
		for (GameType gameType : gameTypes) {
			simThreads.put(gameType, new GameSimulationThread(gameType, playerPosition, playerCards, skatCards));
			JSkatEventBus.INSTANCE.post(new CreateTableCommand(JSkatViewType.TRAINING_TABLE, "SIM" + gameType.name()));
		}
	}

	SimulationResults simulateMaxEpisodes(Long maxEpisodes) {

		SimulationResults results = new SimulationResults();

		List<CompletableFuture<Void>> futures = new ArrayList<>();
		for (GameSimulationThread thread : simThreads.values()) {

			futures.add(CompletableFuture.runAsync(() -> thread.startSimulationWithMaxEpidodes(maxEpisodes)));
		}

		CompletableFuture<Void> combinedFuture = CompletableFuture
				.allOf(futures.toArray(new CompletableFuture[futures.size()]));
		try {
			combinedFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (GameSimulationThread thread : simThreads.values()) {
			results.setWonRate(thread.getGameType(), thread.getWonRate());
		}

		return results;
	}
}
