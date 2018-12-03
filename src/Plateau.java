
public class Plateau {
	double largeur, longueur, nbMaxDomino;
	
	public Plateau(double largeurInit, double longueurInit, double nbMaxDominoInit) {
		this.largeur = largeurInit;
		this.longueur = longueurInit;
		this.nbMaxDomino = nbMaxDominoInit;
	}
	
	/**
	 * Permet de choisir le nombre de Domino durant la partie
	 * @param nbDomino
	 */
	private void setNbMaxDomino(double nbDomino) {
		this.nbMaxDomino = nbDomino;
	}
}
