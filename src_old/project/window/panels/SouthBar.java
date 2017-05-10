package project.window.panels;

import project.media.PlayerManager;
import project.media.files.PathFile;
import project.window.MainFrame;
import project.window.panels.buttons.ControlButton;
import project.window.panels.buttons.SoundSlider;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import lombok.Getter;

public class SouthBar extends Box{
	private final MainFrame window;
	private PlayerManager playerManager;
	private @Getter ControlButton play;

	public SouthBar(MainFrame window) throws MalformedURLException {
		super(BoxLayout.X_AXIS);
		this.window = window;
	}

	public void create() throws IOException {
		PathFile playP = new PathFile("/assets/play1.png",true);
		PathFile pauseP = new PathFile("/assets/pause.png",true);
		PathFile backP = new PathFile("/assets/back.png",true);
		PathFile stopP = new PathFile("/assets/stop.png",true);
		PathFile nextP = new PathFile("/assets/next.png",true);
		PathFile randomP = new PathFile("/assets/random.png",true);
		PathFile repeatP = new PathFile("/assets/repeat.png",true);
		PathFile fullscreenP = new PathFile("/assets/fullscreen.png",true);
		PathFile playlistP = new PathFile("/assets/playlist.png",true);
		PathFile soundP = new PathFile("/assets/sound.png",true);
		PathFile muteP = new PathFile("/assets/mute.png",true);

		//hide/show repeat fullscreen

		ControlButton play = new ControlButton(new ImageIcon(playP.getPath()), new ImageIcon(pauseP.getPath()))
			.attachPlayer(this.playerManager)
			.setUpControl("play");
		ControlButton back = new ControlButton(new ImageIcon(backP.getPath()))
			.attachPlayer(this.playerManager)
			.setUpControl("back");
		ControlButton stop = new ControlButton(new ImageIcon(stopP.getPath()))
			.attachPlayer(this.playerManager)
			.setUpControl("stop");
		ControlButton next = new ControlButton(new ImageIcon(nextP.getPath()))
			.attachPlayer(this.playerManager)
			.setUpControl("next");
		ControlButton random = new ControlButton(new ImageIcon(randomP.getPath()), true)
			.attachPlayer(this.playerManager)
			.setUpControl("random");
		ControlButton repeat = new ControlButton(new ImageIcon(repeatP.getPath()), true)
			.attachPlayer(this.playerManager)
			.setUpControl("repeat");
		ControlButton fullscreen = new ControlButton(new ImageIcon(fullscreenP.getPath()), true)
			.attachPlayer(this.playerManager)
			.setUpControl("fullscreen");
		ControlButton playlist = new ControlButton(new ImageIcon(playlistP.getPath()), true)
			.attachWindow(this.window)
			.attachPlayer(this.playerManager)
			.setUpControl("playlist");
		ControlButton mute = new ControlButton(new ImageIcon(soundP.getPath()), new ImageIcon(muteP.getPath()))
			.attachPlayer(this.playerManager)
			.setUpControl("mute");

		SoundSlider slider = new SoundSlider(0, 100, 20);
		mute.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slider.toggleMute();
			}
		});
		//slider.setLayout(slider, new BoxLayout(BoxLayout.LINE_ALIGNEMENT));

		this.setBorder(BorderFactory.createEmptyBorder(0, 3, 5, 0));

		this.add(play);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(back);
		this.add(stop);
		this.add(next);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(random);
		this.add(repeat);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(fullscreen);
		this.add(playlist);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(mute);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(slider);

		this.play = play;
	}

	public SouthBar attachPlayer(PlayerManager playerManager) {
		this.playerManager = playerManager;
		return this;
	}
}
