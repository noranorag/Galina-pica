import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class picerija {
	
	public static void main(String[] args) {
		String vards, uzvards, majasAdrese, izvele;
		String[] darbibas = {"Jauns klients", "Apkalpojamo klientu saraksts", "Apskat�t cilv�ka pas�t�jumu", "Apkalpot pirmo klientu", "Aizv�rt programmu"};
		int talrunis, masivaL, skaititajs, skaits=0;
		cilveks klients = null;
		
		ArrayList<cilveks> cilvekuMasivs = new ArrayList<cilveks>();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "Izv�le", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			switch(izvele) {
			case "Jauns klients":
				//klients = new cilveks(vards, uzvards, talrunis, majasAdrese);
				klients.setVards(JOptionPane.showInputDialog("Ievadi studenta v�rdu"));
				klients.setUzvards(JOptionPane.showInputDialog("Ievadi studenta uzv�rdu"));
				
				String tel="";
				do{
					tel = JOptionPane.showInputDialog("Ievadi telefona numuru form�t� 200000000");
				}while(!Pattern.matches("^[2]{1}[0-9]{7}$", tel));
				klients.setTalrunis("+371"+tel);
				
				
				cilvekuMasivs.add(klients);
			break;
			}
			
		}while(!izvele.equals("Aizv�rt programmu"));
				
		
		 

	}

}
