package model;

import java.util.Iterator;

public class King {
	
	String color;
	
	/*
	 * Constructeur du roi 
	 * @param colorInit
	 */
	public King(String colorInit) {
		this.color = colorInit;
	}
	
	@Override
	public String toString() {
		return "La couleur du roi est " + this.color;
	}
	
	/**
	 * Permet de retourner la couleur du Roi
	 * @return color
	 */
	public String getColor() {
		return this.color;
	}

}
