import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	ArrayList<Player> listOfPlayers = new ArrayList<Player>();
	
	/*
	 * Constructeur de la classe 
	 */
	public Game() {
		this.toString();
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
					this.setKingsPerPlayer(numberOfPlayers);
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
				System.out.println("Saisissez le nombre du joueur n°" + i +  ": \n");
				nameOfPlayer = scan.next();
				Player player = new Player(nameOfPlayer);
				this.listOfPlayers.add(player);
			} catch(Exception e) {
				System.out.println("ATTENTION, saisissez bien le prénom du joueur !");
				scan.nextLine();
			}
		}
	}
	
	/*
	 * Définit les rois de chaque joueur.
	 */
	public void setKingsPerPlayer(int numberOfPlayers) {
		String color;
		Scanner scan = new Scanner(System.in);
		if(numberOfPlayers == 2) {
			for(int i=1; i < numberOfPlayers+1; i++) {
				try {
					for(int j=0; j < 2; j++) {
						System.out.println("Joueur n°"+ i +", quelle couleur voulez-vous ? \n");
						color = scan.next();
						King king = new King(color);
					}
				} catch(Exception e) {
					System.out.println("ATTENTION, choisissez bien une couleur !");
					scan.nextLine();
				}
			}
		} else {
			for(int i=1; i < numberOfPlayers+1; i++) {
				try {
					System.out.println("Joueur n°"+ i +", quelle couleur voulez-vous ? \n");
					color = scan.next();
					King king = new King(color);
				} catch(Exception e) {
					System.out.println("ATTENTION, choisissez bien une couleur !");
					scan.nextLine();
				}
			}
		}
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
