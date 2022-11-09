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
    
    public static void CarbonMoyBien(BienConso L){
	    System.out.println("Votre empreinte carbone moyenne est de " + L.getImpact() + "T CO2 eq.");
	    System.out.println("En moyenne les francais.e.s consomment 0.763 T CO2 eq à cause des vêtements, 0.682 à cause des autres biens et services et 1.180 à cause des achats et usages Internet et technologies.");
    }
    
    @Override
    public String toString() {
    	return ("id : "+super.getid()+",\nmontant : " + montant + " euros,\nimpact des depenses : " + this.getImpact()+"\n");
    }

}
