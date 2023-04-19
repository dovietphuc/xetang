package xetang;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	
	public GameObject(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw(Graphics g);
	
	public boolean isHit(GameObject object) {
		Rectangle myRect = new Rectangle(x, y, width, height);
		Rectangle rectangle =
				new Rectangle(object.x, object.y, object.width, object.height);
		return myRect.intersects(rectangle);
	}
}
