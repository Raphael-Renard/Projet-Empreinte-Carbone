package consoCarbone;

/**
 * Transport est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant ses déplacements
 */
public class Transport extends ConsoCarbone{
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	
	// constructeur par defaut
	public Transport(){
        this(false, Taille.P, 0, 0, 0);
		this.CalculImpactTransp(0);
    }

    // constructeur parametre
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement, double fabrication){
    	if(kilomAnnee<0 | amortissement<0 | fabrication<0) {
    		System.out.println("Erreur kilomAnnee, amortissement ou fabrication negative. On initialise tout à 0");
    		this.possede = false;
			this.taille = Taille.P;
    		this.kilomAnnee = 0;
    		this.amortissement = 0;
    		this.CalculImpactTransp(0);
    	}
    	else {
	        this.possede = possede;
			this.taille = taille;
			this.kilomAnnee = kilomAnnee;
			this.amortissement = amortissement;
			this.CalculImpactTransp(fabrication);
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
    

	public void CalculImpactTransp(double fabrication){
        if (this.possede) {
        	super.setimpact ( this.kilomAnnee * 1.93 * 0.0001 + fabrication / this.amortissement);
        }
        
        else {
        	super.setimpact( 0);
        }
    }

    public static void CarbonMoyTransp(Transport T, double fabrication){
    	System.out.println("Votre empreinte carbone moyenne en transports est de ");
    	if (T.possede) {
    		System.out.println(1.93*T.kilomAnnee*0.0001 + "T C02 eq à cause du kilometrage et ");
    		System.out.println(fabrication / T.amortissement +"T C02 eq à cause de la fabrication de la voiture.");
    	}
    	
    	else {
    		System.out.println("0 T C02 eq.");
    	}
	
    	System.out.println("En moyenne les francais.e.s consomment 1.972 T CO2 eq à cause de leur(s) voiture(s), 0.480 à cause des voyages en avion, 0.383 pour cause de fret et messagerie et 0.085 à cause des voyages en train et bus.");

	}  
    
    @Override
	public String toString() {
	    return ("id : "+super.getid()+",\npossede : " + this.possede + ",\ntaille : " + this.taille + ",\nkilomAnnee : " + this.kilomAnnee + ",\nimpact : " + this.getImpact()+" TCO2eq\n");
	  }
	

}
