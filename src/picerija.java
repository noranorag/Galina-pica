import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;


public class picerija {

	public static void main(String[] args) {
		String vards = null, uzvards = null, majasAdrese = null, izvele, izvele2, izvele3, izvele4, veids = null, izmers = null;
		String[] darbibas = {"Jauns klients", "Apskatīt klientus", "Apskatit klientu pasutijumus", "Apkalpot pirmo klientu", "Uztaisīt picu", "Edienkarte", "Aizvert programmu"};
		String[] picuVeidi = {"Olīvu pica", "Siera pica", "Studentu pica", "Peperoni pica", "Pica itāļu gaumē"};
		String[] picuVeidi2 = {"Olīvu pica", "Siera pica", "Studentu pica", "Peperoni pica", "Pica itāļu gaumē", "Atpakaļ"};
		String[] lidznemsanas = {"Uz vietas", "Piegade uz majam"};
		String[] izmeriP = {"30 cm diametra", "50 cm diametra", "80 cm diametra"};
		String talrunis = null;
		int kadsKlients;
		cilveks klients = null;
		pica jaunaPica = null;
		boolean peperoni = false, siers = false, tomati = false, gurki = false, lidznemsana = false;
		
		
		ArrayList<cilveks> cilvekuMasivs = new ArrayList<cilveks>();
		ArrayList<pica> picuMasivs = new ArrayList<pica>();
		
		ImageIcon bilde = new ImageIcon("loggo.png");
		JOptionPane.showMessageDialog(null, "Spied 'ok' \n lai sāktu", "Noras picērija", JOptionPane.INFORMATION_MESSAGE, bilde);
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
						picuMasivs.add(jaunaPica);
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
						picuMasivs.add(jaunaPica);
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
				Iterator<pica> apskatit = picuMasivs.iterator();
				String rezultats = "Picu masivs: "+picuMasivs.size()+"\n______________________\n";
				while(apskatit.hasNext()){
					rezultats += apskatit.next().izvadit()+"\n______________________\n";
					
				}
				JOptionPane.showMessageDialog(null, rezultats, "Picas", JOptionPane.INFORMATION_MESSAGE);

			break;
			
			case "Uztaisīt picu":
					JOptionPane.showMessageDialog(null, ((pica)picuMasivs.get(0)).izvadit());
				
			break;
				
			
			case "Aizvert programmu":
				JOptionPane.showMessageDialog(null, "Programma tiek aizvērta!");
			break;
			
			case "Edienkarte":
				do {
				izvele4 = (String) JOptionPane.showInputDialog(null, "Izvelies kuras picas sastavdalas apskatit", "Izvele", JOptionPane.QUESTION_MESSAGE,
						null, picuVeidi2, picuVeidi2[0]);
				
				switch(izvele4) {
				case "Olīvu pica":
					ImageIcon bilde2 = new ImageIcon("olivu pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nOlīvas\nTomāti\nŠampinjoni\nPaprika\nSiers\nTomātu mērce"
							+ "\n______\nCena:\n30cm - 6.99\n50cm - 9.99\n80cm - 12.99 ", "Olīvu pica", JOptionPane.INFORMATION_MESSAGE, bilde2);
				break;
				case "Siera pica":
					ImageIcon bilde3 = new ImageIcon("siera pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nSiers\nTomātu mērce\nbaziliks\nķiploks"
							+ "\n______\nCena:\n30cm - 5.99\n50cm - 8.99\n80cm - 11.99 ", "Siera pica", JOptionPane.INFORMATION_MESSAGE, bilde3);
				break;
				case "Studentu pica":
					ImageIcon bilde4 = new ImageIcon("studentu pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nSiers\nTomātu mērce\nPaprika\nSīpoli\nOlīvas"
							+ "\n______\nCena:\n30cm - 4.99\n50cm - 7.99\n80cm - 11.99 ", "Siera pica", JOptionPane.INFORMATION_MESSAGE, bilde4);
				break;
				case "Peperoni pica":
					ImageIcon bilde5 = new ImageIcon("peperoni pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nSiers\nTomātu mērce\nPeperoni\nĶiploki"
							+ "\n______\nCena:\n30cm - 5.99\n50cm - 8.99\n80cm - 11.99 ", "Peperoni pica", JOptionPane.INFORMATION_MESSAGE, bilde5);
				break;
				case "Pica itāļu gaumē":
					ImageIcon bilde6 = new ImageIcon("italu pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nSiers\nTomātu mērce\nTomāti\nĶiploki\nOregano\nLapas"
							+ "\n______\nCena:\n30cm - 5.99\n50cm - 8.99\n80cm - 11.99 ", "Peperoni pica", JOptionPane.INFORMATION_MESSAGE, bilde6);
				break;
				case "Atpakaļ":
					
				break;
				}
				}while(!izvele4.equals("Atpakaļ"));
				
			break;
				
			}
		}while(!izvele.equals("Aizvert programmu"));
				
		
		

	}


}
