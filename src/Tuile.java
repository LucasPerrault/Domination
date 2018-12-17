/**
 * Une tuile représente la moitié d'un Domino. Elle est composée d'un nombre de couronne et d'un type
 */
public class Tuile {
	
	private int nbCouronne;
	private String type;
	private int positionX, positionY;
	
	public Tuile(String typeInit, int nbCouronneInit) {
		this.nbCouronne = nbCouronneInit;
		this.type = typeInit;
	}
	
	@Override
	public String toString() {
		return " une tuile de type " + this.type + " et contient " + this.nbCouronne + " couronne(s)\n";
	}
	
	/*
	 * Affiche le nom de couronne
	 * @return nbCouronne
	 */
	public int getNbCouronne() {
		return this.nbCouronne;
	}
	
	/**
	 * Affiche le type de la tuile
	 * @return
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Retourne la position X 
	 * @return position x
	 */
	public int getPositionX() {
		return this.positionX;
	}
	
	/**
	 * Retourne position y
	 * @return position y
	 */
	public int getPositionY() {
		return this.positionY;
	}
	
	/**
	 * Définit une nouvelle position x
	 * @param positionX
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	/**
	 * Définit une nouvelle position y
	 * @param positionY
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
