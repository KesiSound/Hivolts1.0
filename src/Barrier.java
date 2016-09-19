
import java.awt.Image;

import java.awt.Color;
import java.awt.Graphics;


import javax.swing.*;

public class Barrier extends JLabel {
	private int x, y;
	public Barrier(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/Fence.png").
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}
	
	void moveToPosition(int x, int y) {
		this.x = x;
		this.y= y;
		
	}
	
	int randomXY() {
		return (1 + (int) (Math.random() * 11));

	}

	void moveRandomInside() {
		moveToPosition(randomXY(), randomXY());
	}
	

	int getX1() {
		return x;
	}
	
	int getY1() {
		return y;
	}
	
}
