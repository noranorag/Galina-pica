
public class cilveks {
	String vards;
	String uzvards;
	String talrunis;
	String majasAdrese;
	boolean atrak;
	
	//konstruktors
	public cilveks(String vards, String uzvards, String talrunis, String majasAdrese) {
		this.vards = vards;
		this.uzvards = uzvards;
		this.talrunis = talrunis;
		this.majasAdrese = majasAdrese;
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
		public void setAtrak(boolean atrak) {
			this.atrak = atrak;
		}
		
	//get metodes
		
		public void getVards(String vards) {
			this.vards=vards;
		}
		public void getUzvards(String uzvards) {
			this.uzvards = uzvards;
		}
		public void getTalrunis(String talrunis) {
			this.talrunis = talrunis;
		}
		public void getMajasAdrese(String majasAdrese) {
			this.majasAdrese = majasAdrese;
		}
		public void getAtrak(boolean atrak) {
			this.atrak = atrak;
		}
		
}
