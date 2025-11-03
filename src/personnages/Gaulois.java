package personnages;
import objets.*;

public class Gaulois {
	private String nom;
	//private int force;
	private int effetPotion = 1;
	public Village village;
	
	// TP 3
	private int force;
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];
	
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	
	// ------- Partie 3 - TP1 ------- //
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force*effetPotion)/3);
//		if(effetPotion > 1) {
//			--effetPotion;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
	}
	
	
	// Partie 4 - TP1 //
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	
	// TP 2

	public void sePresenter() {
		if(village == null) {
			parler("Je suis " + nom + " et je voyage de villages en villages.");
		}else if(village.getChef() == this) {
			parler("Je suis " + nom + ", chef du village de " + village.getNom() + ".");			
		}
		else {
			parler("Je suis " + nom + " et j'habite le village: " + village.getNom() + ".");
		}
	}
	
	
}
