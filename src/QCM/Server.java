package QCM;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private ServerSocket ss;
	private int port = 1234;
	protected int studentNumber;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	public connectedStudent studentList;
	static ArrayList<StudentSpace> students = new ArrayList<StudentSpace>();
	
	
	public Server() 
	{
		try {
			ss = new ServerSocket(port);
			studentList = new connectedStudent();
			
			while(true)
			{
				Socket s = ss.accept();
				++studentNumber;
				StudentSpace sc = new StudentSpace(s,this);
				sc.start();
				students.add(sc);
				
			}
		} catch (IOException e) {
			System.out.println("server Socket Failed => "+e.getMessage());
		}
		
	}

	public static void main(String[] args) 
	{
		new Server();

	}

}
