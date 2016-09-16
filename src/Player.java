
public class Player {
	
	private int xCoord;
	public int getxCoord() {
		return xCoord;
	}
	
	private int yCoord;
	public int getyCoord() {
		return yCoord;
	}
	public Player() {
		xCoord = 0;
		yCoord = 0;
	}
	
	
	public void moveToPosition(int x, int y) {
		xCoord = x;
		yCoord = y;
	}
	
	//Movements
	void moveLeft() {
		xCoord = xCoord - 1;
	}
	
	void moveRight() {
		xCoord = xCoord +1;
	}
	
	void moveUp() {
		yCoord = yCoord + 1;
		
	}
	
	void moveDown() {
		yCoord = yCoord - 1;
	}
	
	void moveDiagonalLeftUp() {
		moveLeft();
		moveUp();
	}
	
	void moveDiagonalLeftDown() {
		moveLeft();
		moveDown();
	}
	
	void moveDiagonalRightUp() {
		moveRight();
		moveUp();
	}
	
	void moveDiagonalRightDown() {
		moveRight();
		moveDown();
	}
	
	int randomXY() {
		return (1 + (int)(Math.random() * 12)); 
	}
	void moveRandom() {
		moveToPosition(randomXY(), randomXY());
	}
	
	
	
}
