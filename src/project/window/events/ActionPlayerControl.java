/*
 *   Java Project
 *   Project
 *   Package : project.window.events
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.window.events;

import project.media.PlayerManager;
import project.utils.console;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionPlayerControl extends MouseAdapter {
	private String action;

	public ActionPlayerControl(String action) {
		this.action = action;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(this.action) {
			case "play":
				if(PlayerManager.getInstance().getMediaComponent() != null) {
					PlayerManager.getInstance().getMediaComponent().play();
					this.action = "pause";
				}
				break;
			case "pause":
				PlayerManager.getInstance().getMediaComponent().pause();
				this.action = "play";
				break;
			default:
				console.log("No action defined on " + this.action);
		}
	}
}
