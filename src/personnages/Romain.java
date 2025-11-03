package personnages;

public class Romain {
	//Attributs
	private String nom;
	private int force;
	
	//Constructeur
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
	}
	//Getter
	public String getNom() {
		return nom;
	}
	//Méthodes
	public void parler(String texte) {	
		System.out.println(prendreParole() +"\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		// Pré condition
		assert isInvariantVerified(force);
		final int force_debut = force;
		
		force -= forceCoup;
		if(force < 1) {
			force = 0;
			parler("J'abandonne !");
			
		}else
			parler("Aïe !");
		
		// Post condition
		assert isInvariantVerified(force);
		assert force < force_debut;
		System.out.println("Post condition vérifiée");
		
	}
	
	
	// ----------- TP 2 -----------
	private boolean isInvariantVerified(int force) {
		return force >= 0;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Gaulois asterix = new Gaulois("Astérix", 4);
		asterix.frapper(minus);
	}
	
}
