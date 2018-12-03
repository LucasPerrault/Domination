public class Dominos {
	
	private int NbCouronne1, privateNbCouronne2, NumeroDomino;
	private String Type1, Type2;
	
	//constructeur
	public Dominos(int nbCouronne1, int privateNbCouronne2, int numeroDomino, String type1, String type2) {
		super();
		NbCouronne1 = nbCouronne1;
		this.privateNbCouronne2 = privateNbCouronne2;
		NumeroDomino = numeroDomino;
		Type1 = type1;
		Type2 = type2;
	}

	@Override
	public String toString() {
		return "Dominos [NbCouronne1=" + NbCouronne1 + ", privateNbCouronne2=" + privateNbCouronne2 + ", NumeroDomino="
				+ NumeroDomino + ", Type1=" + Type1 + ", Type2=" + Type2 + "]";
	}

	public int getNbCouronne1() {
		return NbCouronne1;
	}

	public void setNbCouronne1(int nbCouronne1) {
		NbCouronne1 = nbCouronne1;
	}

	public int getPrivateNbCouronne2() {
		return privateNbCouronne2;
	}

	public void setPrivateNbCouronne2(int privateNbCouronne2) {
		this.privateNbCouronne2 = privateNbCouronne2;
	}

	public int getNumeroDomino() {
		return NumeroDomino;
	}

	public void setNumeroDomino(int numeroDomino) {
		NumeroDomino = numeroDomino;
	}

	public String getType1() {
		return Type1;
	}

	public void setType1(String type1) {
		Type1 = type1;
	}

	public String getType2() {
		return Type2;
	}

	public void setType2(String type2) {
		Type2 = type2;
	}
	
}
	
