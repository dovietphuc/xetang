package xetang;

import java.awt.Graphics;

public class Bullet extends GameObject implements Moveable, Hitable {

	public Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void move(int direction) {
		switch (direction) {
		case MOVE_LEFT:
			x -= velocity();
			break;
		case MOVE_RIGHT:
			x += velocity();
			break;
		case MOVE_DOWN:
			y += velocity();
			break;
		case MOVE_UP:
			y -= velocity();
			break;
		}
	}

	@Override
	public int velocity() {
		return 30;
	}

	@Override
	public void draw(Graphics g) {
		move(Moveable.MOVE_UP);
		g.fillOval(x, y, width, height);
	}
	
	@Override
	public void behit(GameObject gameObject) {
		if(gameObject instanceof XeTang) {
			XeTang xeTang = (XeTang)gameObject;
			xeTang.behit(this);
		}
	}
}
