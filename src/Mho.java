import java.awt.Image;

import javax.swing.*;

public class Mho extends JLabel {
	private int x, y;
	public Mho(int x, int y) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/Enemy.png").
		getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		this.setIcon(imageIcon);
		this.x = x;
		this.y = y;
	}
}