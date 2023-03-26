import java.util.Random;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class picerija {
	
	public static void main(String[] args) {
		String vards = null, uzvards = null, majasAdrese = null, izvele, izvele2, izvele3, izvele4, veids = null, izmers = null;
		String[] darbibas = {"Jauns klients", "Apskatīt klientus", "Apskatit klientu pasutijumus", "Apkalpot pirmo klientu", "Uztaisīt picu", "Edienkarte", "", "Aizvert programmu"};
		String[] picuVeidi = {"Olīvu pica", "Siera pica", "Studentu pica", "Peperoni pica", "Pica itāļu gaumē"};
		String[] lidznemsanas = {"Uz vietas", "Piegade uz majam"};
		String[] izmeriP = {"30 cm diametra", "50 cm diametra", "80 cm diametra"};
		String talrunis = null;
		int kadsKlients;
		cilveks klients = null;
		pica jaunaPica = null;
		boolean peperoni = false, siers = false, tomati = false, gurki = false, lidznemsana = false;
		
		
		ArrayList<cilveks> cilvekuMasivs = new ArrayList<cilveks>();
		ArrayList<pica> picuMasivs = new ArrayList<pica>();
		
		Random rand = new Random();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvelies darbibu", "Izvele", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			switch(izvele) {
			case "Jauns klients":
				if(cilvekuMasivs.size() <= 5) {
				klients = new cilveks(vards, uzvards, talrunis, majasAdrese, veids);
				jaunaPica = new pica(veids, peperoni, siers, tomati, gurki, izmers, lidznemsana);
				
				kadsKlients = rand.nextInt(2)+1;
				if(kadsKlients==1) {
					JOptionPane.showMessageDialog(null, "Klients veic pasūtijumu pa telefonu!");
					
					izvele2 = (String) JOptionPane.showInputDialog(null, "Izvelies kādu picu vēlas klients", "Izvele", JOptionPane.QUESTION_MESSAGE,
							null, picuVeidi, picuVeidi[0]);
					
					switch(izvele2) {
					case "Olīvu pica":
						jaunaPica.setVeids("Olīvu pica");
					break;
					case "Siera pica":
						jaunaPica.setVeids("Sieru pica");
					break;
					case "Studentu pica":
						jaunaPica.setVeids("Studentu pica");
					break;
					case "Peperoni pica":
						jaunaPica.setVeids("Peperoni pica");
					break;
					case "Pica itāļu gaumē":
						jaunaPica.setVeids("Pica itāļu gaumē");
					break;
					}
					
					jaunaPica.setPeperoni(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra peperoni? (true/false)")));
					jaunaPica.setSiers(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra siers? (true/false)")));
					jaunaPica.setTomati(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra tomati? (true/false)")));
					jaunaPica.setGurki(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra gurki? (true/false)")));
					izmers = (String) JOptionPane.showInputDialog(null, "Izvelies picas izmeru", "Izvele", JOptionPane.QUESTION_MESSAGE,
							null, izmeriP, izmeriP[0]);
					
					switch(izmers) {
					case "30 cm diametra":
						jaunaPica.setIzmers("30 cm diametra");
					break;
					case "50 cm diametra":
						jaunaPica.setIzmers("50 cm diametra");
					break;
					case "80 cm diametra":
						jaunaPica.setIzmers("80 cm diametra");
					break;
					
					}
					izvele3 = (String) JOptionPane.showInputDialog(null, "Izvelies darbibu", "Izvele", JOptionPane.QUESTION_MESSAGE,
							null, lidznemsanas, lidznemsanas[0]);
					
					switch(izvele3) {
					case "Uz vietas":
						klients.setVards(JOptionPane.showInputDialog("Ievadi klienta vardu"));
						klients.setUzvards(JOptionPane.showInputDialog("Ievadi klienta uzvardu"));
						JOptionPane.showMessageDialog(null, "Klients saglabāts!");
						cilvekuMasivs.add(klients);
						JOptionPane.showMessageDialog(null, "Pica drīz būs gatava!");
						jaunaPica.setLidznemsana(false);
					break;
					case "Piegade uz majam":
						JOptionPane.showMessageDialog(null, "Nepieciešams ierakstīt klienta info!");
						
						
						klients.setVards(JOptionPane.showInputDialog("Ievadi klienta vardu"));
						klients.setUzvards(JOptionPane.showInputDialog("Ievadi klienta uzvardu"));
						
						String tel="";
						do{
							tel = JOptionPane.showInputDialog("Ievadi telefona numuru formata 200000000");
						}while(!Pattern.matches("^[2]{1}[0-9]{7}$", tel));
						klients.setTalrunis("+371"+tel);
						klients.setMajasAdrese(JOptionPane.showInputDialog("Ievadi klienta majas adresi"));
						JOptionPane.showMessageDialog(null, "Klienta info pierakstīts! Pica drīz būs gatava!");
						cilvekuMasivs.add(klients);
						jaunaPica.setLidznemsana(true);
					break;
					}
					
			
					
				} else {
					JOptionPane.showMessageDialog(null, "Klients veic pasūtijumu klātienē!"); //klatiene
				
				izvele2 = (String) JOptionPane.showInputDialog(null, "Izvelies kādu picu vēlas klients", "Izvele", JOptionPane.QUESTION_MESSAGE,
						null, picuVeidi, picuVeidi[0]);
				
				switch(izvele2) {
				case "Olīvu pica":
					jaunaPica.setVeids("Olīvu pica");
				break;
				case "Siera pica":
					jaunaPica.setVeids("Sieru pica");
				break;
				case "Studentu pica":
					jaunaPica.setVeids("Studentu pica");
				break;
				case "Peperoni pica":
					jaunaPica.setVeids("Peperoni pica");
				break;
				case "Pica itāļu gaumē":
					jaunaPica.setVeids("Pica itāļu gaumē");
				break;
				}
				
				jaunaPica.setPeperoni(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra peperoni? (true/false)")));
				jaunaPica.setSiers(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra siers? (true/false)")));
				jaunaPica.setTomati(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra tomati? (true/false)")));
				jaunaPica.setGurki(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra gurki? (true/false)")));
				izmers = (String) JOptionPane.showInputDialog(null, "Izvelies picas izmeru", "Izvele", JOptionPane.QUESTION_MESSAGE,
						null, izmeriP, izmeriP[0]);
				
				switch(izmers) {
				case "30 cm diametra":
					jaunaPica.setIzmers("30 cm diametra");
				break;
				case "50 cm diametra":
					jaunaPica.setIzmers("50 cm diametra");
				break;
				case "80 cm diametra":
					jaunaPica.setIzmers("80 cm diametra");
				break;
				
				}

				picuMasivs.add(jaunaPica);
				JOptionPane.showMessageDialog(null, "Pica saglabāta!");
				
				klients.setVards(JOptionPane.showInputDialog("Ievadi klienta vardu"));
				klients.setUzvards(JOptionPane.showInputDialog("Ievadi klienta uzvardu"));
				JOptionPane.showMessageDialog(null, "Klients saglabāts!");
				cilvekuMasivs.add(klients);
				
				JOptionPane.showMessageDialog(null, "Pica drīz būs gatava!");
				}
				}else
					JOptionPane.showMessageDialog(null, "Tu nevari pieņemt vairāk par 5 cilvēkiem vienlaicīgi");
				
				
			break;
			
			case "Apskatit klientu pasutijumus":

				int kk=1;
				for(int i=0; i<picuMasivs.size(); i++) {
					JOptionPane.showMessageDialog(null, kk+". klients\n"+((pica)picuMasivs.get(i)).izvadit());
					kk++;
				}
			break;
			
			case "Uztaisīt picu":
					JOptionPane.showMessageDialog(null, ((pica)picuMasivs.get(0)).izvadit());
				
			break;
				
			
			case "Aizvert programmu":
				JOptionPane.showMessageDialog(null, "Programma tiek aizvērta!");
			break;
			
			case "Edienkarte":
				izvele4 = (String) JOptionPane.showInputDialog(null, "Izvelies kuras picas sastavdalas apskatit", "Izvele", JOptionPane.QUESTION_MESSAGE,
						null, picuVeidi, picuVeidi[0]);
				
				switch(izvele4) {
				case "Olīvu pica":
					JOptionPane.showMessageDialog(null, "Olivas, tomati, baziliks, paprika, siers, tomatu merce");
				break;
				case "Siera pica":
					JOptionPane.showMessageDialog(null, "Siers, tomatu merce, baziliks, melnie pipari");
				break;
				case "Studentu pica":
					JOptionPane.showMessageDialog(null, "Peperoni, siers, tomatu merce, sipoli, kiploks");
				break;
				case "Peperoni pica":
					JOptionPane.showMessageDialog(null, "Siers, tomatu merce, peperoni, baziliks, melnie pipari");
				break;
				case "Pica itāļu gaumē":
					JOptionPane.showMessageDialog(null, "Oregano, tomati, olivas, siers, olivu ella, senes");
				break;
				}
				
			break;
			}
			
		}while(!izvele.equals("Aizvert programmu"));
				
		
		 

	}


}
