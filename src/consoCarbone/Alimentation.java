package consoCarbone;

public class Alimentation extends ConsoCarbone{
	private double txBoeuf;  //de boeuf
	private double txVege;
	private double impact;  //impact aliment
    
    public Alimentation(double txBoeuf, double txVege){
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
    }

    public Alimentation(){
        this(1,0);
    }

	static void CalculImpactAli(Alimentation personne) {
		personne.impact = 8*personne.txBoeuf + 1.6 *(1 - personne.txVege - personne.txBoeuf) + 0.9 * personne.txVege;
	}
	
	public double gettxBoeuf() {
		return this.txBoeuf;
	}
	
	public double gettxVege() {
		return this.txVege;
	}
	
	public double getImpactA() {
		return this.impact;
	}
	
	public void settxBoeuf(double tb) {
		this.txBoeuf=tb;
	}
	
	public void settxVege(double tv) {
		this.txVege=tv;
	}
	
 /*   public static void CarbonMoyAli(){
	    System.out.println("Votre empreinte carbone moyenne est de ");
	    System.out.println(8*gettxBoeuf() + "T C02 eq à cause du boeuf, ");
	    System.out.println(1.6*(1 - gettxVege() - gettxBoeuf()) +"T C02 eq à cause du poisson et autres viandes, ");
	    System.out.println(0.9*gettxVege() + "T C02 eq à cause de l'alimentation végétale.");
    	}
*/	
	public static void main(String[] args){
		Alimentation a = new Alimentation(0.3,0.6);
		//CarbonMoyAli();
		CalculImpactAli(a);
		System.out.println("ali txB : "+a.txBoeuf);
		System.out.println("ali txV : "+a.txVege);
		System.out.println("ali impact : "+a.impact);
	}

}
