import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Partie {
	private double nbTour, nbJoueur;
	
	public Partie(double nbTourInit, double nbJoueurInit, Map<String, String> couleurParJoueurInit ) {
		nbTour = nbTourInit;
		nbJoueur = nbJoueurInit;
		this.initPartie(couleurParJoueurInit);
	}
	
	private void initPartie(Map<String, String> couleurParJoueur) {
		afficheDico(couleurParJoueur);
		
	}
	
	/**
	 * Afficher un dictionnaire
	 * @param map
	 */
	public static void afficheDico(Map map) {
		Set <Entry>setMap = map.entrySet();
		Iterator <Entry>iter = setMap.iterator();
		while(iter.hasNext()) {
			Entry displayMap = iter.next();
			System.out.println(displayMap.getKey() + ":" + displayMap.getValue());
		}
	}
	
	private void piocherDomino() {
		
	}
	
	private void trierDomino() {
		
	}
	
	private void placementDomino() {
		
	}
	
	

}
