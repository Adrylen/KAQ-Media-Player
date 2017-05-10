/*
 *   Java Project
 *   Project
 *   Package : project.window.panels
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.window.panels;

import project.window.MainFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TimerBar extends JPanel {
	private JProgressBar timerBar;
	private JLabel currentTimeLabel = new JLabel("--:--");
	private JLabel maxTimeLabel = new JLabel("--:--");

	public TimerBar() {
		timerBar = new JProgressBar(0, 0);
		timerBar.setValue(0);
		timerBar.setMinimum(0);
		timerBar.setMaximum(100);
		timerBar.setStringPainted(false);
		timerBar.setPreferredSize(new Dimension(MainFrame.getInstance().getWidth() - 180, 10));

		MainFrame.getInstance().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				timerBar.setPreferredSize(new Dimension(MainFrame.getInstance().getWidth() - 180, 10));
			}
		});

		add(currentTimeLabel);
		add(timerBar);
		add(maxTimeLabel);
	}

	public void updateBar() {
		String[] currentTime = currentTimeLabel.getText().split(":");
		String[] maxTime = maxTimeLabel.getText().split(":");
		if(currentTime[0].equals("--") || maxTime[0].equals("--")) {
			return;
		}
		timerBar.setValue(
			(Integer.parseInt(currentTime[0])*60 + Integer.parseInt(currentTime[1])) * 100 /
			(Integer.parseInt(maxTime[0])*60 + Integer.parseInt(maxTime[1]))
		);
	}

	public TimerBar setCurrentTimeLabel(String currentTimeLabelText) {
		currentTimeLabel.setText(currentTimeLabelText);
		return this;
	}

	public TimerBar setMaxTimeLabel(String maxTimeLabelText) {
		maxTimeLabel.setText(maxTimeLabelText);
		return this;
	}
}
