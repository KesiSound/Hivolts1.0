//Kesi Sound, Jerry Wu, Aashai Avadhani
//Prompt class
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Prompt extends JPanel{ //Creates Prompt type object that are JPanels
	
	JLabel status; //Prompt will have status JLabel
	JButton restart, quit; //Prompt will have buttons to restart or quit
	Main m; //Prompt will have an object of type Main
	
	public Prompt(Main m){
		setBackground(Color.WHITE);
		status = yourTurn(); //Shows the stuff that says it's your turn
		add(status, BorderLayout.CENTER);
		this.m = m;
		setVisible(true);
	}
	
	private JLabel yourTurn(){ //Prints the 
		JLabel status = new JLabel("It is your turn", JLabel.CENTER);
		status.setBackground(Color.WHITE);
		status.setFont(new Font("Serif", Font.PLAIN, 20));		
		status.setVisible(true);
		status.setOpaque(true);
		return status;
	}
	
	// change from label to 2 buttons
	public void deathPrompt() {
       
		restart = new JButton("Play again");
		restart.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("Play again");
		        m.rebuild();
		    }
		});
		
		quit = new JButton("Quit");
		quit.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("going to quit");
		        System.exit(1);
		    }
		});
		remove(status);
		add(new JLabel("You 've lost ! "));
		add(restart);
		add(quit);
		revalidate();
	}
	
	public void youWin() {
		restart = new JButton("Play again");
		restart.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("play again");
		        m.rebuild();
		    }
		});
		
		quit = new JButton("Quit");
		quit.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println("going to quit");
		        System.exit(1);
		    }
		});
		remove(status);
		add(new JLabel("You win !!! "));
		add(restart);
		add(quit);
		revalidate();
	}
	
}
