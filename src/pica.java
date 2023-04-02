
public class pica {
	String veids;
	boolean peperoni;
	boolean siers;
	boolean tomati;
	boolean gurki;
	String izmers;
	boolean lidznemsana;
	
	//konstruktors
	public pica(String veids, boolean peperoni, boolean siers, boolean tomati, boolean gurki, String izmers, boolean lidznemsana) {
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
		
		public void setLidznemsana(boolean lidznemsana) {
			this.lidznemsana = lidznemsana;
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
		
		public boolean getLidznemsana() {
			return lidznemsana;
		}
		
		public String izvadit() {
			return "Veids: "+getVeids()+"\nExtra Peperoni: "+getPeperoni()+"\nExtra Siers: "+getSiers()+"\nExtra tomati: "+getTomati()+"\nExtra Gurki: "+getGurki()+"\nIzmērs"+getIzmers()+"\nSutisana uz majam: "+getLidznemsana();
		}

			 @Override
			 public boolean equals(Object obj) {
			     if (this == obj)
			         return true;
			     if (obj == null || !(obj instanceof pica))
			         return false;

			     pica other = (pica) obj;
			     
			     if (siers != other.siers)
			         return false;
			     else if (siers == other.siers)
			         return true;
			     if (veids != other.veids)
			         return false;
			     else if (veids == other.veids)
			         return true;
			     if (peperoni != other.peperoni)
			         return false;
			     else if (peperoni == other.peperoni)
			         return true;
			     if (tomati != other.tomati)
			         return false;
			     else if (tomati == other.tomati)
			         return true;
			     if (gurki != other.gurki)
			         return false;
			     else if (gurki == other.gurki)
			         return true;
			     if (izmers != other.izmers)
			         return false;
			     else if (izmers == other.izmers)
			         return true;
			     if (lidznemsana != other.lidznemsana)
			         return false;
			     else if (lidznemsana != other.lidznemsana)
			         return true;
			     
			     return true;
			 }

			
}
		



