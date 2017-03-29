/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import project.path.PathFile;

/**
 *
 * @author Qwen
 */
public class SouthBar extends JMenuBar{
    public SouthBar() throws MalformedURLException{
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

        JButton play = new JButton(new ImageIcon(playP.getPath()));
        JButton pause = new JButton(new ImageIcon(pauseP.getPath()));
        JButton back = new JButton(new ImageIcon(backP.getPath()));
        JButton stop = new JButton(new ImageIcon(stopP.getPath()));
        JButton next = new JButton(new ImageIcon(nextP.getPath()));
        JButton random = new JButton(new ImageIcon(randomP.getPath()));
        JButton repeat = new JButton(new ImageIcon(repeatP.getPath()));
        JButton fullscreen = new JButton(new ImageIcon(fullscreenP.getPath()));
        JButton playlist = new JButton(new ImageIcon(playlistP.getPath()));
        JButton sound = new JButton(new ImageIcon(soundP.getPath()));
        JButton mute = new JButton(new ImageIcon(muteP.getPath()));
        
        this.add(play);
        this.add(pause);
        
        JMenu separator = new JMenu();
        separator.addSeparator();
        this.add(separator);
        
        this.add(back);
        this.add(stop);
        this.add(next);
        
        JMenu separator1 = new JMenu();
        separator1.addSeparator();
        this.add(separator1);
        
        this.add(random);
        this.add(repeat);
        
        JMenu separator2 = new JMenu();
        separator2.addSeparator();
        this.add(separator2);
        
        this.add(fullscreen);
        this.add(playlist);
        
        JMenu separator3 = new JMenu();
        separator3.addSeparator();
        this.add(separator3);
        
        this.add(mute);
        this.add(sound);
    }
    
}
