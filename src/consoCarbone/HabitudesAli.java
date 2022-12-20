package consoCarbone;

public class HabitudesAli extends Alimentation {
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

    public HabitudesAli(){
        this(false,false,20,false,false);
		this.CalculImpactAli();
    }

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
			this.locaux = locaux;
			this.vrac = vrac;
			this.ecommerce = ecommerce;
			this.gaspillage = gaspillage;
    		this.CalculImpactHabAli();
    	}
	}


    public void CalculImpactHabAli() {
		double tmp = boeuf * super.gettxBoeuf() + autre *(1 - super.gettxVege() - super.gettxBoeuf()) + vege * super.gettxVege();
		
		if (this.saison) {tmp = tmp * 0.1;}
		if (this.locaux) {tmp = tmp - 0.17;}
		if (this.vrac) {tmp = tmp * 0.6;}
		if (this.ecommerce) {tmp = tmp * 0.7;}
		super.setimpact(tmp); //definition de impact dans classe mère Alimentation
	}


    // getter

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
}
