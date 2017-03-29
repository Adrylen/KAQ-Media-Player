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
		this.playlistPanel = new PlaylistPanel(this.width, this.height / 4);
	}

	public void create() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.add(this.playlistPanel, BorderLayout.SOUTH);

		this.setSize(this.width, this.height);
		this.setVisible(true);
	}
}
