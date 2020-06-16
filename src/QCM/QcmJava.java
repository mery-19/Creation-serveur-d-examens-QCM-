package QCM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class QcmJava{

	ArrayList<Integer> imgQuestion;
	ArrayList<Integer> audioQuestion;
	ImageIcon imgIcon ;
	Image img;
	int id;
	
	public QcmJava(Graphics g, Qcm qcm) {
		
		imgQuestion = new ArrayList<Integer>();
		audioQuestion = new ArrayList<Integer>();
		
		imgQuestion.add(4);
		imgQuestion.add(5);
		
		audioQuestion.add(7);
		
		id = qcm.id;
		
		if(imgQuestion.contains(id))
		{			
			imgIcon = new ImageIcon(getClass().getResource("/images/q"+QcmJava.this.id+".png"));
			img = imgIcon.getImage();
			
			g.drawImage(img,350, 100, 350, 250, null);
		}
		
		if(audioQuestion.contains(id))
		{
			System.out.println("contains: "+audioQuestion.contains(id)+" / enter: id= "+id);
			qcm.play = new JButton();
			qcm.play.setText("click here to play the voice");
			qcm.play.setBounds(400,150,200,100);
			qcm.play.setBackground(Color.orange);
			qcm.contentPane.add(qcm.play);
			qcm.play.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						InputStream is = new FileInputStream(new File(id+".wav"));
						try {
							AudioStream as = new AudioStream(is);
							AudioPlayer.player.start(as);
						} catch (IOException e1) {
							e1.printStackTrace();
						}	
						audioQuestion.remove(0);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
											
				}
			});	
		}
		
//		if(!audioQuestion.contains(id) && qcm.play.getParent() == qcm.contentPane)
//		{
//			qcm.contentPane.remove(qcm.play);
//			qcm.contentPane.revalidate();
//			qcm.contentPane.repaint();
//		}
	
	}
	
	public void paint(Graphics g) 
	{
	}
	
	public void audio()
	{
//		play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	}
	
	

}
