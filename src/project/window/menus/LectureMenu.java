/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Qwen
 */
public class LectureMenu extends JMenu{
    public LectureMenu(String str){
        super(str);
        
        JMenuItem play = new JMenuItem("Play");
        JMenuItem back = new JMenuItem("Précédent");
        JMenuItem stop = new JMenuItem("Stop");
        JMenuItem next = new JMenuItem("Suivant");
        JMenuItem random = new JMenuItem("Random");
        JMenuItem repeat = new JMenuItem("Repeat");
        JMenuItem fullscreen = new JMenuItem("Fullscreen");
        JMenuItem playlist = new JMenuItem("Afficher la playlist");
        
        
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
