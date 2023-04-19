package xetang;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	XeTang xeTang;
	XeTang[] xeTangDich = { new XeTang(20, 20, 50, 50), new XeTang(90, 90, 50, 50), new XeTang(200, 50, 50, 50) };

	KeyAdapter keyAdapter = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				xeTang.move(Moveable.MOVE_UP);
				break;
			case KeyEvent.VK_LEFT:
				xeTang.move(Moveable.MOVE_LEFT);
				break;
			case KeyEvent.VK_DOWN:
				xeTang.move(Moveable.MOVE_DOWN);
				break;
			case KeyEvent.VK_RIGHT:
				xeTang.move(Moveable.MOVE_RIGHT);
				break;
			case KeyEvent.VK_SPACE:
				xeTang.shoot();
				break;
			}
		};
	};

	public GamePanel() {
		super();
		xeTang = new XeTang(250, 400, 50, 50);
		addKeyListener(keyAdapter);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		xeTang.draw(g);

		g.setColor(Color.RED);
		for (int i = 0; i < xeTangDich.length; i++) {
			xeTangDich[i].draw(g);
		}
	}

	public void checkBulletHit() {
		Iterator<Bullet> iterator = xeTang.listBullets.iterator();
		while (iterator.hasNext()) {
			Bullet bullet = iterator.next();
			if (bullet.y <= 0) {
				iterator.remove();
				continue;
			}
			for (int i = 0; i < xeTangDich.length; i++) {
				if (xeTangDich[i].isAlive) {
					if (xeTangDich[i].isHit(bullet)) {
						bullet.behit(xeTangDich[i]);
						iterator.remove();
					}
				}
			}
		}
	}

	public Thread gameLoop() {
		return new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					repaint();
					checkBulletHit();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}

	public void startGame() {
		gameLoop().start();
	}
}
