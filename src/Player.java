import java.util.ArrayList;

public class Player {
	
	String name;
	Castle castle;
	ArrayList<King> listKings = new ArrayList<King>();
	ArrayList<Castle> listCastle = new ArrayList<Castle>();
	ArrayList<Domino> listDominos = new ArrayList<Domino>();
	
	public Player(String nameInit) {
		this.name = nameInit;
	}
	
	public String getName() {
		return this.name;
	}
}
