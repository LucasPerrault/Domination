import java.util.ArrayList;
import java.util.Iterator;


/*
 *  Projet: Domination
 *  
 *  Créateur: Camélia De Sousa, Augustin Simon et Lucas Perrault
 *  Date de début: 20/11/2018
 *  Date de fin: 
 *  
 *  Cours: Algorithme et Programmation
 *  Professeur: Monsieur Hugueney
 */


public class App {
	
	public static void main(String[] args) {
		Game game = new Game();
		Deck deck = new Deck();
		ArrayList<Domino> listDomino = new ArrayList();
		listDomino = game.sortDomino(deck.distributeDomino(4));
		Iterator<Domino> iterator = listDomino.iterator();
		while(iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			System.out.println(domino.toString());
		}
		
	}

}
