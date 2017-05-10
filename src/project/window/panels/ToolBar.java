package project.window.panels;

import project.window.menus.MediaMenu;

import javax.swing.JMenuBar;

public class ToolBar extends JMenuBar {
	private static ToolBar instance;

	private ToolBar() {
		super();
	}

	public ToolBar create() {
		add(MediaMenu.getInstance().create());

		return this;
	}

	public static ToolBar getInstance() {
		if(instance == null) {
			instance = new ToolBar();
		}
		return instance;
	}
}