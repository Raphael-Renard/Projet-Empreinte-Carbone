package consoCarbone;


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
	 * Constructeur paramétré
    */ 
    public Alimentation(double txBoeuf, double txVege){
    	if(txBoeuf+txVege>1 | txBoeuf<0 | txVege<0) {  //on teste si les taux sont realistes
    		System.out.println("erreur dans les taux\nOn initialise donc à 0 les taux.");
    		this.txBoeuf = 0;
            this.txVege = 0;
    	}
    	else {
            this.txBoeuf = txBoeuf;
            this.txVege = txVege;
    	}
		this.CalculImpactAli();
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
		this.txBoeuf=tb;
		this.CalculImpactAli();
	}
	
	/**
	 * setter
	 * @param tv est le taux de repas végétariens
	 */
	public void settxVege(double tv) {
		this.txVege=tv;
		this.CalculImpactAli();
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
		if (this.txBoeuf > 0.5){
			System.out.println("Essayez de manger moins de boeuf, remplacez par d'autres viandes moins polluantes comme le poulet. Essayez de manger moins de viande, remplacez par des alternatives végatales comme les légumineuses.");
		}
		else if (this.txVege < 0.3) {
			System.out.println("Essayez de manger moins de viande, remplacez par des alternatives végatales comme les légumineuses.");
		}

	}
}
