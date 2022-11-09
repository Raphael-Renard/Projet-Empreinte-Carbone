package consoCarbone;

public class Logement extends ConsoCarbone{
	
    private int superficie;  //superficie en m^2
    private CE ce;

	// constructeur par defaut
    public Logement(){
        this(0,CE.F);
		this.CalculImpactLog();
    }

	// constructeur parametre
    public Logement(int superficie, CE ce){
        this.superficie = superficie;
        this.ce = ce;
		this.CalculImpactLog();
    }

    public void CalculImpactLog(){
    	double tmp = this.superficie * this.ce.getace();
        super.setimpact(tmp); //impact definie dans la classe mère
    }
    
	// getter
	public int getsuperficie() {
		return this.superficie;
	}
	
	public CE getce() {
		return this.ce;
	}
	
	// setter
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
	
	 //@Override
    public String toString() {
    	return ("id : "+super.getid()+",\nsuperficie : " + superficie + ",\nclasse energetique : " + ce + ",\nimpact des depenses :" + this.getImpact()+"\n");
    }

}
