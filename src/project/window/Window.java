/*
 *   Java Project
 *   Project
 *   Package : project.window
 *   Created by adrylen on 27/03/17.
*/

package project.window;

import project.window.panels.PlaylistPanel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame {
	private PlaylistPanel playlistPanel;
	private String title = "Player";
	private int width;
	private int height;

	public Window(String title, int width, int height) {
		super(title);
		this.title = title;
		this.width = width;
		this.height = height;
		this.playlistPanel = new PlaylistPanel(this.width / 4, this.height);
	}

	public void create() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JScrollPane playlist = new JScrollPane(this.playlistPanel,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		);
		playlist.setPreferredSize(new Dimension(this.width / 4, this.height));

		this.add(playlist, BorderLayout.WEST);

		this.setSize(this.width, this.height);
		this.setVisible(true);
	}
}
