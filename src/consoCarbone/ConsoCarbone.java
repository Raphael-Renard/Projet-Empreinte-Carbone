package consoCarbone;

public abstract class ConsoCarbone{
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
