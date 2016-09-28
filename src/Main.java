import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	JFrame window;
	Prompt p;
	Board b;
	public Main() {
		window = makeFrame();
		p = new Prompt(this);
		b = new Board(p);
	}
	
	JFrame makeFrame(){
		JFrame window = new JFrame();
		window.getContentPane().setBackground(Color.black);
		window.setSize(600, 600);
		window.setTitle("Hivolts");
		window.setBackground(Color.BLACK);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return window;
	}
	
	//start a new game
	public void rebuild() {
		window.setVisible(false);
		window.dispose();
		window = makeFrame();
		p = new Prompt(this);
		b = new Board(p);
		window.add(b, BorderLayout.CENTER);
		window.add(p, BorderLayout.PAGE_END);
		window.pack();		
		window.setVisible(true);	
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.window.add(m.b, BorderLayout.CENTER);
		m.window.add(m.p, BorderLayout.PAGE_END);
		m.window.pack();		
		m.window.setVisible(true);
	}
}