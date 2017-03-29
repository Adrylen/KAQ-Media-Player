/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.player;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		
		String arg = "/home/isen/Videos/pony_anthology/PONIES_The_Anthology_I.avi";
        
		SwingUtilities.invokeLater(() -> StartWindow());
        SwingUtilities.invokeLater(() -> playFile(arg));
	}

	public static void playFile(String arg){
		mediaPlayerComponent.getMediaPlayer().playMedia(arg);
	}
	
	
	public static void StartWindow() {

		frame = new JFrame("My First Media Player");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });
        
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
		frame.setVisible(true);

	}
}
