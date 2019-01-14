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
						this.putDomino(player, gameboardCtrl, this.returnDomino(gameboardCtrl.listOfDominoPull, numberOfDominoSelect));
						gameboardCtrl.removeSelectDomino(numberOfDominoSelect);

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
				this.putDomino(player, gameboardCtrl, this.returnDomino(gameboardCtrl.listOfDominoPull, numberOfDominoSelect));
				gameboardCtrl.removeSelectDomino(numberOfDominoSelect);
			}
		}
		
		return initialListOfDominoPull;
		
	}
	
	/**
	 * Ordonne une liste de joueur en fonction des dominos choisis avant
	 * @param initialListOfDominoPull
	 */
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
	
	/**
	 * Retourne un objet domino en fonction d'un numero int
	 * @param listOfDominoPull
	 * @param numberOfDomino
	 * @return
	 */
	public Domino returnDomino(ArrayList<Domino> listOfDominoPull, int numberOfDomino) {
		Domino domino = null;
		Iterator<Domino> iterator = listOfDominoPull.iterator();
		while (iterator.hasNext()) {
			domino = iterator.next(); // On récupère l'élément courant
			if(numberOfDomino == domino.getNumeroDomino()) {
				return domino;
			}
		}
		return domino;
	}
	
	/**
	 * Permet de placer un domino sur un plateau
	 * @param player
	 * @param gameboardCtrl
	 * @param domino
	 */
	public void putDomino(Player player, GameboardCtrl gameboardCtrl, Domino domino) {
		int cordxg = 0;
		int cordyg = 0;
		int cordxd = 0;
		int cordyd = 0;
		Case cases2;
		Case cases1;
		System.out.println("RAPPEL: vous devez placer ce: " + domino.toString() + "\n");
		System.out.println("Placer ce domino sur votre plateau : \n");
		gameboardCtrl.displayGameboard(player.gameboard.plat);
		
		do {
			cordxg = this.getPositionPositionXLeftTuile();
			cordyg = this.getPositionPositionYLeftTuile();
			cordxd = this.getPositionPositionXRightTuile();
			cordyd = this.getPositionPositionYRightTuile();
			
			cases1 = new Case(domino.getTuileLeft());
			cases2 = new Case(domino.getTuileRight());
		} while((
			!checkCase1(player.listDominos, player.gameboard.plateau, cordxg, cordyg) && 
			!checkCase2(player.listDominos, player.gameboard.plateau, cordxg, cordyg, cordxd, cordyd)
		));
		// Initialisation des positions
		
		player.gameboard.plateau.put(cordxg + "." + cordyg, cases1);
		player.gameboard.plateau.put(cordxd + "." + cordyd, cases2);
		player.gameboard.plat[cordyg][cordxg] = cases1.toString();
		player.gameboard.plat[cordyd][cordxd] = cases2.toString();
		gameboardCtrl.displayGameboard(player.gameboard.plat);

	}
	
	/**
	 * Permet de sélectionner la position x pour la tuile gauche
	 * @return
	 */
	public int getPositionPositionXLeftTuile() {
		int cordxg = 0; // Tuile de gauche*
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("Selectionner une cordonnée X pour la tuile gauche : ");
				cordxg = scan.nextInt();
			} catch (Exception e) {
				System.out.println("ATTENTION, une position !");
			}
		} while(false);
		return cordxg;
	}
	
	/**
	 * Permet de sélectionner la position y pour la tuile gauche
	 * @return
	 */
	public int getPositionPositionYLeftTuile() {
		int cordyg = 0; // Tuile de gauche*
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("Selectionner une cordonnée Y pour la tuile gauche : ");
				cordyg = scan.nextInt();
			} catch (Exception e) {
				System.out.println("ATTENTION, une position !");
			}
		} while(false);
		return cordyg;
	}
	
	/**
	 * Permet de sélectionner la position x pour la tuile droite
	 * @return
	 */
	public int getPositionPositionXRightTuile() {
		int cordxd = 0; // Tuile de gauche*
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("Selectionner une cordonnée X pour la tuile droite : ");
				cordxd = scan.nextInt();
			} catch (Exception e) {
				System.out.println("ATTENTION, une position !");
			}
		} while(false);
		return cordxd;
	}
	
	/**
	 * Permet de sélectionner la position y pour la tuile droite
	 * @return
	 */
	public int getPositionPositionYRightTuile() {
		int cordyd = 0; // Tuile de gauche*
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("Selectionner une cordonnée Y pour la tuile droite : ");
				cordyd = scan.nextInt();
			} catch (Exception e) {
				System.out.println("ATTENTION, une position !");
			}
		} while(false);
		return cordyd;
	}
	
	/**
	 * Permet de déterminer si les cases à coter de la notre sont bonnes ou non
	 * @param listeDomino
	 * @param plateau
	 * @param cordxg
	 * @param cordyg
	 * @return
	 */
	public boolean checkCase1(ArrayList<Domino> listeDomino, Map<String, Case> plateau, int cordxg, int cordyg) {
		ArrayList<String> listCases = new ArrayList<String>();
		String cordxyg = (cordxg + "." + cordyg);
		String cordxygGauche = (cordxg - 1 + "." + cordyg);
		String cordxygDroite = (cordxg + 1 + "." + cordyg);
		String cordxygHaut = (cordxg + "." + (cordyg + 1));
		String cordxygBas = (cordxg + "." + (cordyg - 1));

		if (plateau.containsKey(cordxygGauche)){
			listCases.add(cordxygGauche);
			}
		if (plateau.containsKey(cordxygDroite)){
			listCases.add(cordxygDroite);
		}
		if (plateau.containsKey(cordxygHaut)){
			listCases.add(cordxygHaut);
			}
		if (plateau.containsKey(cordxygBas)){
			listCases.add(cordxygBas);
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
	
	/**
	 * Permet de déterminer si les cases à coter de la notre sont bonnes ou non
	 * @param listeDomino
	 * @param plateau
	 * @param cordxg
	 * @param cordyg
	 * @param cordxd
	 * @param cordyd
	 * @return
	 */
	public boolean checkCase2(ArrayList<Domino> listeDomino, Map<String, Case> plateau,int cordxg, int cordyg,int cordxd, int cordyd) {
		ArrayList<String> listCases = new ArrayList<String>();
		String cordxyd = (cordxd + "." + cordyd);
		String cordxydGauche = (cordxd - 1 + "." + cordyd);
		String cordxydDroite = (cordxd + 1 + "." + cordyd);
		String cordxydHaut = (cordxd + "." + cordyd + 1);
		String cordxydBas = (cordxd + "." + cordyd--);
		

		if (plateau.containsKey(cordxydGauche)) {
			listCases.add(cordxydGauche);
		}
		if (plateau.containsKey(cordxydDroite)) {
			listCases.add(cordxydDroite);
		}
		if (plateau.containsKey(cordxydHaut)) {
			listCases.add(cordxydHaut);
		}
		if (plateau.containsKey(cordxydBas)) {
			listCases.add(cordxydBas);
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
