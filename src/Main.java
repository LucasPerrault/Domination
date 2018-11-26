import java.util.Scanner;

// Première partie
public class Main {
	public static void main(String[] args) {
		System.out.println("Helmonde");
		// Ajout du scanner pour rentrer son prenom
		Scanner scan = new Scanner(System.in);
		String test = scan.nextLine();
		System.out.println("Comment ça va " + test + "?");
	}
}

