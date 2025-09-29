package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca (rip UTF) te dirais d'aller chasser des sangliers ? ");
		asterix.parler("Oui, très bonne idée.");
		
		
		// Partie 3 - TP1
		Romain minus = new Romain("Minus", 6);
		System.out.printf("Dans la forêt %s et %s tombent nez à nez sur le romain %s.", asterix.getNom(), obelix.getNom(), minus.getNom());
		for(int i=0; i<3; ++i) 
			asterix.frapper(minus);	
	}
}
