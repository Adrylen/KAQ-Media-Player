/*
 *   Java Project
 *   Project
 *   Package : project.window.panels
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.window.panels;

import project.utils.console;
import project.window.panels.buttons.ButtonController;
import project.window.panels.buttons.SoundSlider;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ControlBar extends Box {
	private static ControlBar instance;

	private ControlBar() {
		super(BoxLayout.X_AXIS);
	}

	public ControlBar create() {
		JButton mute = null;
		SoundSlider slider;
		setBorder(BorderFactory.createEmptyBorder(0,3,5,0));

		try {
			add(new ButtonController(
				new ImageIcon(new File("assets/play1.png").getCanonicalPath()),
				new ImageIcon(new File("assets/pause.png").getCanonicalPath())
			).attachAction("play")); br();
			add(new ButtonController(new ImageIcon(new File("assets/back.png").getCanonicalPath())));
			add(new ButtonController(new ImageIcon(new File("assets/stop.png").getCanonicalPath())));
			add(new ButtonController(new ImageIcon(new File("assets/next.png").getCanonicalPath())));       br();
			add(new ButtonController(new ImageIcon(new File("assets/random.png").getCanonicalPath()), true));
			add(new ButtonController(new ImageIcon(new File("assets/repeat.png").getCanonicalPath()), true));     br();
			add(new ButtonController(new ImageIcon(new File("assets/fullscreen.png").getCanonicalPath()), true));
			add(new ButtonController(new ImageIcon(new File("assets/playlist.png").getCanonicalPath()), true));   br();
			add(mute = new ButtonController(
				new ImageIcon(new File("assets/sound.png").getCanonicalPath()),
				new ImageIcon(new File("assets/mute.png").getCanonicalPath())
			));  br();
		} catch (IOException e) {
			console.log("Error with loading assets", e);
		}

		add(slider = new SoundSlider(0,100,20));
		mute.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slider.toggleMute();
			}
		});

		return this;
	}

	public void updateNewMediaComponent() {
		((ButtonController)getComponent(0)).switchIcon();
	}

	private void br() {
		add(Box.createRigidArea(new Dimension(10,0)));
	}

	public static ControlBar getInstance() {
		if(instance == null) {
			instance = new ControlBar();
		}
		return instance;
	}
}
