package vue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private int width, height;
	
	JButton play = new JButton("Jouer");
	JButton regles = new JButton("Regles");
	JButton exit = new JButton("QUITTER");
	JButton mainMenu = new JButton("Menu principal");
	JButton twoPlayers = new JButton("Deux joueurs");
	JButton threePlayers = new JButton("Trois joueurs");
	JButton fourPlayers = new JButton("Quatre joueurs");
	JButton back = new JButton("Retour");
	
	CardLayout layout = new CardLayout(100,150);
	
	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	JPanel menu = new JPanel(( new GridLayout(6, 3, 100, 100) )); 
	JPanel rules = new JPanel(); 
	JPanel two = new JPanel(); 
	JPanel three = new JPanel(); 
	JPanel four = new JPanel(); 

	public Window(int width, int height) {
	    this.width = width;
	    this.height = height;
	
	    panel.setLayout(layout);        
	    addButtons();
	
	    setSize(width, height);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setTitle("DOMINATION");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    requestFocus();
	
	}

	private void addButtons() {
		
	    play.addActionListener(this);
	    regles.addActionListener(this);
	    exit.addActionListener(this);
	    mainMenu.addActionListener(this);
	    back.addActionListener(this);
	    twoPlayers.addActionListener(this);
	    threePlayers.addActionListener(this);
	    fourPlayers.addActionListener(this);
	
	    //menu buttons
	    menu.add(regles);
	    menu.add(play);
	    menu.add(exit);
	
	    //game buttons
	    game.add(back);
	    game.add(twoPlayers);
	    game.add(threePlayers);
	    game.add(fourPlayers);
	    
	    //rules buttons
	    rules.add(mainMenu);
	
	    //background colors
	    game.setBackground(Color.WHITE);
	    menu.setBackground(Color.BLACK);
	    two.setBackground(Color.ORANGE);
	    three.setBackground(Color.BLUE);
	    four.setBackground(Color.RED);
	
	    //adding children to parent Panel
	    panel.add(menu,"Menu");
	    panel.add(game,"Game");
	    panel.add(rules,"Regles");
	    panel.add(two,"Two");
	    panel.add(three,"Three");
	    panel.add(four,"Four");
	
	    add(panel);
	    layout.show(panel,"Menu");
	
	}

	public void actionPerformed(ActionEvent event) {

	    Object source = event.getSource();
	
	    if (source == exit) {
	        System.exit(0);
	    } else if (source == play) {
	        layout.show(panel, "Game");
	    } else if (source == regles){
	        layout.show(panel, "Regles");
	    } else if (source == mainMenu){
	        layout.show(panel, "Menu");
	    } else if (source == back){
	        layout.show(panel, "Menu");
	    } else if (source == twoPlayers){
	        layout.show(panel, "Two");
	    } else if (source == threePlayers){
	        layout.show(panel, "Three");
	    } else if (source == fourPlayers){
	        layout.show(panel, "Four");
	    }

    }

}
