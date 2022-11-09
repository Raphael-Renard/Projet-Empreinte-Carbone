package consoCarbone;

public class Main { //classe contenant une méthode main permetant de faire des tests et de lancer le programme

	public static void main(String[] args) {
		
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
