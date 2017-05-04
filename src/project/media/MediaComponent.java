package project.media;

import project.media.files.PathFile;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.io.File;

public class MediaComponent extends EmbeddedMediaPlayerComponent {
	private JFrame frame;
	private String file;

	public MediaComponent(String file) {
		this.file = file;
		this.getMediaPlayer().setPlaySubItems(true);
//		try {
//			this.getMediaPlayer().setSubTitleFile("C:\\Users\\AdrienMartinez\\Documents\\Project_KAQ\\assets\\subtitles\\test.srt");
//		} catch (IOException e) {
//			e.printStackTrace();
//		};
	}

	public MediaComponent setMediaPanel(JFrame frame) {
		this.frame = frame;
		return this;
	}

	public void play() {
		if(this.getMediaPlayer().isPlaying()) {
			this.getMediaPlayer().pause();
		} else {
			this.getMediaPlayer().playMedia(this.file);
		}
	}

	public void pause() {
		this.getMediaPlayer().pause();
	}

	@Override
	public void playing(MediaPlayer mediaPlayer) {
		SwingUtilities.invokeLater(() -> frame.setTitle(String.format(
			"Media Player - %s",
			this.getMediaPlayer().getMediaMeta().getTitle()
		)));
	}

	@Override
	public void finished(MediaPlayer mediaPlayer) {
//		SwingUtilities.invokeLater(() -> frame.closeMediaPlayer());
	}

	@Override
	public void error(MediaPlayer mediaPlayer) {
		SwingUtilities.invokeLater(() -> {
			JOptionPane.showMessageDialog(
				frame,
				"Failed to play Media",
				"Error",
				JOptionPane.ERROR_MESSAGE
			);
			//frame.closeMediaPlayer();
		});
	}
}
