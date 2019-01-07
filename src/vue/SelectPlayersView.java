package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectPlayersView extends JPanel implements ActionListener {
	
	JPanel two = new JPanel(); 
	JPanel three = new JPanel(); 
	JPanel four = new JPanel(); 

	
	private void addButtons() {
		
		this.add(two,"Two");
	    this.add(three,"Three");
	    this.add(four,"Four");
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
