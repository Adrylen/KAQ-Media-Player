package project.main;

import project.window.MainFrame;

import javax.swing.SwingUtilities;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
	private Main() {}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new MainFrame()
					.init()
					.create();
			} catch (MalformedURLException e) {
				Logger.getLogger(Main.class.getName()).log(Level.WARNING, "MalformedURLException in process", e);
			}
		});
	}
}
