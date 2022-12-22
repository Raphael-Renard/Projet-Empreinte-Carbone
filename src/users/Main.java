package users;

import java.util.Scanner;

public class Main {
	/**
	 * Cadre intéractif pour la calculateur.
	 * Permet de créer un utilisateur avant de proposer les différentes actions possibles.
	 */
	public static void debut() {
		System.out.println("~~Bienvenue sur notre calculateur d’empreinte carbone~~");
		Scanner sc1 = new Scanner(System.in);
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tapant (0).");
			System.out.println("Voulez-vous créer un utilisateur avec un fichier (1) ou en donnant les valeurs à la main (2) : ");
			str1 = sc1.nextLine();
			if(!str1.matches("-?\\d+")){
				rep=-6;
				System.out.println("Veuillez répondre uniquement par les options données.");
			}
			else rep=Integer.valueOf(str1);
		}
		switch(rep) {
		case 0:
			System.out.println("Vous avez quitté le calculateur d'empreinte carbonne.");
			break;
		case 1:
			System.out.println("Veuillez donner le chemin d'accès de votre fichier :");
			User user1 = new User(sc1.nextLine());
			actions(sc1,user1);
			break;
		case 2:
			User user2 = new User(sc1);
			actions(sc1,user2);
			break;		
		}
		sc1.close();
		System.out.println("FIN");
	}
	/**
	 * 
	 * @param sc Scanner permettant de communiquer avec l'utilisateur
	 * @param user Utilisateur pour lequel on considère son empreinte et/ou des modifications des consommations.
	 * Donne l'empreinte de l'Utilisateur puis propose de détailler l'empreinte, d'avoir des conseil ou de modifier l'utilisateur.
	 */
	public static void actions(Scanner sc, User user) {
		int rep=-6;
		while(rep!=0) {
			System.out.println("\nL'empreinte de votre utilisateur est de "+user.getempreinte()+" TCO2.\n");
			String str1="a";
			rep=-6;
			while(rep != 1 && rep !=2 && rep!=3 && rep!= 0) {
				System.out.println("Vous pouvez quitter en tapant (0),");
				System.out.println("Pour voir l'empreinte détaillée tapez (1),");
				System.out.println("Pour avoir les consommations ordonnées et des conseils tapez (2),");
				System.out.println("Pour modifier votre utilisateur tapez (3) : ");
				str1 = sc.nextLine();
				if(!str1.matches("-?\\d+")){
					rep=-6;
					System.out.println("Veuillez répondre uniquement par les options données.");
				}
				else rep=Integer.valueOf(str1);
			}
			switch(rep) {
			case 0:
				System.out.println("Vous avez quitté le calculateur d'empreinte carbonne.");
				break;
			case 1:
				user.detaillerEmpreinte();
				rep=-6;
				break;
			case 2:
				user.ordonne();
				rep=-6;
				break;
			case 3:
				user.modifUser(sc);
				rep=-6;
				break;
			}
		}
	}
	
	/**
	 * Lance la méthode debut() pour lancer le calculateur.
	 * @param args
	 */
	public static void main(String[] args) {
		debut();
	}
}
