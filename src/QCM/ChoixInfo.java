package QCM;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class ChoixInfo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private ImageIcon icon,usmba;
	private Image image,imgUsmba;
	DataOutputStream dataOut;
	Client etudiant;
	int x,y;
	
	public ChoixInfo(Client etudiant)
	{
		this.etudiant = etudiant;
		setTitle("choix de module");
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
		
		JLabel lblChoisissezUnModule = new JLabel("Choisissez un module pour Commencer l'examen: ");
		lblChoisissezUnModule.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChoisissezUnModule.setBounds(225, 109, 346, 20);
		contentPane.add(lblChoisissezUnModule);
		
		JButton javabutt = new JButton("JAVA");
		javabutt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		javabutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				envoyer le choix au serveur (studentSpace class)
				try {
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.writeUTF("java");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Qcm(etudiant,"java");
				dispose();
				
			}
		});
		javabutt.setFont(new Font("Tahoma", Font.BOLD, 16));
		javabutt.setForeground(Color.WHITE);
		javabutt.setBackground(Color.ORANGE);
		javabutt.setBounds(194, 145, 115, 29);
		contentPane.add(javabutt);
		
		JButton c = new JButton("C/C++");
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c.setForeground(Color.WHITE);
		c.setFont(new Font("Tahoma", Font.BOLD, 16));
		c.setBackground(Color.ORANGE);
		c.setBounds(334, 145, 115, 29);
		contentPane.add(c);
		
		JButton english = new JButton("English");
		english.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		english.setForeground(Color.WHITE);
		english.setFont(new Font("Tahoma", Font.BOLD, 16));
		english.setBackground(Color.ORANGE);
		english.setBounds(474, 145, 115, 29);
		contentPane.add(english);
		
		setVisible(true);
		
	}
}
