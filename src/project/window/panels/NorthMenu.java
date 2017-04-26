package project.window.panels;

import project.window.MainFrame;
import project.window.menus.MediaMenu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import project.window.menus.AudioMenu;
import project.window.menus.LectureMenu;
import project.window.menus.OptionMenu;

public class NorthMenu extends JMenuBar{
    
    public NorthMenu(MainFrame window){
        
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
