package personnages;

public class Gaulois {
	public String nom;
	public int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3)*effetpotion);
//	}
		
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}
	public void boirePotion(int forcePotion) {
		
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion+" fois décuplée");
	}
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees!=0) {
			parler("Je donne au musee tous mes trophees :\n");
			for (int i=0;i<nbTrophees;i++) {
				System.out.println(trophees[i]);
			}
		}
	}
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//		System.out.println(asterix);
//		et du coup là ca affiche le nom de asterix 
//		La méthode toString permet de transformer l’affichage de l’objet sous
//		sa forme nomDuPaquage.nomDeLaCLasse@adresseMemoire en chaine de
//		caractère correspondant à l’état de l’objet.
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Druide panoramix = new Druide("Panoramix",5,10);
		int forcePotion = panoramix.preparerPotion();
//	System.out.println(asterix.toString()); ca n'affiche pas le nom du nouveau gaulois !!
		System.out.println(asterix.getNom());
		asterix.parler("Bonjour !");
		asterix.frapper(minus);
		asterix.boirePotion(forcePotion);
	}
}
