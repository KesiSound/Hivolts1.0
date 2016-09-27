import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel implements KeyListener {
	
	public static ArrayList<Mho> Mhos = new ArrayList<Mho>(); 
	
	int frameHeight = 600, frameWidth = 600;
	public static JPanel[][] squares;
	public static Square[][] squareTracker = new Square[12][12];
	private int ROWS = 12, COLS = 12;
	Player ourPlayer = new Player(0,0);

	
	//have to make the points randomized

	public Board() {
		
		setPreferredSize(new Dimension(frameHeight, frameWidth));
		squares = new JPanel[ROWS][COLS]; 
		setLayout(new GridLayout(ROWS, COLS));
		addSquareTracker();
		add();
		addFenceBorder();
		spawnPlayer();
		addRandomFences();
		spawnMhos();
		this.setVisible(true);
		addKeyListener(this);
		
	}
	private void add(){
		repaint();
		for (int j = 0; j < ROWS; j++) {
			for (int i = 0; i < COLS; i++) {
				squares[i][j] = new JPanel(); 
				add(squares[i][j]); 
			}
		}
	}
	
	void addFenceBorder() {
		repaint();
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
		repaint();
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
		repaint();
		ourPlayer.moveRandom();
		JLabel playerLabel = ourPlayer;
		ourPlayer.setBorder(new EmptyBorder(10,10,10,10));
		squares[ourPlayer.getX()][ourPlayer.getY()].add(playerLabel);
		squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
		repaint();
	}
	
	void addSquareTracker() {
		for (int a = 0; a < 12; a++) {
			for (int b = 0; b < 12; b++) {
				squareTracker[a][b] = new Square(0,0,'u');
			}
		}
	}
	
	void spawnMhos() {
		//fill mhos with
		for (int r = 0; r < 12; r++) {
			Mhos.add(r, new Mho(0, 0));
			Mhos.get(r).setBorder(new EmptyBorder(10,10,10,10));
		}
		int counter = 0;
		while (true) {
			Mhos.get(counter).moveRandom();
			if (squareTracker[Mhos.get(counter).getX()][Mhos.get(counter).getY()].getStatus() == 'u') {
				squares[Mhos.get(counter).getX()][Mhos.get(counter).getY()].add(Mhos.get(counter));
				squareTracker[Mhos.get(counter).getX()][Mhos.get(counter).getY()].setStatus('m');
				counter++;
				repaint();
			}
			if (counter == 12) {
				break;
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
			int oldX = ourPlayer.getX();
			int oldY = ourPlayer.getY();
			ourPlayer.moveUp();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX][oldY].setStatus('u');
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);

			}
			
		case 'a':
			int oldX1 = ourPlayer.getX();
			int oldY1 = ourPlayer.getY();
			ourPlayer.moveLeft();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX1][oldY1].setStatus('u');
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
				ourPlayer.moveRight();
				setVisible(false);
				System.exit(0);
				
			}
			
		case 'd':
			int oldX2 = ourPlayer.getX();
			int oldY2 = ourPlayer.getY();
			System.out.println("hit d");
			ourPlayer.moveRight();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX2][oldY2].setStatus('u');
				repaint();
				break;
			}
			else {

				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
				ourPlayer.moveLeft();

			}
		case 's':
			System.out.println("hit s");
			repaint();
			break;
		case 'x': 
			int oldX3 = ourPlayer.getX();
			int oldY3 = ourPlayer.getY();
			System.out.println("hit x");
			ourPlayer.moveDown();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX3][oldY3].setStatus('u');
				repaint();
				break;	
				
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
				
			}
		case 'q':
			int oldX4 = ourPlayer.getX();
			int oldY4 = ourPlayer.getY();
			System.out.println("hit q");
			ourPlayer.moveUpLeft();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX4][oldY4].setStatus('u');
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
			}
		case 'e':
			int oldX5 = ourPlayer.getX();
			int oldY5 = ourPlayer.getY();
			System.out.println("hit e");
			ourPlayer.moveUpRight();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX5][oldY5].setStatus('u');
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);

			}
		case 'z':
			int oldX6 = ourPlayer.getX();
			int oldY6 = ourPlayer.getY();
			System.out.println("hit z");
			ourPlayer.moveDownLeft();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX6][oldY6].setStatus('u');
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
			}
		case 'c':
			System.out.println("hit c");
			int oldX7 = ourPlayer.getX();
			int oldY7 = ourPlayer.getY();
			ourPlayer.moveDownRight();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX7][oldY7].setStatus('u');
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
			}
		case 'j':
			int oldX8 = ourPlayer.getX();
			int oldY8 = ourPlayer.getY();
			ourPlayer.Jump();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
				squareTracker[oldX8][oldY8].setStatus('u');
				repaint();
				break;
			}
		}

		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//Add moveAI();
		char key = e.getKeyChar();
		switch(key) {
		case 'q':
			moveAICool();
			break;
		case 'w':
			moveAICool();
			break;
		case 'e':
			moveAICool();
			break;
		case 'a':
			moveAICool();
			break;
		case 's':
			moveAICool();
			break;
		case 'd':
			moveAICool();
			break;
		case 'z':
			moveAICool();
			break;
		case 'x':
			moveAICool();
			break;
		case 'c':
			moveAICool();
			break;
			
		}
	}
	
	public void moveAICool() {
		for (int i = 0; i < Mhos.size(); i++) {
			int oldX = Mhos.get(i).getX();
			int oldY = Mhos.get(i).getY();
			Mhos.get(i).moveAI(ourPlayer);
			if (squareTracker[Mhos.get(i).getX()][Mhos.get(i).getY()].getStatus() != 'u') {
				squares[Mhos.get(i).getX()][Mhos.get(i).getY()].remove(Mhos.get(i));
				Mhos.remove(i);
				repaint();
				break;
			}
			else {
				squares[Mhos.get(i).getX()][Mhos.get(i).getY()].add(Mhos.get(i));
				squareTracker[Mhos.get(i).getX()][Mhos.get(i).getY()].setStatus('m');
				squareTracker[oldX][oldY].setStatus('u');
			}
			
		}
		repaint();
	}
}
	






