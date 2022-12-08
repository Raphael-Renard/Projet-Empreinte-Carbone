package consoCarbone;


/**
 * BienConso est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant ses dépenses en biens de consommation
 */

public class BienConso extends ConsoCarbone{
	private double montant; //depenses annuelles en euros
	
    // constructeur par defaut
	public BienConso(){
        this(0);
        this.CalculImpactDep();
    }

    // constructeur parametre
    public BienConso(double montant){
    	if(montant<0) {
    		System.out.println("Montant negatif. On initialise donc à 0");
    		this.montant=0;
    	}
    	else{
    		this.montant = montant;
    	}
        this.CalculImpactDep();
    }

    /** Calcule de l'impact des dépenses en terme de gaz a effets de serre en TCO2eq.
    Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
    */
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
    /** Réécriture pour afficher une comsommation des dépenses avec ses paramètres
	 */
    @Override
    public String toString() {
    	return ("id : "+super.getid()+",\nmontant : " + montant + " euros,\nimpact des depenses : " + this.getImpact()+" TCO2eq\n");
    }

}
