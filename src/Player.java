import java.awt.Image;

import javax.swing.*;

public class Player extends JLabel {
	private int x, y;
	public Player(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/Player.png").
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}
}
