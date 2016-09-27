import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
	public static void main(String[] args) {
		Board b = new Board();
		b.setFocusable(true);
		JFrame window = new JFrame();
		window.getContentPane().setBackground(Color.black);
		window.setSize(600, 600);
		window.add(b);
		window.setTitle("Hivolts");
		window.setBackground(Color.BLACK);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();		
		window.setVisible(true);
	}
}