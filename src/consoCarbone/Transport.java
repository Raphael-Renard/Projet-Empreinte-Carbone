package consoCarbone;

public class Transport extends ConsoCarbone{
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	private double impact;
	
	static void CalculImpactTransp(Transport T, double fabrication){
        if (T.possede) {
        	T.impact = T.kilomAnnee * 1.93 * 0.0001 + fabrication / T.amortissement;
        }
        
        else {
        	T.impact = 0;
        }
    }
	
	
	public int getamortissement() {
		return this.amortissement;
	}
    
    public void setamortissement(int a) {
		this.amortissement = a;
    }
	
	public int getkilom() {
		return this.kilomAnnee;
	}
    
    public void setkilom(int k) {
		this.kilomAnnee = k;
    }
	
	public boolean getpossede() {
		return this.possede;
	}
    
    public void setpossede(boolean p) {
		this.possede = p;
    }
	
    public double getimpact() {
		return this.impact;
	}
    
    public void setimpact(double i) {
		this.impact = i;
    }
    
    public Taille gettaille() {
		return this.taille;
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
	    return ("possede : " + this.possede + ", taille : " + this.taille + ", kilomAnnee : " + this.impact);
	  }

}
