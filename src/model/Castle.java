package model;
public class Castle {
	
	String color;
	int positionX, positionY;
	
	/*
	 * Constructeur du château 
	 * @param name
	 */
	public Castle(String colorInit) {
		this.color = colorInit;
	}
	
	@Override
	public String toString() {
		return 	"La couleur du château est " + this.color +
				"\n Sa position sur X vaut: " + this.positionX +
				"\n Sa position sur Y vaut: " + this.positionY;
	}
	
	/*
	 * Retourne la couleur du chateau
	 */
	public String getColor() {
		return this.color;
	}
	
	/**
	 * Retourne la position en X du chateau
	 */
	public int getPositionX() {
		return this.positionX;
	}
	
	/**
	 * Retourne la position en Y du chateau
	 */
	public int getPositionY() {
		return this.positionY;
	}

}
