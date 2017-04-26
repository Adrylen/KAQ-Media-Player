package project.window.panels.buttons;

import lombok.Getter;
import project.media.PlayerManager;
import project.window.MainFrame;
import project.window.events.ActionPlayerControls;
import project.window.panels.SouthBar;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;

public class ControlButton extends JButton{
    private Icon icone1, icone2;
    private boolean bool;
	private PlayerManager playerManager;
	private @Getter	MainFrame window;

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
	            ((ControlButton)e.getSource()).switchIcon();
            }
        });
    }

    public void switchIcon() {
	    if(icone2 != null) {
		    if(this.getIcon().equals(icone1)) {
			    this.setIcon(icone2);
		    } else if (this.getIcon().equals(icone2)) {
			    this.setIcon(icone1);
		    }
	    }
    }
    
    public void toggleState() {
        this.setEnabled(!bool);
        bool = !bool;
    }

	public ControlButton attachPlayer(PlayerManager playerManager) {
    	this.playerManager = playerManager;
    	return this;
	}

	public ControlButton setUpControl(String s) {
    	this.addMouseListener(new ActionPlayerControls(s, this.playerManager));
    	return this;
	}

	public ControlButton attachWindow(MainFrame window) {
    	this.window = window;
    	return this;
	}
}
