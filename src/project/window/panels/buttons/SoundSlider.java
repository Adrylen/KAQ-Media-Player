/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window.panels.buttons;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Qwen
 */
public class SoundSlider extends JPanel {
        JSlider slider;
      public SoundSlider(int min, int max, int defValue){
          JSlider slider = new JSlider();
          slider.setMaximum(max);
          slider.setMinimum(min);
          slider.setValue(defValue);
          this.add(slider);
          this.setSize(100,10);
    //this.setPreferredSize(new Dimension(10, 10));
    
}
}
