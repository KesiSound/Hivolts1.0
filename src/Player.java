
public class Player {
	int xCoord;
	int yCoord;
	
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
	
	void 
	
	
}
