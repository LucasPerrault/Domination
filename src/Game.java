import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {
	
	ArrayList<Player> players;
	
	/*
	 * Constructeur de la classe 
	 */
	public Game() {
		this.toString();
	}
	
	public String toString() {
		return "Début de la partie";
	}
	/*
	 * Initialisation de la partie
	 */
	public void init() {
		//
	}
	
	/*
	 * Définit la liste de joueur ajouter dans l'interface. 
	 */
	public void setPlayers() {
		//
	}
	
	/*
	 * Définit les rois de chaque joueur.
	 */
	public void setKingsPerPlayer() {
		//
	}
	
	/*
	 * Définit les chateaux de chaque joueur
	 */
	public void setCastle() {
		//
	}
	
	/**
	 * Fonction permettant de supprimer un nombre de dominos en fonction du nombre de joueur.
	 * @param nbDeJoueur
	 * @return nbToDelete
	 */
	public static int nbDominosToDelete(int nbOfPlayer) {
		int nbToDelete = 0;
		if (nbOfPlayer == 2) {
			nbToDelete = 24;
		} else if (nbOfPlayer == 3) {
			nbToDelete = 12;
		}
		return nbToDelete;
	}
	
	/*
	 * Définit les actions durant le premier tour de jeu 
	 */
	public void firstTurnOfPlay() {
		//
	}
	
	/*
	 * Définit les actions de chaque tour de jeu 
	 */
	public void turnOfPlay() {
		//
	}
	
	/*
	 * Trie les dominos dans l'ordre croissant 
	 */
	public ArrayList<Domino> sortDomino(ArrayList<Domino> liste) {
		Collections.sort(liste, Comparator.comparingInt(Domino::getNumeroDomino));
		return liste;
	}
	
	/*
	 * Mélange de manière aléatoire une liste de roi (joueurs) afin de déterminer lequel qui commencera. 
	 */
	public void mixKing() {
		//
	}
	
	/*
	 * Définit l'ordre de passage de chaque joueur 
	 */
	public void orderPlayers() {
		//
	}
	
	/*
	 * Définit le Domino choisit par chaque joueur 
	 */
	public void selectDomino() {
		//
	}
	
	
}
