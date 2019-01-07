package vue;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameboardView extends JPanel {
	
				
	public void paintComponent(Graphics g){

	    //x1, y1, width, height

	    g.drawRect(10, 10, 300, 300);

	}        
}
