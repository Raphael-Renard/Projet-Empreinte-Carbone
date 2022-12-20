package consoCarbone;

/**
 * Taille est l'énumération des différentes tailles de véhicules possibles
 */
public enum Taille {
	P(4.2), // petite voiture
    G(19); // grosse voiture

    /** empreinte carbone de la production d'une voiture 
    */
    private double production;
    
    /** 
     * Constructeur
    */
    private Taille(double production){
        this.production = production;
    }
    
    /**
     * getter
     * @return empreinte carbone de la production du véhicule
     */
    public double getProduction() {
    	return this.production;
    }
}
