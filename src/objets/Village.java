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
	
	public void afficherVillage() {
		
	}
	
	
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village();
		village.chef = abraracourcix;
		
		
	}
	
	
}