package project.window.panels.buttons;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class SoundSlider extends JPanel {
	JSlider slider;
	public SoundSlider(int min, int max, int defValue){
		JSlider slider = new JSlider();
		slider.setMaximum(max);
		slider.setMinimum(min);
		slider.setValue(defValue);
		this.add(slider);
		this.setSize(100,10);
		//this.setPreferredSize(new Dimension(10, 10));
	}
}
