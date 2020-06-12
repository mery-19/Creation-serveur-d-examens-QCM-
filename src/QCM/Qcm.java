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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Qcm extends JFrame {

	protected JPanel contentPane;
	private JRadioButton ans1,ans2,ans3,ans4;
	private JLabel question,fin;
	private ButtonGroup buttonGroup;
	DataOutputStream dataOut;
	DataInputStream dataIn;
	static protected String choix;
	Client etudiant;
	final int QUESTIONS_NUMB = 7;
	protected int id,j=1;
	ArrayList<Integer> idTable=new ArrayList<Integer>();
	protected JButton next;
	private ImageIcon icon,usmba;
	private Image image,imgUsmba;
	private int x,y;
	
	private JTable table;
	
	private Connection connection;
	private PreparedStatement ps;

	public Qcm(Client etudiant,String module) 
	{
		header();

		this.choix = module;
		this.etudiant = etudiant;

		header();
		
		fin = new JLabel();
		fin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fin.setBounds(25, 16, 300, 20);

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
			id = random.nextInt(QUESTIONS_NUMB)+1;
		}while(idTable.contains(id) == true);
		
		idTable.add(id);
		
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
//				j++ car apres la première clique on va passe au question 2
				j++;
				try {	
					
				if(j <= QUESTIONS_NUMB) {
//					sending answer to server to stock it in the database
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.writeUTF(buttonGroup.getSelection().getActionCommand());
					
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.write(generateQuestion());
					
					getQuestionFromDB();
					
				}else
				{
//					sending answer to server to stock it in the database
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.writeUTF(buttonGroup.getSelection().getActionCommand());
					dataIn = new DataInputStream(etudiant.socket.getInputStream());
					int score = dataIn.read();
					JOptionPane.showMessageDialog(contentPane, "you finished the quiz! your score is: "+score+"/20");
					
					contentPane.removeAll();
					finPanel();
					id=0;
					contentPane.revalidate(); 
					contentPane.repaint();
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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 800, 400);
		
		icon = new ImageIcon(getClass().getResource("/images/ensa.jpg"));
		image = icon.getImage();
		
		usmba = new ImageIcon(getClass().getResource("/images/usmba.png"));
		imgUsmba = usmba.getImage();
		contentPane = new JPanel() 
		{
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				graphics(g);
				repaint();
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

	public void finPanel()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 89, 362, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton show = new JButton("Show All My Scores");
		show.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		show.setBackground(Color.ORANGE);
		show.setForeground(Color.WHITE);
		show.setBounds(75, 121, 210, 40);
		contentPane.add(show);
		
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tableScore();
			}
		});
		
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		exit.setBackground(Color.ORANGE);
		exit.setBounds(75, 178, 210, 40);
		contentPane.add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lab1 = new JLabel("Universit\u00E9 Sidi Mohammed Ben Abdellah");
		lab1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab1.setBounds(253, 16, 282, 20);
		contentPane.add(lab1);
		
		JLabel lab2 = new JLabel("Ecole Nationale des Sciences Appliqu\u00E9es");
		lab2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab2.setBounds(253, 32, 282, 20);
		contentPane.add(lab2);
	}

	public void tableScore()
	{
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/informatique","root","");
			 String query = "select module,score from notes WHERE etudiant='"+etudiant.nom+"'";
			 ps = connection.prepareStatement(query);
			 ResultSet result = ps.executeQuery();
			 
			 table.setModel(DbUtils.resultSetToTableModel(result));
			 
		} catch (SQLException e) {
			System.out.println("Connection failed: "+ e.getMessage());
		}
		
		
		
	}

	public void graphics(Graphics g)
	{
		 x= this.getWidth();
		 y= this.getHeight();
		g.drawImage(image, 20,10,80,50,null);
		g.drawImage(imgUsmba, x-100,10,80,50,null);//100=20+imgTaille
		g.drawLine(5, 65, x-5, 65);
		if(choix.equals("java"))
		{
			new QcmJava(g, this);
		}
		
		repaint();
		
	}
}
