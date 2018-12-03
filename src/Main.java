import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import edu.princeton.cs.introcs.StdDraw;


public class Main {
	
	public static void main(String[] args) {
		
		String[] tableName = {"Lucas", "Augustin"};
		Map<String, String> couleurParJoueur = new HashMap<String, String>();
		couleurParJoueur.put("Lucas", "Rouge");
		couleurParJoueur.put("Jean-Pierre", "Noir");
		couleurParJoueur.put("Augustin", "Vert");
		couleurParJoueur.put("Camélia", "Rouge");
		
		Partie partie = new Partie(0, couleurParJoueur.size(), couleurParJoueur);
		
	}
}

