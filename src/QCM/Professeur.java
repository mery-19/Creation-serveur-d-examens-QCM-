package QCM;

import java.util.ArrayList;

public class Professeur
{
	private String nom;
	private String specialite;
	private ArrayList<Qcm> listQcm;
	
	public Professeur(String nom, String specialite, ArrayList<Qcm> listQcm) {
		super();
		this.nom = nom;
		this.specialite = specialite;
		this.listQcm = listQcm;
	}
	
	public Professeur(String nom, String specialite, Qcm ...listQcm) {
		super();
		this.nom = nom;
		this.specialite = specialite;
		this.listQcm = new ArrayList<Qcm>();
		
		for (Qcm qcm : listQcm) 
		{
			this.listQcm.add(qcm);
			
		}
		
	}
	


}
