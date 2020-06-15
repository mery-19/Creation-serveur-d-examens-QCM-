package QCM;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignIn {

	String nom, pass;
	Connection connection;
	PreparedStatement pst;
	Statement st;
	boolean res = false;

	public SignIn(signInFrame sif) {
		super();

		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+sif.filiere,"root","");
		} catch (SQLException e) {
			System.out.println("Connection failed: "+ e.getMessage());
		}
		
		this.nom = sif.nom.getText();
		char[] p=sif.passField.getPassword();
		this.pass = new String(p);
		
		res = exist(nom, pass);

		
	}
	
	boolean exist(String nom, String pass)
	{
		String query = "SELECT * FROM etudiants WHERE nom='"+nom+"' and Password= '"+pass+"'";
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
