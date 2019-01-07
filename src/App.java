import controler.Game;
import vue.Window;


/*
 *  Projet: Domination
 *  
 *  Créateur: Camélia De Sousa, Augustin Simon et Lucas Perrault
 *  Date de début: 20/11/2018
 *  Date de fin: 
 *  
 *  Cours: Algorithme et Programmation
 *  Professeur: Monsieur Hugueney
 */


public class App {
	
	public static void main(String[] args) {
		Window window = new Window(1000,1000, new Game());
	}

}
