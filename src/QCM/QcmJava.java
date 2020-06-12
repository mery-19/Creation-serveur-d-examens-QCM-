package QCM;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class QcmJava{

	ArrayList<Integer> imgQuestion;
	ImageIcon imgIcon ;
	Image img;
	int id;
	
	public QcmJava(Graphics g, Qcm qcm) {
		
		imgQuestion = new ArrayList<Integer>();
		imgQuestion.add(4);
		imgQuestion.add(5);
		
		id = qcm.id;
		
		if(imgQuestion.contains(id))
		{			
			imgIcon = new ImageIcon(getClass().getResource("/images/q"+QcmJava.this.id+".png"));
			img = imgIcon.getImage();
			
			paint(g);
		}
	
	}
	
	public void paint(Graphics g) 
	{
		if(imgQuestion.contains(id ))
		{
			g.drawImage(img,350, 100, 350, 250, null);
			
		}
	
	}
	
	

}
