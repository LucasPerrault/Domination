package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import model.Domino;

public class GameboardCtrl {
	
	ArrayList<Domino> listOfDominoPull = new ArrayList<Domino>();
	int turn = 0;
	
	/**
	 * Initilisation du GameBoard
	 * @param deckCtrl
	 * @param playerCtrl
	 */
	public void init(DeckCtrl deckCtrl, PlayerCtrl playerCtrl) {
		deckCtrl.init(playerCtrl.numberOfPlayers);
		this.firstTurnOfPlay(playerCtrl, deckCtrl);
		while(deckCtrl.getNumberOfDomino() != 0) {
			this.turnOfPlayer(playerCtrl, deckCtrl);
		}
	}

	
	/*
	 * Définit les actions durant le premier tour de jeu 
	 */
	public void firstTurnOfPlay(PlayerCtrl playerCtrl, DeckCtrl deckCtrl) {
		this.turn += 1;
		System.out.println("\n\n*******************Tour n°: " + this.turn + "****************\n");
		
		if(playerCtrl.numberOfPlayers == 3) {
			this.listOfDominoPull = deckCtrl.distributeDomino(3);
		} else {
			this.listOfDominoPull = deckCtrl.distributeDomino(4);
		}

		this.sortDomino(this.listOfDominoPull);
		
		playerCtrl.randomOrderPlayer();
		
		playerCtrl.orderPlayer(playerCtrl.selectDomino(this));		
			
		// @Todo: Créer la fonction qui permet de placer un domino sur le plateau
	}
	
	/**
	 * Méthode pour chaque tour
	 * @param playerCtrl
	 * @param deckCtrl
	 */
	public void turnOfPlayer(PlayerCtrl playerCtrl, DeckCtrl deckCtrl) {
		this.turn += 1;
		System.out.println("******************Tour n°: " + this.turn + "******************\n");
		
		if(playerCtrl.numberOfPlayers == 3) {
			this.listOfDominoPull = deckCtrl.distributeDomino(3);
		} else {
			this.listOfDominoPull = deckCtrl.distributeDomino(4);
		}
				
		this.sortDomino(this.listOfDominoPull);
		
		playerCtrl.orderPlayer(playerCtrl.selectDomino(this));

	}

	/*
	 * Trie les dominos dans l'ordre croissant 
	 */
	public ArrayList<Domino> sortDomino(ArrayList<Domino> liste) {
		Collections.sort(liste, Comparator.comparingInt(Domino::getNumeroDomino));
		return liste;
	}
	
	
	/**
	 * Affiche les dominos disponible que les joueurs peuvent choisir
	 * @param listOfDominoWhichTakeByPlayers
	 */
	public void displayDomino() {
		Iterator<Domino> iterator = this.listOfDominoPull.iterator();
		while(iterator.hasNext()) {
			Domino domino = iterator.next();
			System.out.println("Les dominos disponibles sont : " + domino.getNumeroDomino());
		}
		
	}
	
	/**
	 * On supprime le domino qui vient d'être choisi par un joueur
	 * @param numeroDomino
	 * @param listOfDominoWhichTakeByPlayers
	 * @return
	 */
	public void removeSelectDomino(int numeroDomino) {
		Iterator<Domino> iterator = this.listOfDominoPull.iterator();
		while (iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			if(numeroDomino == domino.getNumeroDomino()) {
				iterator.remove();
			}
		}
	}

	

}
