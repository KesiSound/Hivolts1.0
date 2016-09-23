import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel implements KeyListener {
	
	public static Mho[] Mhos = new Mho[12]; 
	
	int frameHeight = 600, frameWidth = 600;
	private JPanel[][] squares;
	public static Square[][] squareTracker = new Square[12][12];
	
	private int ROWS = 12, COLS = 12;
	Player ourPlayer = new Player(0,0);

	
	//have to make the points randomized

	public Board() {
		setPreferredSize(new Dimension(frameHeight, frameWidth));
		squares = new JPanel[ROWS][COLS]; 
		setLayout(new GridLayout(ROWS, COLS));
		setBackground(Color.BLACK);
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
			Mhos[r] = new Mho(0, 0);
		}
		int counter = 0;
		while (true) {
			Mhos[counter].moveRandom();
			if (squareTracker[Mhos[counter].getX()][Mhos[counter].getY()].getStatus() == 'u') {
				squares[Mhos[counter].getX()][Mhos[counter].getY()].add(Mhos[counter]);
				squareTracker[Mhos[counter].getX()][Mhos[counter].getY()].setStatus('m');
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
			System.out.println("hit w lol");
			ourPlayer.moveUp();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);

			}
			
		case 'a':
			System.out.println("hit a");
			ourPlayer.moveLeft();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
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
			System.out.println("hit d");
			ourPlayer.moveRight();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
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
			System.out.println("hit x");
			ourPlayer.moveDown();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				repaint();
				break;	
				
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
				
			}
		case 'q':
			System.out.println("hit q");
			ourPlayer.moveUpLeft();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
			}
		case 'e':
			System.out.println("hit e");
			ourPlayer.moveUpRight();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);

			}
		case 'z':
			System.out.println("hit z");
			ourPlayer.moveDownLeft();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
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
			ourPlayer.moveDownRight();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				repaint();
				break;
			}
			else {
				System.out.println("You lose");
				setVisible(false);
				System.exit(0);
			}
		case 'j':
			ourPlayer.Jump();
			if (squareTracker[ourPlayer.getX()][ourPlayer.getY()].getStatus() == 'u') {
				squares[ourPlayer.getX()][ourPlayer.getY()].add(ourPlayer);
				repaint();
				break;
			}
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//Add moveAI();
	}
	
	
	public void drawDeadScreen(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,800,800);
		g.drawString("AHHAH you lost", 350, 350);
	}

	
	
}
	






