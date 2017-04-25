/*
 *   Java Project
 *   Project
 *   Package : project.window
 *   Created by adrylen on 27/03/17.
*/

package project.window;

import project.window.panels.NorthMenu;
import project.window.panels.PlaylistPanel;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame {
	private JMenuBar menus, actions;
	private JScrollPane playlistPanel;
	private String title = "Player";
	private int width;
	private int height;

	public Window(String title, int width, int height) {
		super(title);

		this.playlistPanel = new JScrollPane(
			new PlaylistPanel(this.width / 4, this.height),
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		);

//		this.menus = new NorthMenu(this);
		//this.actions = new SouthBar();

		this.title = title;
		this.width = width;
		this.height = height;
	}

	public Window init() {
		this.playlistPanel.setPreferredSize(new Dimension(this.width / 4, this.height));

		return this;
	}

	public Window create() {
		this.setTitle(this.title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.add(this.playlistPanel, BorderLayout.WEST);
		this.add(this.menus, BorderLayout.NORTH);
		//this.add(this.actions, BorderLayout.SOUTH);

		this.setSize(this.width, this.height);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);

		return this;
	}
}
