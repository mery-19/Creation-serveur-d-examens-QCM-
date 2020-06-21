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
			g.drawImage(img,350, 105, 360, 250, null);
		}
	
	}

}
