package model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

import model.Domino;
import model.Tuile;

public class Deck {
	
	ArrayList<Domino> listDominos = new ArrayList<Domino>();
	
	public Deck() {
		String pathCSVDominos = "../DOMINATION/CSV/dominos.csv";
		
		try (Stream<String> readFiles = Files.lines(Paths.get(pathCSVDominos))) {

			readFiles.skip(1).forEach((lines) -> {
				
				String[] tableLine = lines.split(",");
				
				int nbCouronneLeft 		= Integer.parseInt(tableLine[0]);
				String typeLeft 		= tableLine[1];
				int nbCouronneRight 	= Integer.parseInt(tableLine[2]);
				String typeRight 		= tableLine[3];
				int numero		 		= Integer.parseInt(tableLine[4]);
				
				Tuile tuileLeft = new Tuile(typeLeft, nbCouronneLeft);
				Tuile tuileRight = new Tuile(typeRight, nbCouronneRight);
				Domino domino = new Domino(numero, tuileLeft, tuileRight);
				listDominos.add(domino);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Permet de distribuer un certain nombre de carte.
	 * @return distributeListDomino
	 */
	public ArrayList<Domino> distributeDomino(int number) {
		ArrayList<Domino> distributeListDomino = new ArrayList<Domino>();
		Random numberRandom = new Random();
		for (int i = 0; i < number; i++) {
			int j = numberRandom.nextInt(this.listDominos.size());
			distributeListDomino.add(this.listDominos.get(j));
			this.removeSpecificDomino(this.listDominos.get(j).getNumeroDomino());
		}
		return distributeListDomino;
	}
	
	/*
	 * Permet d'enlever les Dominos déjà distribués 
	 */
	public void removeRandomDomino(int nbDominosToDelete) {
		Random nombreAleatoire = new Random();

		for (int i = 0; i < nbDominosToDelete; i++) {
			int j = nombreAleatoire.nextInt(this.listDominos.size());
			this.listDominos.remove(j);
		}
	}
	
	/**
	 * Supprimer un domino en fonction de son numéro
	 * @param numeroDomino
	 */
	public void removeSpecificDomino(int numeroDomino) {
		Iterator<Domino> iterator = this.listDominos.iterator();
		while (iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			if(numeroDomino == domino.getNumeroDomino()) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * Retourne le nombre de domino disponible dans le deck
	 * @return
	 */
	public int getNumberOfDomino() {
		return this.listDominos.size();
	}

}
