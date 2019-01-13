package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Gameboard {
	 public int width, height;
	 public String[][] plat = new String[9][9];
	 public Map<String, Case> plateau = new HashMap<String, Case>();

	
	/**
	 * Constructeur du plateau de jeu
	 * @param widthInit
	 * @param heightInit
	 */
	 public Gameboard(int widthInit, int heightInit) {
		 this.width = widthInit;
		 this.height = heightInit;
		 this.initPlat();
	 }
	 
	 @Override
	public String toString() {
		return "Le plateau fait " + this.width +
				" de largeur et " + this.height +
				" de longueur";
	}
	 
	 public void initPlat() {
        for(int i=0; i<plat.length; i++){
            for(int j=0; j<plat.length ; j++){
                plat[i][j] = ".\t";
            }
        }
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
