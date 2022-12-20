package consoCarbone;

import java.util.Scanner;

/**
 * Transport est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant ses déplacements
 */
public class Transport extends ConsoCarbone{ //javadoc
	
	/** boolean indiquant si l’utilisateur.rice possède une voiture
	 */
	private boolean possede;
	/** taille du véhicule
	 */
	private Taille taille;
	/** nombre de kilomètres parcourus par an
	 */
	private int kilomAnnee;
	/** durée de conservation du véhicule
	 */
	private int amortissement;
	

	/** 
	 * Constructeur par défaut 
	*/
	public Transport(){
        this(false, Taille.P, 0, 0, 0);
		this.CalculImpactTransp(0);
	}
	
	public Transport(Scanner sc){
		System.out.print(" Saisir la taille de la voiture grande ou petite(G/P) :");
		String str1 = sc.nextLine();
		System.out.print(" Entrez le nombre de kilomètre parcourut chaque année :");
		String str2 = sc.nextLine();
		System.out.print(" Saisir la durée de conservation du véhicule :");
		String str4 = sc.nextLine();
		System.out.print(" Saisir les émissions nécessaires à la fabrication de la voiture :");
		String str5 = sc.nextLine();
		if(Integer.valueOf(str2)<0 | Integer.valueOf(str4)<0 | Double.valueOf(str5)<0) {
    		System.out.println("Erreur kilomAnnee, amortissement ou fabrication negative. On initialise tout à 0");
    		this.possede = false;
			this.taille = Taille.P;
    		this.kilomAnnee = 0;
    		this.amortissement = 0;
    		this.CalculImpactTransp(0);
    	}
    	else {
	        this.possede = true;
			this.taille = Taille.valueOf(str1);
			this.kilomAnnee = Integer.valueOf(str2);
			this.amortissement = Integer.valueOf(str4);
			this.CalculImpactTransp(Double.valueOf(str5));
    	}
    }

    /** 
	 * Constructeur paramétré
    */ 
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement, double fabrication){
    	if(kilomAnnee<0 | amortissement<0 | fabrication<0) {
    		System.out.println("Erreur kilomAnnee, amortissement ou fabrication negative. On initialise tout à 0");
    		this.possede = false;
			this.taille = Taille.P;
    		this.kilomAnnee = 0;
    		this.amortissement = 0;
    		this.CalculImpactTransp(0);
    	}
    	else {
	        this.possede = possede;
			this.taille = taille;
			this.kilomAnnee = kilomAnnee;
			this.amortissement = amortissement;
			this.CalculImpactTransp(fabrication);
    	}
    }

	/**
	 * getter
	 * @return durée de conservation du véhicule
	 */
	public int getamortissement() {
		return this.amortissement;
	}
    
	/**
	 * getter
	 * @return nombre de km parcourus par an
	 */
	public int getkilom() {
		return this.kilomAnnee;
	}

	/**
	 * getter
	 * @return boolean indiquant si l’utilisateur.rice possède une voiture
	 */
	public boolean getpossede() {
		return this.possede;
	}

	/**
	 * getter
	 * @return taille du véhicule
	 */
	public Taille gettaille() {
		return this.taille;
	}


	/**
	 * setter
	 * @param a est la durée de conservation du véhicule en années
	 */
    public void setamortissement(int a) {
		this.amortissement = a;
    }
	
	/**
	 * setter
	 * @param k est le nombre de kilomètres parcourus par an
	 */
    public void setkilom(int k) {
		this.kilomAnnee = k;
    }
    
	/**
	 * setter
	 * @param p est le boolean représentant si l'utilisateur.ice possède ou non une voiture
	 */
    public void setpossede(boolean p) {
		this.possede = p;
    }
    
	/**
	 * setter
	 * @param t est la taille de la voiture
	 */
    public void settaille(Taille t) {
		this.taille = t;
	}
    
    /** Calcule de l'impact des transports en terme de gaz a effets de serre en TCO2eq.
	 * Utilise la classe mère ConsoCarbone pour mettre à jour la consommation carbone.
    */
	public void CalculImpactTransp(double fabrication){
        if (this.possede) {
        	super.setimpact ( this.kilomAnnee * 1.93 * 0.0001 + fabrication / this.amortissement);
        }
        
        else {
        	super.setimpact( 0);
        }
    }

	/**
	 Affiche la consommation du Transport en paramètre. Puis affiche la distribution de l'impact moyen d'un français à cause des transports.
	 */
    public static void CarbonMoyTransp(Transport T, double fabrication){
    	System.out.println("Votre empreinte carbone moyenne en transports est de ");
    	if (T.possede) {
    		System.out.println(1.93*T.kilomAnnee*0.0001 + "T C02 eq à cause du kilometrage et ");
    		System.out.println(fabrication / T.amortissement +"T C02 eq à cause de la fabrication de la voiture.");
    	}
    	
    	else {
    		System.out.println("0 T C02 eq.");
    	}
	
    	System.out.println("En moyenne les francais.e.s consomment 1.972 T CO2 eq à cause de leur(s) voiture(s), 0.480 à cause des voyages en avion, 0.383 pour cause de fret et messagerie et 0.085 à cause des voyages en train et bus.");

	}  

    /** Réécriture pour afficher une consommation des transports avec ses paramètres
	 */
    @Override
	public String toString() {
	    return ("id : "+super.getid()+",\npossede : " + this.possede + ",\ntaille : " + this.taille + ",\nkilomAnnee : " + this.kilomAnnee + ",\nimpact : " + this.getImpact()+" TCO2eq\n");
	}
	

	/** 
	 * Méthode qui donne des conseils pour réduire son empreinte carbone
	 */
	@Override
	public void conseil(){
		if (this.taille == Taille.G){
			System.out.println("Si cela ne vous est pas utile, songez à changer de voiture pour en acheter une plus petite.");
		}
		if (this.kilomAnnee > 2000) {
			System.out.println("Si possible, favorisez les transports en commun et le covoiturage; le train pour les longs trajets; la marche, le vélo, la trotinette ou encore les rollers pour les courts trajets.");
		}
		if (this.amortissement < 5) {
			System.out.println("Gardez votre voiture le plus longtemps possible. N'en changez que si c'est nécéssaire ou si vous souhaitez faire l'aquisition d'un véhicule plus écologique.");
		}
	}
}
