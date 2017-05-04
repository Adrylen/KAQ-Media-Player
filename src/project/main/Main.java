package project.main;

import com.sun.jna.NativeLibrary;
import project.window.MainFrame;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.SwingUtilities;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
	private static Logger console = Logger.getLogger(Main.class.getName());
	private Main() {}

	public static void main(String[] args) {
		console.log(Level.INFO, "Natives finded : " + Boolean.toString(new NativeDiscovery().discover()));
		console.log(Level.INFO, LibVlc.INSTANCE.libvlc_get_version());

		SwingUtilities.invokeLater(() -> {
			try {
				new MainFrame()
					.init()
					.create();
//					.test();
			} catch (MalformedURLException e) {
				Logger.getLogger(Main.class.getName()).log(Level.WARNING, "MalformedURLException in process", e);
			} catch (IOException e) {
				Logger.getLogger(Main.class.getName()).log(Level.WARNING, "IOException in process", e);
			}
		});
	}
}
