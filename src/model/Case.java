package model;

public class Case {

	private Tuile tuile;
	private boolean castle;

	public Case(Tuile tuile) {
		super();
		this.tuile = tuile;
	}

	public Tuile getTuile() {
		return tuile;
	}

	public void setTuile(Tuile tuile) {
		this.tuile = tuile;
	}

	public boolean isCastle() {
		return castle;
	}

	public void setCastle(boolean castle) {
		this.castle = castle;
	}

	@Override
	public String toString() {
		return "" + tuile;
	}

}
