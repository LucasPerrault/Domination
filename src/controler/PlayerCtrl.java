package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import model.Case;
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
				System.out.println("Saisissez le nombre de joueur: 1/2/3/4 \n (Si vous souhaitez jouer seul, une IA sera automatiquement proposée \n");
				this.numberOfPlayers = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, seulement 1, 2, 3 ou 4 joueurs sont autorisés à jouer");
				scan.nextLine();
			}
		} while (false  || this.numberOfPlayers !=1 && this.numberOfPlayers !=2 && this.numberOfPlayers !=3 && this.numberOfPlayers !=4);
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
				Player player = new Player(nameOfPlayer, false);
				this.listOfPlayers.add(player);
			} catch(Exception e) {
				System.out.println("ATTENTION, saisissez bien le prenom du joueur !");
				scan.nextLine();
			}
		}
	}
	
	/**
	 * Menu pour choisir de jouer ou non avec une IA
	 * @return
	 */
	public int choiceIA() {
		int playingWithIA = 1;
		if(this.numberOfPlayers == 1) {
			// S'il n'y qu'un joueur, alors une IA est automatiquement ajoutées
			playingWithIA = 0;
		} else {
			Scanner scan = new Scanner(System.in);
			do {
				try {
					System.out.println("Souhaitez-vous jouer contre une IA ? \n 0 - OUI \n 1 - NON \n");
					playingWithIA = scan.nextInt();
				} catch(Exception e) {
					System.out.println("ATTENTION, seulement les réponses 0 ou 1 sont autorisés");
					scan.nextLine();
				}
			} while (false  || playingWithIA !=0 && playingWithIA !=1);
		}
		return playingWithIA;
	}
	
	/**
	 * Création de l'IA en fonction de la réponse de la fonction d'au dessus
	 * @param playingWithIA
	 */
	public void createIA(int playingWithIA) {
		if(playingWithIA == 0) {
			Player ia = new Player("Rebecca IA", true);
			System.out.println("Ajout de l'IA: " + ia.getName() + "\n");
			this.listOfPlayers.add(ia);
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
		Random rand = new Random();
		int numberOfDominoSelect = 0;

		while(iterator.hasNext()) {
			Player player = iterator.next();
			System.out.println("INFORMATION: C'est à " + player.getName() + " de jouer\n");
			gameboardCtrl.displayDomino();
			
			// Si il y a deux joueurs, ils doivent choisir deux dominos
			if(listOfPlayers.size() == 2) {
				if(player.isIa) {
					for(int i=0; i<listOfPlayers.size(); i++) {
						int value = rand.nextInt(gameboardCtrl.listOfDominoPull.size());
						numberOfDominoSelect = gameboardCtrl.listOfDominoPull.get(value).getNumeroDomino();
						player.addDomino(gameboardCtrl.listOfDominoPull, numberOfDominoSelect);
						gameboardCtrl.removeSelectDomino(numberOfDominoSelect);
						this.putDomino(player, gameboardCtrl);

					}
				} else {
					for(int i=0; i<listOfPlayers.size(); i++) {						
						try {
							System.out.println("Veuillez selectionner le numero du domino que vous souhaitez : \n");
							numberOfDominoSelect = scan.nextInt();
						} catch(Exception e) {
							System.out.println("ATTENTION, selectionnez le numero du domino \n");
						}
						player.addDomino(gameboardCtrl.listOfDominoPull, numberOfDominoSelect);
						gameboardCtrl.removeSelectDomino(numberOfDominoSelect);
						this.putDomino(player, gameboardCtrl);
					}
				}
			} else {
				if(player.isIa) {
					int value = rand.nextInt(gameboardCtrl.listOfDominoPull.size());
					numberOfDominoSelect = gameboardCtrl.listOfDominoPull.get(value).getNumeroDomino();
				} else {
					try {
						System.out.println("Veuillez selectionner le numero domino que vous souhaitez : \n");
						numberOfDominoSelect = scan.nextInt();
					} catch(Exception e) {
						System.out.println("ATTENTION, selectionnez le numero du domino \n");
					}
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
	
	public void putDomino(Player player, GameboardCtrl gameboardCtrl) {
			
		System.out.println("Placer ce domino sur votre plateau : \n");
		gameboardCtrl.displayGameboard(player.gameboard.plat);
	
		// Demande à l'utilisateur
		Scanner scan = new Scanner(System.in);
		String cordxyg;
		String cordxygGauche = "";
		String cordxygDroite = "";
		String cordxygHaut = "";
		String cordxygBas = "";
		int cordxg = 0;
		int cordyg =0;
		int cordxd = 0;
		int cordyd = 0;
		Case cases1;
		Case cases2;

		System.out.println("Cord X pour la tuile gauche");
		cordxg = scan.nextInt();

		System.out.println("Cord Y pour la tuile gauche");
		cordyg = scan.nextInt();

		cordxyg = (cordxg + "." + cordyg);
		cordxygGauche = (cordxg - 1 + "." + cordyg);
		cordxygDroite = (cordxg + 1 + "." + cordyg);
		cordxygHaut = (cordxg + "." + cordyg + 1);
		cordxygBas = (cordxg + "." + cordyg--);
		cases1 = new Case(player.listDominos.get(0).getTuileLeft());
		

		System.out.println("Cord X pour la tuile droite");
		cordxd = scan.nextInt();

		System.out.println("Cord Y pour la tuile droite");
		cordyd = scan.nextInt();
		
		String cordxyd = (cordxd + "." + cordyd);
		String cordxydGauche = "";
		String cordxydDroite = "";
		String cordxydHaut = "";
		String cordxydBas = "";
		
		cordxyd = (cordxd + "." + cordyd);
		cordxydGauche = (cordxd - 1 + "." + cordyd);
		cordxydDroite = (cordxd + 1 + "." + cordyd);
		cordxydHaut = (cordxd + "." + cordyd + 1);
		cordxydBas = (cordxd + "." + cordyd--);
		cases2 = new Case(player.listDominos.get(0).getTuileRight());
		
		
		if (checkCase2(player.listDominos, player.gameboard.plateau,cordxg, cordyg, cordxd, cordyd, cordxydGauche, cordxydDroite, cordxydHaut, cordxydBas) || (checkCase1(player.listDominos, player.gameboard.plateau, cordxg, cordyg, cordxygGauche, cordxygDroite, cordxygHaut, cordxygBas))) {
			player.gameboard.plateau.put(cordxyg, cases1);
			player.gameboard.plat[cordyg+1][cordxg] = cases1.toString();
			player.gameboard.plateau.put(cordxyd, cases2);
			player.gameboard.plat[cordyd+1][cordxd] = cases2.toString();
		}
	

		System.out.println(player.gameboard.plateau);			
	}
	
	
	public boolean checkCase1(ArrayList<Domino> listeDomino, Map<String, Case> plateau, int cordxg, int cordyg, String cordxyGauche,
			String cordxyDroite, String cordxyHaut, String cordxyBas) {
		ArrayList<String> listCases = new ArrayList<String>();

		if (plateau.containsKey(cordxyGauche)){
			listCases.add(cordxyGauche);
			}
		if (plateau.containsKey(cordxyDroite)){
			listCases.add(cordxyDroite);
		}
		if (plateau.containsKey(cordxyHaut)){
			listCases.add(cordxyHaut);
			}
		if (plateau.containsKey(cordxyBas)){
			listCases.add(cordxyBas);
		}
		
		if (listCases.isEmpty()) {
		    return false;
		}
		
		int nbDeCaseAdroite = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey((cordxg + i) + "." + cordyg)) {
				nbDeCaseAdroite++;
			}
		}

		int nbDeCaseAgauche = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey((cordxg - i) + "." + cordyg)) {
				nbDeCaseAgauche++;
			}
		}

		int nbDeCaseEnHaut = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey(cordxg + "." + (cordyg + i))) {
				nbDeCaseEnHaut++;
			}
		}

		int nbDeCaseEnBas = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey(cordxg + "." + (cordyg - i))) {
				nbDeCaseEnBas++;
			}
		}
		
		if (nbDeCaseAdroite > 4 || nbDeCaseAgauche > 4 || nbDeCaseEnHaut > 4 || nbDeCaseEnBas > 4) {
			System.out.println("Impossible de placer la case sinon on d�passe 5x5");
			return false;
		}
		else {
			for (int i = 0; i < listCases.size(); i++) {
				if (plateau.get(listCases.get(i)).isCastle()) {
					System.out.println("La case adjacente est un chateau");
					return true;
				}
				if (listeDomino.get(1).getTuileLeft().getType().equalsIgnoreCase(plateau.get(listCases.get(i)).getTuile().getType())) {
					System.out.println("La case adjacente est du meme type");
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	
	

	
	
	public boolean checkCase2(ArrayList<Domino> listeDomino, Map<String, Case> plateau,int cordxg, int cordyg,int cordxd, int cordyd, String cordxyGauche,
			String cordxyDroite, String cordxyHaut, String cordxyBas) {
		ArrayList<String> listCases = new ArrayList<String>();
		

		if (plateau.containsKey(cordxyGauche)) {
			listCases.add(cordxyGauche);
		}
		if (plateau.containsKey(cordxyDroite)) {
			listCases.add(cordxyDroite);
		}
		if (plateau.containsKey(cordxyHaut)) {
			listCases.add(cordxyHaut);
		}
		if (plateau.containsKey(cordxyBas)) {
			listCases.add(cordxyBas);
		}

		if (listCases.isEmpty()) {
			return false;
		}

		int nbDeCaseAdroite = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey((cordxd + i) + "." + cordyd)) {
				nbDeCaseAdroite++;
			}
		}

		int nbDeCaseAgauche = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey((cordxd - i) + "." + cordyd)) {
				nbDeCaseAgauche++;
			}
		}

		int nbDeCaseEnHaut = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey(cordxd + "." + (cordyd + i))) {
				nbDeCaseEnHaut++;
			}
		}

		int nbDeCaseEnBas = 0;
		for (int i = 0; i < 5; i++) {
			if (plateau.containsKey(cordxd + "." + (cordyd - i))) {
				nbDeCaseEnBas++;
			}
		}
		
		if (nbDeCaseAdroite > 4 || nbDeCaseAgauche > 4 || nbDeCaseEnHaut > 4 || nbDeCaseEnBas > 4) {
			System.out.println("Impossible de placer la case sinon on d�passe 5x5");
			return false;
		}	
		else {
			for (int i = 0; i < listCases.size(); i++) {
				if (listCases.get(i).equalsIgnoreCase(cordxg + "." + cordyg)) {
					return true;
				}
			}
		}
		return false;
	}	


}
