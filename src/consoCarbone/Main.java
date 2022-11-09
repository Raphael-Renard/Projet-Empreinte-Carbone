package consoCarbone;

public class Main {

	public static void main(String[] args) {
		Logement log = new Logement(75, CE.C);
		// log.CalculImpactLog();
		//Logement.CarbonMoyLog(log);
		System.out.println(log);
	
		Alimentation a = new Alimentation(0.3,0.6);
		//Alimentation.CarbonMoyAli(a);
		// a.CalculImpactAli();
		System.out.println(a);
		
		BienConso c = new BienConso(1200);
		//BienConso.CarbonMoyBien(c);
    	// c.CalculImpactDep();
    	System.out.println(c);
		
		Transport transp = new Transport(true, Taille.G, 100000,340, 30000);
		// transp.CalculImpactTransp(250);
		 //Transport.CarbonMoyTransp(transp, 250);
		System.out.println(transp);
		
		System.out.println("\n\nTest d'utilisation du polymorphisme avec toString : \n\n");
		
		// fait appel a la fonction toString de BienConso
    	ConsoCarbone c1 = new BienConso(20);
    	System.out.println(c1);

		// fait appel a la fonction toString de ConsoCarbone
		ConsoCarbone d = new ConsoCarbone();
    	System.out.println(d);

		// fait appel a la fonction toString de Logement
		Logement log1 = new Logement();
    	System.out.println(log1);
		
    	//fait appel a la fonction toString de Logement
    	ConsoCarbone log2 = new Logement(100,CE.A);
    	System.out.println(log2);
    	
    	//fait appel a la fonction toString de Alimentation
    	ConsoCarbone a2 = new Alimentation(0.4,0.6);
    	System.out.println(a2);
    	
	}

}
