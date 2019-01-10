package controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import model.Deck;
import model.Domino;

public class DeckCtrl {
	
	Deck deck = new Deck();
	
	/**
	 * Fonction permettant de supprimer un nombre de dominos en fonction du nombre de joueur.
	 * @param nbDeJoueur
	 * @return nbToDelete
	 */
	public void init(int numberOfPlayer) {
		if (numberOfPlayer == 2) {
			this.removeRandomDomino(24);
		} else if (numberOfPlayer == 3) {
			this.removeRandomDomino(12);
		}
	}
	
	/*
	 * Permet de distribuer un certain nombre de carte.
	 * @return distributeListDomino
	 */
	public ArrayList<Domino> distributeDomino(int number) {
		ArrayList<Domino> distributeListDomino = new ArrayList<Domino>();
		Random numberRandom = new Random();
		for (int i = 0; i < number; i++) {
			int j = numberRandom.nextInt(deck.listDominos.size());
			distributeListDomino.add(deck.listDominos.get(j));
			this.removeSpecificDomino(deck.listDominos.get(j).getNumeroDomino());
		}
		return distributeListDomino;
	}
	
	/*
	 * Permet d'enlever les Dominos déjà distribués 
	 */
	public void removeRandomDomino(int nbDominosToDelete) {
		Random nombreAleatoire = new Random();

		for (int i = 0; i < nbDominosToDelete; i++) {
			int j = nombreAleatoire.nextInt(deck.listDominos.size());
			deck.listDominos.remove(j);
		}
	}
	
	/**
	 * Supprimer un domino en fonction de son numéro
	 * @param numeroDomino
	 */
	public void removeSpecificDomino(int numeroDomino) {
		Iterator<Domino> iterator = deck.listDominos.iterator();
		while (iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			if(numeroDomino == domino.getNumeroDomino()) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * Retourne le nombre de domino disponible dans le deck
	 * @return
	 */
	public int getNumberOfDomino() {
		return deck.listDominos.size();
	}

}
