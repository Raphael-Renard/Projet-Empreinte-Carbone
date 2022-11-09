package consoCarbone;

public class Main {

	public static void main(String[] args) {
		Logement log = new Logement(75, CE.C);
		// log.CalculImpactLog();
		System.out.println(log);
		
		Alimentation a = new Alimentation(0.3,0.6);
		//CarbonMoyAli();
		// a.CalculImpactAli();
		System.out.println(a);
		
		Transport transp = new Transport(true, Taille.G, 100000,340, 30000);
		// transp.CalculImpactTransp(250);
		// CarbonMoyTransp(transp, 250);
		System.out.println(transp);
		
		
		// fait appel a la fonction toString de BienConso
    	ConsoCarbone c = new BienConso(20);
    	System.out.println(c);

		// fait appel a la fonction toString de ConsoCarbone
		ConsoCarbone d = new ConsoCarbone();
    	System.out.println(d);

		// fait appel a la fonction toString de Logement
		Logement log1 = new Logement();
    	System.out.println(log1);
		
    	//fait appel a la fonction toString 
    	ConsoCarbone log2 = new Logement(100,CE.A);
    	System.out.println(log2);
	}

}
