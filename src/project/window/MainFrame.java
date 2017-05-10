/*
 *   Java Project
 *   Project
 *   Package : project.window
 *   Created by AdrienMartinez on 09/05/2017.
*/

package project.window;

import lombok.Getter;
import project.media.PlayerManager;
import project.window.panels.ControlBar;
import project.window.panels.MediaPanel;
import project.window.panels.ToolBar;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
	private static MainFrame instance;

	@Getter
	private ArrayList<MediaPanel> mediaPanels;

	private final int MINIMUM_HEIGHT = 400;
	private final int MINIMUM_WIDTH = 600;

	private MainFrame() {
		super("KAQ Media Player");
	}

	public MainFrame init() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5,5));
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));

		ToolBar.getInstance();
		ControlBar.getInstance();

		PlayerManager.getInstance().setActiveMediaPanel(new MediaPanel());
		mediaPanels = new ArrayList<>();
		mediaPanels.add(PlayerManager.getInstance().getActiveMediaPanel());

		return this;
	}

	public void create() {
		add(ToolBar.getInstance().create(), BorderLayout.NORTH);
		add(ControlBar.getInstance().create(), BorderLayout.SOUTH);

		for(MediaPanel mediaPanel : mediaPanels) {
			add(mediaPanel, BorderLayout.CENTER);
		}

		setVisible(true);
	}

	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	public void test() throws IOException {
		PlayerManager.getInstance().setMediaComponent(new File("assets/videos/bob_video.mp4").getCanonicalPath());
		PlayerManager.getInstance().getMediaComponent().play();
	}
}
