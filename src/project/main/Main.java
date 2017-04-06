/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.main;

import project.window.MyFrame;

import javax.swing.SwingUtilities;
import java.net.MalformedURLException;

/**
 *
 * @author adrylen
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new MyFrame()
					.init()
					.create();
//					.testPlayer();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		});
	}
}
