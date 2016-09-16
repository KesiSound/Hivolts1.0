import java.awt.Graphics2D;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Board extends JFrame{
	//Create New Array of Squares
	//Square[][] ourBoard;
	//Add Enemies
	Mho[][] Mhos;
	//frameHeight, frameWidth
	int frameHeight = 600;
	int frameWidth = 600;
	
	//Keyboard key = new Keyboard();
	public Board(){
		init();
	}
	
	public void init(){
		setSize(frameHeight, frameWidth);
		
		
		
	}
	
	public void paint(Graphics2D g){
		
	}
	
	//we should have a method that converts pixels 
	
	
}
