package professeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class EspaceProf extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon,usmba;
	private Image image,imgUsmba;
	private int x,y;
	private JTextField nomProfesseur;
	private JTextField qcm;
	JLabel lblQcm;
	JLabel nom;
	JButton search;
	private JTable table;
	private Professeur prof;
	private Connection connection;
	private PreparedStatement ps;

	public EspaceProf() {
		
		initialiser();
		
		this.setVisible(true);
	}

	public void initialiser()
	{
		setTitle("Espace Professeur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		this.setLocationRelativeTo(null);
		
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
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lab1 = new JLabel("Universit\u00E9 Sidi Mohammed Ben Abdellah");
		lab1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab1.setBounds(253, 16, 282, 20);
		contentPane.add(lab1);
		
		JLabel lab2 = new JLabel("Ecole Nationale des Sciences Appliqu\u00E9es");
		lab2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lab2.setBounds(253, 32, 282, 20);
		contentPane.add(lab2);
		
		nomProfesseur = new JTextField();
		nomProfesseur.setBounds(91, 154, 167, 26);
		contentPane.add(nomProfesseur);
		nomProfesseur.setColumns(10);
		
		qcm = new JTextField();
		qcm.setColumns(10);
		qcm.setBounds(91, 196, 167, 26);
		contentPane.add(qcm);
		
		nom = new JLabel("Name:");
		nom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		nom.setForeground(Color.ORANGE);
		nom.setBounds(15, 156, 69, 20);
		contentPane.add(nom);
		
		lblQcm = new JLabel("QCM: ");
		lblQcm.setForeground(Color.ORANGE);
		lblQcm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblQcm.setBounds(15, 198, 69, 20);
		contentPane.add(lblQcm);
		
		search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		search.setBackground(Color.ORANGE);
		search.setForeground(Color.WHITE);
		search.setBounds(91, 245, 115, 29);
		contentPane.add(search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 97, 451, 217);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Chercher les notes des \u00E9tudiants: </html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(15, 95, 255, 43);
		contentPane.add(lblNewLabel_1);
		
		searchClick();
	}
	
	public void searchClick()
	{
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prof = new Professeur(nomProfesseur.getText());
				if(prof.liste.contains(qcm.getText()))
				{
					System.out.println("the text exist");
					tableScore();
				}
				
			}
		});
		
	}
	
	public void tableScore()
	{
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+prof.filiere,"root","");
			 String query = "select etudiant,score from notes WHERE module='"+qcm.getText() +"'";
			 ps = connection.prepareStatement(query);
			 ResultSet result = ps.executeQuery();
			 
			 table.setModel(DbUtils.resultSetToTableModel(result));
			 
		} catch (SQLException e) {
			System.out.println("Connection failed: "+ e.getMessage());
		}
	}
}
