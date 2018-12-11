import java.util.ArrayList;

public class Player {
	
	String name;
	Castle castle;
	ArrayList<King> listKings;
	ArrayList<Domino> listDominos;
	
	public Player(String nameInit) {
		this.name = nameInit;
	}
}
