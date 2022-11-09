package consoCarbone;

public enum Taille {
	P(4.2), // petite voiture
    G(19); // grosse voiture

    private double production;
    
    private Taille(double production){
        this.production = production;
    }
    
    public double getProduction() {
    	return this.production;
    }
}
