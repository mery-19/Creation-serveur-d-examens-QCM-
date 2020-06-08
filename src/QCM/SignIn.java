package QCM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignIn {

	String nom,pass;
	Connection connection;
	PreparedStatement pst;
	Statement st;
	boolean res = false;

	public SignIn(Etudiant etudiant,String pass) {
		super();
		this.nom = etudiant.getNom();
		this.pass = pass;		
	
		try {
			System.out.println(etudiant.getFiliere().getNom());
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+etudiant.getFiliere().getNom(),"root","");
		} catch (SQLException e) {
			System.out.println("Connection failed: "+ e.getMessage());
		}
		res = exist(this.nom, pass);

		
	}
	
	boolean exist(String cne, String pass)
	{
		String query = "SELECT * FROM student WHERE CNE='"+cne+"' and Password= '"+pass+"'";
		try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
    		res = rs.next() ? true : false;
    		
			
		} catch (SQLException e) {
			System.out.println("conection pepare statment failed: "+e.getMessage());
		}
		return res;
		
	}
	
	
	
	
	
}
