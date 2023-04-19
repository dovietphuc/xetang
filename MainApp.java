package xetang;

import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 500, 500);
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setBounds(0, 0, 500, 500);
		frame.add(gamePanel);
		
		frame.setVisible(true);
		gamePanel.startGame();
	}
}
