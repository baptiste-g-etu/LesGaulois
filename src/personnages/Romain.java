package personnages;
import objets.Equipement;

public class Romain {
	//Attributs
	private String nom;
	private int force;
	
	Equipement[] equipements = new Equipement[2];
	int nbEquipements = 0;
	
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
	
	
	// ----------- TP 2 - Partie 2 -----------
	private boolean isInvariantVerified(int force) {
		return force >= 0;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Gaulois asterix = new Gaulois("Astérix", 4);
		asterix.frapper(minus);
		
		// ----------- TP 2 - Partie 3 -----------
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);
		
	}

	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipements) {
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
				if(equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
				}else {
					ajouterEquipement(equipement);
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + " !");
				}
				break;
			case 0:
				ajouterEquipement(equipement);
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + " !");
				break;
			default:
				break;
		}
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipements++] = equipement;
	}
	
}
