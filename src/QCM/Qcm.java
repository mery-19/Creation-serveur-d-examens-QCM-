package QCM;

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
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Qcm extends JFrame {

	protected JPanel contentPane;
	private JRadioButton ans1,ans2,ans3,ans4;
	private JLabel question,fin,lab1,labTime;
	private ButtonGroup buttonGroup;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	protected String choix,stg;
	private Client etudiant;
	private final int QUESTIONS_NUMB = 20;
	protected int id,j=1;
	private ArrayList<Integer> idTable=new ArrayList<Integer>();
	private JButton next,play;
	private ImageIcon icon,usmba;
	private Image image,imgUsmba;
	private int i=0,minute=0,second=0;
	private QcmJava qcmJava;
	private JTable table;
	private Connection connection;
	private PreparedStatement ps;
	private Timer horloge;

	public Qcm(Client etudiant,String module) 
	{
		this.choix = module;
		this.etudiant = etudiant;

		initialize();

		horloge = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if(second != 60)
				{
					labTime.setText("the time passed "+minute+":"+second);
				}else {
					minute++;
					second = 0;
					labTime.setText("the time passed "+minute+":"+second);
				}
				second++;
				repaint();

			}
		});
		horloge.start();
		
		try {
//		for the first question
			getQuestionFromServer();
		} 
		catch (IOException e) {e.printStackTrace();}
		
//		on next press
		nextActionListner();

		this.setVisible(true);
	}
	
	public void initialize()
	{
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 800, 400);
		setTitle("QCM");
		
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
		
		lab1 = new JLabel("<html>Université Sidi Mohammed Ben Abdellah Ecole Nationale des Sciences Appliquées<html>");
		lab1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab1.setBounds(253, 16, 282, 45);
		contentPane.add(lab1);
		
		buttonGroup = new ButtonGroup();
		
		next = new JButton("Next");
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		next.setBackground(Color.orange);
		next.setBounds(25, 264, 115, 29);
		
		contentPane.setLayout(null);
		question = new JLabel();
		question.setFont(new Font("Tahoma", Font.PLAIN, 18));
		question.setBounds(25, 82, 738, 29);
		contentPane.add(question);
		
		ans1 = new JRadioButton();
		buttonGroup.add(ans1);
		ans1.setBounds(25, 134, 350, 29);
		ans1.setBackground(Color.white);
		contentPane.add(ans1);
		
		ans2 = new JRadioButton();
		buttonGroup.add(ans2);
		ans2.setBounds(25, 159, 350, 29);
		ans2.setBackground(Color.white);
		contentPane.add(ans2);

		ans3 = new JRadioButton();
		buttonGroup.add(ans3);
		ans3.setBounds(25, 184, 350, 29);
		ans3.setBackground(Color.white);
		contentPane.add(ans3);
		
		ans4 = new JRadioButton();
		buttonGroup.add(ans4);
		ans4.setBounds(25, 209, 350, 29);
		ans4.setBackground(Color.white);
		contentPane.add(ans4);
		
		labTime = new JLabel();
		labTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labTime.setBounds(25, 320, 200, 29);
		contentPane.add(labTime);

	}
	
	public int generateQuestion()
	{
		Random random= new Random();
		do {
			id = random.nextInt(30)+1;
		}while(idTable.contains(id) == true);
		idTable.add(id);
		return id;
	}
	
	public void nextActionListner()
	{
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
					
					getQuestionFromServer();
				}else
				{
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
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.writeUTF("\n the student << "+etudiant.nom+" >> had finished the exam. \n");
				}
				}catch (IOException e1) {e1.printStackTrace();}	
			}
		});
		contentPane.add(next);
	}
	
	public void getQuestionFromServer() throws IOException
	{
//		send question number to the server
		dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
		dataOut.write(generateQuestion());
		
		buttonGroup = new ButtonGroup();
		
		i++;
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		question.setText(i+ ")- "+dataIn.readUTF());
	
		stg = inputStream();
		ans1.setText(stg);
		ans1.setActionCommand(stg);
		buttonGroup.add(ans1);

		stg = inputStream();
		ans2.setText(stg);
		ans2.setActionCommand(stg);
		buttonGroup.add(ans2);

		stg = inputStream();
		ans3.setText(stg);
		ans3.setActionCommand(stg);			
		buttonGroup.add(ans3);
		
		stg = inputStream();
		ans4.setText(stg);
		ans4.setActionCommand(stg);
		buttonGroup.add(ans4);
		
		audio();	
	}

	public String inputStream() throws IOException
	{
		dataIn = new DataInputStream(etudiant.socket.getInputStream());
		String stg = dataIn.readUTF();
		
		return stg;
	}

	public void graphics(Graphics g)
	{
		int x= this.getWidth();
		int y= this.getHeight();
		g.drawImage(image, 20,10,80,50,null);
		g.drawImage(imgUsmba, x-100,10,80,50,null);//100=20+imgTaille
		g.drawLine(5, 65, x-5, 65);
		
		if(choix.equals("java"))
		{
			qcmJava = new QcmJava(g, this);
		}
		else if(choix.equals("C/C++"))
		{
			new QcmC(g,this);
		}		
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

	public void audio() {
		
		if(qcmJava!= null && qcmJava.audioQuestion.contains(id))
		{
		play = new JButton();
		play.setText("click here to play the voice");
		play.setBounds(400,150,200,100);
		play.setBackground(Color.orange);
		contentPane.add(play);
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					InputStream is = new FileInputStream(new File(qcmJava.id+".wav"));
					try {
						AudioStream as = new AudioStream(is);
						AudioPlayer.player.start(as);
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}							
			}
		});	
		} else {
			if(play != null)
			{
				play.setVisible(false);
			}
		}
	}

	public void finPanel()
	{
		fin = new JLabel();
		fin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fin.setBounds(25, 16, 300, 20);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 89, 362, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
//	    scrollPane.getViewport().setBackground(Color.orange);

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
		
		JButton exit = new JButton("<html>go to the start frame</html>");
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		exit.setBackground(Color.ORANGE);
		exit.setBounds(75, 178, 210, 40);
		contentPane.add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				dispose();
			}
		});
	
		contentPane.add(lab1);
	}

}
