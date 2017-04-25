/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels.buttons;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

/**
 *
 * @author Qwen
 */
public class ControlMenu extends JMenuItem{
    private String str1, str2;
    public ControlMenu(String str){
        this(str, null);
                
    }
    public ControlMenu(String str1, String str2){
        super(str1);
        this.str1 = str1;
        this.str2 = str2;
        this.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (str2 != null){
                    if(((JMenuItem)e.getSource()).getText().equals(str1)){
                        ((JMenuItem)e.getSource()).setText(str2);
                    } else if (((JMenuItem)e.getSource()).getText().equals(str2)){
                        ((JMenuItem)e.getSource()).setText(str1);
                    }
                }
            }
        });
    }
    
}
