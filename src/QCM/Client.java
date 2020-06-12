package QCM;
//the client is the student

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
	protected Socket socket;
	private String ip = "localhost";
	private int port = 1234;
	private DataOutputStream dataOut;
	private DataInputStream dataInt;
//	protected quizFrame quiz;
	private ChoixInfo cq;
	int clientNb ;
	String nom,filiere;
	
	
	public Client(signInFrame signinframe) {
		
		try {
			socket = new Socket(ip,port);
		}
		catch (IOException e) {
			System.out.println("socket creation Failed => "+ e.getMessage());	
		}
		
		this.nom = signinframe.nom.getText();
		this.filiere = signinframe.filiere;
		
		try {
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataOut.writeUTF(filiere);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataOut.writeUTF(nom);
	
			dataInt = new DataInputStream(socket.getInputStream());
			String msg = dataInt.readUTF();
			clientNb = Integer.parseInt(msg);
			System.out.println("you are student number: "+msg);
			
			if(filiere.equals("informatique"))
			{
				cq = new ChoixInfo(this);	
			}
//			code des autres filières
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


}
