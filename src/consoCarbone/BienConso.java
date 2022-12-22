package consoCarbone;

import java.util.Scanner;

/**
 * BienConso est la classe qui définit un poste de consommation carbone de l’utilisateur.rice concernant ses dépenses en biens de consommation
 */

public class BienConso extends ConsoCarbone{
	/** dépenses annuelles en euros
	 */
    private double montant;
	

    /** 
     * Constructeur par défaut
	 */
    public BienConso(){
        this(0);
        this.CalculImpactDep();
    }

    /**
     * Constructeur interactif
     * @param sc scanner utilisé pour interagir avec l'utilisateur
     */
	public BienConso(Scanner sc){
		System.out.print(" Entrez le montant des dépenses annuelles :");
		String str1 = sc.nextLine();
		try {
			double montant = Double.valueOf(str1);
			if(montant<0) {
				throw new Exception("erreur dans le montant");
			}
			else {
				this.montant = montant;
			}
		}
		catch (NumberFormatException nfe) {
			System.out.print("Input non lisible. On initialise le montant à 0.");
			this.montant=0;
		}
		catch (Exception e) {
			System.out.println("Montant négatif. On initialise donc à 0");
			this.montant=0;
		}
		finally {
			this.CalculImpactDep();
		}
    }

	/**
     * Constructeur interactif sans print
     * @param sc Scanner permettant de lire le fichier
     * @param i peut être n'importe quel entier
 	*/
	public BienConso(Scanner sc, int i){
		String str1 = sc.nextLine();
		try {
			double montant = Double.valueOf(str1);
			if(montant<0) {
				throw new Exception("erreur dans le montant");
			}
			else {
				this.montant = montant;
			}
		}
		catch (NumberFormatException nfe) {
			System.out.print("Input non lisible. On initialise le montant à 0.");
			this.montant=0;
		}
		catch (Exception e) {
			System.out.println("Montant négatif. On initialise donc à 0");
			this.montant=0;
		}
		finally {
			this.CalculImpactDep();
		}
    }

    /** 
     * Constructeur paramétré
     */
    public BienConso(double montant){
		try {
			if(montant<0) {
				throw new Exception("erreur dans le montant");
			}
			else {
				this.montant = montant;
			}
		}
		catch (Exception e) {
			System.out.println("Montant negatif. On initialise donc à 0");
    		this.montant=0;
		}
		finally {
			this.CalculImpactDep();
		}
    }

    /** Calcule de l'impact des dépenses en terme de gaz a effets de serre en TCO2eq.
     * Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
    */
    public void CalculImpactDep(){
        super.setimpact(this.montant / 1750);
    }
    


    /**
	 * getter
	 * @return montant des dépenses annuelles en euros
	 */
    public double getMontant() {
		return this.montant;
	}
    
    /**
	 * setter
	 * @param m est le montant
	 */
    public void setmontant(double m) {
		try {
			if(m<0) {
				throw new Exception("erreur dans le montant");
			}
			else {
				this.montant = m;
				this.CalculImpactDep();
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans le nouveau montant. Changement non accepté.");
		}
	}
    
    /**
	 * 
	 * @param sc Scanner permettant de communiquer avec l'utilisateur.
	 * Permet de modifier le montant des dépenses de l'objet BienConso de façon intéractive.
	 */
    public void modif(Scanner sc) {
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tappant 0 ,");
			System.out.println("Tapez 1 pour modifiez le montant des dépenses : ");
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
			this.setmontant(Integer.valueOf(str1));
			break;		
		}
	}
    
    /**
     * Affiche l'empreinte carbone de l'utilisateur.rice et la compare avec celle d'un.e français.e moyen.ne
     */
    public static void CarbonMoyBien(BienConso L){
	    System.out.println("Votre empreinte carbone moyenne est de " + L.getImpact() + "T CO2 eq.");
	    System.out.println("En moyenne les francais.e.s consomment 0.763 T CO2 eq à cause des vêtements, 0.682 à cause des autres biens et services et 1.180 à cause des achats et usages Internet et technologies.");
    }

    /** Réécriture pour afficher une comsommation des dépenses avec ses paramètres
	 */
    @Override
    public String toString() {
    	return ("id : "+super.getid()+",\nmontant : " + montant + " euros,\nimpact des depenses : " + this.getImpact()+" TCO2eq\n");
    }


    /** 
	 * Méthode qui donne des conseils pour réduire son empreinte carbone
	 */
    @Override
    public void conseil(){
		if (this.montant > 2500){
			System.out.println("Essayez de faire moins d'achats si cela ne vous est pas utile. Essayer d'acheter des objets reconditionnés, des vêtements dans des friperies,...");
		}
		else {
			System.out.println("Essayez de faire moins d'achats si cela ne vous est pas nécéssaire.");
		}
	}
}
