/*

@ShortLicense@

Authors: @JS@
         @MJL@

Released: @ReleaseDate@

 */

package jskat.gui.main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Special table cell renderer for the score table
 */
public class ScoreTableCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 361464758473283201L;

	/**
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		if (row % 6 < 3) {

			setBackground(new Color(255, 255, 200));
		} 
		else {

			setBackground(Color.WHITE);
		}

		if (value.toString() == "-") {

			setHorizontalAlignment(CENTER);
		} 
		else {

			setHorizontalAlignment(RIGHT);
		}

		setValue(value);

		return this;
	}
}
