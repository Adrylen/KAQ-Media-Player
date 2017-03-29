/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import project.window.menus.MediaMenu;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import project.window.menus.LectureMenu;

/**
 *
 * @author Qwen
 */
public class NorthMenu extends JMenuBar{
    
    public NorthMenu(){
        
        MediaMenu media = new MediaMenu("Media");
        LectureMenu lecture = new LectureMenu("Lecture");
        JMenu audio = new JMenu("Audio");
        JMenu video = new JMenu("Video");
        this.add(media);
        this.add(lecture);
        this.add(audio);
        this.add(video);
    
}
    
}
