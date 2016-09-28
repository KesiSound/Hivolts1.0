//Kesi Sound, Jerry Wu, Aashai Avadhani
//Mho Class
import java.awt.Image;

import javax.swing.*;

public class Mho extends JLabel {
	private int x, y;	//Mho x and y coordinate
	Board b; //Mho uses a board and updates it
	boolean dead = false; //Default state of the mho is not dead

	public Mho(Board b, int x, int y) { //Constructor of Mho, sets everything appropriately
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/Enemy.png").
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)); //Adds the image of the Mho
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
		this.b = b;
	}
	void moveToPosition(int x, int y) { //Moves Mho to a position
		this.x = x;
		this.y = y;
	}
	int randomXY() { //Makes random coordinate between 1 and 10 (Inside the board)
		return (1 + (int)(Math.random() * ((10 - 1) + 1)));

	}

	void moveRandom() { //Moves the Mho to random spot
		moveToPosition(randomXY(), randomXY());
	}
	
	public int getX() { //X Getter
		return x;
	}
	
	public int getY() { //Y Getter
		return y;
	}
	
	//AI, true means moved
	boolean moveAI(Player thePlayer) {
		int PlayerX = thePlayer.getX(); //sets the players xCoord to PlayerX for easier reading
		int PlayerY = thePlayer.getY(); //sets the players yCoord to PlayerY for easier reading
		int MhoX = getX(); //sets the Mhos xCoord to MhoX for easier readability
		int MhoY = getY(); //sets the Mhos yCoord to MhoY for easier readability
		int xDist = Math.abs(PlayerX - MhoX); //Finds the x distance between the player and Mho
		int yDist = Math.abs(PlayerY - MhoY); //Find thes y distance between the player and Mho
		boolean moved = true; //Sets moved to true by default
		
		//If the player is directly vertical or horizontal, move towards it
		if (PlayerX == MhoX || PlayerY == MhoY) {
			if (PlayerX == MhoX) {
				if (PlayerY > MhoY) {
					this.y++;
				}
				else {
					this.y--;
				}
			}
			if(PlayerY == MhoY) {
				if (PlayerX > MhoY) {
					this.x++;
				}
				else {
					this.x--;
				}
			}
			
			if (PlayerX == MhoX && PlayerY == MhoY) // player dead
				thePlayer.dead = true;
			else if (b.squareTracker[this.x][this.y].getStatus() == 'f') // mho dead
				this.dead = true;
			else if (b.squareTracker[this.x][this.y].getStatus() == 'm'){ // don't move into mho
				this.x = MhoX; 
				this.y = MhoY;
				moved = false;
			}
			return moved;
		}
		
		//If it is not directly vertical or horizontal...
		//2.1. Diag movement towards you
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
			this.y++;
		}
		if (thePlayer.getX() == this.x && thePlayer.getY() == this.y){ // player dead
			thePlayer.dead = true;
			return moved;
		}
		else if (b.squareTracker[this.x][this.y].getStatus() == 'u'){ // empty spot, we are done
			return moved;
		}
		else if (b.squareTracker[this.x][this.y].getStatus() == 'f'){ // if Mho hit's a fence, dead
			dead = true;
			return moved;
		}
		else if (b.squareTracker[this.x][this.y].getStatus() == 'm'){ // don't move into mho
			this.x = MhoX; 
			this.y = MhoY;
			moved = false;
		}
		
		//step 2.2 - if xDist > yDist
		if (xDist > yDist) {
			if (thePlayer.getX() > getY()) {
				this.x++;
			}
			else {
				this.x--;
			}
		}
		//step 2.3 - none of those happen
		else {
			if (thePlayer.getY() > getY()) {
				this.y++;
			}
			else {
				this.y--;
			}			
		}
		if (thePlayer.getX() == this.x && thePlayer.getY() == this.y){ // player dead
			thePlayer.dead = true;
			return moved;
		}
		else if (b.squareTracker[this.x][this.y].getStatus() == 'u'){ // empty spot, we are done
			return moved;
		}
		else if (b.squareTracker[this.x][this.y].getStatus() == 'f'){ // fence
			dead = true;
			return moved;
		}
		else if (b.squareTracker[this.x][this.y].getStatus() == 'm'){ // don't move into mho
			this.x = MhoX; 
			this.y = MhoY;
			moved = false;
		}
		
		return moved;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
}