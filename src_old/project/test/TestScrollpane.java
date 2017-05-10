package project.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestScrollpane {
	private int i;
	private JPanel listContainer;

	private void initUI() {
		final JFrame frame = new JFrame(TestScrollpane.class.getSimpleName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listContainer = new JPanel();
		listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

		frame.add(new JScrollPane(listContainer), BorderLayout.CENTER);
		JButton button = new JButton("Add");
		button.addActionListener(e -> {
			final JPanel newPanel = new JPanel();
			newPanel.add(new JLabel("Label " + i++));
			listContainer.add(newPanel);
			listContainer.revalidate();
			// Scroll down to last added panel
			SwingUtilities.invokeLater(() -> newPanel.scrollRectToVisible(newPanel.getBounds()));
		});
		frame.add(button, BorderLayout.PAGE_END);

		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(() -> new TestScrollpane().initUI());
	}
}