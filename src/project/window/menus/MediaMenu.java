/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.menus;

import javax.swing.JMenu;
import project.window.panels.buttons.ControlMenu;

/**
 *
 * @author Qwen
 */
public class MediaMenu extends JMenu{
    public MediaMenu(String str){
        super(str);
        
        ControlMenu openF = new ControlMenu("Ouvrir un fichier");
        ControlMenu openFs = new ControlMenu("Ouvrir plusieurs fichiers");
        ControlMenu quit = new ControlMenu("Quitter");
        
        this.add(openF);
        this.add(openFs);
        this.add(quit);
}
    
}
