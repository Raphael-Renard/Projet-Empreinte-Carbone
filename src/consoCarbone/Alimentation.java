package consoCarbone;

public class Alimentation {
	double txBoeuf;
	double txVege;
	double impact;
	
	public Alimentation() {
	}
	
	public Alimentation(double txBoeuf, double txVege) {
		this.txBoeuf = txBoeuf;
		this.txVege = txVege;
	}
	
	static void calcul_carbone (Alimentation personne) {
		personne.impact = 8*personne.txBoeuf + 1.6 *(1 - personne.txVege - personne.txBoeuf) + 0.9 * personne.txVege;
		
		System.out.println("Votre empreinte carbone est de "+ personne.impact+ " tonnes de CO2 eq");
	}
	
	
	public static void main(String[] args) {
 
		Alimentation personne = new Alimentation(0.2, 0.6);
        calcul_carbone(personne);
    }

}
