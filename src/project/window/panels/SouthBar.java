/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import java.awt.Dimension;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import project.path.PathFile;
import project.window.panels.buttons.ControlButton;

/**
 *
 * @author Qwen
 */
public class SouthBar extends Box{
    public SouthBar() throws MalformedURLException{
        super(BoxLayout.X_AXIS);
        PathFile playP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/play1.png");
        PathFile pauseP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/pause.png");
        PathFile backP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/back.png");
        PathFile stopP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/stop.png");
        PathFile nextP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/next.png");
        PathFile randomP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/random.png");
        PathFile repeatP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/repeat.png");
        PathFile fullscreenP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/fullscreen.png");
        PathFile playlistP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/playlist.png");
        PathFile soundP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/sound.png");        
        PathFile muteP = new PathFile("file:///C:/Users/Qwen/Documents/KAQMediaPlayer/assets/mute.png");
        
        //hide/show repeat fullscreen

        ControlButton play = new ControlButton(new ImageIcon(playP.getPath()), new ImageIcon(pauseP.getPath()));
        ControlButton back = new ControlButton(new ImageIcon(backP.getPath()));
        ControlButton stop = new ControlButton(new ImageIcon(stopP.getPath()));
        ControlButton next = new ControlButton(new ImageIcon(nextP.getPath()));
        ControlButton random = new ControlButton(new ImageIcon(randomP.getPath()), true);
        ControlButton repeat = new ControlButton(new ImageIcon(repeatP.getPath()), true);
        ControlButton fullscreen = new ControlButton(new ImageIcon(fullscreenP.getPath()), true);
        ControlButton playlist = new ControlButton(new ImageIcon(playlistP.getPath()), true);
        ControlButton mute = new ControlButton(new ImageIcon(muteP.getPath()), new ImageIcon(soundP.getPath()));
        
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
    }
    
}
