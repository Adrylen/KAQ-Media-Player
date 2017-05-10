package project.main;

import project.utils.console;
import project.window.MainFrame;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.SwingUtilities;

public class Main {
	private Main(){}

	public static void main(String[] args) {
		MainFrame.getInstance();

		console.log("Natives finded : " + Boolean.toString(new NativeDiscovery().discover()));
		console.log(LibVlc.INSTANCE.libvlc_get_version());

		SwingUtilities.invokeLater(() -> {
//			try {
				MainFrame.getInstance().init().create();
//				MainFrame.getInstance().test();
//			} catch (MalformedURLException e) {
//				console.log("MalformedURLException in process", e);
//			} catch (IOException e) {
//				console.log("IOException in process", e);
//			}
		});
	}
}
