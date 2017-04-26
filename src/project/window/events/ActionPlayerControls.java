package project.window.events;

import project.media.PlayerManager;
import project.window.panels.PlaylistPanel;
import project.window.panels.buttons.ControlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionPlayerControls extends MouseAdapter {
	private String action;
	private PlayerManager playerManager;

	public ActionPlayerControls(String action, PlayerManager playerManager) {
		this.action = action;
		this.playerManager = playerManager;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(this.action) {
			case "play":
				if(this.playerManager.getMediaComponent() != null) {
					this.playerManager.getMediaComponent().play();
					this.action = "pause";
				}
				break;
			case "pause":
				this.playerManager.getMediaComponent().pause();
				this.action = "play";
				break;
			case "playlist":
				((ControlButton) e.getSource()).getWindow().getPlaylistPanel().togglePanel();
				break;
			default:
				System.out.println("No action defined on "+this.action);
		}
	}
}
