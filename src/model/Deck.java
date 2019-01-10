package model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

import model.Domino;
import model.Tuile;

public class Deck {
	
	public ArrayList<Domino> listDominos = new ArrayList<Domino>();
	
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
				
				Tuile tuileLeft = new Tuile(typeLeft, nbCouronneLeft);
				Tuile tuileRight = new Tuile(typeRight, nbCouronneRight);
				Domino domino = new Domino(numero, tuileLeft, tuileRight);
				listDominos.add(domino);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		String response = "Les dominos disponibles dans le Deck sont: ";
		Iterator<Domino> dominos = this.listDominos.iterator();
		while(dominos.hasNext()) {
			Domino domino = dominos.next();
			response.concat(domino.toString() + "\n");
		}
		return response;
	}

}
