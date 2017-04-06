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
public class AudioMenu extends JMenu{
    public AudioMenu(String str){
        super(str);
        
        JMenuItem mute = new JMenuItem("Couper le son");
        JMenuItem soundm = new JMenuItem("Baisser le volume");
        JMenuItem soundp = new JMenuItem("Augmenter le volume");
        
        this.add(mute);
        this.add(soundm);
        this.add(soundp); 
    }
    
}
