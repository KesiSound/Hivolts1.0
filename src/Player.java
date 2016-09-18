import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Player extends JLabel {
	private int x, y;
	public Player(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Player.png").
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}
	
	void moveUp(){
		//int temp = getY();
		y -= 1;
		
		
	}
	 void moveDown(){
		//int temp = getY();
		y += 1;
	}
	
	 void moveRight(){
		//int temp = getX();
		x += 1;
		
	}
	 void moveLeft(){
	//	int temp = getX();
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
	  public int getX(){
		return this.x;
	}
	
	  public int getY(){
		 return this.y;
	}
	  
	  int randomXY() {
			return (1 + (int)(Math.random() * 12)); 
	  
	  }
	  void moveRandom() {
		moveToPosition(randomXY(), randomXY());
	  }
		
		public void moveToPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}

}
