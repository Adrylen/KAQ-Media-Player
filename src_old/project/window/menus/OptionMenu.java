package project.window.menus;

import javax.swing.JMenu;
import project.window.panels.buttons.ControlMenu;

public class OptionMenu extends JMenu{
    public OptionMenu(String str){
        super(str);
        
        ControlMenu subtitles = new ControlMenu("Subtitles");
        
        this.add(subtitles);
    }
    
}
