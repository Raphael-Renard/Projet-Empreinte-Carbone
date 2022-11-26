package consoCarbone;

/**
 * ServicesPublics est la classe qui définit un poste de consommation carbone de l’utilisateur.rice
concernant son utilisation des services publics
 */
public class ServicesPublics extends ConsoCarbone{
	static final double empreinte=1.5;
	//singleton
	public ServicesPublics() {
		super.setimpact(empreinte);
	}
}
