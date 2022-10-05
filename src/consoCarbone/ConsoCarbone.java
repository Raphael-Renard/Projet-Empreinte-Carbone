package consoCarbone;

public class ConsoCarbone {
	private int id;
	private int impactGlobal;
	static int nbConsoC;
	//quels attributs ? impactA ? impactL ? impactDep ? impactT ?
	
    public ConsoCarbone(){ 
    	nbConsoC = nbConsoC +1;
        this.id = nbConsoC;
        this.impactGlobal=0; //initialiser ??
    }

    public String toString() {
    	return ("id : "+id+", impact global :"+impactGlobal);
    }
    public static void main(String[] args) {
    	ConsoCarbone c = new BienConso();
    	System.out.println(c);
     }
}
