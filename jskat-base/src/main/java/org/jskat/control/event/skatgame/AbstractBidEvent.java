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

import java.util.Objects;

import org.jskat.data.SkatGameData;
import org.jskat.util.Player;

public abstract class AbstractBidEvent extends AbstractPlayerMoveEvent {

	public final Integer bid;

	public AbstractBidEvent(Player player, Integer bid) {
		super(player);
		this.bid = bid;
	}

	@Override
	public final void processForward(SkatGameData data) {
		data.addPlayerBid(player, bid);
	}

	@Override
	public final void processBackward(SkatGameData data) {
		data.removeLastPlayerBid(player);
	}

	@Override
	protected final String getMoveDetails() {
		return bid.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bid);
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
		final AbstractBidEvent other = (AbstractBidEvent) obj;
		
		return Objects.equals(bid, other.bid);
	}
}