/*
 *   Java Project
 *   Project
 *   Package : project.window.menus
 *   Created by AdrienMartinez on 09/05/2017.
*/

package project.window.menus;

import project.media.PlayerManager;
import project.media.files.MediaFilter;
import project.utils.console;
import project.window.MainFrame;
import project.window.panels.ControlBar;
import project.window.panels.buttons.ButtonController;
import project.window.panels.buttons.MenuController;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;

public class MediaMenu extends JMenu {
	private static MediaMenu instance;

	private MediaMenu(String title) {
		super(title);
	}

	public MediaMenu create() {
		openFileMenuItem();
		quitMenuItem();
		return this;
	}

	private void openFileMenuItem() {
		add(new MenuController("Ouvrir un fichier").addListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());

				fileChooser.setFileFilter(new MediaFilter("MPEG-4 File", ".mp4"));

				fileChooser.showOpenDialog(null);
				if(fileChooser.getSelectedFile() != null) {
					ControlBar.getInstance().updateNewMediaComponent();

					PlayerManager.getInstance().setMediaComponent(fileChooser.getSelectedFile().getAbsolutePath());
					PlayerManager.getInstance().getMediaComponent().play();
				}
			}
		}));
	}

	private void quitMenuItem() {
		add(new MenuController("Quitter").addListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().dispose();
			}
		}));
	}

	public static MediaMenu getInstance() {
		if(instance == null) {
			instance = new MediaMenu("Media");
		}
		return instance;
	}
}
