package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Case;
import model.Domino;
import model.Gameboard;
import model.Player;

public class GameboardCtrl {
	
	ArrayList<Domino> listOfDominoPull = new ArrayList<Domino>();

	int turn = 0;
	
	/**
	 * Initilisation du GameBoard
	 * @param deckCtrl
	 * @param playerCtrl
	 */
	public void init(DeckCtrl deckCtrl, PlayerCtrl playerCtrl) {
		this.defineGameboard(playerCtrl);
		deckCtrl.init(playerCtrl.numberOfPlayers);
		this.firstTurnOfPlay(playerCtrl, deckCtrl);
		while(deckCtrl.getNumberOfDomino() != 0) {
			this.turnOfPlayer(playerCtrl, deckCtrl);
		}
	}
	
	/**
	 * Initialisation de chaque plateau et affichage pour chaque joueur
	 * @param playerCtrl
	 */
	public void defineGameboard(PlayerCtrl playerCtrl) {
		Iterator<Player> iterator = playerCtrl.listOfPlayers.iterator();
		while(iterator.hasNext()) {
			Player player = iterator.next();
			player.gameboard = new Gameboard(900,900);
			System.out.println("Le plateau de jeu de " + player.getName() + " est :\n");
			this.addCastleInGameboard(player.gameboard.plat, player);
			this.displayGameboard(player.gameboard.plat);
		}
	}
	
	public void addCastleInGameboard(String[][] plat, Player player) {
		Case cases = new Case(null);
		cases.setCastle(true);
		player.gameboard.plateau.put(Double.toString(4.4), cases);
		plat[4][4] = player.getCastles();
	}
	
	/**
	 * Affiche du plateau en console
	 * @param gameboard
	 */
	public void displayGameboard(String[][] gameboard) {
        int i, j;
        for(i=0; i<gameboard.length; i++){
            for(j=0; j<gameboard.length ; j++){
                System.out.print(gameboard[i][j]);
            }
            System.out.println("\n\n\n");
        }
        System.out.println("\n");
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
