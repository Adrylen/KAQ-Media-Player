package project.window.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MediaPanel extends JPanel {
	public MediaPanel() {
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.add(new ProgressBar(30, 60), BorderLayout.SOUTH);
	}
}
