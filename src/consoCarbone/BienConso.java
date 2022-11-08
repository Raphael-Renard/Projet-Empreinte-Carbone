package consoCarbone;

public class BienConso extends ConsoCarbone{
	private double montant; //depenses annuelles en euros
	
	public BienConso(){
        this(0);
    }
    public BienConso(double montant){
        this.montant = montant;
    }
    public void CalculImpactDep(){
        super.setimpact( this.montant / 1750);
    }
    
    public double getMontant() {
		return this.montant;
	}
    
    public void setmontant(double m) {
		this.montant=m;
	}
    
    public String toString() {
    	return ("montant : "+montant+",\nimpact des depenses :"+this.getImpact());
    }
    public static void main(String[] args) {
    	BienConso c = new BienConso(1200);
    	c.CalculImpactDep();
    	System.out.println(c);
     }
}
