//Kesi Sound, Jerry Wu, Aashai Avadhani
//Board class
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel implements KeyListener {
	
	public static ArrayList<Mho> Mhos = new ArrayList<Mho>(); //Creates new ArrayList of Mhos
	
	int frameHeight = 600, frameWidth = 600; //Used to set window frame heights
	public JPanel[][] squares; //Stores the JPanel Components in a 2D array to display stuff on the JFrame
	public Square[][] squareTracker = new Square[12][12]; //Stores a 2D array of squares which have statuses of what is currently in each box
	private int ROWS = 12, COLS = 12; //Used when making the array of squares
	Player ourPlayer = new Player(0,0, this); //Creates the player that you play as
	Prompt status; //Defines a new prompt object called status
	private boolean lost = false; //Makes the default state not a loss

	public Board(Prompt status) { //Constructor for Board, takes a prompt and creates a JPanel
		this.setBackground(Color.BLACK); //Doesn't work for whatever reason. doesn't do what it's supposed to do
		setFocusable(true);
		this.status = status;
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
	
	private void add(){ //Creates the board by adding JPanels to each square in the squares array
		repaint();
		for (int j = 0; j < ROWS; j++) {
			for (int i = 0; i < COLS; i++) {
				squares[i][j] = new JPanel(); 
				add(squares[i][j]); 
			}
		}
	}
	
	void addFenceBorder() { //Adds the fence border
		for (int i = 0; i < 12; i++){
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
		repaint();
	}
	
	void addRandomFences() { //Adds the 20 random fences, makes sure they don't overlap
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
	
	
	
	void spawnPlayer() { //Spawns the player randomly
		repaint();
		ourPlayer.moveRandom();
		JLabel playerLabel = ourPlayer;
		ourPlayer.setBorder(new EmptyBorder(10,10,10,10));
		squares[ourPlayer.getX()][ourPlayer.getY()].add(playerLabel);
		squareTracker[ourPlayer.getX()][ourPlayer.getY()].setStatus('p');
		repaint();
	}
	
	void addSquareTracker() { //Fills the squareTracker array with squares 
		for (int a = 0; a < 12; a++) {
			for (int b = 0; b < 12; b++) {
				squareTracker[a][b] = new Square('u');
			}
		}
	}
	
	void spawnMhos() {
		//fill mhos with empty mhos, and then spawns the 12 mhos to random places 
		for (int r = 0; r < 12; r++) {
			Mhos.add(r, new Mho(this, 0, 0));
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
	public void keyTyped(KeyEvent e) { //Never used, but in order to implement keyListeners it's needed
	}
	
	@Override
	public void keyPressed(KeyEvent e) { //Controls movement for player, updates squareTracker as well as win/lose status
		if (lost) { //Makes sure that if you have lost you can't move around anymore
			return;
		}
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
				System.out.println("You lose 1");
				status.deathPrompt();
				lost = true;
				return;
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
				System.out.println("You lose 2");
				status.deathPrompt();
				lost = true;				
				return;
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
				System.out.println("You lose 3");
				status.deathPrompt();
				lost = true;				
				return;
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
				System.out.println("You lose 4");
				status.deathPrompt();
				lost = true;				
				return;
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
				System.out.println("You lose 5");
				status.deathPrompt();
				lost = true;				
				return;
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
				System.out.println("You lose 6");
				status.deathPrompt();
				lost = true;				
				return;
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
				System.out.println("You lose 7");
				status.deathPrompt();
				lost = true;				
				return;
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
				System.out.println("You lose 8");
				status.deathPrompt();
				lost = true;
				return;
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
			else {
				System.out.println("You lose 8");
				status.deathPrompt();
				lost = true;
				return;
			}
		}
	}

	
	public void keyReleased(KeyEvent e) { //Calls on AI after key is released signifying end of turn
		if (lost) {//Makes sure that if you have lost the AI doesn't keep moving
			return; 
		}
		char key = e.getKeyChar();
		switch(key) {
		case 'q':
			moveAICool();
			repaint();
			break;
		case 'w':
			moveAICool();
			repaint();
			break;
		case 'e':
			moveAICool();
			repaint();
			break;
		case 'a':
			moveAICool();
			repaint();
			break;
		case 's':
			moveAICool();
			repaint();
			break;
		case 'd':
			moveAICool();
			repaint();
			break;
		case 'z':
			moveAICool();
			repaint();
			break;
		case 'x':
			moveAICool();
			repaint();
			break;
		case 'c':
			moveAICool();
			repaint();
			break;			
		}
		
	}
	
	public void moveAICool() { //Moves AI, called on for AI's turn
		Iterator<Mho> i = Mhos.iterator(); //Used to iterate through the Mhos list
		while (i.hasNext()) { //Makes sure that the loop only runs while there are still Mhos in the Mhos list
			Mho m = i.next(); //Sets a Mho named m to a mho in the list		
			int oldX = m.getX(); //Stores the x and y values before the AI is called on
			int oldY = m.getY(); 
			boolean moved = m.moveAI(ourPlayer); //Sets a moved status after AI is called, moveAI returns a boolean that shows if the Mho has been moved or not
			if (ourPlayer.dead){ //Checks if the player is dead
				//If the player is dead, you lose, puts up the death prompt	
				System.out.println("You lose");
				status.deathPrompt();
				return;				
			}
			else if (m.dead){ //if the mho is dead, removes from the list and makes the space unfilled
				squares[oldX][oldY].remove(m);			
				squareTracker[oldX][oldY].setStatus('u');
				i.remove();
			}
			else if (moved) { //If the AI has been called open and everything is good, then it moves the position of the mho
				squares[oldX][oldY].remove(m);			
				squares[m.getX()][m.getY()].add(m);
				squareTracker[m.getX()][m.getY()].setStatus('m');
				squareTracker[oldX][oldY].setStatus('u');
			}
			repaint();			
		}			
		repaint();
		if (Mhos.size() == 0){ //When there are no more Mhos left, you win
			status.youWin();
			
		}
	}
}
	






