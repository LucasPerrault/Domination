import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
	public void distributeDomino(int number) {
		//
	}
	
	/*
	 * Permet d'enlever les Dominos déjà distribués 
	 */
	public void removeDomino() {
		//
	}

}
