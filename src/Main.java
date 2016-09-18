import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener{
	Board b;
	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setSize(700, 700);
		
		window.add(new Board());
		window.setTitle("Hivolts");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();		
		window.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

		// TODO Auto-generated method stub
		  if (c ==KeyEvent.VK_UP) {
			  b.player.moveUp();
	        } else if(c==KeyEvent.VK_DOWN) {                
	          b.player.moveDown();
	        } else if(c==KeyEvent.VK_LEFT) { 
	        	b.player.moveLeft();
	        } else if(c==KeyEvent.VK_RIGHT) {                
	        	b.player.moveRight();
	        } 

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}