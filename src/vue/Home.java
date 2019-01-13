package vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Home extends JPanel {
	
	private JButton play = new JButton("Play");
	private JButton quit = new JButton("Quit");
	
	public void paintComponent(Graphics g){

	    try {
	        Image img = ImageIO.read(new File("../DOMINATION/image/Home.jpg"));
	        g.drawImage(img, 0, 0, this);
	        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    this.add(play, gbc);
	    this.add(quit);
	    play.addActionListener(new MenuListener());
	    quit.addActionListener(new MenuListener());
	}
}


class MenuListener implements ActionListener{ 
  public void actionPerformed(ActionEvent e) {
	  System.out.println("Hmm: " + e.getActionCommand());
  }                

}
