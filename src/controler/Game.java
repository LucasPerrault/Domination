package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Case;
import model.Domino;

public class Game {

	PlayerCtrl playerCtrl = new PlayerCtrl();
	CastleCtrl castleCtrl = new CastleCtrl();
	KingCtrl kingCtrl = new KingCtrl();
	DeckCtrl deckCtrl = new DeckCtrl();
	GameboardCtrl gameboardCtrl = new GameboardCtrl();

	private int numberOfPlaying = 0;

	/*
	 * Constructeur de la classe
	 */
	public Game() {
	}

	/*
	 * Initialisation de la partie
	 */
	public void init() {
		int value = 0;
		do {
			value = menu();
			switch (value) {
			case 0:
				System.out.println("Debut de la partie !");

				ArrayList<Domino> listeDomino = deckCtrl.distributeDomino(40);
					playerCtrl.setNumberOfPlayers();
					playerCtrl.setPlayers();
					playerCtrl.createIA(playerCtrl.choiceIA());
					playerCtrl.setGameboardOfPlayer();
					castleCtrl.setCastle(playerCtrl.listOfPlayers);
					
					kingCtrl.setKings(playerCtrl.listOfPlayers);					
					gameboardCtrl.init(deckCtrl, playerCtrl);
				System.out.println(playerCtrl.toString());
				
				Map<String, Case> plateau = new HashMap<String, Case>();
				Case cases = new Case(null);
				cases.setCastle(true);
				plateau.put(Double.toString(4.4), cases);
				System.out.println(plateau);
				boolean gagner = false;
				do {
					ArrayList<Integer> listX= new ArrayList<Integer>();
					ArrayList<Integer> listY = new ArrayList<Integer>();
					listX.add(4);
					listY.add(4);
					
					Scanner scan = new Scanner(System.in);
					String cordxyg;
					String cordxyGauche = "";
					String cordxyDroite = "";
					String cordxyHaut = "";
					String cordxyBas = "";
					Case cases1;
					Case cases2;

					System.out.println("Cord X pour la tuile gauche");
					int cordxg = scan.nextInt();
					listX.add(cordxg);
					System.out.println("Cord Y pour la tuile gauche");
					int cordyg = scan.nextInt();
					listY.add(cordyg);
					cordxyg = (cordxg + "." + cordyg);
					cordxyGauche = (cordxg - 1 + "." + cordyg);
					cordxyDroite = (cordxg + 1 + "." + cordyg);
					cordxyHaut = (cordxg + "." + cordyg + 1);
					cordxyBas = (cordxg + "." + cordyg--);
					cases1 = new Case(listeDomino.get(1).getTuileLeft());
					if (checkCase1(listeDomino, plateau, cordxyGauche, cordxyDroite, cordxyHaut, cordxyBas)) {
						plateau.put(cordxyg, cases1);
					}

					System.out.println("Cord X pour la tuile droite");
					int cordxd = scan.nextInt();
					listX.add(cordxd);
					System.out.println("Cord Y pour la tuile droite");
					int cordyd = scan.nextInt();
					String cordxyd = (cordxd + "." + cordyd);
					cases2 = new Case(listeDomino.get(1).getTuileRight());
					if (checkCase2(listeDomino, plateau, cordxyGauche, cordxyDroite, cordxyHaut, cordxyBas)) {
						plateau.put(cordxyd, cases2);
					}
				

					System.out.println(plateau);

				} while (!gagner);

				break;
			}
		} while (value != 1);
		System.out.println("Vous avez decider de quittez l'application !");
	}

	
	
	public boolean checkCase1(ArrayList<Domino> listeDomino, Map<String, Case> plateau, String cordxyGauche,
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
		
		if (Collections.max(listX)-Collections.min(listX)<=4 && Collections.max(listY)-Collections.min(listY)<=4) {
			for (int i = 0; i < listCases.size(); i++) {
				if (plateau.get(listCases.get(i)).isCastle()) {
					System.out.println("La case est un chateau");
					return true;
				}
				if (listeDomino.get(1).getTuileLeft().getType().equalsIgnoreCase(plateau.get(listCases.get(i)).getTuile().getType())) {
					System.out.println("La case est du meme type");
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	
	

	
	
	public boolean checkCase2(ArrayList<Domino> listeDomino, Map<String, Case> plateau, String cordxyGauche,
			String cordxyDroite, String cordxyHaut, String cordxyBas) {
		ArrayList<String> listCases = new ArrayList<String>();
		
		if (Collections.max(listX)-Collections.min(listX)<=4 && Collections.max(listY)-Collections.min(listY)<=4) {
			for (int i=0, i<listX.size(), i++);
				if (cordxyd!=(listX.get(i) + '.' +listY.get(i)) ) {
					if ((cordxd,cordyd)==(cordxd+1,cordyd) || (cordxd,cordyd)==((cordxd-1,cordyd) || (cordxd,cordyd)==((cordxd,cordyd+1) {|| (cordxd,cordyd)==(cordxd,cordyd-1)) {
						return true;
				}
			}
		}
		
		
		return false;
	}	
	
	
	
	
	
	
	/**
	 * Affichage du menu de selection d'action
	 * 
	 * @return 0 ou 1
	 */
	public int menu() {
		int response = 0;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("0. Jouer \n" + "1. Quitter");
				response = scan.nextInt();
			} catch (Exception e) {
				System.out.println("ATTENTION, selectionnez le 0 ou 1");
			}

		} while (false || response != 0 && response != 1);
		return response;
	}

}
