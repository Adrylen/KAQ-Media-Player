/*
 *   Java Project
 *   Project
 *   Package : project.media
 *   Created by AdrienMartinez on 10/05/2017.
*/

package project.media;

import project.utils.console;
import project.window.MainFrame;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class MediaComponent extends EmbeddedMediaPlayerComponent {
	private String file;
	private Timer timer;

	public MediaComponent(String file) {
		this.file = file;
		getMediaPlayer().setPlaySubItems(true);
	}

	public void play() {
		if(getMediaPlayer().isPlaying()) {
			getMediaPlayer().pause();
		} else {
			getMediaPlayer().playMedia(file);
		}
	}

	public void pause() {
		this.getMediaPlayer().pause();
	}

	@Override
	public void playing(MediaPlayer mediaPlayer) {
		SwingUtilities.invokeLater(() -> {
			MainFrame.getInstance().setTitle(String.format("Media Player - %s", getMediaPlayer().getMediaMeta().getTitle()));
			console.log(Long.toString(PlayerManager.getInstance().getMediaComponent().getMediaPlayer().getLength()));
			PlayerManager.getInstance().getActiveMediaPanel().getTimerBar().setMaxTimeLabel(
				String.format("%02d",(PlayerManager.getInstance().getMediaComponent().getMediaPlayer().getLength() / 1000) / 60)
				+ ":" +
				String.format("%02d",(PlayerManager.getInstance().getMediaComponent().getMediaPlayer().getLength() / 1000) % 60)
			);
		});
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				int time = (int) PlayerManager.getInstance().getMediaComponent().getMediaPlayer().getTime();
				int second = time / 1000;
				int minutes = second / 60;
				second -= minutes * 60;
				PlayerManager.getInstance().getActiveMediaPanel().getTimerBar().setCurrentTimeLabel(
					String.format("%02d", minutes) + ":" + String.format("%02d", second)
				).updateBar();
			}
		}, 10, 100);
	}

	@Override
	public void finished(MediaPlayer mediaPlayer) {
//		SwingUtilities.invokeLater(() -> frame.closeMediaPlayer());
	}

	@Override
	public void error(MediaPlayer mediaPlayer) {
		SwingUtilities.invokeLater(() ->
				JOptionPane.showMessageDialog(
					MainFrame.getInstance(),
					"Failed to play Media",
					"Error",
					JOptionPane.ERROR_MESSAGE
				)
			//frame.closeMediaPlayer();
		);
	}
}
