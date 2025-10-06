package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public boolean resterPotion() {
		return quantitePotion > 0;
	}
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	public int prendreLouche() {
		if(resterPotion()) {
			--quantitePotion;
		}else {
			forcePotion = 0;
		}
		return forcePotion;
	}
}
