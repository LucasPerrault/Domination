/**
 * Un domino est composé de deux tuiles sur une face et d'un numéro sur l'autre face.
 */
public class Domino {
	
	private int numero;
	private Tuile tuileRight, tuileLeft;

	/**
	 * Constructeur de Domino
	 * @param numeroInit
	 * @param tuileLeftInit
	 * @param tuileRightInit
	 */
	public Domino(int numeroInit, Tuile tuileLeftInit, Tuile tuileRightInit) {
		this.numero = numeroInit;
		this.tuileLeft = tuileLeftInit;
		this.tuileRight = tuileRightInit;
	}
	
	@Override
	public String toString() {
		return 	"Le domino est le numéro " + 
				this.numero + " ayant " + 
				this.tuileLeft.toString() + 
				"et" + this.tuileRight.toString();
	}

	/*
	 * Affiche le numéro du Domino
	 * @return numero
	 */
	public int getNumeroDomino() {
		return this.numero;
	}
	
}
