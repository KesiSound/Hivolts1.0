import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Player extends JLabel {
	private int x, y;

	public Player(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("img/Player.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}

	void moveUp() {
		y -= 1;

	}

	void moveDown() {
		y += 1;
	}

	void moveRight() {
		x += 1;

	}

	void moveLeft() {
		x -= 1;
	}

	void moveUpRight() {
		moveUp();
		moveRight();
	}

	void moveUpLeft() {
		moveUp();
		moveRight();
	}

	void moveDownRight() {
		moveDown();
		moveRight();
	}

	void moveDownLeft() {
		moveDown();
		moveLeft();
	}
	
	public int getX1() {
		return this.x;
	}

	public int getY1() {
		return this.y;
	}

	int randomXY() {
		return (1 + (int) (Math.random() * 12));

	}

	void moveRandom() {
		moveToPosition(randomXY(), randomXY());
	}

	public void moveToPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
