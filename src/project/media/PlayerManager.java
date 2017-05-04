package project.media;

import lombok.Getter;
import project.media.files.PathFile;
import project.window.panels.MediaPanel;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class PlayerManager {
	private JFrame frame;
	private MediaPanel mediaPanel;
	private @Getter MediaComponent mediaComponent;

	public PlayerManager(JFrame frame, MediaPanel mediaPanel) {
		this.frame = frame;
		this.mediaPanel = mediaPanel;
	}

	public PlayerManager setMediaComponent(PathFile pathFile) {
		return this.setMediaComponent(pathFile.getPath());
	}

	public PlayerManager setMediaComponent(String file) {
		if(this.mediaComponent != null) {
			this.mediaComponent.remove(this.mediaComponent);
		}
		this.mediaComponent = new MediaComponent(file).setMediaPanel(frame);
		this.mediaPanel.add(this.mediaComponent, BorderLayout.CENTER);
		return this;
	}

/*	public MediaComponent getMediaComponent() {
		return this.mediaComponent;
	}*/
}
