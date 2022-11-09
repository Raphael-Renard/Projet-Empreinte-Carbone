package consoCarbone;

public class Transport extends ConsoCarbone{
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	//private double impact;
	
	public void CalculImpactTransp(double fabrication){
        if (this.possede) {
        	super.setimpact ( this.kilomAnnee * 1.93 * 0.0001 + fabrication / this.amortissement);
        }
        
        else {
        	super.setimpact( 0);
        }
    }
	
	// getter
	public int getamortissement() {
		return this.amortissement;
	}
    
	public int getkilom() {
		return this.kilomAnnee;
	}

	public boolean getpossede() {
		return this.possede;
	}

	public Taille gettaille() {
		return this.taille;
	}

	// setter
    public void setamortissement(int a) {
		this.amortissement = a;
    }
	
    public void setkilom(int k) {
		this.kilomAnnee = k;
    }
    
    public void setpossede(boolean p) {
		this.possede = p;
    }
    
    public void settaille(Taille t) {
		this.taille = t;
	}
    
    public static void CarbonMoyTransp(Transport T, double fabrication){
    	System.out.println("Votre empreinte carbone moyenne en transports est de ");
    	if (T.possede) {
    		System.out.println(1.93*T.kilomAnnee*0.0001 + "T C02 eq à cause du kilometrage et ");
    		System.out.println(fabrication / T.amortissement +"T C02 eq à cause de la fabriquation de la voiture.");
    	}
    	
    	else {
    		System.out.println("0 T C02 eq.");
    	}
	
    	System.out.println("En moyenne les francais.e.s consomment 1.972 T CO2 eq à cause de leur(s) voiture(s), 0.480 à cause des voyages en avion, 0.383 pour cause de fret et messagerie et 0.085 à cause des voyages en train et bus.");

	}  
    
    @Override
	public String toString() {
	    return ("possede : " + this.possede + ", taille : " + this.taille + ", kilomAnnee : " + this.getImpact());
	  }
	
	public static void main(String[] args) { 
		Transport transp = new Transport(0, CE.C);
		transp.CalculImpactTransp(250);
		//CarbonMoyLog();
		System.out.println(transp);
    }

}
