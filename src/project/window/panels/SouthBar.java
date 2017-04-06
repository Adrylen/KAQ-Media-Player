/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import project.path.PathFile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author Qwen
 */
public class SouthBar extends JMenuBar{
    public SouthBar() throws MalformedURLException{
        PathFile playP = null, pauseP = null,
            backP = null, stopP = null, nextP = null,
            randomP = null, repeatP = null,
            fullscreenP = null, playlistP = null,
            soundP = null, muteP = null;

        try {
            playP = new PathFile("/assets/play1.png",true);
            pauseP = new PathFile("/assets/pause.png",true);
            backP = new PathFile("/assets/back.png",true);
            stopP = new PathFile("/assets/stop.png",true);
            nextP = new PathFile("/assets/next.png",true);
            randomP = new PathFile("/assets/random.png",true);
            repeatP = new PathFile("/assets/repeat.png",true);
            fullscreenP = new PathFile("/assets/fullscreen.png",true);
            playlistP = new PathFile("/assets/playlist.png",true);
            soundP = new PathFile("/assets/sound.png",true);
            muteP = new PathFile("/assets/mute.png",true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //hide/show repeat fullscreen

        JButton play = new JButton(new ImageIcon(playP.getPath())),
            pause = new JButton(new ImageIcon(pauseP.getPath())),
            back = new JButton(new ImageIcon(backP.getPath())),
            stop = new JButton(new ImageIcon(stopP.getPath())),
            next = new JButton(new ImageIcon(nextP.getPath())),
            random = new JButton(new ImageIcon(randomP.getPath())),
            repeat = new JButton(new ImageIcon(repeatP.getPath())),
            fullscreen = new JButton(new ImageIcon(fullscreenP.getPath())),
            playlist = new JButton(new ImageIcon(playlistP.getPath())),
            sound = new JButton(new ImageIcon(soundP.getPath())),
            mute = new JButton(new ImageIcon(muteP.getPath()));

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
