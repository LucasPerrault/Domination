package model;
import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	
	String name;
	Castle castle;
	public ArrayList<King> listKings = new ArrayList<King>();
	public ArrayList<Castle> listCastle = new ArrayList<Castle>();
	public ArrayList<Domino> listDominos = new ArrayList<Domino>();
	
	public Player(String nameInit) {
		this.name = nameInit;
	}
	
	public String getName() {
		return this.name;
	}
	
}
