package project.media;

import project.window.panels.MediaPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lombok.Getter;

public class PlayerManager {
	private JFrame frame;
	private MediaPanel mediaPanel;
	private @Getter MediaComponent mediaComponent;

	public PlayerManager(JFrame frame, MediaPanel mediaPanel) {
		this.frame = frame;
		this.mediaPanel = mediaPanel;
	}

	public void setMediaComponent(String file) {
		if(this.mediaComponent != null) {
			this.mediaComponent.remove(this.mediaComponent);
		}
		this.mediaComponent = new MediaComponent(file).setMediaPanel(frame);
		this.mediaPanel.add(this.mediaComponent, BorderLayout.CENTER);
	}
}
