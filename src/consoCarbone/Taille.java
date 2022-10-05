package consoCarbone;

public enum Taille {
	P(4.2),
    G(19);

    private double production;
    
    private Taille(double production){
        this.production = production;
    }
    
    public double getProduction() {
    	return this.production;
    }
}
