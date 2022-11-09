package consoCarbone;

public class Alimentation extends ConsoCarbone{
	private double txBoeuf;  // taux de boeuf
	private double txVege; // taux d'alimentation vegetale
	//private double impact;  //impact a

	static final double boeuf = 8, autre = 1.6, vege = 0.9; //coefficients constants des impacts
    
	// constructeur parametre
    public Alimentation(double txBoeuf, double txVege){
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
		this.CalculImpactAli();
    }

	// constructeur par defaut
    public Alimentation(){
        this(1,0);
		this.CalculImpactAli();
    }

	public void CalculImpactAli() {
		double tmp =boeuf * this.txBoeuf + autre *(1 - this.txVege - this.txBoeuf) + vege * this.txVege;
		super.setimpact(tmp); //definition de impact dans classe mère
	}
	
	// getter
	public double gettxBoeuf() {
		return this.txBoeuf;
	}
	
	public double gettxVege() {
		return this.txVege;
	}
		// setter

	public void settxBoeuf(double tb) {
		this.txBoeuf=tb;
	}
	
	public void settxVege(double tv) {
		this.txVege=tv;
	}
	
    public static void CarbonMoyAli(Alimentation A){
	    System.out.println("Votre empreinte carbone moyenne en alimentation est de ");
	    System.out.println(boeuf*A.gettxBoeuf() + "T C02 eq à cause du boeuf, ");
	    System.out.println(autre*(1 - A.gettxVege() - A.gettxBoeuf()) +"T C02 eq à cause du poisson et autres viandes, ");
	    System.out.println(vege*A.gettxVege() + "T C02 eq à cause de l'alimentation végétale.");
	    System.out.println("En moyenne les francais.e.s consomment 1.114 T CO2 eq à cause des viandes et poissons, 0.408 à cause des produits laitiers et oeufs, 0.263 à cause des boissons et 0.538 pour d'autres raisons.");
    	}
	
	
	@Override
	public String toString() {
	    return ("taux de boeuf : " + this.txBoeuf + ", taux de repas végétariens : " + this.txVege + ", impact : " + this.getImpact());
	  }

	public static void main(String[] args){
		Alimentation a = new Alimentation(0.3,0.6);
		//CarbonMoyAli();
		// a.CalculImpactAli();
		// System.out.println("ali txB : "+a.txBoeuf);
		// System.out.println("ali txV : "+a.txVege);
		// System.out.println("ali impact : "+a.getImpact());
		System.out.println(a);
	}
}
