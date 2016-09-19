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
	private JLabel[][] squares;
	private int ROWS = 12, COLS = 12;
	//have to make the points randomized
	//ourPlayer.moveRandom(); - Doesn't work
	// Keyboard key = new Keyboard();
	public Board() {
		setPreferredSize(new Dimension(frameHeight, frameWidth));
		squares = new JLabel[ROWS][COLS];
		setBorder(BorderFactory.createLineBorder(Color.blue));
		setBackground(Color.BLACK);
		setLayout(new GridLayout(ROWS, COLS));
		add();
		this.setVisible(true);
	}

	private void add() {
		JLabel label;

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (i == 0 || i == ROWS - 1 || j == 0 || j == COLS - 1) {
					label = new Barrier(i, j);
				}
				else {
					label = new Player(i,j); 
				}
				label.setBorder(new EmptyBorder(10, 10, 10, 10));
				squares[i][j] = label;
				add(label);
			}
		}
		//Should work to randomize in the future
		//for (int z = 0; z < 20; z++) {
			//Barrier myBarrier = new Barrier(0,0);
			//myBarrier.moveRandomInside();
			//label = myBarrier;
			//add(label);
		//}

	}
	

}
