import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
	Board b;
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(700, 700);
		window.add(new Board());
		window.setTitle("Hivolts");
		window.setBackground(Color.BLACK);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();		
		window.setVisible(true);
	}

	
}