
public class pica {
	String veids;
	boolean peperoni;
	boolean siers;
	boolean tomati;
	boolean gurki;
	String izmers; 
	
	//konstruktors
	public pica(String veids, boolean peperoni, boolean siers, boolean tomati, boolean gurki, String izmers) {
		this.veids = veids;
		this.peperoni = peperoni;
		this.siers = siers;
		this.tomati = tomati;
		this.gurki = gurki;
		this.izmers = izmers;
	}
	
	//set metodes
		public void setVeids(String veids) {
			this.veids=veids;
		}
		public void setPeperoni(boolean peperoni) {
			this.peperoni = peperoni;
		}
		public void setSiers(boolean siers) {
			this.siers = siers;
		}
		public void setTomati(boolean tomati) {
			this.tomati = tomati;
		}
		public void setGurki(boolean gurki) {
			this.gurki = gurki;
		}
		public void setIzmers(String izmers) {
			this.izmers = izmers;
		}
		
		//get metodes
		public String getVeids() {
			return veids;
		}
		public boolean getPeperoni() {
			return peperoni;
		}
		public boolean getSiers() {
			return siers;
		}
		public boolean getTomati() {
			return tomati;
		}
		public boolean getGurki() {
			return gurki;
		}
		public String getIzmers() {
			return izmers;
		}
		
		public String izvadit() {
			return "Veids: "+getVeids()+"\nExtra Peperoni: "+getPeperoni()+"\nExtra Siers: "+getSiers()+"\nExtra tomati: "+getTomati()+"\nExtra Gurki: "+getGurki()+"\nIzmērs"+getIzmers();
			
		}
		
		
}
