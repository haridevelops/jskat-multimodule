/**
 * This file is part of JSkat.
 *
 * JSkat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JSkat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JSkat.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jskat.gui.swing;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import org.jskat.data.JSkatOptions;

public class JSkatMainFrameComponentAdapter extends ComponentAdapter {

	@Override
	public void componentResized(ComponentEvent e) {
		JSkatOptions.instance().setMainFrameSize(e.getComponent().getSize());
	}
	
	@Override
	public void componentMoved(ComponentEvent e) {
		JSkatOptions.instance()
				.setMainFramePosition(e.getComponent().getLocationOnScreen());
	}
}
