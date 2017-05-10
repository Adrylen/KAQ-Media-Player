package project.window;

import project.media.PlayerManager;
import project.window.panels.MediaPanel;
import project.window.panels.NorthMenu;
import project.window.panels.PlaylistPanel;
import project.window.panels.SouthBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.Box;

import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import lombok.Getter;

public class MainFrame extends JFrame {
	private static final int MINIMUM_WIDTH = 600;
	private static final int MINIMUM_HEIGHT = 400;

	private @Getter Box southBar;
	private @Getter PlayerManager playerManager;
	private @Getter PlaylistPanel playlistPanel;

	private JMenuBar northMenu;
	private JScrollPane playlistScrollPane;
	private MediaPanel mediaPanel;

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

    public MainFrame init() throws IOException {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout(5, 5));
        this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));

        this.playlistScrollPane.setPreferredSize(new Dimension(MINIMUM_WIDTH/4, MINIMUM_HEIGHT));
        this.playlistPanel.attachParentPane(this.playlistScrollPane).attachWindow(this);

	    ((SouthBar)this.southBar).attachPlayer(this.playerManager).create();

        return this;
    }

    public void create() {
        this.add(northMenu, BorderLayout.NORTH);
        this.add(mediaPanel, BorderLayout.CENTER);
        this.add(southBar, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
