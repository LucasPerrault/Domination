import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
		// PARTIE CAMELIA
	}
	
	private void piocherDomino() {
		// PARTIE AUGUSTIN
	}
	
	/**
	 * Cette fonction permet 
	 */
	private static void trierDomino() {
		if(liste.isEmpty()) {
			System.out.println("Il faut une liste non vide");
			return;
		}
		List<Integer> sousListe = liste.subList(0, liste.size());
		Collections.sort(liste); 
		System.out.println(liste);
	}
	
	private void placementDomino() {
		
	}
	
	

}
