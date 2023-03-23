import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class picerija {
	
	public static void main(String[] args) {
		String vards = null, uzvards = null, majasAdrese = null, izvele;
		String[] darbibas = {"Jauns klients", "Apkalpojamo klientu saraksts", "Apskatat cilveka pasutijumu", "Apkalpot pirmo klientu", "Aizvert programmu"};
		String talrunis = null;
		int masivaL, skaititajs, skaits=0;
		cilveks klients = null;
		
		ArrayList<cilveks> cilvekuMasivs = new ArrayList<cilveks>();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "Izv�le", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			switch(izvele) {
			case "Jauns klients":
				klients = new cilveks(vards, uzvards, talrunis, majasAdrese);
				klients.setVards(JOptionPane.showInputDialog("Ievadi studenta vardu"));
				klients.setUzvards(JOptionPane.showInputDialog("Ievadi studenta uzvardu"));
				
				String tel="";
				do{
					tel = JOptionPane.showInputDialog("Ievadi telefona numuru formata 200000000");
				}while(!Pattern.matches("^[2]{1}[0-9]{7}$", tel));
				klients.setTalrunis("+371"+tel);
				klients.setMajasAdrese(JOptionPane.showInputDialog("Ievadi klienta majas adresi"));
				JOptionPane.showMessageDialog(null, "Klients izveidots!");
				cilvekuMasivs.add(klients);
			break;
			
			case "Aizvert programmu":
				JOptionPane.showMessageDialog(null, "Programma tiek aizvērta!");
			break;
			}
			
		}while(!izvele.equals("Aizvert programmu"));
				
		
		 

	}

}
