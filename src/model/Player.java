package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Player {
	
	String name;
	public boolean isIa;
	public Gameboard gameboard;
	public ArrayList<King> listKings = new ArrayList<King>();
	public ArrayList<Castle> listCastle = new ArrayList<Castle>();
	public ArrayList<Domino> listDominos = new ArrayList<Domino>();
	public ArrayList<Domino> listSelectDominos = new ArrayList<Domino>();

	
	public Player(String nameInit, boolean isIaInit) {
		this.name = nameInit;
		this.isIa = isIaInit;
	}
	
	@Override
	public String toString() {
		return "Le joueur " + this.name +
				" détient le chateau de couleur " + this.getCastles() +
				". Il détient aussi les rois de couleur " + this.getKing() +
				". Et actuellement, il détient les dominos " + this.getDominos();
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
		String color = "";
		Iterator<Castle> castles = listCastle.iterator();
		while(castles.hasNext()) {
			Castle castle = castles.next(); 
			color = castle.color;
		}
		return "Cht" + color + "\t";
	}
	
	/*
	 * Retourne les dominos du joueur
	 */
	public String getDominos() {
		String dominoI = "Les dominos sont ";
		Iterator<Domino> dominos = listDominos.iterator();
		while(dominos.hasNext()) {
			Domino domino= dominos.next();
			dominoI.concat(domino.toString());
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
			King king= kings.next();
			kingI.concat(king.toString());
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
