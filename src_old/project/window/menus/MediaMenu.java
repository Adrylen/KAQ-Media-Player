package project.window.menus;

import project.media.files.MediaFilter;
import project.window.MainFrame;
import project.window.panels.SouthBar;
import project.window.panels.buttons.ControlMenu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MediaMenu extends JMenu{
	private MainFrame window;

	public MediaMenu(MainFrame window, String str){
        super(str);
        this.window = window;

        openFile();
        openFiles();
        quitItem();
	}

	private void openFile() {
		JMenuItem item = new ControlMenu("Ouvrir un fichier");
		item.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
				fileChooser.setFileFilter(new MediaFilter("MPEG-4 File", ".mp4"));
				fileChooser.showOpenDialog(null);
				if(fileChooser.getSelectedFile() != null) {
					window.getPlayerManager().setMediaComponent(fileChooser.getSelectedFile().getAbsolutePath());
					SwingUtilities.updateComponentTreeUI(window);
					((SouthBar)window.getSouthBar()).getPlay().switchIcon();
					window.getPlayerManager().getMediaComponent().play();
				}
			}
		});
		this.add(item);
	}

	private void openFiles() {
		JMenuItem item = new ControlMenu("Ouvrir plusieurs fichiers");
		this.add(item);
	}

	private void quitItem() {
		JMenuItem item = new ControlMenu("Quitter");
		item.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				window.dispose();
			}
		});
		this.add(item);
	}
}
