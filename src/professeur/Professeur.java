package professeur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.proteanit.sql.DbUtils;

public class Professeur
{
	private String nom;
	private String specialite;
	private String listQcm = new String();
	private String[] l;
	protected ArrayList<String> liste = new ArrayList<String>();
	private Connection connection;
	private PreparedStatement ps;
	protected String filiere;
	
	
	public Professeur(String nom) {
		super();
		this.nom = nom;
		
		try {
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/professeurs","root","");
		 String query = "select filiere,listQcm from profs where nom='"+nom+"'";
		 System.out.println(query);
		 ps = connection.prepareStatement(query);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 this.filiere = rs.getString(1);
			 this.listQcm = rs.getString(2);
		 }
		 
		 if(listQcm.contains(","))
		 {
			 l = listQcm.split(",");
			 for (String module : l) {
				liste.add(module);
				System.out.println(module);
			} 
		 }
		 
		 		 
	} catch (SQLException e) {
		System.out.println("Connection failed: "+ e.getMessage());
	}
		
	}
	

	


}
