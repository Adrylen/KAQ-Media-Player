package project.window;

import lombok.Getter;
import project.media.PlayerManager;
import project.window.panels.MediaPanel;
import project.window.panels.NorthMenu;
import project.window.panels.PlaylistPanel;
import project.window.panels.SouthBar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;

public class MainFrame extends JFrame {
	private final int MINIMUM_WIDTH = 600;
	private final int MINIMUM_HEIGHT = 400;

	private JScrollPane playlistScrollPane;
	private @Getter PlaylistPanel playlistPanel;
	private JMenuBar northMenu;
	private @Getter Box southBar;
	private MediaPanel mediaPanel;
	private @Getter PlayerManager playerManager;

    public MainFrame() throws IOException {
    	super("KAQMediaPlayer");
        this.northMenu = new NorthMenu(this);
        this.southBar = new SouthBar(this);

        this.mediaPanel = new MediaPanel();
		
		this.playlistPanel = new PlaylistPanel(MINIMUM_WIDTH/4, MINIMUM_HEIGHT);
		
        this.playlistScrollPane = new JScrollPane(this.playlistPanel,
	        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        this.playerManager = new PlayerManager(this, mediaPanel);
    }

    public MainFrame init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout(5, 5));
        this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));

        this.playlistScrollPane.setPreferredSize(new Dimension(MINIMUM_WIDTH/4, MINIMUM_HEIGHT));
        this.playlistPanel.attachParentPane(this.playlistScrollPane).attachWindow(this);

	    ((SouthBar)this.southBar).attachPlayer(this.playerManager).create();

        return this;
    }

    public MainFrame create() {
        this.add(northMenu, BorderLayout.NORTH);
//        this.add(playlistScrollPane, BorderLayout.WEST);
        this.add(mediaPanel, BorderLayout.CENTER);
        this.add(southBar, BorderLayout.SOUTH);

        this.setVisible(true);

        return this;
    }
}
