
public class cilveks {
	String vards;
	String uzvards;
	String talrunis;
	String majasAdrese;
	String veids;
	
	//konstruktors
	public cilveks(String vards, String uzvards, String talrunis, String majasAdrese, String veids) {
		this.vards = vards;
		this.uzvards = uzvards;
		this.talrunis = talrunis;
		this.majasAdrese = majasAdrese;
		this.veids = veids;
	}
	
	//set metodes
		public void setVards(String vards) {
			this.vards=vards;
		}
		public void setUzvards(String uzvards) {
			this.uzvards = uzvards;
		}
		public void setTalrunis(String talrunis) {
			this.talrunis = talrunis;
		}
		public void setMajasAdrese(String majasAdrese) {
			this.majasAdrese = majasAdrese;
		}
		public void setVeids(String veids) {
			this.veids = veids;
		}
		
	//get metodes
		
		public String getVards() {
			return vards;
		}
		public String getUzvards() {
			return uzvards;
		}
		public String getTalrunis() {
			return talrunis;
		}
		public String getMajasAdrese() {
			return majasAdrese;
		}
		public String getVeids() {
			return veids;
		}
		
		public String izvaditC() {
			return "Vards: "+getVards()+"\nUzvards: "+getUzvards()+"\nTalrunis: "+getTalrunis()+"\nMajasAdrese: "+getMajasAdrese()+"\nVeids: "+getVeids()
;
}
