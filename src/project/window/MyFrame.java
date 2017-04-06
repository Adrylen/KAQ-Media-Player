/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window;

import project.window.panels.NorthMenu;
import project.window.panels.SouthBar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.net.MalformedURLException;

/**
 *
 * @author Qwen
 */
public class MyFrame extends JFrame {
    public MyFrame() throws MalformedURLException {
        this.setTitle("KAQMediaPlayer");
        this.setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar northMenu = new NorthMenu();
        JMenuBar southBar = new SouthBar();
        JPanel center = new JPanel();
        center.setBackground(Color.red);
        this.getContentPane().add(center, BorderLayout.CENTER);
        this.add(southBar, BorderLayout.SOUTH);
        this.add(northMenu, BorderLayout.NORTH);
        this.setSize(800,600);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);    
    }
}
