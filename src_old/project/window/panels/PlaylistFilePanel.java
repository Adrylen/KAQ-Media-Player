/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import project.media.files.PathFile;
import project.window.panels.buttons.PlaylistFileButton;

/**
 *
 * @author Qwen
 */
public class PlaylistFilePanel extends JPanel{
    
    public PlaylistFilePanel(int width, int i, int nb) throws IOException{
                        this.setLayout(new BorderLayout());
                        this.add(new JLabel("Test : "+i), BorderLayout.CENTER);
                        if(i !=0){
                            PathFile upP = new PathFile("/assets/up.png",true);
                            PlaylistFileButton up = new PlaylistFileButton(new ImageIcon(upP.getPath()));
                            this.add(up, BorderLayout.NORTH);
                        }
                        if(i != nb-1){
                            PathFile downP = new PathFile("/assets/down.png", true);
                            JButton down = new JButton(new ImageIcon(downP.getPath()));
                            this.add(down, BorderLayout.SOUTH);
                            down.setPreferredSize(new Dimension(16, 16));
                        }
			this.setPreferredSize(new Dimension(width-2, 60));
			this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    }    
}
