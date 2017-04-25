/*
 *   Java Project
 *   Project
 *   Package : project.media
 *   Created by adrylen on 06/04/17.
*/

package project.media;

import project.path.PathFile;
import project.window.panels.MediaPanel;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class PlayerManager {
	private JFrame frame;
	private MediaPanel mediaPanel;
	private MediaComponent mediaComponent;

	public PlayerManager(JFrame frame, MediaPanel mediaPanel) {
		this.frame = frame;
		this.mediaPanel = mediaPanel;
	}

	public void newComponent(PathFile pathFile) {
		this.mediaComponent = new MediaComponent(pathFile.getPath()).setMediaPanel(frame);
		this.mediaPanel.add(this.mediaComponent, BorderLayout.CENTER);
		this.mediaComponent.play();
	}
}
