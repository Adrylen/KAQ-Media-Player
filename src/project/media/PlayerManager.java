/*
 *   Java Project
 *   Project
 *   Package : project.media
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.media;

import lombok.Getter;
import lombok.Setter;
import project.window.MainFrame;
import project.window.panels.MediaPanel;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class PlayerManager {
	private static PlayerManager instance;

	@Getter
	@Setter
	private MediaPanel activeMediaPanel;

	@Getter
	private MediaComponent mediaComponent;

	public PlayerManager setMediaComponent(String file) {
		if(mediaComponent != null) {
			mediaComponent.remove(mediaComponent);
		}
		mediaComponent = new MediaComponent(file);
		activeMediaPanel.add(mediaComponent, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());

		return this;
	}

	public static PlayerManager getInstance() {
		if(instance == null) {
			instance = new PlayerManager();
		}
		return instance;
	}
}
