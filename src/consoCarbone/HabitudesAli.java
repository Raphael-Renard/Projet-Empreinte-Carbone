package consoCarbone;

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
        this(false,false,20,false,false);
		this.CalculImpactAli();
    }

	/** 
	 * Constructeur paramétré
    */ 
    public HabitudesAli(boolean saison, boolean locaux, double gaspillage, boolean vrac, boolean ecommerce){
    	if(gaspillage<0) {
    		System.out.println("erreur dans les valeurs\nOn initialise donc à 0 le gaspillage et faux le reste.");
			this.saison = false;
			this.locaux = false;
			this.vrac = false;
			this.ecommerce = false;
			this.gaspillage = 0;
    	}
    	else {
			this.saison = saison;
			this.locaux = locaux;
			this.vrac = vrac;
			this.ecommerce = ecommerce;
			this.gaspillage = gaspillage;
    	}
		this.CalculImpactHabAli();
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
		this.gaspillage=g;
		this.CalculImpactHabAli();
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
}
