import javax.swing.JFrame;

public class Main extends JFrame{
	public static void main(String[] args) {
		JFrame ourBoard = new Board();
		ourBoard.setTitle("Hivolts");
		ourBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ourBoard.setVisible(true);
	}
}
