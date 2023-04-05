import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;


public class picerija {

	public static void main(String[] args) {
		String vards = null, uzvards = null, majasAdrese = null, izvele, izvele2, izvele3, izvele4, izvele5, veids = null, izmers = null, izvele6;
		String[] darbibas = {"Edienkarte", "Jauns klients", "Apskatit klientu pasutijumus", "Apkalpot pirmo klientu", "Pirkt produktus",  "Jauna diena",  "Naudas maks", "Aizvert programmu"};
		String[] picuVeidi = {"Olīvu pica", "Siera pica", "Studentu pica", "Peperoni pica", "Pica itāļu gaumē"};
		String[] klientaIz = {"Pasutijumi", "Klienti"};
		String[] picuVeidi2 = {"Olīvu pica", "Siera pica", "Studentu pica", "Peperoni pica", "Pica itāļu gaumē", "Atpakaļ"};
		String[] lidznemsanas = {"Uz vietas", "Piegade uz majam"};
		String[] izmeriP = {"30 cm diametra", "50 cm diametra", "80 cm diametra"};
		String[] produktuPirkt = {"1 picai | 5EUR", "3 picam | 13EUR", "6 picam | 25EUR", "10 picam |40EUR"};
		String talrunis = null;
		int kadsKlients, dienas = 1, pabeigtasPicas=0, produkti=3;
		double picasCena=0, naudasMaks=0;
		cilveks klients = null;
		pica jaunaPica = null;
		pica otraPica = null;
		boolean peperoni = false, siers = false, tomati = false, gurki = false, lidznemsana = false;
		ArrayList<cilveks> cilvekuMasivs = new ArrayList<cilveks>();
		ArrayList<pica> picuMasivs = new ArrayList<pica>();
		ArrayList<pica> picuMasivs2 = new ArrayList<pica>();
		
		try {
		ImageIcon bilde = new ImageIcon("loggo.png");
		JOptionPane.showMessageDialog(null, "Spied 'ok' \n lai sāktu", "Noras picērija", JOptionPane.INFORMATION_MESSAGE, bilde);
		
		JOptionPane.showMessageDialog(null, dienas+". diena strādājot Noras picērijā");
		Random rand = new Random();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvelies darbibu", "Izvele", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			switch(izvele) {
			case "Jauns klients":
				if(produkti>1) {
				if(cilvekuMasivs.size() <= 5) {
				klients = new cilveks(vards, uzvards, talrunis, majasAdrese);
				jaunaPica = new pica(veids, peperoni, siers, tomati, gurki, izmers, lidznemsana);
				otraPica = new pica(veids, peperoni, siers, tomati, gurki, izmers, lidznemsana);
				
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
					jaunaPica.setIzmers((String) JOptionPane.showInputDialog(null, "Izvelies picas izmeru", "Izvele", JOptionPane.QUESTION_MESSAGE,
							null, izmeriP, izmeriP[0]));
									
					
					
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
						klients.setTalrunis(" - ");
						klients.setMajasAdrese(" - ");
						JOptionPane.showMessageDialog(null, "Klients saglabāts!");
						cilvekuMasivs.add(klients);
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
						JOptionPane.showMessageDialog(null, "Pica maksā EUR"+picasCena);
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
				klients.setTalrunis(" - ");
				klients.setMajasAdrese(" - ");
				JOptionPane.showMessageDialog(null, "Klients saglabāts!");
				cilvekuMasivs.add(klients);
				
				}
				}else
					JOptionPane.showMessageDialog(null, "Tu nevari pieņemt vairāk par 5 cilvēkiem vienlaicīgi");
			}else 
				JOptionPane.showMessageDialog(null, "Tev nepietiek produkti lai uztaisītu picas");
				
				
				
			break;
			
			case "Apskatit klientu pasutijumus":
				izvele5 = (String) JOptionPane.showInputDialog(null, "Izvelies kadu info apskatit", "Izvele", JOptionPane.QUESTION_MESSAGE,
						null, klientaIz, klientaIz[0]);
				
				switch(izvele5) {
				case "Pasutijumi":
					int pasutijums = 1;
					Iterator<pica> apskatit = picuMasivs.iterator();
					String rezultats = "Pasūtijumu skaits: "+picuMasivs.size()+"\n_________________\n";
					
					while(apskatit.hasNext()){
						rezultats += pasutijums+". pasutijums"+"\n_________________\n";
						rezultats += apskatit.next().izvadit()+"\n_________________\n";
						pasutijums++;
					}
					JOptionPane.showMessageDialog(null, rezultats, "Picas", JOptionPane.INFORMATION_MESSAGE);
					
				break;
				case "Klienti":
					int pasutijums2 = 1;
					Iterator<cilveks> apskatit2 = cilvekuMasivs.iterator();
					String rezultats2 = "Klientu skaits: "+cilvekuMasivs.size()+"\n_________________\n";
					while(apskatit2.hasNext()){
						rezultats2 += pasutijums2+". klients"+"\n_________________\n";
						rezultats2 += apskatit2.next().izvaditC()+"\n_________________\n";
						pasutijums2++;
					}
					JOptionPane.showMessageDialog(null, rezultats2, "Klienti", JOptionPane.INFORMATION_MESSAGE);
					
				break;
				
				}
			break;
			
			case "Apkalpot pirmo klientu":
				if(cilvekuMasivs.size()>0) {
				JOptionPane.showMessageDialog(null, "Megini atcereties klienta pasutijumu un uztaisit tadu pasu picu!");
					JOptionPane.showMessageDialog(null, ((pica)picuMasivs.get(0)).izvadit());
					
					izvele2 = (String) JOptionPane.showInputDialog(null, "Izvelies kādu picu vēlas klients", "Izvele", JOptionPane.QUESTION_MESSAGE,
							null, picuVeidi, picuVeidi[0]);
					
					switch(izvele2) {
					case "Olīvu pica":
						otraPica.setVeids("Olīvu pica");
					break;
					case "Siera pica":
						otraPica.setVeids("Sieru pica");
					break;
					case "Studentu pica":
						otraPica.setVeids("Studentu pica");
					break;
					case "Peperoni pica":
						otraPica.setVeids("Peperoni pica");
					break;
					case "Pica itāļu gaumē":
						otraPica.setVeids("Pica itāļu gaumē");
					break;
					}
					
					otraPica.setPeperoni(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra peperoni? (true/false)")));
					otraPica.setSiers(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra siers? (true/false)")));
					otraPica.setTomati(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra tomati? (true/false)")));
					otraPica.setGurki(Boolean.parseBoolean(JOptionPane.showInputDialog("Extra gurki? (true/false)")));
					otraPica.setIzmers((String) JOptionPane.showInputDialog(null, "Izvelies picas izmeru", "Izvele", JOptionPane.QUESTION_MESSAGE,
							null, izmeriP, izmeriP[0]));
					
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
						otraPica.setLidznemsana(false);
						picuMasivs2.add(otraPica);
					break;
					case "Piegade uz majam":
						otraPica.setLidznemsana(true);
						picuMasivs2.add(otraPica);
					break;
					}
					
					JOptionPane.showMessageDialog(null, "Tiek pārbaudīta pica");
					if(picuMasivs.get(0).getPeperoni()==true)
						naudasMaks = naudasMaks+0.50;
					if(picuMasivs.get(0).getTomati()==true)
							naudasMaks = naudasMaks+0.50;
								if(picuMasivs.get(0).getSiers()==true)
									naudasMaks = naudasMaks+0.50;
								if(picuMasivs.get(0).getGurki()==true)
									naudasMaks = naudasMaks+0.50;
								if(picuMasivs.get(0).getIzmers()=="30 cm diametra")
									picasCena = picasCena+6.99;
									if(picuMasivs.get(0).getIzmers()=="50 cm diametra")
										picasCena = picasCena+9.99;
										if(picuMasivs.get(0).getIzmers()=="80 cm diametra")
											picasCena = picasCena+12.99;
										if(picuMasivs.get(0).getVeids()=="Sieru pica")
										picasCena = picasCena - 1.00;
										if(picuMasivs.get(0).getVeids()=="Studentu pica")
											picasCena = picasCena - 1.00;
										if(picuMasivs.get(0).getVeids()=="Peperoni pica")
											picasCena = picasCena - 1.00;
									
								
					
					if(picuMasivs.get(0).getVeids() == picuMasivs2.get(0).getVeids() && picuMasivs.get(0).getPeperoni() == picuMasivs2.get(0).getPeperoni() &&
							picuMasivs.get(0).getSiers() == picuMasivs2.get(0).getSiers() && picuMasivs.get(0).getTomati() == picuMasivs2.get(0).getTomati() &&
							picuMasivs.get(0).getGurki() == picuMasivs2.get(0).getGurki() && picuMasivs.get(0).getIzmers() == picuMasivs2.get(0).getIzmers() &&
							picuMasivs.get(0).getLidznemsana() == picuMasivs2.get(0).getLidznemsana()) {
						JOptionPane.showMessageDialog(null, "Tev izdevas pagatavot tadu pasu picu!");
						int tips;
						tips = rand.nextInt(3)+1;
						JOptionPane.showMessageDialog(null, "Klients tev iedeva dzeramnaudu par labu darbu!");
						JOptionPane.showMessageDialog(null, "EUR"+picasCena+" + EUR"+tips+" pievienots tavam naudas makam!");
						picasCena=picasCena+tips;
						naudasMaks = naudasMaks+picasCena;
					} else {
					    JOptionPane.showMessageDialog(null, "Tev neizdevas pagatavot tadu pasu picu!\nKlients maksas mazak");
					    int mazak;
					    mazak = rand.nextInt(3)+1;
					    JOptionPane.showMessageDialog(null, "EUR"+picasCena+" - EUR"+mazak+" pievienots tavam naudas makam!");
					    naudasMaks=picasCena-mazak;
					}
					
					pabeigtasPicas++;
					produkti = produkti-1;
					picuMasivs.remove(0);
					picuMasivs2.remove(0);
					cilvekuMasivs.remove(0);
					picasCena=0;
				} else
					JOptionPane.showMessageDialog(null, "Tev nav pienemti klienti");
					
			break;
			
			case "Jauna diena":
				if(pabeigtasPicas>=3) {
				dienas++;
				JOptionPane.showMessageDialog(null, dienas+". diena strādājot Noras picērijā!" );
				JOptionPane.showMessageDialog(null, "EUR10.00 pievienots tavam naudas makam" );
				naudasMaks = naudasMaks+10.00;
				} else
					JOptionPane.showMessageDialog(null, "Tu neesi uztaisījis vismaz 3 picas lai sāktu jaunu dienu!" );
					
				
				
			break;
			
			case "Pirkt produktus":
				ImageIcon bildeI = new ImageIcon("produkti.png");
				JOptionPane.showMessageDialog(null, "Tev sobrid pietiek produkti\n    lai uztaisitu "+produkti+" picas", "Produkti", JOptionPane.INFORMATION_MESSAGE, bildeI);
				izvele6 = (String) JOptionPane.showInputDialog(null, "Izvelies cik picam pirkt produktus", "Izvele", JOptionPane.QUESTION_MESSAGE,
						null, produktuPirkt, produktuPirkt[0]);
				
				switch(izvele6) {
				case "1 picai | 5EUR":
					if(naudasMaks>5) {
					produkti = produkti+1;
					naudasMaks = naudasMaks - 5;
					JOptionPane.showMessageDialog(null, "Nopirkti produkti vēl 1 picai!");
					}else 
						JOptionPane.showMessageDialog(null, "Tev nepietiek naudas");
				break;
				case "3 picam | 13EUR":
					if(naudasMaks>13) {
						produkti = produkti+3;
						naudasMaks = naudasMaks - 13;
						JOptionPane.showMessageDialog(null, "Nopirkti produkti vēl 3 picam!");
						}else 
							JOptionPane.showMessageDialog(null, "Tev nepietiek naudas");
					
				break;
				
				case "6 picam | 25EUR":
					if(naudasMaks>25) {
						produkti = produkti+6;
						naudasMaks = naudasMaks - 25;
						JOptionPane.showMessageDialog(null, "Nopirkti produkti vēl 6 picam!");
						}else 
							JOptionPane.showMessageDialog(null, "Tev nepietiek naudas");		
				break;
				case "10 picam |40EUR":
					if(naudasMaks>40) {
						produkti = produkti+10;
						naudasMaks = naudasMaks - 40;
						JOptionPane.showMessageDialog(null, "Nopirkti produkti vēl 10 picam!");
						}else 
							JOptionPane.showMessageDialog(null, "Tev nepietiek naudas");
						
				break;
				}
				
				
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
							+ "\n______\nCena:\n30cm - 5.99\n50cm - 8.99\n80cm - 11.99 ", "Siera pica", JOptionPane.INFORMATION_MESSAGE, bilde4);
				break;
				case "Peperoni pica":
					ImageIcon bilde5 = new ImageIcon("peperoni pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nSiers\nTomātu mērce\nPeperoni\nĶiploki"
							+ "\n______\nCena:\n30cm - 5.99\n50cm - 8.99\n80cm - 11.99 ", "Peperoni pica", JOptionPane.INFORMATION_MESSAGE, bilde5);
				break;
				case "Pica itāļu gaumē":
					ImageIcon bilde6 = new ImageIcon("italu pica.png");
					JOptionPane.showMessageDialog(null, "Sastāvdaļas:\nSiers\nTomātu mērce\nTomāti\nĶiploki\nOregano\nLapas"
							+ "\n______\nCena:\n30cm - 6.99\n50cm - 9.99\n80cm - 12.99 ", "Peperoni pica", JOptionPane.INFORMATION_MESSAGE, bilde6);
				break;
				case "Atpakaļ":
					
				break;
				}
				}while(!izvele4.equals("Atpakaļ"));
				
			break;
			
			case "Naudas maks":
				if(naudasMaks==0) {
					ImageIcon bilde3 = new ImageIcon("no nauda.png");
					JOptionPane.showMessageDialog(null, "Tavā naudas makā šobrīd atrodas EUR"+naudasMaks, "Naudas Maks", JOptionPane.INFORMATION_MESSAGE, bilde3);
				} else {
				ImageIcon bilde3 = new ImageIcon("yes nauda.png");
				JOptionPane.showMessageDialog(null, "Tavā naudas makā šobrīd atrodas EUR"+naudasMaks, "Naudas Maks", JOptionPane.INFORMATION_MESSAGE, bilde3);
				}
			break;
				
			}
		}while(!izvele.equals("Aizvert programmu"));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Kaut kas nogāja greizi");
		}
				
		
		

	}


}
