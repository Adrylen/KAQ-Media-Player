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
        
        this.add(play);
        this.add(back);
        this.add(stop);
        this.add(next);
    }
    
}
