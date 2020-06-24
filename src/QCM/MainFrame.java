package QCM;


import professeur.*;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private ImageIcon icon,usmba;
	private Image image,imgUsmba;
	int x,y;
	
	
	public MainFrame() {
		this.setTitle("ENSA Fes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		icon = new ImageIcon(getClass().getResource("/images/ensa.jpg"));
		image = icon.getImage();
		
		usmba = new ImageIcon(getClass().getResource("/images/usmba.png"));
		imgUsmba = usmba.getImage();
		contentPane = new JPanel(){
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
		
		JLabel lblChoisissezVotreFilire = new JLabel("Choisissez Votre Fili\u00E9re :");
		lblChoisissezVotreFilire.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChoisissezVotreFilire.setBounds(297, 101, 183, 20);
		contentPane.add(lblChoisissezVotreFilire);
		
		JButton info = new JButton("G\u00C9NIE INFORMATIQUE");
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInFrame sf = new signInFrame("informatique");
				sf.nom.setText("test");
				sf.passField.setText("test");
				dispose();
			}
		});
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Tahoma", Font.BOLD, 17));
		info.setBackground(new Color(51, 102, 204));
		info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info.setBounds(266, 141, 252, 29);
		contentPane.add(info);
		
		JButton indus = new JButton("G\u00C9NIE INDUSTRIEL");
		indus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "still not coding !_!");
			}
		});
		indus.setForeground(Color.WHITE);
		indus.setFont(new Font("Tahoma", Font.BOLD, 17));
		indus.setBackground(new Color(51, 102, 204));
		indus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indus.setBounds(266, 174, 252, 29);
		contentPane.add(indus);
		
		JButton gtr = new JButton("G\u00C9NIE T\u00C9L\u00C9COM. & R\u00C9SEAUX");
		gtr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "still not coding !_!");
			}
		});
		gtr.setForeground(Color.WHITE);
		gtr.setFont(new Font("Tahoma", Font.BOLD, 17));
		gtr.setBackground(new Color(51, 102, 204));
		gtr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gtr.setBounds(266, 209, 252, 29);
		contentPane.add(gtr);
		
		JButton sys = new JButton("G\u00C9NIE SYS. EMBQ");
		sys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "still not coding !_!");
			}
		});
		sys.setForeground(Color.WHITE);
		sys.setFont(new Font("Tahoma", Font.BOLD, 17));
		sys.setBackground(new Color(51, 102, 204));
		sys.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sys.setBounds(266, 244, 252, 29);
		contentPane.add(sys);
		
		JButton meca = new JButton("G\u00C9NIE M\u00C9CA");
		meca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "still not coding !_!");
			}
		});
		meca.setForeground(Color.WHITE);
		meca.setFont(new Font("Tahoma", Font.BOLD, 17));
		meca.setBackground(new Color(51, 102, 204));
		meca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		meca.setBounds(266, 279, 252, 29);
		contentPane.add(meca);
		
		JButton cancel = new JButton("Cancel");
		cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		cancel.setBounds(664, 315, 115, 29);
		contentPane.add(cancel);
		
		JButton btnNewButton = new JButton("je suis professeur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				new EspaceProf();
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(15, 316, 218, 29);
		contentPane.add(btnNewButton);
		this.setVisible(true);
		
		
	}
	
	private JPanel contentPane;
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}
}
