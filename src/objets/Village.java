package objets;
import personnages.*;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	
	private Gaulois chef;
	private int NB_MAX_VILLAGEOIS = 30;
	private Gaulois[] villagois = new Gaulois[NB_MAX_VILLAGEOIS];
	
	
	public String getNom() {
		return this.nom;
	}
	public Gaulois getChef() {
		return this.chef;
	}
	
	public void ajouterVillagois(Gaulois gaulois) {
		villagois[nbVillageois++] = gaulois;
		gaulois.village = this;
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		// Le premier villageois est le numéro 1
		if(villagois[numVillageois-1] != null) {
			return villagois[numVillageois-1];
		} else {
			System.out.println("Il n'y a pas autant d'habitants dans le village");
			return null;
		}
	}
	
	public void afficherVillageois() {
		System.out.println("Chef du village " + this.getNom() + " : " + chef.getNom());
		System.out.println("Habitants du village : ");
		for(int i=0; i<nbVillageois; i++) {
			System.out.println("- " + villagois[i].getNom());
		}
	}
	
	
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		
		//TODO : abraracourcix n'est pas encore le chef du village
		Village village = new Village();
		village.chef = abraracourcix;
		
		
		village.nom = "Le village des irréductibles";
		village.NB_MAX_VILLAGEOIS = 30;
		
		// Vérification
		//Gaulois gaulois_test = village.trouverVillageois(30);
		
		// Ajout d'un habitant
		Gaulois Asterix = new Gaulois("Astérix", 8);
		village.ajouterVillagois(Asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		System.out.println("------------------------------");
		
		
		
		// Test de gaulois.sePresenter()
		
		//TODO : Maj ou pas pour Asterix / Obelix ?
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillagois(obelix);
		Gaulois doublePolemix = new Gaulois("DoublePolemix", 4);

		//TODO : Sujet : Attention : dans ce TP le chef ne fait pas partie des villageois
		village.ajouterVillagois(abraracourcix);
		
		
		village.afficherVillageois();
		
		//TODO : code plus opti ?
		Asterix.sePresenter();
		obelix.sePresenter();
		doublePolemix.sePresenter();
		
		abraracourcix.sePresenter();
		
	}
	
	
}