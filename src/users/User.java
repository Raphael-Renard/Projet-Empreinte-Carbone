package users;

import java.util.*;

import consoCarbone.*;

/**
 * User est la classe qui associe un.e utilisateur.rice à sa consommation carbone
 */
public class User {
	//private int id;
	/** poste de consommation carbone alimentaire
	 */
	private Alimentation alimentation;
	
	/** poste de consommation carbone lié aux dépenses en biens de consommation
	*/
	private BienConso bienConso;
	
	/** poste de consommation carbone lié au logement
	*/
	private ArrayList<Logement> listeLogement;
	
	/** poste de consommation carbone lié au transport
	*/
	private ArrayList<Transport> listeTransport;
	
	/** poste de consommation carbone lié aux services publics
	*/
	private ServicesPublics services;
	
	/** permet de moduler l'impact carbone d'alimentation en fonction des habitudes alimentaires
	*/
	private HabitudesAli habitudes;
	
	/** empreinte carbonne totale de l'utilisateur.rice
	*/
	private double empreinte;
	
	/** 
	 * Constructeur par défaut 
	*/ 
	public User() {
		alimentation = new Alimentation();
		bienConso = new BienConso();
		listeLogement = new ArrayList<Logement>();
		listeLogement.add(new Logement());
		listeTransport = new ArrayList<Transport>();
		listeTransport.add(new Transport());
		services = new ServicesPublics();
		habitudes = new HabitudesAli();
		empreinte = calculerEmpreinte();
	}

	/** 
	 * Constructeur paramétré 
	*/
	public User(double txBoeuf, double txVege, boolean saison, boolean locaux, double gaspillage, boolean vrac, boolean ecommerce, double montant, int superficie, CE ce, boolean possede, Taille taille, int kilomAnnee, int amortissement, double fabrication) {
		alimentation = new Alimentation(txBoeuf, txVege);
		habitudes = new HabitudesAli(saison, locaux, gaspillage, vrac, ecommerce);
		bienConso = new BienConso(montant);
		listeLogement = new ArrayList<Logement>();
		listeLogement.add( new Logement(superficie, ce));
		listeTransport = new ArrayList<Transport>();
		listeTransport.add(new Transport(possede, taille, kilomAnnee, amortissement, fabrication));
		services = new ServicesPublics();
		empreinte = calculerEmpreinte();
	} //Pb : initialiser les listes
	
	/**
	 * Méthode qui calcule l'empreinte carbone de l'utilisateur.rice
	 * @return empreinte carbone
	 */
	private double calculerEmpreinte() {
		int sommelogement=0;
		for (Logement loge : listeLogement) {
			sommelogement += loge.getImpact();
		}
		int sommetransport=0;
		for (Transport transp : listeTransport) {
			sommetransport += transp.getImpact();
		}
		return (alimentation.getImpact()+habitudes.getImpact()+bienConso.getImpact()+sommelogement+sommetransport+services.getImpact());
	}
	
	/**
	 * Méthode qui détaille l'empreinte carbone de l'utilisateur.rice pour chaque poste de consommation
	 */
	private void detaillerEmpreinte() {
		System.out.println("L'utilisateur consomme "+alimentation.getImpact()+" à cause de l'alimentation.");
		System.out.println("L'utilisateur consomme "+habitudes.getImpact()+" à cause de vos habitudes alimentaires.");
		System.out.println("L'utilisateur consomme "+bienConso.getImpact()+" à cause des dépenses.");
		for (Logement loge : listeLogement) {
			System.out.println("L'utilisateur consomme "+loge.getImpact()+" à cause du logement "+loge.getid()+".");
		}
		for (Transport transp : listeTransport) {
			System.out.println("L'utilisateur consomme "+transp.getImpact()+" à cause des transports.");
		}
		System.out.println("L'utilisateur consomme "+services.getImpact()+" à cause des services publiques.");
		System.out.println("Au total la consommation de l'utilisateur est de "+this.calculerEmpreinte());

	}

	/**
	 *  Méthode qui ordonne les consommations carbone de l’utilisateur.rice dans une liste
	 * puis présente l’information obtenue à ce.tte dernier.e
	*/ 
	public void ordonne () {
		ArrayList<ConsoCarbone> liste = new ArrayList<ConsoCarbone>();
		liste.add(alimentation);
		liste.add(habitudes);
		liste.add(bienConso);
		for (Logement loge : listeLogement) {   //consoderer la somme des logements ???
			liste.add(loge);
		}
		for (Transport transp : listeTransport) {
			liste.add(transp);
		}
		liste.add(services);
		Collections.sort(liste);
		for (ConsoCarbone poste_conso : liste) {
			System.out.println(poste_conso.getClass().getSimpleName()+", impact : "+poste_conso.getImpact()+" TCO2eq\n");
		}
		System.out.println("Impact max :\n"+Collections.max(liste));
		Collections.max(liste).conseil();
	}

	public static void main(String[] args) {
		User utilisateur = new User(0.4, 0.5, false, false, 259, true, true,1500, 200,CE.A, true, Taille.P, 1500, 10, 0.4);
		utilisateur.ordonne();
	}
} 
