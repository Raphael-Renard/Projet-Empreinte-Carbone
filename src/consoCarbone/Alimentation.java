package consoCarbone;


/**
 * Alimentation est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant son alimentation
 */

public class Alimentation extends ConsoCarbone{
	/** taux de repas à base de boeuf
	 */
	private double txBoeuf;
	/** taux de repas végétariens
	 */
	private double txVege;
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
	 coefficient fixe influençant l'impact de l'alimentation
	 */
	static final double boeuf = 8, autre = 1.6, vege = 0.9;
    

	// constructeur par défaut
    public Alimentation(){
        this(1,0,false,false,20,false,false);
		this.CalculImpactAli();
    }
    
	// constructeur paramétré
    public Alimentation(double txBoeuf, double txVege, boolean saison, boolean locaux, double gaspillage, boolean vrac, boolean ecommerce){
    	if(txBoeuf+txVege>1 | txBoeuf<0 | txVege<0 | gaspillage<0) {  //on teste si les taux sont realistes
    		System.out.println("erreur dans les taux\nOn initialise donc à 0 les taux.");
    		this.txBoeuf = 0;
            this.txVege = 0;
			this.saison = false;
			this.locaux = false;
			this.vrac = false;
			this.ecommerce = false;
			this.gaspillage = 0;
    	}
    	else {
            this.txBoeuf = txBoeuf;
            this.txVege = txVege;
			this.locaux = locaux;
			this.vrac = vrac;
			this.ecommerce = ecommerce;
			this.gaspillage = gaspillage;
    		this.CalculImpactAli();
    	}

    
	}
	

    /** Calcule de l'impact de l'alimentation en terme de gaz a effets de serre en TCO2eq.
    Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
    */
	public void CalculImpactAli() {
		double tmp = boeuf * this.txBoeuf + autre *(1 - this.txVege - this.txBoeuf) + vege * this.txVege;
		
		if (this.saison) {tmp = tmp * 0.1;}
		if (this.locaux) {tmp = tmp - 0.17;}
		if (this.vrac) {tmp = tmp * 0.6;}
		if (this.ecommerce) {tmp = tmp * 0.7;}
		super.setimpact(tmp); //definition de impact dans classe mère
	}


	// getter
	public double gettxBoeuf() {
		return this.txBoeuf;
	}
	
	public double gettxVege() {
		return this.txVege;
	}

	public boolean getsaison() {
		return this.saison;
	}

	public boolean getlocaux() {
		return this.locaux;
	}

	public boolean getvrac() {
		return this.vrac;
	}

	public boolean getecommerce() {
		return this.ecommerce;
	}

	public double getgaspillage() {
		return this.gaspillage;
	}
	
	// setter

	public void settxBoeuf(double tb) {
		this.txBoeuf=tb;
	}
	
	public void settxVege(double tv) {
		this.txVege=tv;
	}

	public void setsaison(boolean s) {
		this.saison=s;
	}

	public void setlocaux(boolean l) {
		this.locaux=l;
	}

	public void setgaspillage(double g) {
		this.gaspillage=g;
	}

	public void setvrac(boolean v) {
		this.vrac=v;
	}

	public void setecommerce(boolean ec) {
		this.ecommerce=ec;
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
	
	
	//@Override
    /** Réécriture pour afficher une alimentation avec ses paramètres
	 */
	public String toString() {
	    return ("id : "+super.getid()+",\ntaux de boeuf : " + this.txBoeuf + ",\ntaux de repas végétariens : " + this.txVege + ",\nimpact : " + this.getImpact()+" TCO2eq\n");
	  }

}
