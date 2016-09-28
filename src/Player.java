//Kesi Sound, Jerry Wu, Aashai Avadhani
//Player class
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class Player extends JLabel {
	private int x, y;
	boolean dead = false;
	Board b;
	public Player(int x, int y, Board b) { //Creates a new player that has x and y coordinates as well as a board that it will modify
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("img/Player.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
		this.b = b;
	}
	//Functions for changing x and y coordinates based on movement
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
		moveLeft();
	}

	void moveDownRight() {
		moveDown();
		moveRight();
	}

	void moveDownLeft() {
		moveDown();
		moveLeft();
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	int randomXY() { //Creates a new random coordinate inside the fence border
		return (1 + (int)(Math.random() * ((10 - 1) + 1))); 
	}

	void moveRandom() { //Movs player to random place
		moveToPosition(randomXY(), randomXY());
	}

	public void moveToPosition(int x, int y) { //Sets position
		this.x = x;
		this.y = y;
	}
	
	void Jump() { //Handles changing coordinates for when you jump
		int randomX;
		int randomY;
		while (true) {
			randomX = randomXY();
			randomY = randomXY();
			if (b.squareTracker[randomX][randomY].getStatus() != 'f' &&
					randomX != this.x && randomY != this.y) {
				moveToPosition(randomX, randomY);
				break;
			}
		
		}	
	}
}
