import java.awt.Image;

import javax.swing.*;

public class Mho extends JLabel {
	private int x, y;
	public Mho(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/Enemy.png").
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}
	void moveToPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int randomXY() {
		return (1 + (int) (Math.random() * 12));

	}

	void moveRandom() {
		moveToPosition(randomXY(), randomXY());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	//AI
	void moveAI(Player thePlayer) {
		//If the player is directly vertical or horizontal, move towards it
		if (thePlayer.getX() == getX() || thePlayer.getY() == getY()) {
			if (thePlayer.getX() == getX()) {
				if (thePlayer.getY() > getY()) {
					this.y--;
				}
				else {
					this.y++;
				}
			}
			if(thePlayer.getY() == getY()) {
				if (thePlayer.getX() > getY()) {
					this.x++;
				}
				else {
					this.x--;
				}
			}
		}
		
		//If it is not directly vertical or horizontal...
		else {
			
		}
	}
}