package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RulesView extends JPanel implements ActionListener {
	
	JButton mainMenu = new JButton("Menu principal");
	
	private void addButtons() {
	    mainMenu.addActionListener(this);
	    
	    this.add(mainMenu);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
