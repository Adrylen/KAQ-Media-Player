package project.window.panels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PlaylistPanel extends JPanel {
	public PlaylistPanel(int width, int height) {
		GridBagConstraints placement = new GridBagConstraints();
		placement.anchor = GridBagConstraints.FIRST_LINE_START;
		placement.weighty = 1;

		int nb = 10;
		this.setLayout(new GridBagLayout());
		for(int i = 0; i < nb; ++i) {
			JPanel panel = new JPanel();
			panel.add(new JLabel("Test : "+i));
			placement.gridy = i;
			panel.setPreferredSize(new Dimension(width-2, 60));
			panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			this.add(panel, placement);
		}
		this.setAutoscrolls(true);
	}
}