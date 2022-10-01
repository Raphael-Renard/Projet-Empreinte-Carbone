package consoCarbone;

public class Transport {
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	private double impact;
	
	static void CalculImpactTransp(Transport T, double fabrication){
        if (T.possede) {
        	T.impact = T.kilomAnnee * 1.93 * 0.0001 + fabrication / T.amortissement;
        }
        
        else {
        	T.impact = 0;
        }
    }
    
	
	
	
	public int getamortissement() {
		return this.amortissement;
	}
    
    public void setamortissement(int a) {
		this.amortissement = a;
    }
	
	public int getkilom() {
		return this.kilomAnnee;
	}
    
    public void setkilom(int k) {
		this.kilomAnnee = k;
    }
	
	public boolean getpossede() {
		return this.possede;
	}
    
    public void setpossede(boolean p) {
		this.possede = p;
    }
	
    public double getimpact() {
		return this.impact;
	}
    
    public void setimpact(double i) {
		this.impact = i;
    }
    
    public Taille gettaille() {
		return this.taille;
	}
    
    public void settaille(Taille t) {
		this.taille = t;
	}

}
