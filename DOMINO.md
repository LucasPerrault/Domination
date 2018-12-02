# Domination
Projet de Java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DOMINO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cheminDominos = "../DOMINATION/CSV/dominos.csv"; // chemin
		List<Dominos> listeDesDominos = new ArrayList<Dominos>();
		
		try (Stream<String> lireFichiers = Files.lines(Paths.get(cheminDominos))) {

			lireFichiers.skip(1).forEach((ligne) -> {
				String[] tableauDeLigne = ligne.split(",");
				int nbCouronnes1 = Integer.parseInt(tableauDeLigne[0]);
				String type1 = tableauDeLigne[1];
				int nbCouronnes2 = Integer.parseInt(tableauDeLigne[2]);
				String type2 = tableauDeLigne[3];
				int numeroDominos = Integer.parseInt(tableauDeLigne[4]);
				Dominos dominos = new Dominos(nbCouronnes1, nbCouronnes2, numeroDominos, type1, type2);
				listeDesDominos.add(dominos);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		System.out.println(listeDesDominos.get(47).getNbCouronne1());
	}

}

