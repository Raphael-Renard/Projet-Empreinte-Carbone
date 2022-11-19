package users;

import consoCarbone.*;

public class User {
	Alimentation alimentation;
	BienConso bienConso;
	Logement logement;
	Transport transport;
	ServicesPublics services;
	
	public User() {
		//utiliser constructeurs des conso
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
}
