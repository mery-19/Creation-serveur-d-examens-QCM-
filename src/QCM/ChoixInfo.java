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
import javax.swing.JTextPane;
import java.awt.SystemColor;

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
		
		JButton javabutt = new JButton();
		ImageIcon img= new ImageIcon(ChoixInfo.class.getResource("/images/java.jpg"));
		Image img1 = img.getImage() ;  
		Image newimg = img1.getScaledInstance(120, 100,  java.awt.Image.SCALE_SMOOTH ) ;
		img = new ImageIcon( newimg );
		javabutt.setIcon(img);
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
		javabutt.setBounds(167, 145, 115, 101);
		contentPane.add(javabutt);
		
		JButton c = new JButton();
		ImageIcon imgc= new ImageIcon(ChoixInfo.class.getResource("/images/c.png"));
		Image img1c = imgc.getImage() ;  
		Image newimgc = img1c.getScaledInstance(120, 100,  java.awt.Image.SCALE_SMOOTH ) ;
		imgc = new ImageIcon( newimgc );
		c.setIcon(imgc);
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c.setForeground(Color.WHITE);
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.writeUTF("C/C++");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Qcm(etudiant,"C/C++");
				dispose();
			}
		});
		c.setFont(new Font("Tahoma", Font.BOLD, 16));
		c.setBackground(Color.ORANGE);
		c.setBounds(334, 145, 115, 101);
		contentPane.add(c);
		
		JButton english = new JButton();
		ImageIcon imge= new ImageIcon(ChoixInfo.class.getResource("/images/english.jpg"));
		Image img1e = imge.getImage() ;  
		Image newimge = img1e.getScaledInstance(120, 100,  java.awt.Image.SCALE_SMOOTH ) ;
		imge = new ImageIcon( newimge );
		english.setIcon(imge);
		english.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		english.setForeground(Color.WHITE);
		english.setFont(new Font("Tahoma", Font.BOLD, 16));
		english.setBackground(Color.ORANGE);
		english.setBounds(494, 145, 115, 101);
		english.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dataOut = new DataOutputStream(etudiant.socket.getOutputStream());
					dataOut.writeUTF("english");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new Qcm(etudiant,"english");
				dispose();				
			}
		});
		contentPane.add(english);
		
		JLabel lblNewLabel = new JLabel("<html>-Instructions: </html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(42, 288, 102, 20);
		contentPane.add(lblNewLabel);
		
		JLabel text = new JLabel();
		text.setForeground(SystemColor.controlDkShadow);
		text.setText("<html>1)- Each quiz has 20 questions generated randomly.<br> 2)-Correct: +1, incorrect: +0.<br> 3)-After you finish the quiz you can see all your results.</html>");
		text.setBounds(167, 282, 404, 62);
		contentPane.add(text);
		
		setVisible(true);
		
	}
}
