package project.window.panels;

import project.window.MainFrame;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PlaylistPanel extends JPanel {
	private boolean isVisible;
	private JScrollPane playlistScrollPane;
	private MainFrame mainFrame;

	public PlaylistPanel(int width, int height) throws IOException {
		this.add(new JButton(new AbstractAction("Add to playlist") {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		}));
		GridBagConstraints placement = new GridBagConstraints();
		placement.anchor = GridBagConstraints.FIRST_LINE_START;
		placement.weighty = 1;
		this.isVisible = false;

//		int nb = 10;
//		this.setLayout(new GridBagLayout());
//		for(int i = 0; i < nb; ++i) {
//                        PlaylistFilePanel panel = new PlaylistFilePanel(width, i, nb);
//			placement.gridy = i;
//			this.add(panel, placement);
//		}
		this.setAutoscrolls(true);
	}

	public void togglePanel() {
		if(this.isVisible = !this.isVisible) {
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