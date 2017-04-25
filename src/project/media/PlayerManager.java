package project.media;

import project.media.files.PathFile;
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

	public void setMediaComponent(PathFile pathFile) {
		if(this.mediaComponent != null) {
			this.mediaComponent.remove(this.mediaComponent);
		}
		this.mediaComponent = new MediaComponent(pathFile.getPath()).setMediaPanel(frame);
		this.mediaPanel.add(this.mediaComponent, BorderLayout.CENTER);
	}

	public MediaComponent getMediaComponent() {
		return this.mediaComponent;
	}
}
