package game;

import javax.swing.JFrame;

public class screen {
	public screen(JFrame frame, int width, int height) {

		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
