package consoCarbone;

import java.util.Scanner;

import java.lang.NumberFormatException;

/**
 * Alimentation est la classe qui définit un poste de consommation carbone de l’utilisateur.rice concernant son alimentation
 */

public class Alimentation extends ConsoCarbone{
	/** 
	 * taux de repas à base de boeuf
	 */
	private double txBoeuf;
	/** 
	 * taux de repas végétariens
	 */
	private double txVege;
	

	/**
	 * coefficients fixes influençant l'impact de l'alimentation
	 */
	static final double boeuf = 8, autre = 1.6, vege = 0.9;
    

	/**
	 * Constructeur par défaut donnant une consommation maximum
	 */
	public Alimentation(){
        this(1,0);
        this.CalculImpactAli();
	}

	/** 
	 * Constructeur intéractif
	 * @param sc scanner utilisé pour interagir avec l'utilisateur
	 */
    public Alimentation(Scanner sc){
		System.out.print(" Entrez le taux de repas (une valeur entre 0 et 1) à base de boeuf :");
		String str1 = sc.nextLine();
		System.out.print(" Entrez le taux de repas végétariens :");
		String str2 = sc.nextLine();
    	try {
			double txBoeuf = Double.valueOf(str1),txVege = Double.valueOf(str2);
			if(txBoeuf+txVege>1 | txBoeuf<0 | txVege<0) {
				throw new Exception("erreur dans les taux");
			}
			else {
				this.txBoeuf = txBoeuf;
				this.txVege = txVege;
			}
		}
		catch (NumberFormatException nfe) {
			System.out.print("Input non lisible. On initialise les taux à 0.");
			this.txBoeuf = 0;
			this.txVege = 0;
		}
		catch (Exception e) {
			System.out.println("Taux impossibles. On initialise les taux à 0.");
			this.txBoeuf = 0;
			this.txVege = 0;
		}
		finally {
			this.CalculImpactAli();
		}
    }
    

    /** 
	 * Constructeur intéractif sans print
	 * @param sc Scanner permettant de lire le fichier
	 * @param i peut être n'importe quel entier
	 */
    public Alimentation(Scanner sc, int i){
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
    	try {
			double txBoeuf = Double.valueOf(str1),txVege = Double.valueOf(str2);
			if(txBoeuf+txVege>1 | txBoeuf<0 | txVege<0) {
				throw new Exception("erreur dans les taux");
			}
			else {
				this.txBoeuf = txBoeuf;
				this.txVege = txVege;
			}
		}
		catch (NumberFormatException nfe) {
			System.out.print("Input non lisible. On initialise les taux à 0.");
			this.txBoeuf = 0;
			this.txVege = 0;
		}
		catch (Exception e) {
			System.out.println("Taux impossibles. On initialise les taux à 0.");
			this.txBoeuf = 0;
			this.txVege = 0;
		}
		finally {
			this.CalculImpactAli();
		}
    }
    
