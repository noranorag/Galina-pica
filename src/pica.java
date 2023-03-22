
public class pica {
	String veids;
	boolean peperoni;
	boolean siers;
	boolean tomati;
	boolean gurki;
	int izmers; 
	
	//konstruktors
	public pica(String veids, boolean peperoni, boolean siers, boolean tomati, boolean gurki, int izmers) {
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
		public void setIzmers(int izmers) {
			this.izmers = izmers;
		}
		
		//get metodes
		public void getVeids(String veids) {
			this.veids=veids;
		}
		public void getPeperoni(boolean peperoni) {
			this.peperoni = peperoni;
		}
		public void getSiers(boolean siers) {
			this.siers = siers;
		}
		public void getTomati(boolean tomati) {
			this.tomati = tomati;
		}
		public void getGurki(boolean gurki) {
			this.gurki = gurki;
		}
		public void getIzmers(int izmers) {
			this.izmers = izmers;
		}
		
		
}
