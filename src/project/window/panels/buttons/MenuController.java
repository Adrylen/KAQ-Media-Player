/*
 *   Java Project
 *   Project
 *   Package : project.window.panels.buttons
 *   Created by AdrienMartinez on 09/05/2017.
*/

package project.window.panels.buttons;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

public class MenuController extends JMenuItem {
	private String str1;
	private String str2;

	public MenuController(String str){
		this(str, null);
	}

	public MenuController(String str1, String str2){
		super(str1);
		this.str1 = str1;
		this.str2 = str2;

		addActionListener(new AbstractAction() {
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

	public MenuController addListener(AbstractAction action) {
		addActionListener(action);
		return this;
	}
}
