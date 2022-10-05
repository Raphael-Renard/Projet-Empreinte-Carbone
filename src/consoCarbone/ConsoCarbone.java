package consoCarbone;

public class ConsoCarbone {
	private int id;
	private int impactGlobal;
	static int nbConsoC;
	//quels attributs ? impactA ? impactL ? impactDep ? impactT ?
	public ConsoCarbone(){
        this(0);
    }
    public ConsoCarbone(int i){ 
    	this.nbConsoC = this.nbConsoC +1;
        this.id = this.nbConsoC;
        this.impactGlobal=i; //initialiser ??
    }
    public String toString() {
    	return ("id : "+id+", impact global :"+impactGlobal);
    }
    public static void main(String[] args) {
    	ConsoCarbone c = new ConsoCarbone(1200);
    	System.out.println(c);
     }

}
