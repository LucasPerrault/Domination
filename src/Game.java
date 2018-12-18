import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	ArrayList<Player> listOfPlayers = new ArrayList<Player>();
	
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
					System.out.println("Début de la partie !");
					Deck deck = new Deck();
					int numberOfPlayers = this.setNumberOfPlayers();
					this.setPlayers(numberOfPlayers);
					this.setCastle();
					this.setKingsPerPlayer();
					this.deleteInitDomino(numberOfPlayers, deck);
				break;
			}
		} while(value !=1);
		System.out.println("Vous avez décider de quittez l'application !");		
	}
	
	/**
	 * Affichage du menu de sélection d'action
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
	 * Détermine le nombre de joueur voulant jouer
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
				System.out.println("ATTENTION, seulement 2, 3 ou 4 joueurs sont autorisés à jouer");
				scan.nextLine();
			}
		} while (false  || nbOfPlayers !=2 && nbOfPlayers !=3 && nbOfPlayers !=4);
		return nbOfPlayers;
	}
	
	/*
	 * Créer l'objet joueur en fonction du nombre de joueur. 
	 */
	public void setPlayers(int numberOfPlayers) {
		String nameOfPlayer;
		Scanner scan = new Scanner(System.in);
		for(int i=0; i < numberOfPlayers; i++) {
			try {
				System.out.println("Saisissez le pseudo du joueur n°" + i +  ": \n");
				nameOfPlayer = scan.next();
				Player player = new Player(nameOfPlayer);
				this.listOfPlayers.add(player);
			} catch(Exception e) {
				System.out.println("ATTENTION, saisissez bien le prénom du joueur !");
				scan.nextLine();
			}
		}
	}
	
	/**
	 * Affiche un menu de possibilité de couleur pour les rois et chateaux
	 * @param player
	 * @return color
	 */
	public String getListOfPosibilityColor(Player player) {
		String color;
		int response = 0;
		Scanner scan = new Scanner(System.in);
		// Le joueur choisit une couleur imposée
		System.out.println(player.getName() + " choisissez votre couleur avec le chiffre correspondant: \n");
		do {
			try {
				System.out.println("0. Rouge \n" + "1. Bleu \n" + "2. Vert \n" + "3. Jaune \n");
				response = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, selectionnez le 0, 1, 2 ou 3");
			}
			
		} while (false || response != 0 && response !=1 && response != 2 && response != 3 );
		
		switch (response) {
			case 0:
				return "Rouge";
			case 1:
				return "Bleu";
			case 2:
				return "Vert";
			case 3:
				return "Jaune";
			default:
				return "Erreur veuillez réessayer..";
		}
	}
	
	/**
	 * Regarde les couleurs déjà choisie par nos joueurs pour les rois et chateaux
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
					System.out.println("Cette couleur est déjà choisie ! \n");
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * Définit les rois de chaque joueur.
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
						System.out.println("Sélection du roi \n");
						colorKing = this.getListOfPosibilityColor(player);
						isSelectColorNotExist = checkColorIsSelected(colorKing);
					} while(!isSelectColorNotExist);
					King king = new King(colorKing);
					player.listKings.add(king);
				}
			} else {
				do {
					System.out.println("Sélection du roi \n");
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
				System.out.println("Sélection du chateau \n");
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
