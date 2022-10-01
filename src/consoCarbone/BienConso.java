package consoCarbone;

public class BienConso {
	private double montant; //depenses annuelles en euros
	private double impact;
	
	public BienConso(){
        this(0);
    }
    public BienConso(double montant){
        this.montant = montant;
    }
    static void CalculImpactDep(BienConso b){
        b.impact = b.montant / 1750;
    }
    
    public double getImpactM() {
		return this.impact;
	}
    
    public double getMontant() {
		return this.montant;
	}
    
    public void setmontant(double m) {
		this.montant=m;
	}
}
