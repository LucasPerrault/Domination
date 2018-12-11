
public class Domino {
	
	private int numero, nbCouronneRight, nbCouronneLeft;
	private String typeRight, typeLeft;

	/*
	 * Constructeur de Domino 
	 * @param nbCouronneRightInit
	 * @param nbCouronneLeftInit
	 * @param numeroInit
	 * @param typeRightInit
	 * @param typeLeftInit
	 */
	public Domino(int nbCouronneLeftInit, int nbCouronneRightInit, int numeroInit, String typeLeftInit, String typeRightInit) {
		this.nbCouronneRight = nbCouronneRightInit;
		this.nbCouronneLeft = nbCouronneLeftInit;
		this.numero = numeroInit;
		this.typeRight = typeRightInit;
		this.typeLeft = typeLeftInit;
	}
	
	@Override
	public String toString() {
		return "Dominos [nbCouronneRight=" + nbCouronneRight + ", nbCouronneLeft=" + nbCouronneLeft + ", numero="
				+ numero + ", typeLeft=" + typeLeft + ", typeRight=" + typeRight + "]";
	}

	/*
	 * Affiche le nom de couronne à droite
	 * @return nbCouronneRight
	 */
	public int getNbCouronneRight() {
		return this.nbCouronneRight;
	}

	/*
	 * Modifie le nombre de couronne à droite 
	 * @param nbCouronneRight
	 */
	public void setNbCouronneRight(int nbCouronneRight) {
		this.nbCouronneRight = nbCouronneRight;
	}

	/*
	 * Affichage le nombre de courone à gauche 
	 * @return nbCouronneLeft
	 */
	public int getNbCouronneLeft() {
		return this.nbCouronneLeft;
	}

	/*
	 * Modifie le nombre de courone à gauche 
	 * @param nbCouronneLeft
	 */
	public void setNbCouronneLeft(int nbCouronneLeft) {
		this.nbCouronneLeft = nbCouronneLeft;
	}

	/*
	 * Affiche le numéro du Domino
	 * @return numero
	 */
	public int getNumeroDomino() {
		return this.numero;
	}

	/**
	 * Ajoute un numero de Domino
	 * @param numeroDomino
	 */
	public void setNumeroDomino(int numero) {
		this.numero = numero;
	}

	/*
	 * Affichage le type de carte à droite du domino
	 * @return typeRight
	 */
	public String getTypeRight() {
		return this.typeRight;
	}

	/*
	 * Ajoute le type de carte à droite du domino 
	 * @param type1
	 */
	public void setTypeRight(String typeRight) {
		this.typeRight = typeRight;
	}

	/*
	 * Affiche le type de carte à gauche 
	 * @return typeLeft
	 */
	public String getTypeLeft() {
		return this.typeLeft;
	}

	/*
	 * Ajoute le type de carte à gauche du domino 
	 * @param typeLeft
	 */
	public void setType2(String typeLeft) {
		this.typeLeft = typeLeft;
	}
	
	
}
