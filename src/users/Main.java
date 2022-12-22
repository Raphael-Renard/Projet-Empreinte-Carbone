package users;

import java.util.Scanner;

public class Main {
	/**
	 * Cadre intéractif pour la calculateur.
	 * Permet de créer un utilisateur avant de proposer les différentes actions possibles.
	 */
	public static void debut(Scanner sc1) {
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
			while(rep != 1 && rep !=2 && rep!=3 && rep!= 4 && rep!= 0) {
				System.out.println("Vous pouvez quitter en tapant (0),");
				System.out.println("Pour voir l'empreinte détaillée tapez (1),");
				System.out.println("Pour avoir les consommations ordonnées et des conseils tapez (2),");
				System.out.println("Pour modifier votre utilisateur tapez (3),");
				System.out.println("Pour sauvegarder votre utilisateur dans un fichier tapez (4) :");
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
			case 4:
				user.sauv(sc);
			}
		}
	}
	
	
	/**
	 * 
	 * @param sc Scanner permettant de communiquer avec l'utilisateur
	 * @param pop Population pour laquelle on considère son empreinte et/ou des modifications des consommations.
	 * Donne l'empreinte de la Population puis propose de modifier la population.
	 */
	public static void actions(Scanner sc, Population pop) {
		int rep=-6;
		while(rep!=0) {
			System.out.println("\nL'empreinte de votre population est de "+pop.getempreinteTot()+" TCO2 au total.");
			System.out.println("L'empreinte de votre Utilisateur moyen est de "+pop.getempreinteMoy()+" TCO2.\n");
			String str1="a";
			rep=-6;
			while(rep != 1 && rep !=2 && rep!= 0) {
				System.out.println("Vous pouvez quitter en tapant (0),");
				System.out.println("Pour modifier tous vos utilisateurs en ajoutant une politique environmentale tapez (1),");
				System.out.println("Pour ajouter des utilisateurs dans la population tapez (2) :");
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
				//fonction de changement
				break;
			case 2:
				int rep1=-6;
				while(rep1 <= 0) {
					System.out.println("Quelle est la taille de la population rajoutée : ");
					str1 = sc.nextLine();
					if(!str1.matches("-?\\d+")){
						rep1=-6;
						System.out.println("Veuillez répondre uniquement par les options données.");
					}
					else rep1=Integer.valueOf(str1);
				}
				while(rep != 1 && rep !=2 && rep!= 0) {
					System.out.println("Vous pouvez quitter quitter en tapant (0).");
					System.out.println("Voulez-vous créer un utilisateur moyen avec un fichier (1) ou en donnant les valeurs à la main (2) : ");
					str1 = sc.nextLine();
					if(!str1.matches("-?\\d+")){
						rep=-6;
						System.out.println("Veuillez répondre uniquement par les options données.");
					}
					else rep=Integer.valueOf(str1);
				}
				int i;
				switch(rep) {
				case 0:
					System.out.println("Vous avez quitté le calculateur d'empreinte carbonne.");
					break;
				case 1:
					System.out.println("Veuillez donner le chemin d'accès de votre fichier :");
					User user1 = new User(sc.nextLine());
					for (i=0;i<rep1;i++) {
						pop.addUser(user1);
					}
					break;
				case 2:
					User user2 = new User(sc);
					for (i=0;i<rep1;i++) {
						pop.addUser(user2);
					}
					break;		
				}
				break;
			}
		}
	}
	
	
	/**
	 * Permet de créer une population et de rajouter des contraintes pour observer l'effet d'une politique environmentale
	 */
	public static void popu(Scanner sc) {
		
		String str1="a";
		int rep=-6;
		while(rep < 0) {
			System.out.println("Vous pouvez quitter en tapant (0),");
			System.out.println("Quelle est la taille de la population créée : ");
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
		default:
			System.out.println("La population est composée du même utilisateur moyen.");
			System.out.println("~~Bienvenue sur notre calculateur d’empreinte carbone~~");
			Scanner sc1 = new Scanner(System.in);
			str1="a";
			rep=-6;
			while(rep != 1 && rep !=2 && rep!= 0) {
				System.out.println("Vous pouvez quitter quitter en tapant (0).");
				System.out.println("Voulez-vous créer un utilisateur moyen avec un fichier (1) ou en donnant les valeurs à la main (2) : ");
				str1 = sc1.nextLine();
				if(!str1.matches("-?\\d+")){
					rep=-6;
					System.out.println("Veuillez répondre uniquement par les options données.");
				}
				else rep=Integer.valueOf(str1);
			}
			Population pop = new Population();
			int i;
			switch(rep) {
			case 0:
				System.out.println("Vous avez quitté le calculateur d'empreinte carbonne.");
				break;
			case 1:
				System.out.println("Veuillez donner le chemin d'accès de votre fichier :");
				User user1 = new User(sc1.nextLine());
				for (i=0;i<rep;i++) {
					pop.addUser(user1);
				}
				actions(sc,pop);
				break;
			case 2:
				User user2 = new User(sc1);
				for (i=0;i<rep;i++) {
					pop.addUser(user2);
				}
				actions(sc,pop);
				break;		
			}
			
			break;
		}
	}
	
	/**
	 * Lance la méthode debut() pour lancer le calculateur avec un utilisateur ou la méthode popu() pour une étude de population.
	 */
	public static void main(String[] args) {
		System.out.println("~~Bienvenue sur notre calculateur d’empreinte carbone~~");
		Scanner sc1 = new Scanner(System.in);
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 ) {
			System.out.println("Tapez 1 pour créer un Utilisateur ou 2 pour créer une population : ");
			str1 = sc1.nextLine();
			if(!str1.matches("-?\\d+")){
				rep=-6;
				System.out.println("Veuillez répondre uniquement par les options données.");
			}
			else rep=Integer.valueOf(str1);
		}
		switch(rep) {
		case 1:
			debut(sc1);
			break;
		case 2:
			popu(sc1);
			break;
		}
		sc1.close();
	}
}
