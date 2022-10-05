package consoCarbone;

public class Logement extends ConsoCarbone{
    private int superficie;  //m^2
    private CE ce;
    private double impact;  //impact logement

    public Logement(){
        this(0,CE.F);
    }
    public Logement(int superficie, CE ce){
        this.superficie = superficie;
        this.ce = ce;
    }

    static void CalculImpactLog(Logement loge){
        loge.impact = loge.superficie * loge.ce.getace();
    }
    
	public int getsuperficie() {
		return this.superficie;
	}
	
	public CE getce() {
		return this.ce;
	}
	
	public double getImpactL() {
		return this.impact;
	}
	
	public void setsuperficie(int s) {
		this.superficie = s;
	}
	
	public void setce(CE ce) {
		this.ce = ce;
	}

    public static void CarbonMoyLog(Logement l){
	    System.out.println("Votre empreinte carbone moyenne est de " + l.getImpactL() + "T CO2 eq.");
	    System.out.println("En moyenne les francais.e.s consomment 0.335 T CO2 eq à cause de l'épquipement des logements, 0.675 à cause de la construction et le gros entretien et 1.696 à cause de l'énergie et les utilités.");
    }
    public String toString() {
    	return ("superficie : "+superficie+", ClasseEnergetique"+ce+", impact des depenses :"+impact);
    }

    public static void main(String[] args) { 
		Logement log = new Logement(75, CE.F);
		CalculImpactLog(log);
		//CarbonMoyLog();
		System.out.println(log);
    }
}
