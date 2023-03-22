
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
		public void setStudProg(boolean gurki) {
			this.gurki = gurki;
		}
		public void izmers(int izmers) {
			this.izmers = izmers;
		}
		
}
