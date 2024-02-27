package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int force1=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}
		else {
			parler("J'abandonne...");
		}
		assert force1>force;
	}
	
	public static void main(String[] args) {
		Romain minus =new Romain("Minus",6);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
		minus.recevoirCoup(8);	
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
	}
} 

