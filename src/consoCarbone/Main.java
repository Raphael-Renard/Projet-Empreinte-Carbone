package consoCarbone;

/**
 * Main est la classe qui contient le programme principal
 */
public class Main { //classe contenant une méthode main permetant de faire des tests et de lancer le programme

	public static void main(String[] args) {

		// tests polymorphisme

		System.out.println("\n\nTest d'utilisation du polymorphisme avec toString : \n\n");
		
		// fait appel a la fonction toString de BienConso
    	ConsoCarbone c1 = new BienConso(20);
    	System.out.println("1er cas :\n"+c1+"\n");

    //	BienConso hab = new BienConso();

		// fait appel a la fonction toString de Logement
		Logement log1 = new Logement();
    	System.out.println("3e cas :\n"+log1+"\n");
		
    	//fait appel a la fonction toString de Logement
    	ConsoCarbone log2 = new Logement(100,CE.A);
    	System.out.println("4e cas :\n"+log2+"\n");
    	
    	//fait appel a la fonction toString de Alimentation
    	ConsoCarbone a2 = new Alimentation(0.4,0.6);
    	System.out.println("5e cas :\n"+a2+"\n");
    
		// comparaison de 2 instances de ConsoCarbone
    	System.out.println(a2.compareTo(log2));
    


	}

}
