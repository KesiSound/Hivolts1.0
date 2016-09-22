import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel implements KeyListener {
	public static Mho[] Mhos;
	int frameHeight = 600, frameWidth = 600;
	private JPanel[][] squares;
	private Square[][] squareTracker = new Square[12][12];
	
	private int ROWS = 12, COLS = 12;
	Player ourPlayer = new Player(0,0);

	
	//have to make the points randomized
	//ourPlayer.moveRandom(); - Doesn't work
	// Keyboard key = new Keyboard();
	public Board() {
		setPreferredSize(new Dimension(frameHeight, frameWidth));
		squares = new JPanel[ROWS][COLS]; 
		setLayout(new GridLayout(ROWS, COLS));
		setBackground(Color.BLACK);
		addSquareTracker();
		add();
		addFenceBorder();
		addRandomFences();
		spawnPlayer();
		this.setVisible(true);
		addKeyListener(this);
		
	}
	private void add(){
		for (int j = 0; j < ROWS; j++) {
			for (int i = 0; i < COLS; i++) {
				squares[i][j] = new JPanel(); 
				add(squares[i][j]); 
			}
		}
	}

	private void addLabels() {
		JLabel label;
		JLabel label1; 
		label = new Barrier(3,2);
		label1 = new Barrier(4,2); 
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		label1.setBorder(new EmptyBorder(10, 10, 10, 10));
		squares[label.getX()][label.getY()].add(label);
		squares[label1.getX()][label1.getY()].add(label1);
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
	}

	
	void addFenceBorder() {
		for (int i =0; i < 12; i++){
			for (int a = 0; a < 12; a++){
				squareTracker[i][a] = new Square();
				
			}
		}
		
		
		JLabel fences;
		
		for (int i = 0; i < 12; i++) {
			if (i == 0 || i == 11) {
				for (int a = 0; a < 12; a++) {
					fences = new Barrier(i, a);
					fences.setBorder(new EmptyBorder(10, 10, 10, 10));
					squares[i][a].add(fences);
					squareTracker[i][a].setStatus('f');
				}
			}
			
			fences = new Barrier(i, 0);
			fences.setBorder(new EmptyBorder(10, 10, 10, 10));
			squares[fences.getX()][fences.getY()].add(fences);
			squareTracker[fences.getX()][fences.getY()].setStatus('f');
			
			fences = new Barrier(i, 11);
			fences.setBorder(new EmptyBorder(10, 10, 10, 10));
			squares[fences.getX()][fences.getY()].add(fences);
			squareTracker[fences.getX()][fences.getY()].setStatus('f');
		}	
	}

	
	void addRandomFences() {
		JLabel fences;
		int counter = 0;
		while (true) { 
			fences = new Barrier(0,0);
			((Barrier) fences).moveRandomInside();
			if (squareTracker[fences.getX()][fences.getY()].getStatus() == 'u') {
				fences.setBorder(new EmptyBorder(10, 10, 10, 10));
				squares[fences.getX()][fences.getY()].add(fences);
				squareTracker[fences.getX()][fences.getY()].setStatus('f');
				counter++;
				if (counter == 20) {
					break;
				}
			}	
		}
	}
	
	
	
	void spawnPlayer() {
		ourPlayer.moveRandom();
		JLabel playerLabel = ourPlayer;
		ourPlayer.setBorder(new EmptyBorder(10,10,10,10));
		squares[ourPlayer.getX()][ourPlayer.getY()].add(playerLabel);
		repaint();
	}
	
	void addSquareTracker() {
		for (int a = 0; a < 12; a++) {
			for (int b = 0; b < 12; b++) {
				squareTracker[a][b] = new Square(0,0,'u');
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		switch(key) {
		case 'w':
			System.out.println("hit w lol");
			ourPlayer.moveUp();
			break;
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
	






