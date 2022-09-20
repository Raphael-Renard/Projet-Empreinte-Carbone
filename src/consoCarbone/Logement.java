package consoCarbone;

public class Logement {
	
	int superficie;
	CE ce;
	double impact;
	
	public Logement(){
		}
	
	public Logement(int superficie, CE ce){
		this.superficie = superficie;
		this.ce = ce;
		}
	
	
	static void calcul_carbone (Logement personne) {
		double coeff;
		if (personne.ce == CE.A) {
			coeff = 0.005;
			} 
		else if (personne.ce == CE.B) {
				coeff =  0.01;
			} 
		else if (personne.ce == CE.C) {
				coeff =   0.02;
			} 
		else if (personne.ce == CE.D) {
				coeff =  0.035;
			} 
		else if (personne.ce == CE.E) {
				coeff =   0.055;
			} 
		else if (personne.ce == CE.F) {
				coeff =  0.08;
			} 
		else {
				coeff = 0.1;
			}
		
		personne.impact = coeff * personne.superficie;
		
		System.out.println("Votre empreinte carbone est de "+ personne.impact+ " tonnes de CO2 eq");
		
	}
	
	public static void main(String[] args) {
		 
		Logement personne = new Logement(75, CE.E);
        calcul_carbone(personne);
    }

}
