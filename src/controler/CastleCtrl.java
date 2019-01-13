package controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import model.Castle;
import model.King;
import model.Player;

public class CastleCtrl {
	
	/*
	 * Définit les chateaux de chaque joueur
	 */
	public void setCastle(ArrayList<Player> listOfPlayers) {
		String colorCastle;
		boolean isSelectColorNotExist;
		Iterator<Player> iterator = listOfPlayers.iterator();
		while(iterator.hasNext()) {
			Player player = iterator.next();
			System.out.println("INFORMATION : C'est à " + player.getName() + " de sélectionner son chateau: \n\n");
			do {
				colorCastle = this.selectColor(player);
				isSelectColorNotExist = checkColorIsSelected(colorCastle, listOfPlayers, player);
			} while(!isSelectColorNotExist);
			
			player.listCastle.add(new Castle(colorCastle)); 
		}
	}
	
	/**
	 * Menu de sélection de la couleur du chateau
	 * @param player
	 * @return
	 */
	public String selectColor(Player player) {
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
	
	/**
	 * Affiche les possibilités de couleur des chateaux
	 * @param player
	 * @return color
	 */
	public int displayPossibilityColor(Player player) {
		int response = 0;
		if(player.isIa) {
			Random rand = new Random();
			response = rand.nextInt(4) + 1;
		} else {
			Scanner scan = new Scanner(System.in);
			// Le joueur choisit une couleur impos�e
			System.out.println("INSTRUCTION: Choisissez la couleur du chateau désiré \navec le chiffre correspondant: \n");
			do {
				try {
					System.out.println("1. Rouge \n" + "2. Bleu \n" + "3. Vert \n" + "4. Jaune \n");
					response = scan.nextInt();
				} catch(Exception e) {
					System.out.println("ATTENTION, selectionnez le 1, 2, 3 ou 4");
				}
				
			} while (false || response != 1 && response !=2 && response != 3 && response != 4 );
		}
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
			Iterator<Castle> iteratorCastle = player.listCastle.iterator();
			
			while(iteratorCastle.hasNext()) {
				Castle castle = iteratorCastle.next();
				if(color.equals(castle.getColor())){
					if(!playerWhichPlay.isIa) {
						System.out.println("WARNING: Cette couleur est deja choisie ! \n");
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
