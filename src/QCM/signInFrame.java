package QCM;
//main class for Client

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class signInFrame extends JFrame {

	private JPanel contentPane;
	protected JTextField nom;
	private JLabel passLabel;
	protected JPasswordField passField;
	private ImageIcon icon ;
	private Image bg;
	private SignIn signin;
	private JLabel lblNewLabel;
    protected String filiere;
	protected Client client;
	

	public signInFrame(String filiere) {
		setTitle("se Conneter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		this.setLocationRelativeTo(null);
		this.filiere = filiere;
		
		icon = new ImageIcon(getClass().getResource("/images/ensaFes.jpg"));
		bg = icon.getImage();
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics e) {
				super.paintComponent(e);
				 if (bg != null)
				    {
				        int x = this.getWidth();
				        int y = this.getHeight();
				        e.drawImage(bg,0,0,x,y,this);
				        e.setColor(new Color(0,0,0,60));
				        e.fillRect(0, 0, x, y); 
				    }
				
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.requestFocusInWindow();
		
		JLabel CNELabel = new JLabel("Nom et Prénom:");
		CNELabel.setForeground(Color.WHITE);
		CNELabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		CNELabel.setBounds(157, 114, 148, 20);
		contentPane.add(CNELabel);
		
		nom = new JTextField();
		nom.setBounds(342, 112, 217, 29);
		contentPane.add(nom);
		nom.setColumns(10);
		
		passLabel = new JLabel("Password: ");
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		passLabel.setBounds(177, 153, 104, 20);
		contentPane.add(passLabel);
		
		passField = new JPasswordField();
		passField.setBounds(342, 154, 217, 29);
		contentPane.add(passField);
		
		JButton submit = new JButton("submit");
		submit.setForeground(Color.WHITE);
		submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submit.setBackground(Color.GREEN);
		submit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		//handle Buttons
		
		/*
		 *  Submit Button
		 */
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { submit(); }
		});
		submit.setBounds(342, 217, 93, 29);
		contentPane.add(submit);
		/*
		 * Cancel Button
		 */
		JButton cancel = new JButton("cancel");
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int s = JOptionPane.showConfirmDialog(contentPane, "do you want do exit?");
				if(s == 0) System.exit(0);
			}
		});
		cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		cancel.setBackground(Color.RED);
		cancel.setBounds(461, 217, 93, 29);
		contentPane.add(cancel);
		
		lblNewLabel = new JLabel("It's Examen Time , Wish you luck.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(217, 35, 371, 20);
		contentPane.add(lblNewLabel);
		
//		handle key Event
		/*
		 * Enter Press
		 */
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					submit();
				}
			}
		});
		nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					submit();
				}
			}
		});
		
		
		this.setVisible(true);

	}
	
	public void submit()
	{
		String etudiantNom = nom.getText();
		char[] p=passField.getPassword();
		String pass = new String(p);
		if(etudiantNom.equals("") || pass.equals(""))
		{
			JOptionPane.showMessageDialog(contentPane, "All the feilds are required");
		}else {
			signin = new SignIn(this);
			if(signin.res)
			{
				dispose();
//				the client will connect to the server
				client = new Client(this);
				client.start();
			}else {
				JOptionPane.showMessageDialog(contentPane, "name or Password incorrect");
			}
		}
	}
	
	
//	getter
	public String getNom()
	{
		return nom.getText();
	}
	
	
	
	
}
