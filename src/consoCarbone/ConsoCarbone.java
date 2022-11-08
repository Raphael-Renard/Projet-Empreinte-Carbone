package consoCarbone;

public class ConsoCarbone {
	private int id;
	private double impact;
	static int nbConsoC;
	
    public ConsoCarbone(){ 
    	nbConsoC = nbConsoC +1;
        this.id = nbConsoC;
        this.impact=0;
    }
    
    public void setimpact(double i) {
		this.impact=i;
	}
    
    public double getImpact() {
		return this.impact;
	}
    
    public String toString() {
    	return ("id : "+id+", impact global :"+impact);
    }
    public static void main(String[] args) {
    	ConsoCarbone c = new BienConso();
    	System.out.println(c);
     }
}
