/*
 *   Java Project
 *   Project
 *   Package : project.window.panels
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.window.panels;

import lombok.Getter;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class MediaPanel extends JPanel {
	@Getter
	private TimerBar timerBar = new TimerBar();

	public MediaPanel() {
		setBackground(Color.black);
		setLayout(new BorderLayout());
		add(timerBar, BorderLayout.SOUTH);
	}
}
