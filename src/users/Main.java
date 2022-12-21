package users;

import consoCarbone.CE;
import consoCarbone.Taille;

public class Main {
	
	public static void main(String[] args) {
		User utilisateur = new User(0.4, 0.5,1500, 200,CE.A, true, Taille.P, 1500, 10, 0.4);
		//Scanner sc1 = new Scanner(System.in);
		//User use = new User(sc1);
		//sc1.close();
		//use.ordonne();
		//System.out.println(use.listeLogement);
		utilisateur.ordonne();
	}
}
