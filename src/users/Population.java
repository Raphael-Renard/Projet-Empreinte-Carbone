package users;

import java.util.*;
import consoCarbone.*;

public class Population {
    /** collection d'utilisateur.ice composant la population
	*/
	private ArrayList<User> listeUser;
    /** empreinte carbone moyenne de la population
	*/
    private double empreinteMoy;
    /** empreinte carbone totale de la population
	*/
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
	 * getter
	 * @return l'empreinte totale de la population
	 */
	public double getempreinteTot() {
		return this.empreinteTot;
	}
	/**
	 * getter
	 * @return l'empreinte moyenne d'un membre de la population
	 */
	public double getempreinteMoy() {
		return this.empreinteMoy;
	}

    /**
     * getter
     * @return la liste des utilisateurs de la population
     */
    public ArrayList<User> getListeUser () {
        return this.listeUser;
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
        try {
        this.listeUser.remove(this.listeUser.lastIndexOf(user));
        Scanner sc1 = new Scanner(System.in);
        user.modifUser(sc1);
        this.addUser(user);
        }
        catch(Exception e) {
            System.out.println("User not in list");
        }
    }

    /**
	 * Méthode pour enlever un utilisateur à la population
	 */
    public void removeUser(User user) {
        try{
            this.listeUser.remove(this.listeUser.lastIndexOf(user));
            this.calculerEmpreinteMoy();
            this.calculerEmpreinteTot();
        }
        catch (Exception e) {
            System.out.println("User not in list");
        }
    }

    /**
	 * Méthode qui teste une mesure de politique publique réduisant la consommation des services publiques à 1TCO2eq
	 */
    public void ReduireSP(){
        this.empreinteTot = this.empreinteTot - 0.5 * this.listeUser.size();
        this.empreinteMoy = this.empreinteTot - 0.5;
    }

    /**
	 * Méthode qui teste une mesure de politique publique forçant les habitants à rénover leur logement si leur CE est en dessous de D
	 */
    public void RenovationEnergetique(){
        for (User user : this.listeUser) {
            for (Logement log : user.getlogements()){
                if(log.getce() == CE.E | log.getce() == CE.F |log.getce() == CE.G){log.setce(CE.D);}
            }
        }
        this.calculerEmpreinteMoy();
		this.calculerEmpreinteTot();
    }


    /**
	 * Méthode qui teste une mesure de politique publique interdisant aux habitants de posséder plus d'une voiture
	 */
    public void UneVoitureMax(){
        for (User user : this.listeUser) {
            ArrayList<Transport> newListeTransp = new ArrayList<Transport>();
            if (user.getTransports().size()>1) {
                newListeTransp.add(user.getTransports().get(0));
                user.setTransports(newListeTransp);
            }
        }
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
        popu.RenovationEnergetique();
        System.out.println(popu.empreinteTot);
    }
}
