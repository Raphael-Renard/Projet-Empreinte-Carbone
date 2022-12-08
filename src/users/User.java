package users;

import java.util.*;

import consoCarbone.*;

public class User { 
	//ajouter id?conso globale?
	private Alimentation alimentation;
	private BienConso bienConso;
	private Logement logement;
	private Transport transport;
	private ServicesPublics services;
	
	// constructeur par défaut
	public User() {
		alimentation = new Alimentation();
		bienConso = new BienConso();
		logement = new Logement();
		transport = new Transport();
		services = new ServicesPublics();
	}

	// constructeur paramétré
	public User(double txBoeuf, double txVege, boolean saison, boolean locaux, double gaspillage, boolean vrac, boolean ecommerce, double montant, int superficie, CE ce, boolean possede, Taille taille, int kilomAnnee, int amortissement, double fabrication) {
		alimentation = new Alimentation(txBoeuf, txVege, saison, locaux, gaspillage, vrac, ecommerce);
		bienConso = new BienConso(montant);
		logement = new Logement(superficie, ce);
		transport = new Transport(possede, taille, kilomAnnee, amortissement, fabrication);
		services = new ServicesPublics();
	}
	
	private double calculerEmpreinte() {
		return (alimentation.getImpact()+bienConso.getImpact()+logement.getImpact()+transport.getImpact()+services.getImpact());
	}
	
	private void detaillerEmpreinte() {
		System.out.println("L'utilisateur consomme "+alimentation.getImpact()+" à cause de l'alimentation.");
		System.out.println("L'utilisateur consomme "+bienConso.getImpact()+" à cause des dépenses.");
		System.out.println("L'utilisateur consomme "+logement.getImpact()+" à cause du logement.");
		System.out.println("L'utilisateur consomme "+transport.getImpact()+" à cause des transports.");
		System.out.println("L'utilisateur consomme "+services.getImpact()+" à cause des services publiques.");
		System.out.println("Au total la consommation de l'utilisateur est de "+this.calculerEmpreinte());

	}

	// méthode qui ordonne les consommations carbone de l’utilisateur.rice dans une liste
	// puis présente l’information obtenue à ce.tte dernier.e
	public void ordonne () {
		ArrayList<ConsoCarbone> liste = new ArrayList<ConsoCarbone>();
		liste.add(alimentation);
		liste.add(bienConso);
		liste.add(logement);
		liste.add(transport);
		liste.add(services);
		Collections.sort(liste);
		for (ConsoCarbone poste_conso : liste) {
			System.out.println(poste_conso.getClass().getSimpleName()+", impact : "+poste_conso.getImpact()+"\n");
		}
		System.out.println(Collections.max(liste));
		//Collections.max.conseil(); ==> creer conseil pour chaque classe
	}

	public static void main(String[] args) {
		User utilisateur = new User(0.4, 0.5, false, false, 259, true, true,1500, 200,CE.A, true, Taille.P, 1500, 10, 0.4);
		utilisateur.ordonne();
	}
}
