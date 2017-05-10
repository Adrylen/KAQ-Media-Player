package project.window.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class MediaPanel extends JPanel {
        ProgressBar bar;
	public MediaPanel() {
                this.bar = new ProgressBar(30, 60);
                this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout()); 
                this.add(bar, BorderLayout.SOUTH);
	}
}
