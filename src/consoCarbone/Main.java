package consoCarbone;

public class Main {

	public static void main(String[] args) {
		// tests de polymorphisme
		
		// fait appel a la fonction toString de BienConso
    	ConsoCarbone c = new BienConso(20);
    	System.out.println("1er cas :\n"+c+"\n");

		// fait appel a la fonction toString de ConsoCarbone
		ConsoCarbone d = new ConsoCarbone();
    	System.out.println("2e cas :\n"+d+"\n");

		// fait appel a la fonction toString de Logement
		Logement log1 = new Logement();
    	System.out.println("3e cas :\n"+log1+"\n");
		
    	//fait appel a la fonction toString de Logement 
    	ConsoCarbone log2 = new Logement(100,CE.A);
    	System.out.println("4e cas :\n"+log2+"\n");
	}

}
