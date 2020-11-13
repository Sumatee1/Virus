package javaapplication7;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class vacc extends JPanel{
    public ImageIcon[] imfire = new ImageIcon[5];
    public int y=500;
    public int x=450;
    public int count=0;
    vacc(int x,int y){
        for(int i=0;i<imfire.length;i++){
            String imageLocation = "vaccc"+(i+1)+".png";
            imfire[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y;
    }
    public void move(){
	this.y-=2;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,65,65));
    }
}
