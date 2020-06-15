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
	private Connection connection;
	private PreparedStatement ps;

	public connectedStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		contentPane.setBackground(new Color(51, 102, 204));
		
		textarea = new JTextArea();
		textarea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		textarea.setBackground(Color.WHITE);
		textarea.setBounds(15, 16, 457, 263);
		textarea.setText("Connected Student :");
		
		contentPane.add(textarea);
		this.setVisible(true);

	}
}
