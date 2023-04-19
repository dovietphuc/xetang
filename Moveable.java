package xetang;

public interface Moveable {
	int MOVE_LEFT = 0;
	int MOVE_RIGHT = 1;
	int MOVE_UP = 2;
	int MOVE_DOWN = 3;

	public void move(int direction);

	public int velocity();
}
