/**
 * This file is part of JSkat.
 * <p>
 * JSkat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * JSkat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with JSkat.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jskat.gui.javafx.dialog.firststeps.model;

import org.jskat.AbstractJSkatTest;
import org.jskat.data.JSkatOptions;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FirstStepsDialogModelTest extends AbstractJSkatTest {
    @Test
    public void testModelOnStartUp() {
        final FirstStepsDialogModel model = new FirstStepsDialogModel();
        assertThat(model.isShowTipsOnStartUp.getValue(), is(JSkatOptions.instance().isShowTipsOnStartUp()));
    }
}
