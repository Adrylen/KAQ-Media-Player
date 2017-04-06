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
import project.path.PathFile;

import javax.swing.ImageIcon;
import project.window.panels.buttons.ControlButton;
import project.window.panels.buttons.SoundSlider;
import java.io.IOException;

/**
 *
 * @author Qwen
 */
public class SouthBar extends Box{
    public SouthBar() throws MalformedURLException{
        super(BoxLayout.X_AXIS);

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

        ControlButton play = new ControlButton(new ImageIcon(playP.getPath()), new ImageIcon(pauseP.getPath()));
        ControlButton back = new ControlButton(new ImageIcon(backP.getPath()));
        ControlButton stop = new ControlButton(new ImageIcon(stopP.getPath()));
        ControlButton next = new ControlButton(new ImageIcon(nextP.getPath()));
        ControlButton random = new ControlButton(new ImageIcon(randomP.getPath()), true);
        ControlButton repeat = new ControlButton(new ImageIcon(repeatP.getPath()), true);
        ControlButton fullscreen = new ControlButton(new ImageIcon(fullscreenP.getPath()), true);
        ControlButton playlist = new ControlButton(new ImageIcon(playlistP.getPath()), true);
        ControlButton mute = new ControlButton(new ImageIcon(muteP.getPath()), new ImageIcon(soundP.getPath()));
        
        SoundSlider slider = new SoundSlider(0, 100, 20);

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
        this.add(slider);
    }

}
