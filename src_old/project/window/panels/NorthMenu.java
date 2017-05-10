package project.window.panels;

import project.window.MainFrame;
import project.window.menus.AudioMenu;
import project.window.menus.LectureMenu;
import project.window.menus.MediaMenu;
import project.window.menus.OptionMenu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class NorthMenu extends JMenuBar{
    public NorthMenu(MainFrame window){
        this.add(new MediaMenu(window, "Media"));
        this.add(new LectureMenu("Lecture"));
        this.add(new AudioMenu("Audio"));
        this.add(new OptionMenu("Options"));
        this.add(new OptionMenu("Options"));
        this.add(new JMenu("Video"));
    }
}
