package personnages;

public class Romain {
	//Attributs
	private String nom;
	private int force;
	
	//Constructeur
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
		force -= forceCoup;
		if(force < 1) {
			force = 0;
			parler("J'abandonne !");
			
		}else
			parler("Aïe !");
	}
}
