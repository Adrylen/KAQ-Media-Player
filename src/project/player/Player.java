/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.player;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

/**
 *
 * @author isen
 */
public class Player {
	private static JFrame frame;
	private static EmbeddedMediaPlayerComponent mediaPlayerComponent;
	   
	   
	public static void main(String[] args) {
		new NativeDiscovery().discover();
        SwingUtilities.invokeLater(Player::StartWindow);
	}

	public static void StartWindow() {
		String arg = "/home/isen/Videos/pony_anthology/PONIES_The_Anthology_I.avi";
		frame = new JFrame("My First Media Player");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
		frame.setVisible(true);
        mediaPlayerComponent.getMediaPlayer().playMedia(arg);
	}
}
