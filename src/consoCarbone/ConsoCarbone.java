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
        this.impactGlobal=0; //initialiser ??
    }

}
