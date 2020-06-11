package QCM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Qcm extends JFrame {

	private JPanel contentPane;
	private JRadioButton ans1,ans2,ans3,ans4;
	private JLabel question;
	private ButtonGroup buttonGroup;
	DataOutputStream dataOut;
	DataInputStream dataIn;
	static protected String choix;
	Client etudiant;
	final int QUESTIONS_NUMB = 7;
	int id,j=0;
	ArrayList<Integer> idTable=new ArrayList<Integer>();
	private ImageIcon icon,usmba;
	JButton next;

	private Image image,imgUsmba;
	int x,y;
	

	public Qcm(Client etudiant,String module) 
	{
		setBackground(Color.WHITE);
		this.choix = module;
		this.etudiant = etudiant;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 800, 400);
		header();

		
		buttonGroup = new ButtonGroup();
		
		nextActionListner();

		try {
//			send question number to the server
			dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
			dataOut.write(generateQuestion());
			
//			the server response with the question
			dataIn = new DataInputStream(etudiant.socket.getInputStream());
			contentPane.setLayout(null);
			question = new JLabel(dataIn.readUTF());
			question.setFont(new Font("Tahoma", Font.PLAIN, 18));
			question.setBounds(25, 82, 738, 29);
			contentPane.add(question);
			
			dataIn = new DataInputStream(etudiant.socket.getInputStream());
			String stg = dataIn.readUTF();
			ans1 = new JRadioButton(stg);
			ans1.setActionCommand(stg);
			buttonGroup.add(ans1);
			ans1.setBounds(25, 134, 350, 29);
			ans1.setBackground(Color.white);
			contentPane.add(ans1);
			
			
			dataIn = new DataInputStream(etudiant.socket.getInputStream());
			String stg1 = dataIn.readUTF();
			 ans2 = new JRadioButton(stg1);
			 ans2.setActionCommand(stg1);
			buttonGroup.add(ans2);
			ans2.setBounds(25, 159, 350, 29);
			ans2.setBackground(Color.white);
			contentPane.add(ans2);
			
			dataIn = new DataInputStream(etudiant.socket.getInputStream());
			String stg3 = dataIn.readUTF();
			 ans3 = new JRadioButton(stg3);
			 ans3.setActionCommand(stg3);			
			 buttonGroup.add(ans3);
			ans3.setBounds(25, 184, 350, 29);
			ans3.setBackground(Color.white);
			contentPane.add(ans3);
			
			dataIn = new DataInputStream(etudiant.socket.getInputStream());
			String stg4 = dataIn.readUTF();
			ans4 = new JRadioButton(stg4);
			ans4.setActionCommand(stg4);
			buttonGroup.add(ans4);
			ans4.setBounds(25, 209, 350, 29);
			ans4.setBackground(Color.white);
			contentPane.add(ans4);

		} catch (IOException e) {e.printStackTrace();}
		
		this.setVisible(true);
	}
	
	public int generateQuestion()
	{
		Random random= new Random();
		do {
			id = random.nextInt(QUESTIONS_NUMB-1)+1;
			System.out.println(id);
            System.out.println("exist"+idTable.contains(id));
		}while(idTable.contains(id) != false);
		idTable.add(id);
		System.out.println("the id is:"+id);
		
		return id;
	}
	
	public void nextActionListner()
	{
		next = new JButton("Next");
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		next.setBackground(Color.orange);
		next.setBounds(25, 264, 115, 29);
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j++;
				try {			
				if(j <= QUESTIONS_NUMB) {
					
//					sending answer to server to stock it in the database
					
//					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
//					dataOut.writeUTF(buttonGroup.getSelection().getActionCommand());
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.write(generateQuestion());
					getQuestionFromDB();
					System.out.println(j);
					
				}
				else
					{
//						sending answer to server to stock it in the database
						dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
						dataOut.writeUTF(buttonGroup.getSelection().getActionCommand());
						j = QUESTIONS_NUMB;
						dataIn = new DataInputStream(etudiant.socket.getInputStream());
						int scoor = dataIn.read();
						JOptionPane.showMessageDialog(contentPane, "you finished the quiz! your score is: "+scoor+"%");
//						fin.setText("your score is: "+scoor+"%");
//						
//						contentPane.removeAll();
//						contentPane.add(fin);
//						contentPane.add(reset);
//						contentPane.validate(); 
//						contentPane.repaint();
						
					}
				}catch (IOException e1) {e1.printStackTrace();}	
			}
		});
		contentPane.add(next);
		
			
	
	}

	public void getQuestionFromDB() throws IOException
	{
		buttonGroup = new ButtonGroup();
		
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		question.setText(dataIn.readUTF());
	
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		String stg = dataIn.readUTF();
		 ans1.setText(stg);
		 ans1.setActionCommand(stg);
		buttonGroup.add(ans1);

		
		
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		String stg1 = dataIn.readUTF();
		 ans2.setText(stg1);
		 ans2.setActionCommand(stg1);
			buttonGroup.add(ans2);

		
		
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		String stg3 = dataIn.readUTF();
		 ans3.setText(stg3);
		 ans3.setActionCommand(stg3);			
		 buttonGroup.add(ans3);
		
		
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		String stg4 = dataIn.readUTF();
		ans4.setText(stg4);
		ans4.setActionCommand(stg4);
		buttonGroup.add(ans4);
		
	}
	
	public void header()
	{
		icon = new ImageIcon(getClass().getResource("/images/ensa.jpg"));
		image = icon.getImage();
		
		usmba = new ImageIcon(getClass().getResource("/images/usmba.png"));
		imgUsmba = usmba.getImage();
		contentPane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				 x= this.getWidth();
				 y= this.getHeight();
				g.drawImage(image, 20,10,80,50,null);
				g.drawImage(imgUsmba, x-100,10,80,50,null);//100=20+imgTaille
				g.drawLine(5, 65, x-5, 65);
				
			}
		};
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lab1 = new JLabel("Universit\u00E9 Sidi Mohammed Ben Abdellah");
		lab1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab1.setBounds(253, 16, 282, 20);
		contentPane.add(lab1);
		
		JLabel lab2 = new JLabel("Ecole Nationale des Sciences Appliqu\u00E9es");
		lab2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab2.setBounds(253, 32, 282, 20);
		contentPane.add(lab2);
	}
}
