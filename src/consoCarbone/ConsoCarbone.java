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
    public int getid() {
		return this.id;
	}
    
	@Override
    public String toString() {
    	return ("id : " + id + ",\nimpact consoCarbone :" + impact+"\n");
    }

}
