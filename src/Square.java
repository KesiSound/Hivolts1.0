import javax.swing.JComponent;
public class Square extends JComponent {
	private char status;
	
	
	public Square(char status){
		this.status = status; //status will hold a character like 'f' - fence, 'm' - mho, 'p' - player, or 'u' -unfilled
	}
	
	public Square(){
		this.status = 'u'; //status will hold a character like 'f' - fence, 'm' - mho, 'p' - player, or 'u' -unfilled
	}
	
	
	public char getStatus(){
		return status;
	}
	
	void setStatus(char newStatus) {
		this.status = newStatus;
	}
	
}
