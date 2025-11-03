package personnages;
import objets.Equipement;

public class Romain {
	//Attributs
	private String nom;
	private int force;
	
	// TP 2
	Equipement[] equipements = new Equipement[2];
	int nbEquipement = 0;
	
	
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
	
//	public void recevoirCoup(int forceCoup) {
//		// Pré condition
//		assert isInvariantVerified(force);
//		final int force_debut = force;
//		
//		force -= forceCoup;
//		if(force < 1) {
//			force = 0;
//			parler("J'abandonne !");
//			
//		}else
//			parler("Aïe !");
//		
//		// Post condition
//		assert isInvariantVerified(force);
//		assert force < force_debut;
//		System.out.println("Post condition vérifiée");
//		
//	}
	
	
	
	
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
		switch(nbEquipement) {
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
				if(equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
				}else {
					ajouterEquipement(equipement);
				}
				break;
			case 0:
				ajouterEquipement(equipement);
				
				break;
			default:
				break;
		}
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement++] = equipement;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + " !");
	}
	
	
	
	// ----------- TP 3 -----------
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force == 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null){
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
}
