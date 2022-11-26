package consoCarbone;

/**
 * Logement est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant son logement
 */
public class Logement extends ConsoCarbone{
	/** Superficie en m^2 du logement
	 */
    private int superficie;
    /** Classe énergétique du logement
     */
    private CE ce;

	/** Constructeur par défaut
	 */
    public Logement(){
        this(0,CE.F);
		this.CalculImpactLog();
    }

	// constructeur parametre
    public Logement(int superficie, CE ce){
    	if(superficie<0) {
    		System.out.println("Superficie negative. On initialise donc à 0");
    		this.superficie=0;
    	}
    	else {
    		this.superficie = superficie;
    	}
        this.ce = ce;
		this.CalculImpactLog();
    }
    /** Calcule de l'impact du logement en terme de gaz a effets de serre en TCO2eq.
     Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
     */
    public void CalculImpactLog(){
    	double tmp = this.superficie * this.ce.getace();
        super.setimpact(tmp); //impact definie dans la classe mère
    }
    
	/**
	 * @return la superficie du logement
	 */
	public int getsuperficie() {
		return this.superficie;
	}
	/**
	 * @return la classe energétique du logement
	 */
	public CE getce() {
		return this.ce;
	}
	
	/**
	 * @param s est la valeur à affecter à superficie
	 */
	public void setsuperficie(int s) {
		this.superficie = s;
	}
	
	/**
	 * @param ce est la valeur de la classe énergétique à affecter au logement
	 */
	public void setce(CE ce) {
		this.ce = ce;
	}

	/**
	 Affiche la consommation du Logement en paramètre. Puis affiche la distribution de l'impact moyen d'un français à cause du logement.
	 */
	public static void CarbonMoyLog(Logement L){
	    System.out.println("Votre empreinte carbone moyenne est de " + L.getImpact() + "T CO2 eq.");
	    System.out.println("En moyenne les francais.e.s consomment 0.335 T CO2 eq à cause de l'épquipement des logements, 0.675 à cause de la construction et le gros entretien et 1.696 à cause de l'énergie et les utilités.");
    }
	
	 //@Override
	/** Réécriture pour afficher un logement avec ses paramètres
	 */
    public String toString() {
    	return ("id : "+super.getid()+",\nsuperficie : " + superficie + ",\nclasse energetique : " + ce + ",\nimpact des depenses :" + this.getImpact()+" TCO2eq\n");
    }

}
