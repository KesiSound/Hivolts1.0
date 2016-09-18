import javax.swing.JComponent;
public class Square extends JComponent {
	private int x;
	private int y;
	private char status;
	
	
	public Square(int x, int y, char status){
		this.x = x;
		this.y = y;
		this.status = status; //status will hold a character like 'f' - fence, 'm' - mho, 'p' - player, or 'u' -unfilled
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public char getStatus(){
		return status;
	}
	
	
}
