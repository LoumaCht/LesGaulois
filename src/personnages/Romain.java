package personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
		equipements= new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int force1=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		}
//		else {
//			parler("J'abandonne...");
//		}
//		assert force1>force;
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup; 
		if (force>0) {
			parler("Aïe");
		}else{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0){
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de";
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
		if (forceCoup<0) {
			forceCoup=0;
		}
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}	
		return equipementEjecte;
	}
	public void  sEquiper (Equipement equipement) {
		switch (nbEquipement) {
		case 0: {
			System.out.println("Le soldat "+nom+" s'equipe avec un "+ equipement+".");
			equipements[nbEquipement]=equipement;
			nbEquipement++;
			break;
			
		}
		case 1: {
			if (equipements[nbEquipement-1]==equipement) {
				System.out.println("Le soldat "+nom+" possede déja un "+ equipement+".");
			}
			else {
				equipements[nbEquipement]=equipement;
				System.out.println("Le soldat "+nom+" s'equipe d'un "+ equipement+".");
				System.out.println("Le soldat "+ nom +" est déjà bien protégé!");
				nbEquipement++;
				break;
			}
		}
		default:
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus =new Romain("Minus",6);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
		minus.recevoirCoup(8);	
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		
	}
} 

