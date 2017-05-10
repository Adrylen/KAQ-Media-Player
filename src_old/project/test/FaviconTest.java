/*
 *   Java Project
 *   Project
 *   Package : project.test
 *   Created by AdrienMartinez on 05/05/2017.
*/

package project.test;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

public class FaviconTest {
	public static void main(String[] args) {
		try {
			JFrame frame = new JFrame();
			frame.setSize(new Dimension(400,400));
			frame.setIconImage(ImageIO.read(new File("assets/play1.png")));
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
