import javax.swing.JFrame;
import java.awt.*;

public class Main{
	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setSize(700, 700);
		
		window.add(new Board());
		window.setTitle("Hivolts");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();		
		window.setVisible(true);
	}
}