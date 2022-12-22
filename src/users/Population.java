package users;

import java.util.*;
import consoCarbone.*;

public class Population {
    /** collection d'utilisateur.ice composant la population
	*/
	private ArrayList<User> listeUser;
    private double empreinteMoy;
    private double empreinteTot;

    /** 
	 * Constructeur par défaut 
	*/ 
    public Population() {
		this.listeUser = new ArrayList<User>();
	}

    /** 
	 * Constructeur paramétré
	*/
	public Population(ArrayList<User> listeUser) {
		this.listeUser = listeUser;
		this.calculerEmpreinteMoy();
		this.calculerEmpreinteTot();
    } 

    /**
	 * Méthode pour ajouter un utilisateur à la population
	 */
    public void addUser(User user){
        this.listeUser.add(user);
        this.calculerEmpreinteMoy();
		this.calculerEmpreinteTot();
    }

    /**
	 * Méthode qui calcule l'empreinte carbone totale de la population
	 */
	private void calculerEmpreinteTot() {
        double tot = 0;
        for (User user : this.listeUser) {
            tot = tot + user.calculerEmpreinte();
        }
		this.empreinteTot = tot;
    }

    /**
	 * Méthode qui calcule l'empreinte carbone moyenne de la population
	 */
	private void calculerEmpreinteMoy() {
        double tot = 0;
        for (User user : this.listeUser) {
            tot = tot + user.calculerEmpreinte();
        }
		this.empreinteMoy = tot/this.listeUser.size();
    }

    /**
	 * Méthode pour modifier un utilisateur de la population
	 */
    public void modifierUser(User user){
        this.listeUser.remove(this.listeUser.lastIndexOf(user));
        Scanner sc1 = new Scanner(System.in);
        user.modifUser(sc1);
        this.addUser(user);
    }

    /**
	 * Méthode pour enlever un utilisateur à la population
	 */
    public void removeUser(User user) {
        this.listeUser.remove(this.listeUser.lastIndexOf(user));
        this.calculerEmpreinteMoy();
		this.calculerEmpreinteTot();
    }

    public static void main(String[] args) {
		User user1 = new User(0,1,true,true,19,false,true,245,34,CE.D,true,Taille.P,2003,10,1000);
        User user2 = new User(0.5,0.2,false,true,34,true,false,1700,150,CE.A,true,Taille.G,500,5,1200);
        User user3 = new User();
        ArrayList<User> liste = new ArrayList<User>();
        liste.add(user1);
        liste.add(user2);
        liste.add(user3);
        Population popu = new Population(liste);
        System.out.println(popu.empreinteMoy);
        System.out.println(popu.empreinteTot);
    }
}
