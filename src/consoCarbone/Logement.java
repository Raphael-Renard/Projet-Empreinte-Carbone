package consoCarbone;

import java.util.Scanner;

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



	/** 
	 * Constructeur par défaut
	 */
    public Logement(){
        this(0,CE.F);
        this.CalculImpactLog();
    }
    /**
     * Constructeur interactif
     * @param sc scanner utilisé pour interagir avec l'utilisateur
     */
    public Logement(Scanner sc){
    	System.out.print(" Entrez la superficie en m^2 :");
		String str1 = sc.nextLine();
		System.out.print(" Entrez la classe énergétique du logement (A/B/C/D/E/F) :");
		String str2 = sc.nextLine();
    	if(Integer.valueOf(str1)<0) {
    		System.out.println("Superficie negative. On initialise donc à 0");
    		this.superficie=0;
    	}
    	else {
    		this.superficie = Integer.valueOf(str1);
    	}
    	this.ce = CE.valueOf(str2);
		this.CalculImpactLog();
    }

	/** 
	 * Constructeur paramétré
	 */ 
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
	 * Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
     */
    public void CalculImpactLog(){
    	double tmp = this.superficie * this.ce.getace();
        super.setimpact(tmp); //impact definie dans la classe mère
    }
    
	/**
	 * getter
	 * @return la superficie du logement
	 */
	public int getsuperficie() {
		return this.superficie;
	}

	/**
	 * getter
	 * @return la classe energétique du logement
	 */
	public CE getce() {
		return this.ce;
	}
	
	/**
	 * setter
	 * @param s est la valeur à affecter à superficie
	 */
	public void setsuperficie(int s) {
		this.superficie = s;
		this.CalculImpactLog();
	}
	
	/**
	 * setter
	 * @param ce est la valeur de la classe énergétique à affecter au logement
	 */
	public void setce(CE ce) {
		this.ce = ce;
		this.CalculImpactLog();
	}

	/**
	 Affiche la consommation du Logement en paramètre. Puis affiche la distribution de l'impact moyen d'un français à cause du logement.
	 */
	public static void CarbonMoyLog(Logement L){
	    System.out.println("Votre empreinte carbone moyenne est de " + L.getImpact() + "T CO2 eq.");
	    System.out.println("En moyenne les francais.e.s consomment 0.335 T CO2 eq à cause de l'épquipement des logements, 0.675 à cause de la construction et le gros entretien et 1.696 à cause de l'énergie et les utilités.");
    }
	
	@Override
	/** Réécriture pour afficher un logement avec ses paramètres
	 */
    public String toString() {
    	return ("id : "+super.getid()+",\nsuperficie : " + superficie + ",\nclasse energetique : " + ce + ",\nimpact des depenses :" + this.getImpact()+" TCO2eq\n");
    }


	/** 
	 * Méthode qui donne des conseils pour réduire son empreinte carbone
	 */
	@Override
	public void conseil(){
		if (this.ce == CE.E | this.ce == CE.F | this.ce == CE.G){
			System.out.println("Songez à renover votre logement pour qu'il ait une meilleure classe énergétique.");
		}
		if (this.superficie > 100) {
			System.out.println("Si vous n'avez pas besoin d'un logement aussi grand, songez à déménager pour réduire les dépenses énergétiques.");
		}
	}
}
