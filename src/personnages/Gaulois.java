package personnages;
import objets.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
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
		//return nom;
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	
	// ------- Partie 3 - TP1 ------- //
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force*effetPotion)/3);
		if(effetPotion > 1) {
			--effetPotion;
		}
	}
	
	// Partie 4 - TP1 //
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	
	// TP 2
	public void setVillage(Village village) {
		// TODO Auto-generated method stub
		
	}
	
	
}
