package controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import model.King;
import model.Player;

public class KingCtrl {
	
	/*
	 * Definit les rois de chaque joueur.
	 */
	public void setKings(ArrayList<Player> listOfPlayers) {
		String colorKing;
		boolean isSelectColorNotExist;
		Iterator<Player> iterator = listOfPlayers.iterator();
		
		while(iterator.hasNext()) {
			Player player = iterator.next();
			System.out.println("INFORMATION: C'est à " + player.getName() + " de sélectionner son roi: \n");
			// S'il y a deux joueurs
			if(listOfPlayers.size() == 2) {
				// Il doit choisir deux rois, donc boucle de deux
				for(int i=0; i < 2; i++) {
					
					do {
						colorKing = this.selectColor(player);
						isSelectColorNotExist = checkColorIsSelected(colorKing, listOfPlayers, player);
					} while(!isSelectColorNotExist);
					
					King king = new King(colorKing);
					player.listKings.add(king);
				}
			} else {
				
				do {
					colorKing = this.selectColor(player);
					isSelectColorNotExist = checkColorIsSelected(colorKing, listOfPlayers, player);
				} while(!isSelectColorNotExist);
				
				King king = new King(colorKing);
				player.listKings.add(king);
			}
		}
	}
	
	/**
	 * Menu de sélection de la couleur du chateau
	 * @param player
	 * @return
	 */
	public String selectColor(Player player) {
		if(player.isIa) {
			Random rand = new Random();
			switch (rand.nextInt(3)+1) {
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
		} else {
			switch (this.displayPossibilityColor(player)) {
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
	}
	
	/**
	 * Affiche les possibilités de couleur des chateaux
	 * @param player
	 * @return color
	 */
	public int displayPossibilityColor(Player player) {
		int response = 0;
		Scanner scan = new Scanner(System.in);
		// Le joueur choisit une couleur impos�e
		System.out.println("INSTRUCTION:  Choisissez la couleur du roi désiré avec \nle chiffre correspondant: \n");
		do {
			try {
				System.out.println("1. Rouge \n" + "2. Bleu \n" + "3. Vert \n" + "4. Jaune \n");
				response = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, selectionnez le 1, 2, 3 ou 4");
			}
			
		} while (false || response != 1 && response !=2 && response != 3 && response != 4 );
		
		return response;
	}
	
	/**
	 * Vérifie que la couleur selectionner n'est pas identique à celle des autres
	 * @param color, player
	 * @return boolean
	 */
	public boolean checkColorIsSelected(String color, ArrayList<Player> players, Player playerWhichPlay) {
		Iterator<Player> iteratorPlayer = players.iterator();
		
		while(iteratorPlayer.hasNext()) {
			Player player = iteratorPlayer.next();
			Iterator<King> iteratorKing = player.listKings.iterator();
			
			while(iteratorKing.hasNext()) {
				King king = iteratorKing.next();
				if(color.equals(king.getColor())){
					if(!playerWhichPlay.isIa) {
						System.out.println("WARNING: Cette couleur est deja� choisie ! \n");
					}
					return false;
				}
			}
		}
		if(playerWhichPlay.isIa) {
			System.out.println(playerWhichPlay.getName() + " a choisi la couleur " + color + "\n");
		}
		return true;
	}

}
