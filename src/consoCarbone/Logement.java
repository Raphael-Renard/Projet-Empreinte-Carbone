package consoCarbone;

public class Logement{
    private int superficie;  //m^2
    private CE ce;
    private double impact;  //impact logement

    public Logement(){
        this(0,CE.F);
    }
    public Logement(int superficie, CE ce){
        this.superficie = superficie;
        this.ce = ce;
    }

    static void CalculImpactLog(Logement loge){
        loge.impact = loge.superficie * loge.ce.getace();
    }
    
	public int getsuperficie() {
		return this.superficie;
	}
	
	public CE getce() {
		return this.ce;
	}
	
	public double getImpact() {
		return this.impact;
	}
	
	public void setsuperficie(int s) {
		this.superficie = s;
	}
	
	public void setce(CE ce) {
		this.ce = ce;
	}

    public static void CarbonMoyLog(){
        System.out.println("carbon logement en moy");
    }
    
    public static void main(String[] args) { 
		Logement log = new Logement(75, CE.F);
		CalculImpactLog(log);
		CarbonMoyLog();
		System.out.println("log superficie : "+log.superficie);
		System.out.println("log CE : "+log.ce);
		System.out.println("log impact : "+log.impact);
    }
}
