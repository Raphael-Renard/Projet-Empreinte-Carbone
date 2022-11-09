package consoCarbone;

public class BienConso extends ConsoCarbone{
	private double montant; //depenses annuelles en euros
	
    // constructeur par defaut
	public BienConso(){
        this(0);
        this.CalculImpactDep();
    }

    // constructeur parametre
    public BienConso(double montant){
        this.montant = montant;
        this.CalculImpactDep();
    }


    public void CalculImpactDep(){
        super.setimpact(this.montant / 1750);
    }
    
    // getter
    public double getMontant() {
		return this.montant;
	}
    
    // setter
    public void setmontant(double m) {
		this.montant=m;
	}
    
    @Override
    public String toString() {
    	return ("id : "+super.getid()+",\nmontant : " + montant + " euros,\nimpact des depenses : " + this.getImpact()+"\n");
    }

    public static void main(String[] args) {
    	BienConso c = new BienConso(1200);
    	// c.CalculImpactDep();
    	System.out.println(c);
     }
}
