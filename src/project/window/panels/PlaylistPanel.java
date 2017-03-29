/*
 *   Java Project
 *   Project
 *   Package : project.window.panels
 *   Created by adrylen on 27/03/17.
*/

package project.window.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class PlaylistPanel extends JScrollPane {
	public PlaylistPanel(int width, int height) {
		JPanel pane = new JPanel();
		pane.add(new JLabel("Test"));
		for(int i = 0; i < 10; ++i) {
			this.add(pane);
		}
		this.setPreferredSize(new Dimension(width, height));
	}
}