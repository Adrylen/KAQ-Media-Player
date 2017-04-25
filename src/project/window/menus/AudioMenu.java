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
public class AudioMenu extends JMenu{
    public AudioMenu(String str){
        super(str);
        
        ControlMenu mute = new ControlMenu("Couper le son", "Remettre le son");
        ControlMenu soundm = new ControlMenu("Baisser le volume");
        ControlMenu soundp = new ControlMenu("Augmenter le volume");
        
        this.add(mute);
        this.add(soundm);
        this.add(soundp); 
    }
    
}
