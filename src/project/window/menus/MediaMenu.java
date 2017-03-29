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
public class MediaMenu extends JMenu{
    public MediaMenu(String str){
        super(str);
        
        JMenuItem openF = new JMenuItem("Ouvrir un fichier");
        JMenuItem openFs = new JMenuItem("Ouvrir plusieurs fichiers");
        JMenuItem quit = new JMenuItem("Quitter");
        
        this.add(openF);
        this.add(openFs);
        this.add(quit);
}
    
}
