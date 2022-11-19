package consoCarbone;

public class ServicesPublics extends ConsoCarbone{
	static final double empreinte=1.5;
	//singleton
	public ServicesPublics() {
		super.setimpact(empreinte);
	}
}
