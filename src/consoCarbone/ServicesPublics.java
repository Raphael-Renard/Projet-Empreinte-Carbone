package consoCarbone;

/**
 * ServicesPublics est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant son utilisation des services publics
 */
public class ServicesPublics extends ConsoCarbone{
	/** empreinte carbone induite par les services publics 
	*/
	static final double empreinte=1.5;

	/** 
	 * Constructeur par défaut 
	 * (design pattern : singleton)
	*/ 
	public ServicesPublics() {
		super.setimpact(empreinte);
	}
	/** 
	 * Méthode qui donne des conseils pour réduire son empreinte carbone
	 */
	public void conseil() {
		System.out.println("Cette empreinte ne change pas car elle est partagée par toute la société.");
	}
}
