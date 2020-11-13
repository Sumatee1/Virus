package javaapplication7;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class playstate1 extends JPanel implements ActionListener{   
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("BG1.jpg"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("BG9.jpg"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("pause5.png"));
	private final ImageIcon resum = new ImageIcon(this.getClass().getResource("bt1.png"));
	private final ImageIcon back = new ImageIcon(this.getClass().getResource("backr.png"));
	tank m = new tank();
	homegames hg = new homegames();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("BG10.jpg"));
	ImageIcon img_paralyze = new ImageIcon(this.getClass().getResource("vv2.gif"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit0.png"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("h1.png"));
        JButton BStartover = new JButton(restart);
	JButton BExitover  = new JButton(exitover);
	
	private JLabel score = new JLabel(); 
        public JButton BPause  = new JButton(pause);
	public JButton BExithome  = new JButton(back); 
	public JButton Bresum  = new JButton(resum);
	public ArrayList<vacc> fireball = new ArrayList<vacc>();
	public ArrayList<virus1> v1 = new ArrayList<virus1>();
	public ArrayList<virus2> v2 = new ArrayList<virus2>();
	public ArrayList<virus3> v3 = new ArrayList<virus3>();
       // public ArrayList<virus4> v4 = new ArrayList<virus4>();
        public ArrayList<H> heart = new ArrayList<H>();
        
        
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean startball = false;
	private gameover gover = new gameover();
	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=4;
	
	Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
	
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
	Thread tv1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startball == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            v1.add(new virus1());
			}
		}
            }
	});
	Thread tv2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            v2.add(new virus2());
			}
		}
            }
	});
	
	Thread tv3 = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startball==false){
                                Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            v3.add(new virus3());
			}
		}
            }
	});
        /////////////////////////////////////////////
        
        
        /////////////////////////////////////////////
        Thread theart = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startball==false){
                                Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            heart.add(new H());
			}
		}
            }
	});
	Thread paralyze = new Thread(new Runnable(){
            public void run(){
		while (true){
			if(time_paralyze > 1){
                            paralyze1 = false;
                            time_paralyze = 0;
			}
			try{
                            Thread.sleep(10);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            }
	});
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
	
	playstate1(){
		this.setFocusable(true);
		this.setLayout(null);
		BPause.setBounds(850,100,40,40);
		BExithome.setBounds(850,30,40,40);
		Bresum.setBounds(850, 170, 40,40);
		BPause.addActionListener(this);
		BExithome.addActionListener(this);
		Bresum.addActionListener(this);
		BExithome.addActionListener(this);
		this.add(BPause);
		this.add(BExithome);
		this.add(score);
		this.add(Bresum);
		
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int q = e.getKeyCode();
			if(!paralyze1){
			    if(q==KeyEvent.VK_LEFT){
			     	m.x-=20;
                                m.count++;
                            }
                            else if(q == KeyEvent.VK_RIGHT){
                               m.x+=20;
                               m.count++;
			   }
                            if(m.count>3){
                                m.count=0;
                            }
                            else if(q == KeyEvent.VK_UP){
                               m.count=5;
			       fireball.add(new vacc(m.x,550));
			    }
			}
                    }
                    public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
		
		m.x = 400;
		time.start();
		actor.start();
		t.start();
		tv1.start();
		tv2.start();
		tv3.start();
		paralyze.start();
                theart.start();
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(times <= 0 || HP<=0){
                this.remove(BPause);
                this.remove(Bresum);
                this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
               // g.
		g.setColor(Color.WHITE);
                g.setFont(new Font("MS Sans Serif",Font.HANGING_BASELINE,40));		
                g.drawString("SCORE =  "+scor,380,400);	     
                g.setFont(new Font("MS Sans Serif",Font.HANGING_BASELINE,80));
                g.drawString("GAME OVER",380,320);
                //g.drawImage(imgmeleon.getImage(), 580, 360, 400, 400, this);
				    
            }else if(times <= 60){
                g.drawImage(imgstate2.getImage(),0,0,1000,800,this);
                if(paralyze1){
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Hobo Std",Font.BOLD,50));
                    g.drawImage(img_paralyze.getImage(), m.x, 550,100,150, this);  
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x, 550,110,160, this);
                }
   		if(m.x<0){
                    m.x=this.getWidth()-10;
   		}
   		if(m.x>this.getWidth()){
                    m.x=20;
   		}
   		for(int i=0;i<fireball.size();i++){
                    vacc ba = fireball.get(i);
      		    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,80,50, null);//
      		    ba.move();
      		    ba.count++;
      		    if(ba.y<0){
      		    	fireball.remove(i);
      		    }
   		}
 		//===========v1================
		for(int i=0 ; i<v1.size();i++){
                    g.drawImage( v1.get(i).getImage() ,v1.get(i).getX(),v1.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<v1.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),v1.get(j).getbound())){
                            v1.remove(j);
			    fireball.remove(i);
                            scor += 10;
			    g.drawString("+10",m.x+100,650);
                        } 
		    }
		}
		//===========v2================
		for(int i=0 ; i<v2.size();i++){
                    g.drawImage(v2.get(i).getImage(),v2.get(i).getX(),v2.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<v2.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),v2.get(j).getbound())){
			    v2.remove(j);
			    fireball.remove(i);
			    scor += 20;
			    g.drawString("+20",m.x+100,650);
   			} 
		    }
		}
		//===========v3================
		for(int i=0 ; i<v3.size();i++){
		    g.drawImage(v3.get(i).getImage(),v3.get(i).getX(),v3.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<v3.size();j++){
                        if(Intersect(fireball.get(i).getbound(),v3.get(j).getbound())){
                            v3.remove(j);
			    fireball.remove(i);
			    scor -=40;
			    HP=HP-3;
			    g.drawString("-2HP",m.x+100,580);
			    g.drawString("-20",m.x+100,650);
			} 
		    }
		}
                /////////////////////////////////////////////////////////
                
                //-----------------------------------------------PLUSHP
                for(int i=0 ; i<heart.size();i++){
		    g.drawImage(heart.get(i).getImage(),heart.get(i).getX(),heart.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<heart.size();j++){
                        if(Intersect(fireball.get(i).getbound(),heart.get(j).getbound())){
                            heart.remove(j);
			    fireball.remove(i);
			    scor +=0;
			    HP=HP+1;
			    g.drawString("+1HP",m.x+100,580);
			    //g.drawString("-20",m.x+100,650);
			} 
		    }
		}
                
		      ////////////////////////////////////////////////
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+scor,80, 100);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("LEVEL "+rs2,400,80);    
		g.drawString("Time "+times,450,150);
		g.drawString("HP  "+HP,100,200);
		      
            }
            ///////////////////////////L3///////////////////////
            ////////////////////////////////////////////////////////////
            else if(times <= 0 || HP<=0){
		this.remove(BPause);
		this.remove(Bresum);
		this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Sogoe Print",Font.HANGING_BASELINE,40));		
		g.drawString("SCORE   "+scor,380,400);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
		g.drawString("GAME OVER",370,320);
		//g.drawImage(imgmeleon.getImage(), 580, 360, 400, 400, this);
            }else{
                g.drawImage(imgstate1.getImage(),0,0,1000,800,this);
                if(paralyze1){
                    g.setColor(Color.RED);
                    g.setFont(new Font("Hobo Std",Font.BOLD,100));
                    g.drawImage(img_paralyze.getImage(), m.x, 550,100,150, this);
                    g.drawString("-10",m.x+100,650);
                   
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x, 550,110,160, this);
                }
		if(m.x<0){
                    m.x=this.getWidth()-10;
		}
		if(m.x>this.getWidth()){
                    m.x=20;
		}
		for(int i=0;i<fireball.size();i++){
		    vacc ba = fireball.get(i);
                    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,80,50, null);
		    ba.move();
                    ba.count++;
		    if(ba.y<0){
		    	fireball.remove(i);
		    }
		}		  
		//========================================v1================= 
                for(int i=0 ; i<v1.size();i++){
                    g.drawImage(v1.get(i).getImage(),v1.get(i).getX(),v1.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<v1.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),v1.get(j).getbound())){
			    v1.remove(j);
			    fireball.remove(i);
			    scor += 10;
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		//========================v2=========================
		for(int i=0 ; i<v2.size();i++){
		    g.drawImage(v2.get(i).getImage(),v2.get(i).getX(),v2.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<v2.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),v2.get(j).getbound())){
			    v2.remove(j);
			    fireball.remove(i);
			    scor += 20;
			    g.drawString("+10",m.x+100,650);
			 } 
		    }
		}
		//=================================v5=============
		for(int i=0 ; i<v3.size();i++){
		    g.drawImage(v3.get(i).getImage(),v3.get(i).getX(),v3.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<v3.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),v3.get(j).getbound())){
			    v3.remove(j);
			    fireball.remove(i);
			    scor -=20;
			    HP=HP-1;
			    g.drawString("-1HP",m.x+100,650);
			    g.drawString("-20",m.x+100,580);
			} 
		    }
		}
		g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawString("SCORE =  "+scor,80, 100);	     
		g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,50));
		g.drawString("LEVEL "+rs1,400,80);
		g.drawString("Time "+times,380,150);
		g.setColor(Color.RED);
		g.drawString("HP  "+HP,100,200);
		      
	    }

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startball = true;
		}else if(e.getSource() == BExitover){
                    System.exit(0);
		}		
	}
}
