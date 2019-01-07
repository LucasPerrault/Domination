package controler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Castle;
import model.Deck;
import model.Domino;
import model.Gameboard;
import model.King;
import model.Player;
import vue.DeckView;
import vue.Window;

public class Game {
	
	ArrayList<Player> listOfPlayers = new ArrayList<Player>();
	Deck deck = new Deck();
	
	/*
	 * Constructeur de la classe 
	 */
	public Game() {
	}
	
	/*
	 * Initialisation de la partie
	 */
	public void init() {
		int value =0;
		do {
			value = menu();
			switch (value) {
				case 0:
					System.out.println("Debut de la partie !");
					
					Window window = new Window(1000,1000);
					
					int numberOfPlayers = this.setNumberOfPlayers();
					this.setPlayers(numberOfPlayers);
//					this.setCastle();
//					this.setKingsPerPlayer();
					this.deleteInitDomino(numberOfPlayers, this.deck);
					this.firstTurnOfPlay(numberOfPlayers);
				break;
			}
		} while(value !=1);
		System.out.println("Vous avez decider de quittez l'application !");		
	}
	
	/**
	 * Affichage du menu de selection d'action
	 * @return 0 ou 1
	 */
	public int menu() {
		int response = 0;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("0. Jouer \n" + "1. Quitter");
				response = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, selectionnez le 0 ou 1");
			}
			
		} while (false || response != 0 && response !=1 );
		return response;
	}
	
	/**
	 * Determine le nombre de joueur voulant jouer
	 * @return
	 */
	public int setNumberOfPlayers() {
		int nbOfPlayers = 0;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("Saisissez le nombre de joueur: 2/3/4 \n");
				nbOfPlayers = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, seulement 2, 3 ou 4 joueurs sont autorises a jouer");
				scan.nextLine();
			}
		} while (false  || nbOfPlayers !=2 && nbOfPlayers !=3 && nbOfPlayers !=4);
		return nbOfPlayers;
	}
	
	/*
	 * Creer l'objet joueur en fonction du nombre de joueur. 
	 */
	public void setPlayers(int numberOfPlayers) {
		String nameOfPlayer;
		Scanner scan = new Scanner(System.in);
		for(int i=1; i <= numberOfPlayers; i++) {
			try {
				System.out.println("Saisissez le pseudo du joueur n�" + i +  ": \n");
				nameOfPlayer = scan.next();
				Player player = new Player(nameOfPlayer);
				this.listOfPlayers.add(player);
			} catch(Exception e) {
				System.out.println("ATTENTION, saisissez bien le prenom du joueur !");
				scan.nextLine();
			}
		}
	}
	
	/**
	 * Affiche un menu de possibilite de couleur pour les rois et chateaux
	 * @param player
	 * @return color
	 */
	public String getListOfPosibilityColor(Player player) {
		String color;
		int response = 0;
		Scanner scan = new Scanner(System.in);
		// Le joueur choisit une couleur impos�e
		System.out.println(player.getName() + " choisissez votre couleur avec le chiffre correspondant: \n");
		do {
			try {
				System.out.println("1. Rouge \n" + "2. Bleu \n" + "3. Vert \n" + "4. Jaune \n");
				response = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, selectionnez le 1, 2, 3 ou 4");
			}
			
		} while (false || response != 1 && response !=2 && response != 3 && response != 4 );
		
		switch (response) {
			case 1:
				return "Rouge";
			case 2:
				return "Bleu";
			case 3:
				return "Vert";
			case 4:
				return "Jaune";
			default:
				return "Erreur veuillez reessayer..";
		}
	}
	
	/**
	 * Regarde les couleurs deja� choisie par nos joueurs pour les rois et chateaux
	 * @param color
	 * @return boolean
	 */
	public boolean checkColorIsSelected(String color) {
		Iterator<Player> iteratorPlayer = this.listOfPlayers.iterator();
		while(iteratorPlayer.hasNext()) {
			Player player = iteratorPlayer.next();
			Iterator<King> iteratorKing = player.listKings.iterator();
			while(iteratorKing.hasNext()) {
				King king= iteratorKing.next();
				if(color.equals(king.getColor())){
					System.out.println("Cette couleur est deja� choisie ! \n");
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * Definit les rois de chaque joueur.
	 */
	public void setKingsPerPlayer() {
		String colorKing;
		boolean isSelectColorNotExist;
		Iterator<Player> iterator = this.listOfPlayers.iterator();
		// On parcourt la liste des joueurs du jeu.
		while(iterator.hasNext()) {
			Player player = iterator.next();
			// S'il y a deux joueurs
			if(this.listOfPlayers.size() == 2) {
				// Il doit choisir deux rois, donc boucle de deux
				for(int i=1; i < this.listOfPlayers.size()+1; i++) {
					do {
						System.out.println("Selection du roi \n");
						colorKing = this.getListOfPosibilityColor(player);
						isSelectColorNotExist = checkColorIsSelected(colorKing);
					} while(!isSelectColorNotExist);
					King king = new King(colorKing);
					player.listKings.add(king);
				}
			} else {
				do {
					System.out.println("Selection du roi \n");
					colorKing = this.getListOfPosibilityColor(player);
					isSelectColorNotExist = checkColorIsSelected(colorKing);
				} while(!isSelectColorNotExist);
				King king = new King(colorKing);
				player.listKings.add(king);
			}
		}
	}
	
	/*
	 * Définit les chateaux de chaque joueur
	 */
	public void setCastle() {
		String colorCastle;
		boolean isSelectColorNotExist;
		Iterator<Player> iterator = this.listOfPlayers.iterator();
		// On parcourt la liste des joueurs du jeu.
		while(iterator.hasNext()) {
			Player player = iterator.next();
			// S'il y a deux joueurs
			do {
				System.out.println("Selection du chateau \n");
				colorCastle = this.getListOfPosibilityColor(player);
				isSelectColorNotExist = checkColorIsSelected(colorCastle);
			} while(!isSelectColorNotExist);
			Castle castle = new Castle(colorCastle);
			player.listCastle.add(castle);
		}
	}
	
	/**
	 * Fonction permettant de supprimer un nombre de dominos en fonction du nombre de joueur.
	 * @param nbDeJoueur
	 * @return nbToDelete
	 */
	public void deleteInitDomino(int numberOfPlayer, Deck deck) {
		if (numberOfPlayer == 2) {
			deck.removeRandomDomino(24);
		} else if (numberOfPlayer == 3) {
			deck.removeRandomDomino(12);
		}
	}
	
	/*
	 * Définit les actions durant le premier tour de jeu 
	 */
	public void firstTurnOfPlay(int numberOfPlayer) {
		ArrayList<Domino> listOfDominoWhichTakeByPlayers = new ArrayList<Domino>();
		if(numberOfPlayer == 3) {
			listOfDominoWhichTakeByPlayers = this.deck.distributeDomino(3);
		} else {
			listOfDominoWhichTakeByPlayers = this.deck.distributeDomino(4);
		}
		// On trie les dominos qui ont été tiré
		this.sortDomino(listOfDominoWhichTakeByPlayers);
		
		// @Todo: à refaire fonctionner orderPlayers
		
		this.selectDomino(listOfDominoWhichTakeByPlayers);
			
		// @Todo: Créer la fonction qui permet de placer un domino sur le plateau
	}
	
	/**
	 * Affiche les dominos disponible que les joueurs peuvent choisir
	 * @param listOfDominoWhichTakeByPlayers
	 */
	public void displayDisponibleDomino(ArrayList<Domino> listOfDominoWhichTakeByPlayers) {
		Iterator<Domino> iterator = listOfDominoWhichTakeByPlayers.iterator();
		while(iterator.hasNext()) {
			Domino domino = iterator.next();
			System.out.println("Les dominos disponibles sont : " + domino.getNumeroDomino() + "\n" );
		}
		
	}
	
	/**
	 * On supprime le domino qui vient d'être choisi par un joueur
	 * @param numeroDomino
	 * @param listOfDominoWhichTakeByPlayers
	 * @return
	 */
	public ArrayList<Domino> removeDominoInDisponibleList(int numeroDomino, ArrayList<Domino> listOfDominoWhichTakeByPlayers) {
		Iterator<Domino> iterator = listOfDominoWhichTakeByPlayers.iterator();
		while (iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			if(numeroDomino == domino.getNumeroDomino()) {
				iterator.remove();
			}
		}
		return listOfDominoWhichTakeByPlayers;
	}
	
	/**
	 * On ajoute le domino choisi par le joueur à sa liste
	 * @param listOfDominoWhichTakeByPlayers
	 * @param numberOfDominoSelect
	 * @param player
	 */
	public void addDominoInListOfPlayer(ArrayList<Domino> listOfDominoWhichTakeByPlayers, int numberOfDominoSelect, Player player) {
		Iterator<Domino> iterator = listOfDominoWhichTakeByPlayers.iterator();
		while (iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			if(numberOfDominoSelect == domino.getNumeroDomino()) {
				player.listDominos.add(domino);
				System.out.println(player.getName() + " a choisi le domino numéro: " + domino.getNumeroDomino() + "\n");
			}
		}

	}
	
	/**
	 * Selection de un ou deux dominos par rapport au nombre de joueur
	 * @param listOfDominoWhichTakeByPlayers
	 */
	public void selectDomino(ArrayList<Domino> listOfDominoWhichTakeByPlayers) {
		Iterator<Player> iterator = this.listOfPlayers.iterator();
		Scanner scan = new Scanner(System.in);
		int numberOfDominoSelect = 0;

		while(iterator.hasNext()) {
			Player player = iterator.next();
			System.out.println(player.getName());
			// Si il y a deux joueurs, ils doivent choisir deux dominos
			if(listOfPlayers.size() == 2) {
				for(int i=0; i<listOfPlayers.size(); i++) {
					System.out.println("C'est à " + player.getName() + " de jouer\n");
					
					this.displayDisponibleDomino(listOfDominoWhichTakeByPlayers);
					try {
						System.out.println("Veuillez selectionner le numero domino que vous souhaitez : \n");
						numberOfDominoSelect = scan.nextInt();
					} catch(Exception e) {
						System.out.println("ATTENTION, selectionnez le numero du domino \n");
					}
					this.addDominoInListOfPlayer(listOfDominoWhichTakeByPlayers, numberOfDominoSelect, player);
//					this.determineOrderOfPlayerNextPlay(listOfDominoWhichTakeByPlayers);
					this.removeDominoInDisponibleList(numberOfDominoSelect, listOfDominoWhichTakeByPlayers);
				}
			} else {
				System.out.println("C'est à " + player.getName() + " de jouer\n");
				
				this.displayDisponibleDomino(listOfDominoWhichTakeByPlayers);
				try {
					System.out.println("Veuillez selectionner le numero domino que vous souhaitez : \n");
					numberOfDominoSelect = scan.nextInt();
				} catch(Exception e) {
					System.out.println("ATTENTION, selectionnez le numero du domino \n");
				}
				this.addDominoInListOfPlayer(listOfDominoWhichTakeByPlayers, numberOfDominoSelect, player);
				this.determineOrderOfPlayerNextPlay(listOfDominoWhichTakeByPlayers, numberOfDominoSelect, player);
				this.removeDominoInDisponibleList(numberOfDominoSelect, listOfDominoWhichTakeByPlayers);
			}
		}
		
		// On parcourt la liste des joueurs du jeu.
	}
	
	public void determineOrderOfPlayerNextPlay(ArrayList<Domino> listOfDominoWhichTakeByPlayers, int numberOfDominoSelect, Player player) {
//		System.out.println(player.getName() + " a pris le domino numero " + numberOfDominoSelect + "\n");
//		ArrayList<Player> listOfOrderPlayers = new ArrayList<Player>();
//		Iterator<Domino> iterator =  listOfDominoWhichTakeByPlayers.iterator();
//		int indexOrder;
//		while(iterator.hasNext()) {
//			Domino domino = iterator.next();
//			if(domino.getNumeroDomino() == numberOfDominoSelect) {
//			}
//		}
		
		// @ Todo: 
		
	}
	
	/*
	 * Définit les actions de chaque tour de jeu 
	 */
	public void turnOfPlay() {
		// On remet la liste des joueurs à zéro à chaque tours
		// On tire de nouveau domino
		// On les trie
		// Le roi placé sur le domino le plus petit, choisi son prochain domino.
		// Puis il le place

	}
	
	/*
	 * Trie les dominos dans l'ordre croissant 
	 */
	public ArrayList<Domino> sortDomino(ArrayList<Domino> liste) {
		Collections.sort(liste, Comparator.comparingInt(Domino::getNumeroDomino));
		return liste;
	}
	
	/*
	 * Définit l'ordre de passage de chaque joueur 
	 */
	public ArrayList<Player> orderPlayers() {
		ArrayList<Player> listOfOrderPlayers = new ArrayList<Player>();
		String firstPlayer = "";
		Random numberRandom = new Random();
//		for (int i = 0; i < this.listOfPlayers.size(); i++) {
//			int j = numberRandom.nextInt(this.listOfPlayers.size());
//			// Affichage du nom du premier joueur
//			firstPlayer = this.listOfPlayers.get(j).getName();
//			listOfOrderPlayers.add(this.listOfPlayers.get(j));
//		}
		System.out.println("Le joueur qui commencera est : " + firstPlayer + "\n");
		return listOfOrderPlayers;
	}
	
}
