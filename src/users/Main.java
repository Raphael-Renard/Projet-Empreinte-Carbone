package users;

import java.util.Scanner;
import consoCarbone.CE;
import consoCarbone.Taille;


public class Main {
	public static void debut() {
		System.out.println("~~Bienvenue sur notre calculateur d’empreinte carbone~~");
		Scanner sc1 = new Scanner(System.in);
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tappant (0).");
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
		case 1:
			System.out.println("Veuillez donner le chemin d'accès de votre fichier :");
			User user1 = new User(sc1.nextLine());
			actions(sc1,user1);
			break;
		case 2:
			User user2 = new User(sc1);
			actions(sc1,user2);
		break;
		default:			
		}
		sc1.close();
		System.out.println("FIN");
	}
	public static void actions(Scanner sc, User user) {
		System.out.println("Vous avez créer un utilisateur. Son empreinte est de "+user.getempreinte()+" TCO2.");
		
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tappant (0),");
			System.out.println("Pour voir l'empreinte détaillée tapez (1),");
			System.out.println("Pour avoir les consommations ordonnées et des conseils tapez (2),");
			System.out.println("Pour modifier votre utilisateur tapez (3) : ");
			//ajout/supp logement transport
			str1 = sc.nextLine();
			if(!str1.matches("-?\\d+")){
				rep=-6;
				System.out.println("Veuillez répondre uniquement par les options données.");
			}
			else rep=Integer.valueOf(str1);
		}
		switch(rep) {
		case 0:
			System.out.println("Vous avez quitter le calculateur d'empreinte carbonne.");
		case 1:
			user.detaillerEmpreinte();
			break;
		case 2:
			user.ordonne();
			break;
		case 3:
			
		default:			
		}
	}
	
	public static void main(String[] args) {
		//User utilisateur = new User(0.4, 0.5,1500, 200,CE.A, true, Taille.P, 1500, 10, 0.4);
		//use.ordonne();
		//System.out.println(use.listeLogement);
		//utilisateur.ordonne();
		debut();
		//User user = new User("~\\Projet\\txt.txt");
		//user.ordonne();

	}
}
