import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel {
	Mho[][] Mhos;
	int frameHeight = 600, frameWidth = 600;
	private JLabel[][] squares;
	private int ROWS = 12, COLS = 12;
	Player player = new Player(6,5);			//have to make the points randomized

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
					label = new JLabel("b" + i + j);
				}
				label.setBorder(new EmptyBorder(10, 10, 10, 10));
				squares[i][j] = label;
				add(label);
			}
		}
		
		
		
		
		
		
	}
	

}
