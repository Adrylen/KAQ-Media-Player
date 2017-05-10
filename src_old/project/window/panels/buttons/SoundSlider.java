package project.window.panels.buttons;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SoundSlider extends JPanel {
        JSlider slider;
        public JLabel text = new JLabel();
        public int oldValue = 0;
        boolean mute = false;
      public SoundSlider(int min, int max, int defValue){
          slider = new JSlider();
          slider.setMaximum(max);
          slider.setMinimum(min);
          slider.setValue(defValue);
          this.setLayout(new BorderLayout());
          this.add(slider, BorderLayout.WEST);
          
          text.setText(Integer.toString(defValue));
          Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
          text.setBorder(paddingBorder);
          this.add(text);
          //this.setBackground(Color.red);
    slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                text.setText(String.valueOf(slider.getValue()));
            }
        });
        text.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent ke) {
                String typed = text.getText();
                slider.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                int value = Integer.parseInt(typed);
                slider.setValue(value);
            }
        });
    
}
      
      public void toggleMute(){
          int tmp = oldValue;
          oldValue = slider.getValue();
          slider.setValue(tmp);
          slider.setEnabled(mute);
          mute = !mute;
      }
}
