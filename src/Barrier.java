
import java.awt.Image;

import java.awt.Color;
import java.awt.Graphics;


import javax.swing.*;

public class Barrier extends JLabel {
	private int x, y; 
	public Barrier(int x, int y) { //Constructor for barrier, barrier has x and y coordinates
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/Fence.png"). //Creates image for barrier
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() { 
		return this.x;
	}
	@Override 
	public int getY() {
		return this.y;
	}

	
	void moveToPosition(int x, int y) { //Moves barrier to a position
		this.x = x;
		this.y= y;
		
	}
	
	int randomXY() { //Makes random x and y coordinates inside the fence border
		return (1 + (int)(Math.random() * ((10 - 1) + 1))); 

	}

	void moveRandomInside() { //Moves a fence to a random place inside the fence border
		moveToPosition(randomXY(), randomXY());
	}
}
