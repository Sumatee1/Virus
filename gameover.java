package javaapplication7;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class gameover extends JPanel{	
	private ImageIcon feildover = new ImageIcon("BG8.jpg");
	gameover(){		
		this.setLayout(null);		
	}
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(feildover.getImage(),0,0,1000,800,this);     
	  }
}
