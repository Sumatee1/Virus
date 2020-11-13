package javaapplication7;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class tank{
    public ImageIcon[] im = new ImageIcon[6];
    public int x;
    public int y; 
    public int count = 0;
    tank(){
        for(int i=0;i<im.length;i++){
            String imageLocation = "tank"+(i+1)+".png";
             im[i] = new ImageIcon(this.getClass().getResource(imageLocation));
           
	}
    }
    public void move(){
	this.y+=1;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,65,65));
    
}}

