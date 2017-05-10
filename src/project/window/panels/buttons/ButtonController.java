/*
 *   Java Project
 *   Project
 *   Package : project.window.panels.buttons
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.window.panels.buttons;

import project.window.events.ActionPlayerControl;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonController extends JButton {
	private Icon icone1;
	private Icon icone2;
	private boolean state;

	public ButtonController(Icon icone){
		this(icone,null);
	}

	public ButtonController(Icon icone, boolean state){
		this(icone, null);
		this.state = state;
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				((ButtonController)e.getSource()).toggleState();
			}
		});
	}

	public ButtonController(Icon icone1, Icon icone2){
		super(icone1);
		this.icone1 = icone1;
		this.icone2 = icone2;
		addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((ButtonController)e.getSource()).switchIcon();
			}
		});
	}

	public ButtonController attachAction(String str){
		addMouseListener(new ActionPlayerControl(str));
		return this;
	}

	public void switchIcon() {
		if(icone2 != null) {
			if(this.getIcon().equals(icone1)) {
				setIcon(icone2);
			} else if (this.getIcon().equals(icone2)) {
				setIcon(icone1);
			}
		}
	}

	public void toggleState() {
		setEnabled(!state);
		state = !state;
	}
}
