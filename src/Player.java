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
		int temp = getY();
		y -= temp;
		
		
	}
	 void moveDown(){
		int temp = getY();
		y += temp;
	}
	
	 void moveRight(){
		int temp = getX();
		x += temp;
		
	}
	 void moveLeft(){
		int temp = getX();
		x -= temp;
	}
	
	  public int getX(){
		return this.x;
	}
	
	  public int getY(){
		 return this.y;
	}

}
