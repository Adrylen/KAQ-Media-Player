/*
 *   Java Project
 *   Project
 *   Package : project.window.panels
 *   Created by adrylen on 27/03/17.
*/

package project.window.panels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class PlaylistPanel extends JPanel {
	public PlaylistPanel(int width, int height) {
		int nb = 10;
		this.setLayout(new GridLayout(nb,1, 0, -1));
		for(int i = 0; i < nb; ++i) {
			JPanel panel = new JPanel();
			panel.add(new JLabel("Test : "+i));
			panel.setSize(new Dimension(width, 20));
			panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			this.add(panel);
		}
		this.setAutoscrolls(true);
	}
}