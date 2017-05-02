/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels.buttons;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Qwen
 */
public class PlaylistFileButton extends JButton {
    
    public PlaylistFileButton(Icon icone){
        super(icone);
        this.setPreferredSize(new Dimension(16, 16));
    }
    
}