	/** 
	 * Constructeur paramétré
    */ 
    public Alimentation(double txBoeuf, double txVege){
		try {
			if(txBoeuf+txVege>1 | txBoeuf<0 | txVege<0) {
				throw new Exception("erreur dans les taux");
			}
			else {
				this.txBoeuf = txBoeuf;
				this.txVege = txVege;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans les taux. On initialise donc les taux à 0.");
			this.txBoeuf = 0;
			this.txVege = 0;
		}
		finally {
			this.CalculImpactAli();
		}
	}


    /** 
	 * Calcule de l'impact de l'alimentation en terme de gaz a effets de serre en TCO2eq.
     * Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
    */
	public void CalculImpactAli() {
		double tmp = boeuf * this.txBoeuf + autre *(1 - this.txVege - this.txBoeuf) + vege * this.txVege;
		super.setimpact(tmp); //definition de impact dans classe mère
	}



	/**
	 * getter
	 * @return le taux de repas à base de boeuf
	 */
	public double gettxBoeuf() {
		return this.txBoeuf;
	}
	
	/**
	 * getter
	 * @return le taux de repas végétariens
	 */
	public double gettxVege() {
		return this.txVege;
	}
	

	/**
	 * setter
	 * @param tb est le taux de repas à base de boeuf
	 */
	public void settxBoeuf(double tb) {
		try {
			if(tb+this.txVege>1 | tb<0) {
				throw new Exception("erreur dans les taux");
			}
			else {
				this.txBoeuf = tb;
				this.CalculImpactAli();
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans le nouveau taux. Changement non accepté.");
		}
	}
	
	/**
	 * setter
	 * @param tv est le taux de repas végétariens
	 */
	public void settxVege(double tv) {
		try {
			if(tv+this.txBoeuf>1 | tv<0) {
				throw new Exception("erreur dans les taux");
			}
			else {
				this.txVege = tv;
				this.CalculImpactAli();
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans le nouveau taux. Changement non accepté.");
		}
	}

	/**
	 * 
	 * @param sc Scanner permettant de communiquer avec l'utilisateur.
	 * Permet de modifier un paramètre de l'objet Alimentation de façon intéractive.
	 */
	public void modif(Scanner sc) {
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tappant 0 ,");
			System.out.println("Quel paramètre de consommation voulez vous modifier ?");
			System.out.println("Tapez 1 pour modifiez le taux de repas à base de boeuf ,");
			System.out.println("Tapez 2 pour modifiez le taux de repas végétariens.");
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
		case 1:
			System.out.println("Donnez la nouvelle valeur : ");
			str1 = sc.nextLine();
			this.settxBoeuf(Integer.valueOf(str1));
			break;
		case 2:
			System.out.println("Donnez la nouvelle valeur : ");
			str1 = sc.nextLine();
			this.settxVege(Integer.valueOf(str1));
			break;			
		}
	}
	
	/**
	 Affiche la consommation de l'alimentaion en paramètre. Puis affiche la distribution de l'impact moyen d'un français à cause de l'alimentation.
	 */
    public static void CarbonMoyAli(Alimentation A){
	    System.out.println("Votre empreinte carbone moyenne en alimentation est de ");
	    System.out.println(boeuf*A.gettxBoeuf() + "T C02 eq à cause du boeuf, ");
	    System.out.println(autre*(1 - A.gettxVege() - A.gettxBoeuf()) +"T C02 eq à cause du poisson et autres viandes, ");
	    System.out.println(vege*A.gettxVege() + "T C02 eq à cause de l'alimentation végétale.");
	    System.out.println("En moyenne les francais.e.s consomment 1.114 T CO2 eq à cause des viandes et poissons, 0.408 à cause des produits laitiers et oeufs, 0.263 à cause des boissons et 0.538 pour d'autres raisons.");
    	}
	
	
	@Override
    /** Réécriture pour afficher une alimentation avec ses paramètres
	 */
	public String toString() {
	    return ("id : " + super.getid() + ",\ntaux de boeuf : " + this.txBoeuf + ",\ntaux de repas végétariens : " + this.txVege + ",\nimpact : " + this.getImpact()+" TCO2eq\n");
	}
	
	/** 
	 * Méthode qui donne des conseils pour réduire son empreinte carbone
	 */
	@Override
	public void conseil(){
		if (this.txBoeuf > 0.3){
			System.out.println("Essayez de manger moins de boeuf, remplacez par d'autres viandes moins polluantes comme le poulet. Essayez de manger moins de viande, remplacez par des alternatives végatales comme les légumineuses.");
		}
		else if (this.txVege < 0.5) {
			System.out.println("Essayez de manger moins de viande, remplacez par des alternatives végatales comme les légumineuses.");
		}
		else {
			System.out.println("Essayer de ne plus manger de viande pour réduire encore plus votre consommation.");
		}

	}
}
