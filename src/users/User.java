package users;

import java.util.*;
import java.io.*;

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
		empreinte = calculerEmpreinte();
	}

	/** 
	 * Constructeur paramétré sans habitudes alimentaires
	*/
	public User(double txBoeuf, double txVege,double montant, int superficie, CE ce, boolean possede, Taille taille, int kilomAnnee, int amortissement, double fabrication) {
		alimentation = new Alimentation(txBoeuf, txVege);
		bienConso = new BienConso(montant);
		listeLogement = new ArrayList<Logement>();
		listeLogement.add( new Logement(superficie, ce));
		listeTransport = new ArrayList<Transport>();
		listeTransport.add(new Transport(possede, taille, kilomAnnee, amortissement, fabrication));
		services = new ServicesPublics();
		empreinte = calculerEmpreinte();
	}
	/** 
	 * Constructeur paramétré avec habitudes alimentaires
	*/
	public User(double txBoeuf, double txVege, boolean saison, boolean locaux, double gaspillage, boolean vrac, boolean ecommerce, double montant, int superficie, CE ce, boolean possede, Taille taille, int kilomAnnee, int amortissement, double fabrication) {
		alimentation = new HabitudesAli(txBoeuf,txVege,saison, locaux, gaspillage, vrac, ecommerce);
		bienConso = new BienConso(montant);
		listeLogement = new ArrayList<Logement>();
		listeLogement.add( new Logement(superficie, ce));
		listeTransport = new ArrayList<Transport>();
		listeTransport.add(new Transport(possede, taille, kilomAnnee, amortissement, fabrication));
		services = new ServicesPublics();
		empreinte = calculerEmpreinte();
	}

	/**
     * Constructeur interactif
     * @param sc1 scanner utilisé pour interagir avec l'utilisateur
     */
	public User(Scanner sc1) {
		System.out.println(" <<Initialisation d'un utilisateur>>");
		System.out.println("<<Initialisation de l'alimentation>>");
		alimentation = new HabitudesAli(sc1);
		System.out.println(" <<Initialisation des dépenses>>");
		bienConso = new BienConso(sc1);
		System.out.println(" <<Initialisation du logement>>");
		listeLogement = new ArrayList<Logement>();
		System.out.print(" Entrez le nombre de logements que vous avez :");
		String str3 = sc1.nextLine(); // condition >0 ou pas
		for (int i=0; i<Integer.valueOf(str3);i++) {
			listeLogement.add( new Logement(sc1));
		}
		System.out.println(" <<Initialisation des Transports>>");
		listeTransport = new ArrayList<Transport>();
		System.out.print(" Entrez le nombre de voitures que vous possédez :");
		str3 = sc1.nextLine(); // condition >0 ou pas
		for (int i=0; i<Integer.valueOf(str3);i++) {
			
			listeTransport.add(new Transport(sc1));
		}
		services = new ServicesPublics();
		empreinte = calculerEmpreinte();
		System.out.println(" <<Fin de l'initialisation>>");
	}

	/**
     * Constructeur par lecture d'un fichier texte
     * @param adresse chemin d'accès du fichier
	 * 
	 * Le fichier doit être présenté comme suit :
	 * taux de repas à base de boeuf (entre 0 et 1)
	 * taux de repas végétarien (entre 0 et 1)
	 * produits de saison ? (Y/n)
	 * produits locaux ? (Y/n)
	 * kg de nourriture gaspillée par an
	 * courses en vrac ? (Y/n)
	 * courses dans des e-commerces ? (Y/n)
	 * dépenses annuelles
	 * nombre d'appartements
	 * superficie
	 * classe énergétique
	 * [répéter autant de fois qu'il y a de logements]
	 * nombre de voitures
	 * taille de la voiture
	 * nb de km parcourus par an
	 * durée de conservation du véhicule
	 * émissions nécessaires à la fabrication de la voiture
	 * [répéter autant de fois qu'il y a de voitures]
     */
	public User(String adresse) {
		try{
			File doc = new File(adresse);
			Scanner sc1 = new Scanner(doc);
			alimentation = new HabitudesAli(sc1,1);
			bienConso = new BienConso(sc1,1);
			listeLogement = new ArrayList<Logement>();
			String str3 = sc1.nextLine(); // condition >0 ou pas
			for (int i=0; i<Integer.valueOf(str3);i++) {
				listeLogement.add( new Logement(sc1,1));
			}
			listeTransport = new ArrayList<Transport>();
			str3 = sc1.nextLine(); // condition >0 ou pas
			for (int i=0; i<Integer.valueOf(str3);i++) {
				listeTransport.add(new Transport(sc1,1));
			}
			services = new ServicesPublics();
			empreinte = calculerEmpreinte();
			sc1.close();
		}
		catch(FileNotFoundException e) {System.out.println("file not found");}
	}

	/**
	 * 
	 * @return empreinte de l'utilisateur
	 */
	public double getempreinte() {
		return this.empreinte;
	}

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
		return (alimentation.getImpact()+bienConso.getImpact()+sommelogement+sommetransport+services.getImpact());
	}
	
	/**
	 * Méthode qui détaille l'empreinte carbone de l'utilisateur.rice pour chaque poste de consommation
	 */
	public void detaillerEmpreinte() {
		System.out.println("L'utilisateur consomme "+alimentation.getImpact()+" à cause de l'alimentation.");
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
		liste.add(bienConso);
		for (Logement loge : listeLogement) { 
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

	public void modifUser(Scanner sc) {
		String str1="a";
		int rep=-6;
		while(rep != 1 && rep !=2 && rep !=3 && rep !=4 && rep!= 0) {
			System.out.println("Vous pouvez quitter quitter en tappant 0 ,");
			System.out.println("Quel type de consommation voulez vous modifier ?");
			System.out.println("Tapez 1 pour modifiez la consommation liée à l'Alimentation,");
			System.out.println("Tapez 2 pour modifiez la consommation liée aux dépenses,");
			System.out.println("Tapez 3 pour modifiez la consommation liée au Logement,");
			System.out.println("Tapez 4 pour modifiez la consommation liée aux Transports : ");
			str1 = sc.nextLine();
			if(!str1.matches("-?\\d+")){
				rep=-6;
				System.out.println("Veuillez répondre uniquement par les options données.");
			}
			else rep=Integer.valueOf(str1);
		}
		switch(rep) {
		case 0:
			System.out.println("Vous avez quitter le calculateur d'empreinte carbonne.");
			break;
		case 1:
			this.alimentation.modif(sc);
			break;
		case 2:
			this.bienConso.modif(sc);
			break;
		case 3:
			str1="a";
			rep=-6;
			while(rep != 1 && rep !=2 && rep !=3) {
				System.out.println("Tapez 1 pour ajouter un logement,");
				System.out.println("Tapez 2 pour supprimer un logement,");
				System.out.println("Tapez 3 pour modifier un logement déjà existant : ");
				str1 = sc.nextLine();
				if(!str1.matches("-?\\d+")){
					rep=-6;
					System.out.println("Veuillez répondre uniquement par les options données.");
				}
				else rep=Integer.valueOf(str1);
			}
			switch(rep) {
			case 1:
				this.listeLogement.add(new Logement(sc));
				break;
			case 2:
				int fin=0;
				for (Logement loge : listeLogement) { 
					str1="a";
					int rep1=-6;
					while(rep1 != 1 && rep1 !=2 && fin !=1) {
						System.out.println(loge);
						System.out.println("Tapez 1 pour supprimer le logement ,sinon tapez 2");
						str1 = sc.nextLine();
						if(!str1.matches("-?\\d+")){
							rep1=-6;
							System.out.println("Veuillez répondre uniquement par les options données.");
						}
						else rep1=Integer.valueOf(str1);
						switch(rep1) {
						case 1:
							fin=1;
							listeLogement.remove(loge);
							break;
						case 2:
							break;
						}
					}
				}
				break;
			case 3:
				fin=0;
				for (Logement loge : listeLogement) { 
					str1="a";
					int rep1=-6;
					while(rep1 != 1 && rep1 !=2 && fin!=1) {
						System.out.println(loge);
						System.out.println("Tapez 1 pour modifiez la consommation liée a ce Logement,sinon tapez 2");
						str1 = sc.nextLine();
						if(!str1.matches("-?\\d+")){
							rep1=-6;
							System.out.println("Veuillez répondre uniquement par les options données.");
						}
						else rep1=Integer.valueOf(str1);
						switch(rep1) {
						case 1:
							fin=1;
							loge.modif(sc);
							break;
						case 2:
							break;
						}
					}
				}
				break;
			}
			
			break;
		case 4:
			str1="a";
			rep=-6;
			while(rep != 1 && rep !=2 && rep !=3) {
				System.out.println("Tapez 1 pour ajouter une voiture,");
				System.out.println("Tapez 2 pour supprimer une voiture,");
				System.out.println("Tapez 3 pour modifier une voiture déjà existante, : ");
				str1 = sc.nextLine();
				if(!str1.matches("-?\\d+")){
					rep=-6;
					System.out.println("Veuillez répondre uniquement par les options données.");
				}
				else rep=Integer.valueOf(str1);
			}
			switch(rep) {
			case 1:
				this.listeTransport.add(new Transport(sc));
				break;
			case 2:
				int fin=0;
				for (Transport transp : listeTransport) { 
					str1="a";
					int rep1=-6;
					while(rep1 != 1 && rep1 !=2 && fin!=1) {
						System.out.println(transp);
						System.out.println("Tapez 1 pour supprimer la voiture ,sinon tapez 2");
						str1 = sc.nextLine();
						if(!str1.matches("-?\\d+")){
							rep1=-6;
							System.out.println("Veuillez répondre uniquement par les options données.");
						}
						else rep1=Integer.valueOf(str1);
						switch(rep1) {
						case 1:
							fin=1;
							listeTransport.remove(transp);
							break;
						case 2:
							break;
						}
					}
				}
			break;
			case 3:
				fin=0;
				for (Transport transp : listeTransport) { 
					str1="a";
					int rep1=-6;
					while(rep1 != 1 && rep1 !=2 && fin!=1) {
						System.out.println(transp);
						System.out.println("Tapez 1 pour modifiez la consommation liée a cette voiture,sinon tapez 2");
						str1 = sc.nextLine();
						if(!str1.matches("-?\\d+")){
							rep1=-6;
							System.out.println("Veuillez répondre uniquement par les options données.");
						}
						else rep1=Integer.valueOf(str1);
						switch(rep1) {
						case 1:
							fin=1;
							transp.modif(sc);
							break;
						case 2:
							break;
						}
					}
				}
			break;
			}		
		}
		this.empreinte = calculerEmpreinte();
	}
} 
