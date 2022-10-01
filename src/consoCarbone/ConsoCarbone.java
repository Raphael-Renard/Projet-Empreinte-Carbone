package consoCarbone;

public class ConsoCarbone {
	private int id;
	static int nbConsoC;
	//quels attributs ?
	public ConsoCarbone(){
        this(0);
    }
    public ConsoCarbone(int i){ 
    	this.nbConsoC = this.nbConsoC +1;
        this.id = this.nbConsoC;
    }

}
