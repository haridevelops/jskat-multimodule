/**
 * Copyright (C) 2019 Jan Schäfer (jansch@users.sourceforge.net)
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
package org.jskat.control.event.skatgame;

import org.jskat.data.SkatGameData;
import org.jskat.util.Player;

/**
 * Event for passing a bid.
 */
public final class PassBidEvent extends AbstractPlayerMoveEvent {

	public PassBidEvent(Player player) {
		super(player);
	}

	@Override
	public final void processForward(SkatGameData data) {
		data.setPlayerPass(player, true);
	}

	@Override
	public final void processBackward(SkatGameData data) {
		data.setPlayerPass(player, false);
	}

	@Override
	protected String getMoveDetails() {
		return "pass";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;			
		}
		if (!super.equals(obj)) {
			return false;			
		}
		if (getClass() != obj.getClass()) {
			return false;			
		}
		return true;
	}
}
