import java.awt.Image;

import javax.swing.*;

public class Mho extends JLabel {
	private int x, y;					//Mho x and y coordinate
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
		return (1 + (int)(Math.random() * ((10 - 1) + 1)));

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
		int PlayerX = thePlayer.getX();
		int PlayerY = thePlayer.getY();
		int MhoX = getX();
		int MhoY = getY();
		int xDist = PlayerX - MhoX;
		int yDist = PlayerY - MhoY;
		double dist = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		
		
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
			//Diag movement 
			
			//diag movement up then left
			if (MhoY > PlayerY && MhoX > PlayerX){
				this.y--;
				this.x--;
				
			}
			
			//diag movement up then right
			else if (MhoY > PlayerY && MhoX < PlayerX){
				this.y--;
				this.x++;
				
			}
			
			//diag movement down then left
			else if(MhoY < PlayerY && MhoX > PlayerX){
				this.x--;
				this.y++;
				
				
			}
			
			//diag movement down then right
			else if (MhoY < PlayerY && MhoX < PlayerX){
				this.x++;
				this.y--;
			}
			
			
			
			
		}
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
}