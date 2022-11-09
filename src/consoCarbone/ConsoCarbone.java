package consoCarbone;

public class ConsoCarbone {
	private int id;
	private double impact;
	static int nbConsoC = 0; // compteur pour id
	
	// constructeur
    public ConsoCarbone(){ 
    	nbConsoC = nbConsoC +1;
        this.id = nbConsoC;
        this.impact=0;
    }
    
	// setter
    public void setimpact(double i) {
		this.impact=i;
	}
    
	// getter
    public double getImpact() {
		return this.impact;
	}
    
	@Override
    public String toString() {
    	return ("id : " + id + ", impact global :" + impact);
    }

    public static void main(String[] args) {
		// fait appel a la fonction toString de BienConso
    	ConsoCarbone c = new BienConso();
    	System.out.println(c);

		// fait appel a la fonction toString de ConsoCarbone
		ConsoCarbone d = new ConsoCarbone();
    	System.out.println(d);

		// fait appel a la fonction toString de Logement
		Logement log = new Logement();
    	System.out.println(log);
     }
}
