/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import project.window.panels.buttons.ControlMenu;

/**
 *
 * @author Qwen
 */
public class LectureMenu extends JMenu{
    public LectureMenu(String str){
        super(str);
        
        ControlMenu play = new ControlMenu("Play", "Pause");
        ControlMenu back = new ControlMenu("Précédent");
        ControlMenu stop = new ControlMenu("Stop");
        ControlMenu next = new ControlMenu("Suivant");
        ControlMenu random = new ControlMenu("Random");
        ControlMenu repeat = new ControlMenu("Repeat");
        ControlMenu fullscreen = new ControlMenu("Fullscreen");
        ControlMenu playlist = new ControlMenu("Afficher la playlist");
        
        
        this.add(play);
        this.add(back);
        this.add(stop);
        this.add(next);
        this.add(random);
        this.add(repeat);
        this.add(fullscreen);
        this.add(playlist);
    }
    
}
