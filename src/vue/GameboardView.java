package vue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameboardView extends JPanel implements ActionListener {
	
	JButton twoPlayers = new JButton("Deux joueurs");
	JButton threePlayers = new JButton("Trois joueurs");
	JButton fourPlayers = new JButton("Quatre joueurs");
	JButton back = new JButton("Retour");
				
	public void GameboardView() {
		
	}
	
	private void addButtons() {
		twoPlayers.addActionListener(this);
	    threePlayers.addActionListener(this);
	    fourPlayers.addActionListener(this);
	    back.addActionListener(this);
	    
	  //game buttons
	    this.add(back);
	    this.add(twoPlayers);
	    this.add(threePlayers);
	    this.add(fourPlayers);
	    
	    this.setBackground(Color.WHITE);

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
