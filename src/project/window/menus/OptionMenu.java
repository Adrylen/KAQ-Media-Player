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
public class OptionMenu extends JMenu{
    public OptionMenu(String str){
        super(str);
        
        JMenuItem subtitles = new JMenuItem("Subtitles");
        
        this.add(subtitles);
    }
    
}
