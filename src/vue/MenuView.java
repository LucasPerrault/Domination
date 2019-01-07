package vue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel implements ActionListener {
	
	JButton play = new JButton("Jouer");
	JButton regles = new JButton("Regles");
	JButton exit = new JButton("QUITTER");
	JButton back = new JButton("Retour");
	
	CardLayout layout = new CardLayout(100,150);
	
	GameboardView game = new GameboardView();
	RulesView rules = new RulesView();
	
	public void MenuView() {
		// On définit le layout du panel parent.
	    this.setLayout(layout);        
	    addButtons();
	}
	
	private void addButtons() {
		play.addActionListener(this);
	    regles.addActionListener(this);
	    exit.addActionListener(this);
	    back.addActionListener(this);
	    
	    //menu buttons
	    this.add(regles);
	    this.add(play);
	    this.add(exit);
	    
	    this.add(game,"Game");
	    this.add(rules,"Regles");
	    
	    this.setBackground(Color.BLACK);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
				
	}

}
