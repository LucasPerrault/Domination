package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import model.Domino;
import model.Gameboard;
import model.Player;

public class PlayerCtrl {
	
	ArrayList<Player> listOfPlayers = new ArrayList<Player>();
	int numberOfPlayers = 0;
	
	int WITH_GAMEBOARD = 300;
	int HEIGHT_GAMEBOARD = 300; 
	
	/**
	 * Determine le nombre de joueur voulant jouer
	 * @return
	 */
	public void setNumberOfPlayers() {
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("Saisissez le nombre de joueur: 2/3/4 \n");
				this.numberOfPlayers = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, seulement 2, 3 ou 4 joueurs sont autorisés à jouer");
				scan.nextLine();
			}
		} while (false  || this.numberOfPlayers !=2 && this.numberOfPlayers !=3 && this.numberOfPlayers !=4);
	}
	
	/*
	 * Creer l'objet joueur en fonction du nombre de joueur. 
	 */
	public void setPlayers() {
		String nameOfPlayer;
		Scanner scan = new Scanner(System.in);
		for(int i=1; i <= this.numberOfPlayers; i++) {
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
	 * Créer le plateau pour chacun des joueurs
	 */
	public void setGameboardOfPlayer() {
		Iterator<Player> iterator = this.listOfPlayers.iterator();
		while(iterator.hasNext()) {
			Player player = iterator.next();
			player.gameboard = new Gameboard(this.WITH_GAMEBOARD, this.HEIGHT_GAMEBOARD);
		}
		
	}
	
	/**
	 * Randomise l'ordre des joueurs au premier tour
	 */
	public void randomOrderPlayer() {
		Player player;
		Random rand = new Random();
		int randomNumber = rand.nextInt(this.numberOfPlayers);
		for(int i=0; i<this.numberOfPlayers; i++) {
			player = this.listOfPlayers.get(i);
			this.listOfPlayers.set(i, this.listOfPlayers.get(randomNumber));
			this.listOfPlayers.set(randomNumber, player);
		}
	}
	
	/**
	 * Selection d'un filtre et de ses modifications
	 * @param gameboardCtrl
	 * @return
	 */
	public ArrayList<Domino> selectDomino(GameboardCtrl gameboardCtrl) {
		ArrayList<Domino> initialListOfDominoPull = new ArrayList<Domino>(gameboardCtrl.listOfDominoPull);
		
		Iterator<Player> iterator = this.listOfPlayers.iterator();
		Scanner scan = new Scanner(System.in);
		int numberOfDominoSelect = 0;

		while(iterator.hasNext()) {
			Player player = iterator.next();
			System.out.println("INFORMATION: C'est à " + player.getName() + " de jouer\n");
			gameboardCtrl.displayDomino();
			
			// Si il y a deux joueurs, ils doivent choisir deux dominos
			if(listOfPlayers.size() == 2) {
				
				for(int i=0; i<listOfPlayers.size(); i++) {
										
					try {
						System.out.println("Veuillez selectionner le numero du domino que vous souhaitez : \n");
						numberOfDominoSelect = scan.nextInt();
					} catch(Exception e) {
						System.out.println("ATTENTION, selectionnez le numero du domino \n");
					}

					player.addDomino(gameboardCtrl.listOfDominoPull, numberOfDominoSelect);
					gameboardCtrl.removeSelectDomino(numberOfDominoSelect);
				}
			} else {
				
				try {
					System.out.println("Veuillez selectionner le numero domino que vous souhaitez : \n");
					numberOfDominoSelect = scan.nextInt();
				} catch(Exception e) {
					System.out.println("ATTENTION, selectionnez le numero du domino \n");
				}
				player.addDomino(gameboardCtrl.listOfDominoPull, numberOfDominoSelect);
				gameboardCtrl.removeSelectDomino(numberOfDominoSelect);

			}
		}
		
		return initialListOfDominoPull;
		
	}
	
	public void orderPlayer(ArrayList<Domino> initialListOfDominoPull) {
		ArrayList<Player> oldListOfPlayers = new ArrayList<Player>(this.listOfPlayers);
		Iterator<Domino> initialDominoPull = initialListOfDominoPull.iterator();
		
		int placeOfPlayer = -1;
		while(initialDominoPull.hasNext()) {
			placeOfPlayer +=1;
			Domino dominoPull = initialDominoPull.next();
			System.out.println("Le numero de la liste est : " + dominoPull.getNumeroDomino());
			
			Iterator<Player> players = oldListOfPlayers.iterator();
			while(players.hasNext()) {
				Player player = players.next();
				
				Iterator<Domino> dominos = player.listDominos.iterator();
				while(dominos.hasNext()) {
					Domino domino = dominos.next();
					
					if(domino.getNumeroDomino() == dominoPull.getNumeroDomino()) {
						if(placeOfPlayer >= this.listOfPlayers.size()) {
							this.listOfPlayers.add(player);
						}
						this.listOfPlayers.set(placeOfPlayer,player);
					}
				}
			}
		}
	}
	
}
