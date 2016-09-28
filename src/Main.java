//Kesi Sound, Jerry Wu, Aashai Avadhani
//Main class
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	JFrame window;
	Prompt p;
	Board b;
	public Main() { //Creates a new object of type main that has the frame, prompt, and board
		window = makeFrame();
		p = new Prompt(this);
		b = new Board(p);
	}
	
	JFrame makeFrame(){ //Base code to make a frame
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
		window = makeFrame(); //Makes a new frame when starting a game
		p = new Prompt(this);
		b = new Board(p);
		window.add(b, BorderLayout.CENTER); //Adds the board to the center of the screen
		window.add(p, BorderLayout.PAGE_END); //Adds the prompt to the bottom of the screen
		window.pack();		
		window.setVisible(true);	
	}
	
	public static void main(String[] args) { 
		Main m = new Main(); //Creates a new Main object
		m.window.add(m.b, BorderLayout.CENTER); //Adds board to center of main
		m.window.add(m.p, BorderLayout.PAGE_END); //Adds prompt to bottom of main
		m.window.pack(); //Makes sure window is at preferred size
		m.window.setVisible(true);
	}
}