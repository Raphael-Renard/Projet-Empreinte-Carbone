package consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone>{
	private int id;
	/**impact en terme de gaz a effets de serre en TCO2eq
	 */
	private double impact;
	/** Compteur pour initialiser les id
	 */
	static int nbConsoC = 0; // compteur pour id
	
	
	// constructeur
    public ConsoCarbone(){ 
    	nbConsoC = nbConsoC +1;
        this.id = nbConsoC;
        this.impact=0;
    }
    
    public int compareTo(ConsoCarbone o){  //return int
    	double tmp = this.impact - o.getImpact();
    	if (tmp <0) {return -1;}
    	else if (tmp >0) {return 1;}
    	else {return 0;}
	}
    
	// setter
    public void setimpact(double i) {
		this.impact=i;
	}
    
	/**
	 * @return impact de l'objet en terme de gaz a effets de serre en TCO2eq
	 */
    public double getImpact() {
		return this.impact;
	}
    public int getid() {
		return this.id;
	}
    
	//@Override
	/** Réécriture pour afficher une consommation avec ses paramètres
	 */
    public String toString() {
    	return ("id : " + id + ",\nimpact consoCarbon :" + impact+" TCO2eq\n");
    }
}
