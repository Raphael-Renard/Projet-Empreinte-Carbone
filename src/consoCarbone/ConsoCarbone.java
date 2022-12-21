package consoCarbone;

/**
 * ConsoCarbone est la classe qui définit un poste de consommation carbone générique
 */
public abstract class ConsoCarbone implements Comparable<ConsoCarbone>{
	/** identifiant unique attribué à l’instance
	 */
	private int id;
	/** impact en terme de gaz a effets de serre en TCO2eq
	 */
	private double impact;
	/** compteur pour initialiser les id
	 */
	static int nbConsoC = 0; // compteur pour id
	
	
	/** 
	 * Constructeur
	*/ 
    public ConsoCarbone(){ 
    	nbConsoC = nbConsoC +1;
        this.id = nbConsoC;
        this.impact=0;
    }


  	@Override
    /**
     * @return -1 si l'impact du premier objet est plus petit que le second objet comparé, 1 si il est plus grand et 0 sinon.
     * @param objet que l'on veut comparer avec l'objet courant
    */
    public int compareTo(ConsoCarbone o){
    	double tmp = this.impact - o.getImpact();
    	if (tmp <0) {return -1;}
    	else if (tmp >0) {return 1;}
    	else {return 0;}
	}
    
	/**
	 * setter
	 * @param i est l'impact carbone
	 */
    public void setimpact(double i) {
		try {
			if(i<0) {
				throw new Exception("erreur dans l'impact");
			}
			else {
				this.impact = i;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur dans le nouvel impact. Changement non accepté.");
		}
	}
    
	/**
	 * getter
	 * @return impact total en terme de gaz a effets de serre en TCO2eq
	 */
    public double getImpact() {
		return this.impact;
	}

	/**
	 * getter
	 * @return id du poste de consommation carbone
	 */
    public int getid() {
		return this.id;
	}
    

	@Override
	/** Réécriture pour afficher une consommation avec ses paramètres
	 */
    public String toString() {
    	return ("id : " + id + ",\nimpact consoCarbon :" + impact+" TCO2eq\n");
    }


	/** Donne des conseils pour réduire son empreinte carbone.
	 * La méthode est redéfinie dans les classes filles.
	 */
	public abstract void conseil();
}
