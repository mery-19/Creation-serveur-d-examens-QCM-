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
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class QcmJava{

	ArrayList<Integer> imgQuestion;
	ArrayList<Integer> audioQuestion;
	ImageIcon imgIcon ;
	Image img;
	int id;
	Qcm qcm;
	boolean res = false;
	
	public QcmJava(Graphics g, Qcm qcm) {
		
		this.qcm = qcm;
		
		imgQuestion = new ArrayList<Integer>();
		audioQuestion = new ArrayList<Integer>();
		
		imgQuestion.add(4);
		imgQuestion.add(5);		
		imgQuestion.add(8);
		imgQuestion.add(9);
		imgQuestion.add(10);
		imgQuestion.add(11);
		imgQuestion.add(12);
		imgQuestion.add(13);
		imgQuestion.add(18);
		imgQuestion.add(19);
		imgQuestion.add(20);
		imgQuestion.add(21);





		
		audioQuestion.add(7);
		
		id = qcm.id;
		
		if(imgQuestion.contains(id))
		{			
			imgIcon = new ImageIcon(getClass().getResource("/images/java/q"+QcmJava.this.id+".png"));
			img = imgIcon.getImage();
			g.drawImage(img,350, 100, 350, 250, null);
		}
		
		
		if(audioQuestion.contains(7))
		{
//			System.out.println("contains:"+audioQuestion.contains(id)+" / enter: id= "+id);
			if(audioQuestion.contains(id))
			{
				res = true;
				System.out.println("response: "+res);
				
			} else {
				res = false;
			}		
		}
	
	
	}

	public void audioPlay() {
		System.out.println("id = "+id);
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
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}							
			}
		});	
		}


}
