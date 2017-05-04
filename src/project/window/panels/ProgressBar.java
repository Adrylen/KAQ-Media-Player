/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Qwen
 */
public class ProgressBar extends JPanel {
    JProgressBar bar;
    JLabel currentTimeLabel, maxTimeLabel;
    int maxTimeH, maxTimeM, maxTimeS, currentTimeH, currentTimeM, currentTimeS;
    
    public ProgressBar(int currentTime,int maxTime){
        //super(new FlowLayout(FlowLayout.LEFT));
        bar = new JProgressBar(0, maxTime);
        bar.setValue(0);
        bar.setStringPainted(false);
        bar.setVisible(true);
        bar.setPreferredSize(new Dimension(1800,10));
        
        currentTimeLabel = new JLabel("- - : - -");
        maxTimeLabel = new JLabel("- - : - -");
        
        maxTimeH = maxTime/3600;
        maxTimeM = moduloj(maxTime/60, 60);
        maxTimeS= moduloj(maxTime, 60);
        maxTimeLabel.setText(String.valueOf(maxTimeH) + ":" + String.valueOf(maxTimeM) + ":" + String.valueOf(maxTimeS));
        
        this.add(currentTimeLabel);
        this.add(bar);
        this.add(maxTimeLabel);
        updatebar(bar, currentTime);
    }
    
    public void updatebar(JProgressBar bar, int currentTime){
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
               bar.setValue(bar.getValue()+1);
               currentTimeH = currentTime/3600;
               currentTimeM = moduloj(currentTime/60, 60);
               currentTimeS= moduloj(currentTime, 60);
               currentTimeLabel.setText(String.valueOf(currentTimeH) + ":" + String.valueOf(currentTimeM) + ":" + String.valueOf(currentTimeS));
               //currentTime = 1 +currentTime;
            }
            
        }, 1*1000, 1*1000);
    }
    
    
    private int moduloj(int x,int mod){ 
        int t; 
        if(x>=0)return x%mod; 
        else{t=(-x)%mod; 
        t=mod-t; 
        if(t==mod)t=0; 
        return t; 
        } 
    }
}
