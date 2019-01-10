package model;

import java.util.Iterator;

public class Gameboard {
	 public int width, height;
	
	/**
	 * Constructeur du plateau de jeu
	 * @param widthInit
	 * @param heightInit
	 */
	 public Gameboard(int widthInit, int heightInit) {
		 this.width = widthInit;
		 this.height = heightInit;
	 }
	 
	 @Override
	public String toString() {
		return "Le plateau fait " + this.width +
				" de largeur et " + this.height +
				" de longueur";
	}
	 
	 /**
	  * Retourne la largeur du plateau
	  */
	 public int getWidth() {
		 return this.width;
	 }
	 
	 /**
	  * Retourne la hauteur du plateau
	  */
	 public int getHeight() {
		 return this.height;
	 }

}
