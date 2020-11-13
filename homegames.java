package javaapplication7;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class homegames extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("gif3.gif"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit0.png"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("play11.jpg"));
	public JButton BStart = new JButton(starts);
	public JButton BExit1  = new JButton(exit);
	homegames(){
            setLayout(null);
            BExit1.setBounds(870,600, 82,82);
            add(BExit1);
            add(BStart);
            BStart.setBounds(460,620,120,50);
            add(BStart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
            
	}
}