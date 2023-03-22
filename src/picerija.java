import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class picerija {
	
	public static void main(String[] args) {
		String vards, uzvards, majasAdrese, izvele;
		String[] darbibas = {"Jauns klients", "Apkalpojamo klientu saraksts", "Apskatît cilvçka pasûtîjumu", "Apkalpot pirmo klientu", "Aizvçrt programmu"};
		int talrunis, masivaL, skaititajs, skaits=0;
		cilveks klients = null;
		
		ArrayList<cilveks> cilvekuMasivs = new ArrayList<cilveks>();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvçlies darbîbu", "Izvçle", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			switch(izvele) {
			case "Jauns klients":
			break;
			}
			
		}while(!izvele.equals("Aizvçrt programmu"));
				
		
		 

	}

}
