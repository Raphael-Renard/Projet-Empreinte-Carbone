package consoCarbone;

public class Logement extends ConsoCarbone{
	
    private int superficie;  //m^2
    private CE ce;

    public Logement(){
        this(0,CE.F);
    }
    public Logement(int superficie, CE ce){
        this.superficie = superficie;
        this.ce = ce;
    }

    public void CalculImpactLog(){
    	double tmp = this.superficie * this.ce.getace();
        super.setimpact(tmp); //impact definie dans la classe mère
    }
    
	public int getsuperficie() {
		return this.superficie;
	}
	
	public CE getce() {
		return this.ce;
	}
	
	public void setsuperficie(int s) {
		this.superficie = s;
	}
	
	public void setce(CE ce) {
		this.ce = ce;
	}

	public static void CarbonMoyLog(Logement L){
	    System.out.println("Votre empreinte carbone moyenne est de " + L.getImpact() + "T CO2 eq.");
	    System.out.println("En moyenne les francais.e.s consomment 0.335 T CO2 eq à cause de l'épquipement des logements, 0.675 à cause de la construction et le gros entretien et 1.696 à cause de l'énergie et les utilités.");
    }
    public String toString() {
    	return ("superficie : "+superficie+",\nClasseEnergetique : "+ce+",\nimpact des depenses :"+this.getImpact());
    }

    public static void main(String[] args) { 
		Logement log = new Logement(75, CE.C);
		log.CalculImpactLog();
		//CarbonMoyLog();
		System.out.println(log);
    }
}
