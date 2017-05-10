/*
 *   Java Project
 *   Project
 *   Package : project.window.panels.buttons
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.window.panels.buttons;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.BorderLayout;

public class SoundSlider extends JPanel {
	private JSlider slider;
	private JLabel text;

	private int oldValue = 0;
	private boolean mute = false;

	public SoundSlider(int min, int max, int defValue) {
		slider = new JSlider(min, max, defValue);
		slider.addChangeListener(e -> text.setText(String.valueOf(slider.getValue())));

		text = new JLabel(Integer.toString(defValue));
		text.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		setLayout(new BorderLayout());

		add(slider, BorderLayout.WEST);
		add(text);
	}

	public void toggleMute() {
		int tmp = oldValue;
		oldValue = slider.getValue();
		slider.setValue(tmp);
		slider.setEnabled(mute);
		mute = !mute;
	}
}
