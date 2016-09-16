import javax.swing.JComponent;
public class Square extends JComponent {
	private int x;
	private int y;
	private char filled;
	
	
	public Square(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public char getFilled(){
		return filled;
	}
	
	
}
