import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel {
	public static Mho[] Mhos;
	int frameHeight = 600, frameWidth = 600;
	private JPanel[][] squares;
	private int ROWS = 12, COLS = 12;
	//have to make the points randomized
	//ourPlayer.moveRandom(); - Doesn't work
	// Keyboard key = new Keyboard();
	public Board() {
		setPreferredSize(new Dimension(frameHeight, frameWidth));
		squares = new JPanel[ROWS][COLS]; 
		setBackground(Color.BLACK);
		setLayout(new GridLayout(ROWS, COLS));
		add();
		addLabels(); 
		addFenceBorder();
		this.setVisible(true);
	}
	private void add(){
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				squares[i][j] = new JPanel(); 
				add(squares[i][j]); 
			}
		}
	}

	private void addLabels() {
		JLabel label;
		JLabel label1; 
		label = new Barrier(3,2);
		label1 = new Barrier(11,11); 
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		label1.setBorder(new EmptyBorder(10, 10, 10, 10));
		squares[label.getX()][label.getY()].add(label);
		squares[label1.getX()][label1.getY()].add(label1);
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
	}
	
	void addFenceBorder() {
		JLabel fences;
		for (int i = 0; i < 12; i++) {
			if (i == 0 || i == 11) {
				for (int a = 0; a < 12; a++) {
					fences = new Barrier(i, a);
					fences.setBorder(new EmptyBorder(10, 10, 10, 10));
					squares[fences.getX()][fences.getY()].add(fences);
				}
			}
			
			fences = new Barrier(i, 0);
			fences.setBorder(new EmptyBorder(10, 10, 10, 10));
			squares[fences.getX()][fences.getY()].add(fences);
			
			fences = new Barrier(i, 11);
			fences.setBorder(new EmptyBorder(10, 10, 10, 10));
			squares[fences.getX()][fences.getY()].add(fences);
		}	
	}
}
	






