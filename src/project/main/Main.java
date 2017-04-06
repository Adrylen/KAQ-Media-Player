/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.main;

//import project.window.MyFrame;

import project.window.Window;

import javax.swing.SwingUtilities;
import java.net.MalformedURLException;

/**
 *
 * @author adrylen
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException {
		//MyFrame frame = new MyFrame();
	    SwingUtilities.invokeLater( () ->
		    new Window("KAQ - MultiMedia Player", 1100, 700)
				.init()
				.create()
	    );
    }
}
