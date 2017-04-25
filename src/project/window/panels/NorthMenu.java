/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import project.window.MyFrame;
import project.window.menus.MediaMenu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import project.window.menus.AudioMenu;
import project.window.menus.LectureMenu;
import project.window.menus.OptionMenu;

/**
 *
 * @author Qwen
 */
public class NorthMenu extends JMenuBar{
    
    public NorthMenu(MyFrame window){
        
        MediaMenu media = new MediaMenu(window, "Media");
        LectureMenu lecture = new LectureMenu("Lecture");
        AudioMenu audio = new AudioMenu("Audio");
        OptionMenu options = new OptionMenu("Options");
        JMenu video = new JMenu("Video");
        this.add(media);
        this.add(lecture);
        this.add(audio);
        this.add(video);
        this.add(options);
    
}
    
}
