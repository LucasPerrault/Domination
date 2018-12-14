import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Deck {
	
	ArrayList<Domino> listDominos;
	
	public Deck() {
		String pathCSVDominos = "../DOMINATION/CSV/dominos.csv";
		
		try (Stream<String> readFiles = Files.lines(Paths.get(pathCSVDominos))) {

			readFiles.skip(1).forEach((lines) -> {
				
				String[] tableLine = lines.split(",");
				
				int nbCouronneLeft 		= Integer.parseInt(tableLine[0]);
				String typeLeft 		= tableLine[1];
				int nbCouronneRight 	= Integer.parseInt(tableLine[2]);
				String typeRight 		= tableLine[3];
				int numero		 		= Integer.parseInt(tableLine[4]);
				
				Domino domino = new Domino(nbCouronneLeft, nbCouronneRight, numero, typeLeft, typeRight);
				listDominos.add(domino);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Permet de distribuer un certain nombre de carte.
	 * @return listDistribuatedDomino
	 */
	public ArrayList<Domino> distributeDomino(int number) {
		ArrayList<Domino> distributeListDomino = new ArrayList<Domino>();
		Random numberRandom = new Random();
		for (int i = 0; i < number; i++) {
			int j = numberRandom.nextInt(this.listDominos.size());
			distributeListDomino.add(this.listDominos.get(j));
			System.out.println("Les dominos renvoy�es sont:" + distributeListDomino.get(j));
		}
		System.out.println("Les dominos sont: " + distributeListDomino);
		
		return distributeListDomino;
	}
	
	/*
	 * Permet d'enlever les Dominos déjà distribués 
	 */
	public void removeDomino(List<Domino> listeDesDominos, int nbDominosToDelete) {
		Random nombreAleatoire = new Random();

		for (int i = 0; i < nbDominosToDelete; i++) {
			int j = nombreAleatoire.nextInt(listeDesDominos.size());
			listeDesDominos.remove(j);
			
		}
	}

}
