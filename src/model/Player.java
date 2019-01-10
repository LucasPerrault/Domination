package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Player {
	
	String name;
	public Gameboard gameboard;
	public ArrayList<King> listKings = new ArrayList<King>();
	public ArrayList<Castle> listCastle = new ArrayList<Castle>();
	public ArrayList<Domino> listDominos = new ArrayList<Domino>();
	public ArrayList<Domino> listSelectDominos = new ArrayList<Domino>();

	
	public Player(String nameInit) {
		this.name = nameInit;
	}
	
	@Override
	public String toString() {
		String response = "Les dominos disponibles dans le Deck sont: ";
		Iterator<Domino> dominos = this.listDominos.iterator();
		while(dominos.hasNext()) {
			Domino domino = dominos.next();
			response.concat(domino.toString() + "\n");
		}
		return response;
	}
	
	/**
	 * Retourne le nom du joueur
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Retourne le(s) chateau(x) du joueur
	 */
	public String getCastles() {
		String castleI = "Les chateaux sont ";
		Iterator<Castle> castles = listCastle.iterator();
		while(castles.hasNext()) {
			Castle castle = castles.next();
			castleI.concat(castle.toString());
		}
		return castleI;
	}
	
	/*
	 * Retourne les dominos du joueur
	 */
	public String getDominos() {
		String dominoI = "Les dominos sont ";
		Iterator<Domino> dominos = listDominos.iterator();
		while(dominos.hasNext()) {
			Domino domino= dominos.next();
			dominoI.concat(castle.toString());
		}
		return dominoI;
	}
	
	/*
	 * Retourne le(s) roi(s) des joueurs
	 */
	public String getKing() {
		String kingI = "Les kings sont ";
		Iterator<King> kings = listKings.iterator();
		while(kings.hasNext()) {
			King kign= kings.next();
			kingI.concat(castle.toString());
		}
		return kingI;
	}
	
	/**
	 * Retourne la taille du jeu par joueur
	 */
	public String getGameboard() {
		return this.gameboard.toString();
	}
	
	
	/**
	 * Permet d'ajouter un Domino à la liste
	 * @param listOfDominoPull
	 * @param numberOfDominoSelect
	 */
	public void addDomino(ArrayList<Domino> listOfDominoPull, int numberOfDominoSelect) {
		Iterator<Domino> iterator = listOfDominoPull.iterator();
		while (iterator.hasNext()) {
			Domino domino = iterator.next(); // On récupère l'élément courant
			if(numberOfDominoSelect == domino.getNumeroDomino()) {
				this.listDominos.add(domino);
				System.out.println(this.name + " a choisi le domino numéro: " + domino.getNumeroDomino() + "\n");
			}
		}
	}
	
}
