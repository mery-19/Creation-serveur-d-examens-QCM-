package QCM;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;



public class StudentSpace extends Thread {
	
	Socket socket;
	Server server;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	String nom;
	Connection connection;
	Statement st;
	String filiere,choix;
	int id;

	public StudentSpace(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
		
		try {
			dataIn = new DataInputStream(socket.getInputStream());
			filiere = dataIn.readUTF();
			System.out.println("la filiere est: "+filiere);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+filiere,"root","");
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public void run() {

			try {
				dataIn = new DataInputStream(socket.getInputStream());
				nom = dataIn.readUTF();
				dataOut = new DataOutputStream(socket.getOutputStream());
				dataOut.writeUTF(Integer.toString(server.studentNumber));
				server.studentList.textarea.append("\n Student: "+server.studentNumber+" de nom: "+nom+" connecté");
				
//				choix from ChoixInfo
				dataIn = new DataInputStream(socket.getInputStream());
				this.choix = dataIn.readUTF();
				System.out.println("le choix de module est:"+choix);
//				envoyer les questions au etudiant(client)	
				while(true)
				{
					dataIn = new DataInputStream(socket.getInputStream());
					id = dataIn.read();
					sendQuestion(id);
					
				}
				
				
				
				
			}catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	
	public void sendQuestion(int nb) 
	{
		String query ="SELECT question, ans1,ans2,ans3,ans4 from "+ this.choix +" where id="+nb;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				for(int i = 1; i <=5; i++){           
					try {
						dataOut = new DataOutputStream(socket.getOutputStream());
						dataOut.writeUTF(rs.getString(i));
						System.out.println(rs.getString(i));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} 
				break;
				
			}
			
		}
		catch (SQLException e) {e.printStackTrace();}		
	}
	
	
}