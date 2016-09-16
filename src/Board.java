import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Board extends JFrame{
	//Create New Array of Squares
	//Square[][] ourBoard;
	//Add Enemies
	Mho[][] Mhos;
	//frameHeight, frameWidth
	int frameHeight = 480;
	int frameWidth = 480;
	
	public Board(){
		init();
	}
	public void init(){
		setSize(frameHeight, frameWidth);
		
		
	}
	
	public void paint(Graphics2D g){
		
	}
	
}
