package QCM;

public class Etudiant
{
	private String nom;
	private Filiere filiere;
	
	public Etudiant(String nom, Filiere filiere) {
		super();
		this.nom = nom;
		this.filiere = filiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
	
	
	
	

}
