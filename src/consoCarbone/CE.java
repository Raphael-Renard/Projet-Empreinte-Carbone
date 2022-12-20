package consoCarbone;

/**
 * CE est l'énumération des différentes classes énergétiques possibles pour un logement
 */

public enum CE {
    A(0.005),
    B(0.01),
    C(0.02),
    D(0.035),
    E(0.055),
    F(0.08),
    G(0.1);

    /**
     * coeffcient multiplicatif associé à la classe énergétique
     */
    private double ace;
    
    /**
     * Constructeur 
     */ 
    private CE(double ace){
        this.ace = ace;
    }
    
    /**
	 * getter
	 * @return coeffcient multiplicatif ace associé à la classe énergétique
	 */
    public double getace() {
    	return this.ace;
    }
    
}
