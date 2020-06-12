package QCM;
// fixez la table dans la base de données (make it dynamique)

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class connectedStudent extends JFrame {

	private JPanel contentPane;
	public JTextArea textarea;
	private Socket socket;
	private JTable table;
	private Connection connection;
	private PreparedStatement ps;

	public connectedStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane.setBackground(new Color(51, 102, 204));
		
		textarea = new JTextArea();
		textarea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		textarea.setBackground(Color.WHITE);
		textarea.setBounds(15, 16, 366, 212);
		textarea.setText("Connected Student :");
		
		contentPane.add(textarea);
		
		JButton listOfStudent = new JButton("R\u00E9sultats (Actualiser)");
		listOfStudent.setBackground(Color.GREEN);
		listOfStudent.setForeground(Color.WHITE);
		listOfStudent.setFont(new Font("Tahoma", Font.BOLD, 18));
		listOfStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tableInformatique();
			}
		});
		listOfStudent.setBounds(15, 254, 366, 53);
		contentPane.add(listOfStudent);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 18, 452, 312);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		this.setVisible(true);

	}
	
	public void tableInformatique()
	{
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/informatique","root","");
			 String query = "select etudiant,score from notes";
			 ps = connection.prepareStatement(query);
			 ResultSet result = ps.executeQuery();
			 
			 table.setModel(DbUtils.resultSetToTableModel(result));
			 
		} catch (SQLException e) {
			System.out.println("Connection failed: "+ e.getMessage());
		}
		
		
		
	}
}
