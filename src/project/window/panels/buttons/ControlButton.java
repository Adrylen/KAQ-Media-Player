/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Qwen
 */
public class ControlButton extends JButton{
    private Icon icone1, icone2;
    private boolean bool;
    public ControlButton(Icon icone){
        this(icone,null);
    }
    public ControlButton(Icon icone, boolean bool){
        this(icone, null);
        this.bool = bool;
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                ((ControlButton)e.getSource()).toggleState();
            }
        });
    }
    public ControlButton(Icon icone1, Icon icone2){
        super(icone1);
        this.icone1 = icone1;
        this.icone2 = icone2;
        this.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("OK");
                if(icone2 != null) {
                    if(((JButton)e.getSource()).getIcon().equals(icone1)) {
                        ((JButton)e.getSource()).setIcon(icone2);
                    } else if (((JButton)e.getSource()).getIcon().equals(icone2)) {
                        ((JButton)e.getSource()).setIcon(icone1);
                    }
                }
            }
        });
    }
    
    public void toggleState() {
        this.setEnabled(!bool);
        bool = !bool;
    }
}
