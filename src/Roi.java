
public class Roi {
	String couleur;
	double positionX, positionY;
	
	public Roi(String couleurInit, double positionXInit, double positionYInit) {
		this.couleur = couleurInit;
		this.positionX = positionXInit;
		this.positionY = positionYInit;
	}
	
	/**
	 * Permet de retourner la couleur du roi
	 * @return couleur
	 */
	private String getCouleur() {
		return this.couleur;
	}
	
	
	/**
	 * Permet de retourner la position du roi sur l'axe des abcisses
	 * @return position en X du roi
	 */
	private double getPositionX() {
		return this.positionX;
	}
	
	/**
	 * Permet de retourner la position du roi sur l'axe des ordonnées
	 * @return position en Y du roi
	 */
	private double getPositionY() {
		return this.positionY;
	}
	
	/**
	 * Permet de modifier la position en abcisse du roi
	 * @param position
	 */
	private void setPositionX(double position) {
		this.positionX = position;
	}
	
	/**
	 * Permet de modifier la position en ordonnée du roi
	 * @param position
	 */
	private void setPositionY(double position) {
		this.positionY = position;
	}
	
	
}
