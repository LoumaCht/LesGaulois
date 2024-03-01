package personnages;

public enum Equipement {
	CASQUE("casque"),BOUCLIER("bouclier");
	
	private String nom;
	
	private Equipement(String nom) {
		// modifier la chaine 
		this.nom=nom;
	}
	public String toString() {
		return nom;
	}
	
	
}
