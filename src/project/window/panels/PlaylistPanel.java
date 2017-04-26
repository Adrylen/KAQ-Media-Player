package project.window.panels;

import project.window.MainFrame;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PlaylistPanel extends JPanel {
	private boolean visible;
	private JScrollPane playlistScrollPane;
	private MainFrame mainFrame;

	public PlaylistPanel(int width, int height) {
		GridBagConstraints placement = new GridBagConstraints();
		placement.anchor = GridBagConstraints.FIRST_LINE_START;
		placement.weighty = 1;
		this.visible = false;

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

	public void togglePanel() {
		if(this.visible = !this.visible) {
			this.mainFrame.add(this.playlistScrollPane, BorderLayout.WEST);
		} else {
			this.mainFrame.remove(this.playlistScrollPane);
		}
		SwingUtilities.updateComponentTreeUI(this.mainFrame);
	}

	public PlaylistPanel attachParentPane(JScrollPane playlistScrollPane) {
		this.playlistScrollPane = playlistScrollPane;
		return this;
	}

	public void attachWindow(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}