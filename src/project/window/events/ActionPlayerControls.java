/*
 *   Java Project
 *   Project
 *   Package : project.window.events
 *   Created by adrylen on 21/04/17.
*/

package project.window.events;

import project.media.PlayerManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPlayerControls implements ActionListener {
	private String action;
	private PlayerManager playerManager;

	public ActionPlayerControls(String action, PlayerManager playerManager) {
		this.action = action;
		this.playerManager = playerManager;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch(this.action) {
			case "play":
				this.playerManager.getMediaComponent().play();
				this.action = "pause";
				break;
			case "pause":
				this.playerManager.getMediaComponent().pause();
				this.action = "play";
				break;
			default:
				System.out.println("No action defined on "+this.action);
		}
	}
}
