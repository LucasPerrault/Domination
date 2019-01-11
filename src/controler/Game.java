package controler;
import java.util.Scanner;

public class Game {
	
	PlayerCtrl playerCtrl = new PlayerCtrl();
	CastleCtrl castleCtrl = new CastleCtrl();
	KingCtrl kingCtrl = new KingCtrl();
	DeckCtrl deckCtrl = new DeckCtrl();
	GameboardCtrl gameboardCtrl = new GameboardCtrl();
	
	private int numberOfPlaying = 0;
	
	/*
	 * Constructeur de la classe 
	 */
	public Game() {
	}
	
	/*
	 * Initialisation de la partie
	 */
	public void init() {
		int value = 0;
		do {
			value = menu();
			switch (value) {
				case 0:
					System.out.println("Debut de la partie !");
					
					playerCtrl.setNumberOfPlayers();
					playerCtrl.setPlayers();
					playerCtrl.createIA(playerCtrl.choiceIA());
					playerCtrl.setGameboardOfPlayer();
					
					castleCtrl.setCastle(playerCtrl.listOfPlayers);
					
					kingCtrl.setKings(playerCtrl.listOfPlayers);
					
					gameboardCtrl.init(deckCtrl, playerCtrl);
					
				break;
			}
		} while(value !=1);
		System.out.println("Vous avez decider de quittez l'application !");		
	}
	
	/**
	 * Affichage du menu de selection d'action
	 * @return 0 ou 1
	 */
	public int menu() {
		int response = 0;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println("0. Jouer \n" + "1. Quitter");
				response = scan.nextInt();
			} catch(Exception e) {
				System.out.println("ATTENTION, selectionnez le 0 ou 1");
			}
			
		} while (false || response != 0 && response !=1 );
		return response;
	}
	
}
