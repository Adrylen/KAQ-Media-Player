/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.window;

import lombok.Data;
import lombok.Getter;
import project.media.PlayerManager;
import project.media.files.PathFile;
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
import javax.swing.Box;

/**
 *
 * @author Qwen
 */
public class MyFrame extends JFrame {
	private final int MINIMUM_WIDTH = 600;
	private final int MINIMUM_HEIGHT = 400;

	private JScrollPane playlistPanel;
	private JMenuBar northMenu;
	private Box southBar;
	private MediaPanel mediaPanel;
	private @Getter PlayerManager playerManager;

	private final int w = 800, h = 600;

    public MyFrame() throws MalformedURLException {
    	super("KAQMediaPlayer");
        this.northMenu = new NorthMenu(this);
        this.southBar = new SouthBar();

        this.mediaPanel = new MediaPanel();

        this.playlistPanel = new JScrollPane(
        	new PlaylistPanel(w/4, h),
	        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        this.playerManager = new PlayerManager(this, mediaPanel);
    }

    public MyFrame init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout(5, 5));
        this.setSize(w,h);
        this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));

        this.playlistPanel.setPreferredSize(new Dimension(w/4, h));

	    ((SouthBar)this.southBar).attachPlayer(this.playerManager).create();

        return this;
    }

    public MyFrame create() {
        this.add(northMenu, BorderLayout.NORTH);
        this.add(playlistPanel, BorderLayout.WEST);
        this.add(mediaPanel, BorderLayout.CENTER);
        this.add(southBar, BorderLayout.SOUTH);

        this.setVisible(true);

        return this;
    }

    public MyFrame testPlayer() {
	    try {
		    playerManager.setMediaComponent(new PathFile("file:///home/adrylen/Videos/mozart5mb.mp4",false));
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
	    return this;
    }
}
