package xetang;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class XeTang extends GameObject implements Moveable, Hitable {
	
	ArrayList<Bullet> listBullets = new ArrayList<>();
	boolean isAlive = true;
	
	public XeTang(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void move(int direction) {
		switch(direction) {
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
		return 10;
	}

	@Override
	public void draw(Graphics g) {
		if(isAlive) {
			g.fillRect(x, y, width, height);
		}
		for(Bullet bullet : listBullets) {
			g.setColor(Color.PINK);
			bullet.draw(g);
		}
	}
	
	public void shoot() {
		Bullet bullet = new Bullet(x, y, 10, 20);
		listBullets.add(bullet);
		System.out.println("Ban chiu chiu");
	}
	
	@Override
	public void behit(GameObject gameObject) {
		isAlive = false;
	}
}
