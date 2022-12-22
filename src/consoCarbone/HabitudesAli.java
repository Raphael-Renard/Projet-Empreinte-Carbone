package consoCarbone;

import java.util.Scanner;

/**
 * HabitudesAli est la classe qui permet de moduler l'impact carbone d'un poste de consommation carbone 
 concernant le régime alimentaire d'un.e utilisateur.rice en fonction des habitudes alimentaires de ce.tte dernier.e 
 */
public class HabitudesAli extends Alimentation {
	/** mangez-vous des aliments de saison ?
	 */
    private boolean saison;
	/** mangez-vous des aliments produits localement ?
	 */
	private boolean locaux;
	/** kg de nourriture gaspillée par an
	 */
	private double gaspillage;
	/** faites-vous vos courses en vrac ?
	 */
	private boolean vrac;
	/** faites-vous vos courses dans des e-commerces ?
	 */
	private boolean ecommerce;	


	/** 
	 * Constructeur par défaut 
	*/ 
	public HabitudesAli(){
	    this(0,0,false,false,20,false,false);
	    this.CalculImpactAli();
	}
	  
	/**
	 * Constructeur interactif
	 * @param sc2 scanner utilisé pour interagir avec l'utilisateur
	*/
    public HabitudesAli(Scanner sc2){
    	super(sc2);
		System.out.print(" Mangez vous des produits de saison ? (Y/n) :");
		String str1 = sc2.nextLine();
		System.out.print(" Mangez vous des produits locaux ? (Y/n) :");
		String str2 = sc2.nextLine();
		System.out.print(" Entrez le nombre en kilo de gaspillage par an :");
		String str3 = sc2.nextLine();
		System.out.print(" Faites vous vos courses en vrac ? (Y/n) :");
		String str4 = sc2.nextLine();
		System.out.print(" Faites vous vos courses dans des e-commerces ? (Y/n) :");
		String str5 = sc2.nextLine();
		try {
			Double g = Double.valueOf(str3);
			if(Double.valueOf(str3)<0) {
				throw new Exception("erreur dans le nb de kg gaspillés");
			}
			else {
				this.gaspillage = g;
			}
		}
		catch (NumberFormatException nfe) {
			System.out.print("Input non lisible. On initialise le gaspillage à 0.");
			this.gaspillage=0;
		}
		catch(Exception e) {
			this.gaspillage = 0;
			System.out.println("Réponse non valide (gaspillage<0), initialisation à 0");
		}
		finally {
		this.saison=false;
		this.locaux=false;
		this.vrac=false;
		this.ecommerce=false;
		switch( str1 ) {
		    case "Y":
		        this.saison=true;
		        break;
		    case "n":
		        break;
		    default:
		        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		switch( str2 ) {
	    case "Y":
	        this.locaux=true;
	        break;
	    case "n":
	        break;
	    default:
	        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		switch( str4 ) {
	    case "Y":
	        this.vrac=true;
	        break;
	    case "n":
	        break;
	    default:
	        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		switch( str5 ) {
	    case "Y":
	        this.ecommerce=true;
	        break;
	    case "n":
	        break;
	    default:
	        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		this.CalculImpactAli();
		}
    }


	/**
	 * Constructeur interactif sans print
	 * @param sc2 Scanner permettant de lire le fichier
	 * @param i peut être n'importe quel entier
	*/
    public HabitudesAli(Scanner sc2, int i){
    	super(sc2,i);
		String str1 = sc2.nextLine();
		String str2 = sc2.nextLine();
		String str3 = sc2.nextLine();
		String str4 = sc2.nextLine();
		String str5 = sc2.nextLine();
		try {
			Double g = Double.valueOf(str3);
			if(Double.valueOf(str3)<0) {
				throw new Exception("erreur dans le nb de kg gaspillés");
			}
			else {
				this.gaspillage = g;
			}
		}
		catch (NumberFormatException nfe) {
			System.out.print("Input non lisible. On initialise le gaspillage à 0.");
			this.gaspillage=0;
		}
		catch(Exception e) {
			this.gaspillage = 0;
			System.out.println("Réponse non valide (gaspillage<0), initialisation à 0");
		}
		finally {
		this.saison=false;
		this.locaux=false;
		this.vrac=false;
		this.ecommerce=false;
		switch( str1 ) {
		    case "Y":
		        this.saison=true;
		        break;
		    case "n":
		        break;
		    default:
		        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		switch( str2 ) {
	    case "Y":
	        this.locaux=true;
	        break;
	    case "n":
	        break;
	    default:
	        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		switch( str4 ) {
	    case "Y":
	        this.vrac=true;
	        break;
	    case "n":
	        break;
	    default:
	        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		switch( str5 ) {
	    case "Y":
	        this.ecommerce=true;
	        break;
	    case "n":
	        break;
	    default:
	        System.out.println("Réponse non valide (Y ou n), initialisation à faux");
		}
		this.CalculImpactAli();
		}
    }

	/** 
	 * Constructeur paramétré
    */ 
    public HabitudesAli(double txBoeuf, double txVege,boolean saison, boolean locaux, double gaspillage, boolean vrac, boolean ecommerce){
    	super(txBoeuf,txVege);
		try{
			if(gaspillage<0) {
				throw new Exception("erreur dans le nb de kg gaspillés");
			}
			else {
				this.saison = saison;
				this.locaux = locaux;
				this.vrac = vrac;
				this.ecommerce = ecommerce;
				this.gaspillage = gaspillage;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans le nb de kg gaspillés. On initialise donc à 0 le gaspillage et faux le reste.");
			this.saison = false;
			this.locaux = false;
			this.vrac = false;
			this.ecommerce = false;
			this.gaspillage = 0;

		}
		finally {
			this.CalculImpactHabAli();
		}
	}


	/** Recalcul l'impact de l'alimentation en terme de gaz a effets de serre en TCO2eq, modulé par les habitudes alimentaires.
     * Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
    */
    public void CalculImpactHabAli() {
		double tmp = boeuf * super.gettxBoeuf() + autre *(1 - super.gettxVege() - super.gettxBoeuf()) + vege * super.gettxVege();
		
		if (this.saison) {tmp = tmp * 0.1;}
		if (this.locaux) {tmp = tmp - 0.17;}
		if (this.vrac) {tmp = tmp * 0.6;}
		if (this.ecommerce) {tmp = tmp * 0.7;}
		super.setimpact(tmp); //definition de impact dans classe ConsoCarbone
	}

    /**
	 * 
	 * @param sc Scanner permettant de communiquer avec l'utilisateur.
	 * Permet de modifier un paramètre de l'objet HabitudesAli de façon intéractive.
	 * Pour les attributs de type booléen, une modification changera automatiquement la valeur à celle opposée (false si true et inversement)
	 */
    @Override
    public void modif(Scanner sc) {
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 && rep !=3 && rep !=4 && rep !=5 && rep !=6 && rep !=7 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tapant 0 ,");
			System.out.println("Quel paramètre de consommation voulez vous modifier ?");
			System.out.println("Tapez 1 pour modifiez le taux de repas à base de boeuf ,");
			System.out.println("Tapez 2 pour modifiez le taux de repas végétariens,");
			System.out.println("Tapez 3 pour modifiez la consommation de produits de saison,");
			System.out.println("Tapez 4 pour modifiez la consommation de produits locaux,");
			System.out.println("Tapez 5 pour modifiez le montant de gaspillage alimentaire par an,");
			System.out.println("Tapez 6 pour modifiez l'achat des courses en  vrac,");
			System.out.println("Tapez 7 pour modifiez l'achat des courses en ecommerces.");

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
		case 3:
			if(this.saison) {
				this.saison = false;
				System.out.println("L'utilisateur ne consomme plus de produits de saison.");
			}
			else {
				this.saison = true;
				System.out.println("L'utilisateur consomme des produits de saison.");
			}
			break;
		case 4:
			if(this.locaux) {
				this.locaux = false;
				System.out.println("L'utilisateur ne consomme plus de produits locaux.");
			}
			else {
				this.locaux = true;
				System.out.println("L'utilisateur consomme des produits locaux.");
			}
			break;
		case 5:
			System.out.println("Donnez la nouvelle valeur : ");
			str1 = sc.nextLine();
			this.setgaspillage(Integer.valueOf(str1));
			break;
		case 6:
			if(this.vrac) {
				this.vrac = false;
				System.out.println("L'utilisateur ne fait plus ses courses en vrac.");
			}
			else {
				this.vrac = true;
				System.out.println("L'utilisateur fait ses courses en vrac.");
			}
			break;
		case 7:
			if(this.ecommerce) {
				this.ecommerce = false;
				System.out.println("L'utilisateur ne fait plus ses courses dans des ecommerces.");
			}
			else {
				this.ecommerce = true;
				System.out.println("L'utilisateur fait ses courses dans des ecommerces.");
			}
			break;
		}
	}
    /**
	 * getter
	 * @return le boolean qui représente si l'utilisateur.ice mange des aliments de saison
	 */
	public boolean getsaison() {
		return this.saison;
	}

	/**
	 * getter
	 * @return le boolean qui représente si l'utilisateur.ice mange des aliments produits localement
	 */
	public boolean getlocaux() {
		return this.locaux;
	}

	/**
	 * getter
	 * @return le boolean qui représente si l'utilisateur.ice fait ses courses en vrac
	 */
	public boolean getvrac() {
		return this.vrac;
	}

	/**
	 * getter
	 * @return le boolean qui représente si l'utilisateur.ice fait ses courses dans des e-commerces
	 */
	public boolean getecommerce() {
		return this.ecommerce;
	}

	/**
	 * getter
	 * @return le nb de kilos de nourriture gaspillée par an
	 */
	public double getgaspillage() {
		return this.gaspillage;
	}
	
	
	/**
	 * setter
	 * @param s est le boolean qui représente si l'utilisateur.ice mange des aliments de saison
	 */
	public void setsaison(boolean s) {
		this.saison=s;
		this.CalculImpactHabAli();
	}

	/**
	 * setter
	 * @param l est le boolean qui représente si l'utilisateur.ice mange des aliments produits localement
	 */
	public void setlocaux(boolean l) {
		this.locaux=l;
		this.CalculImpactHabAli();
	}

	/**
	 * setter
	 * @param g est le nombre de kilos de nourriture gaspillée par an
	 */
	public void setgaspillage(double g) {
		try {
			if(g<0) {
				throw new Exception("erreur dans le nb de kg gaspillés");
			}
			else {
				this.gaspillage=g;
				this.CalculImpactHabAli();
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans le nb de kg gaspillés. Changement non accepté.");
		}
	}

	/**
	 * setter
	 * @param v est le boolean qui représente si l'utilisateur.ice fait ses courses en vrac
	 */
	public void setvrac(boolean v) {
		this.vrac=v;
		this.CalculImpactHabAli();
	}

	/**
	 * setter
	 * @param ec est le boolean qui représente si l'utilisateur.ice fait ses courses dans des e-commerces
	 */
	public void setecommerce(boolean ec) {
		this.ecommerce=ec;
		this.CalculImpactHabAli();
	}
	
	public String toString() {
	    return ("id : " + super.getid() + ",\nAlimentation de saison : " + this.getsaison() + ",\nAlimentation locale : " + this.getlocaux() + ",\nGaspillage alimentaire : "+this.getgaspillage()+"kg,\nCourse en vrac : "+this.getvrac()+",\nCourse dans des e-commerces : "+this.getecommerce()+",\nimpact : " + this.getImpact()+" TCO2eq\n");
	}
	
	/** 
	 * Méthode qui donne des conseils pour réduire son empreinte carbone
	 */
	@Override
	public void conseil() {
		if(!this.getsaison()) {
			System.out.println("Essayez de consommer des produits de saison.");
		}
		if(!this.getlocaux()) {
			System.out.println("Essayez de consommer des produits locaux.");
		}
		if(!this.getvrac()) {
			System.out.println("Essayez de faire vos courses en vrac.");
		}
		if(!this.getecommerce()) {
			System.out.println("Essayez de faire vos courses dans des e-commerces.");
		}
		if(this.getgaspillage()>25) {
			System.out.println("Essayez de réduire le gaspillage alimentaire.");
		}
	}
}
