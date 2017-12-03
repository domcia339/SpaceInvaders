package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaces.EntityA;
import interfaces.EntityB;
import interfaces.EntityC;
import interfaces.EntityHeart;

// TODO: Auto-generated Javadoc
/**
 * G³ówna klasa gry.
 */
public class Game extends Canvas implements Runnable{

	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 1L;
	static JFrame frame= new JFrame();
	/**Zmienna do zwiêkszania intensywnoœæi strza³ow przeciwnikow*/
	private float moreshoot;
	/**Zmienna okreœlajaca czy przeciwnik zostal zastrzelony*/
	private boolean drawboom=false;
	/**Zmienna okreœlajaca czy gracz zosta³ trafiony strzalem */
	private boolean drawdestroy=false;
	/**Zmienna okreœlajaca ile ¿yæ traci u¿ytkownik od danego pocisku*/
	static int bulletPower=1;
	/** Zmienna przechowuj¹ca szerokoœæ okna. */
	public static  int WIDTH;
	/** Zmienna przechowuj¹ca wysokoœæ okna. */
	public static  int HEIGHT;//WIDTH/12*9;
	/**Zmienna przechowuj¹ca pierwotna szerokosc okna*/
	private static int wid;
	/**Zmienna przechowuj¹ca pierwotna wysokosc okna*/
	private static int hei;
	/** Zmienna przechowuj¹ca tytu³ okna. */
	public String TITLE = "Space Invaders";
	/**Zmienna okreœlaj¹ca szybkosc poruszania siê wrogow*/
	public static int speed;
	/**Zmienna okreœlaj¹ca pierwotna szybkosc poruszania siê wrogow, wzglêdem niej zmieniana jest szybkoœæ w grze*/
	private static int firstspeed;
	/** Zmienna przechowuj¹ca iloœæ przeciwników sk³adowej x. */
	public static   int sizexEnemy;
	/** Zmienna przechowuj¹ca iloœæ przeciwników sk³adowej y. */
	public static  int sizeyEnemy;
	/** Zmienna przechowuj¹ca punkty zdobywane bo zabiciu wroga. */
	public static int enemyPoints1,enemyPoints2,enemyPoints3;
	/** Zmienna przechowuj¹ca punkty zdobywane po zabiciu specjalnego wroga. */
	public static int enemyPointsspecial;
	/** Zmienna dziêki której obni¿amy wyskoœæ poruszania siê wrogów. */
	public static int downEnemies;
	/** Zmienna przechowuj¹ca liczbê ¿yæ gracza. */
	public static int lives;
	/** Zmienna przechowuj¹ca pierwotna liczbê ¿yæ gracza. */
	 static int firstlives;
	/**Zmienna okreœlaj¹ca ile punktow potrzebuje gracz aby spad³o dodatkowe ¿ycie*/
	public static int heart;
	/** Zmienna przechowuj¹ca wynik zdobyty przez gracza. */
	public static String highScore="";
	/** Zmienna przechowuj¹ca wyniki z tablicy najwy¿szych wyników. */
	public static String high1,high2,high3, high4,high5;
	/** Zmienna okreœlaj¹ca czy program siê wykonujê. */
	public static boolean running=false;
	
	/**Zmienna pomocnicza okreœlaj¹ce czas wyœwietlania boom po zabiciu wroga*/
	private int time=0;
	/**Zmienna pomocnicza do wyœwietlania obrazka boom po zabiciu wroga*/
	private int count=0;
	/**Zmienna pomocnicza okreœlaj¹ce czas wyœwietlania zniszczonego pojazdu gracza*/
	private int time2=0;
	/**Zmienna pomocnicza do wyœwietlania obrazka po trafieniu gracza przez pocisk*/
	 static int count2;
	
	 /**Thread*/
	private Thread thread;
	
	/** The image. */
	private BufferedImage image=new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
	//private BufferedImage image=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);

	/**BufferedImage*/
	private static BufferedImage spriteSheet=null;
	/**BufferedImage*/
	private static BufferedImage background=null;

	/** Zmienna okreœlaj¹ca czy jest pausa. */
	private volatile boolean isPaused = false;
	/** Zmienna okreœlaj¹ca czy gracz strzela. */
	private boolean is_shooting=false;
	/** Zmienna przechowuj¹ca iloœæ wszystkich przeciwników. */
	private int enemy_count=sizexEnemy*sizeyEnemy;
	/** Zmienna licz¹ca zabitych przeciwników. */
	private int enemy_killed=0;
	/** Zmianna licz¹ca punkty. */
	public static int points=0;
	
	/** Zmienna przechowuj¹ca definicjê poziomu. */
	public static int level;
	/**Zmienna przechowujaca liczbe wszystkich mozliwych leveli*/
	public static int maxlevel;
	/**Zmienna okreœlajaca prêdkoœæ animacji pociskow gracza i wroga*/
	public static int speedanimation;

	/** Player */
	private Player p;
	
	/** Controller */
	private Controller c;
	
	/** Textures */
	private Textures tex;
	
	/**  Menu. */
	private Menu menu;
	
	/** Help. */
	private Help help;
	
	/** Gameover. */
	private GameOver gameover;
	private LastLevel lastlevel;
	
	/** Highscores. */
	private HighScores highscores;
	/**Obiekty interfejsu A*/
	public LinkedList<EntityA> ea;
	/**Obiekty interfejsu b*/
	public LinkedList<EntityB> eb;
	/**Obiekty interfejsu C*/
	public LinkedList<EntityC> ec;
	/**Obiekty interfejsu Heart*/
	public LinkedList<EntityHeart> eh;
	
	/**
	 * Stany mo¿liwe w grze.
	 */
	public static enum STATE{
		/**Menu g³owne*/
		MENU,
		/**Gra*/
		GAME,
		/**Instrukcja */
		HELP,
		/**Przegranie gry przez u¿ytkownika*/
		GAMEOVER,
		/**Lista najwy¿szych wybikow*/
		HIGHSCORES,
		/**Przejœcie wszystkich poziomow przez u¿ytkownika*/
		LASTLEVEL
	};
	
	/**Pocz¹tkowy stan gry. */
	public static STATE State=STATE.MENU;
	
	
	/**
	 * Metoda wczytuj¹ca dane konfiguracyjne z pliku tekstowego.
	 */
	public static void fileReader(){
	Properties prop = new Properties();
	InputStream input = null;

	try {
		input = new FileInputStream("plik.txt");
		prop.load(input);
		WIDTH=Integer.parseInt(prop.getProperty("WIDTH"));
		HEIGHT=Integer.parseInt(prop.getProperty("HEIGHT"));
		speed=Integer.parseInt(prop.getProperty("speed"));
		enemyPoints1=Integer.parseInt(prop.getProperty("enemyPoints1"));
		enemyPoints2=Integer.parseInt(prop.getProperty("enemyPoints2"));
		enemyPoints3=Integer.parseInt(prop.getProperty("enemyPoints3"));
		enemyPointsspecial=Integer.parseInt(prop.getProperty("enemyPointsspecial"));
		downEnemies=Integer.parseInt(prop.getProperty("downEnemies"));
		lives=Integer.parseInt(prop.getProperty("lives"));
		heart=Integer.parseInt(prop.getProperty("heart"));
		speedanimation=Integer.parseInt(prop.getProperty("speedanimation"));
		firstlives=lives;
		 wid=WIDTH;
		 hei=HEIGHT;
		 firstspeed=speed;
		
		} catch (IOException ex) {
		ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}	
	/**Metoda zliczj¹ca liczbê linii w pliku tekstowym, wykorzytywana do okreœlenia liczby poziomow znajdyjacych siê w pliku*/
	public static int countLines(File aFile) throws IOException {
	    LineNumberReader reader = null;
	    try {
	        reader = new LineNumberReader(new FileReader(aFile));
	        while ((reader.readLine()) != null){};
	        return reader.getLineNumber();
	    } catch (Exception ex) {
	        return -1;
	    } finally { 
	        if(reader != null) 
	            reader.close();
	    }
	}
	
	/**Metoda znajduj¹ca tekst potrzebny do wczytania danych levelu, zwraca numer tej linii i na tej podstawie s¹ odczytywane kolejne linie potrzebne do zdefiniowania levelu
	 * @param tekst - tekst do znalezienia w pliku (#numer_levelu)*/
	 public static void odczytLeveli(String tekst) {
		
		 double countBuffer=0,countLine=0;
		    String lineNumber = "";
		    String filePath = "levels.txt";
		    BufferedReader br;
		    String line = "";

		    try {
		        br = new BufferedReader(new FileReader(filePath));
		        try {
		            while((line = br.readLine()) != null)
		            {
		                countLine++;
		                String[] words = line.split(" ");

		                for (String word : words) {
		                  if (word.equals(tekst)) {
		                    countBuffer++;
		                  }
		                }

		                if(countBuffer > 0)
		                {
		                    countBuffer = 0;
		                    lineNumber += countLine ;
		                }

		            }
		            		          
		            br.close();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		    } catch (FileNotFoundException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    double num=Double.parseDouble((lineNumber));
		   sizexEnemy=readLine(num+1); 
		   sizeyEnemy=readLine(num+2); 
		}

/**Metoda odczytuj¹ca konkretn¹ linie z pliku
 * @param d nr linii do odczytania*/
public static int readLine(double d){
        FileReader tempFileReader = null;
        BufferedReader tempBufferedReader = null;
        try { tempFileReader = new FileReader("levels.txt"); 
        tempBufferedReader = new BufferedReader(tempFileReader);
        } catch (Exception e) { }
        String returnStr = "ERROR";
        for(int i = 0; i < d - 1; i++){
            try { tempBufferedReader.readLine(); } catch (Exception e) { }
        }
        try { returnStr = tempBufferedReader.readLine(); }  catch (Exception e) { }
  
        return Integer.parseInt(returnStr);
    }
		 
	/**Metoda do wczytywania obrazkow*/
	public static void imageReader(){
		BufferedImageLoader loader=new BufferedImageLoader();
		
		try{
			
		spriteSheet= loader.loadImage("/obraz8.png");
		background=loader.loadImage("/thief_bg.jpg");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**Metoda wczytuj¹ca tablicê najwy¿szych wynikow*/
	public static void getHighScore() {
		
		Properties prop1 = new Properties();
		InputStream input1 = null;

		try {
			input1 = new FileInputStream("highscore.txt");
			prop1.load(input1);
		
			 high1=(prop1.getProperty("1"));
			 high2=(prop1.getProperty("2"));
			 high3=(prop1.getProperty("3"));
			 high4=(prop1.getProperty("4"));
			 high5=(prop1.getProperty("5"));
			
			} catch (IOException ex) {
			ex.printStackTrace();
			} finally {
				if (input1 != null) {
					try {
					input1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metoda tworz¹ca inicjuj¹ca now¹ grê
	 */
	public void init(){
		fileReader();
		level=1;
		requestFocus(); //zeby nie trzeba by³o klikaæ na ekran aby przyciski dzia³a³y
		File file= new File("levels.txt");
		try {
			maxlevel=countLines(file)/3;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count2=lives;
		count=0;
		odczytLeveli("#"+level);
		addKeyListener(new KeyInput(this));
		tex=new Textures(this);
		c=new Controller(tex,this);
		p=new Player(WIDTH/2,HEIGHT,tex,this,c);  //ustawienie miejsca pojawienia siê obiektu

		ea=c.getEntityA();
		eb=c.getEntityB();
		ec=c.getEntityC();
		eh=c.getEntityHeart();
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
	}
	
	/**
	 * Metoda rozpoczynaj¹ca program.
	 */
	private synchronized void start(){
		if(running)
			return; 
		
		running=true;
		thread=new Thread(this);
		thread.start();
	}
	
	/**
	 * Metoda koñcz¹ca program.
	 */
	private synchronized void stop(){
		if(!running)
			return;
		
		running=false;
		try{
			thread.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	/**
	 * Metoda w interfejsu Runnable, wykonywanie programu
	 */
	public synchronized void run(){
		
		init();
		
		long lastTime=System.nanoTime();
		final double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		int updates=0;
		int frames=0;
		long timer=System.currentTimeMillis();
		int count=0;
		while(running){

			long start=System.nanoTime();
			try {
			    if (isPaused==true) {
			    	
			        synchronized (this) {
			            while (isPaused==true) {
			            	wait();
			            }
			        }
			    }
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			long stop=System.nanoTime();
		
			long now=System.nanoTime();
			delta+=(now-(stop-start)-lastTime)/ns;
			lastTime=now;
			
			
			if(delta>=1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			count++;

			if(System.currentTimeMillis()-timer>1000)
			{
				timer+=1000;
				System.out.println(updates+"Ticks, Fps"+frames);
				updates=0;
				frames=0;
			}
		}
		stop();
	}
	
	/**
	 * Metoda wznawiaj¹ca grê po wciœnieciu pausy.
	 */
	public synchronized void resumeGame() {
	    isPaused = false;
	    notify();
	}
	
	/**
	 * Metoda aktualizacji
	 */
	private synchronized void tick(){
		
		int s=0;
		
		WIDTH =frame.getContentPane().getWidth();
		HEIGHT =frame.getContentPane().getHeight();
		enemy_count=sizexEnemy*sizeyEnemy;
		if(State==STATE.GAME){

		p.tick();
		c.tick();
	
		if(Math.random()<0.04+moreshoot  ){
			c.shootEnemy();
		}
		
		if(Math.random()<0.001  ){
			c.createEnemyone();
		}
		
		if(enemy_killed>=enemy_count){
			enemy_count+=0;
			enemy_killed=0;
			level+=1;
			s=(int) (0.5*level);
			speed=firstspeed+s;
			
			if(level>maxlevel){
			State=STATE.LASTLEVEL;
			return;
			}
			
			odczytLeveli("#"+level);
			moreshoot+=0.001;
			c.createEnemy();
			
		}
		}	
		
	}
	/**
	 * Metoda odœwierzania ekranu
	 */
	private synchronized void render(){
		
		WIDTH=getWidth();
		HEIGHT=getHeight();
		//buffer strategy  
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);  
			return;
		}
		
	
		Graphics g=bs.getDrawGraphics(); 
		g.drawImage(image, 0, 0, getWidth(),getHeight(),this);
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		//g.fillRect(0,0,getWidth(),getHeight());
		//g.fillRect(0,0,1000,1000);
		g.drawImage(background,0, 0,getWidth(),getHeight(), null);
		
		if(highScore.equals("")){
			getHighScore();
			highScore=high1;
		}
		
		if(State==STATE.GAME){
			p.setY(getHeight()-(HEIGHT/15));		

				//if(wid!=WIDTH){
			for(int j=1; j<sizexEnemy; j++ )
			{	
				for(int i=0; i<sizeyEnemy; i++ ){
						c.alien[j][i].setX(c.alien[j-1][i].getX()+(Game.WIDTH/20+Game.WIDTH/80));
				}
			}
				//}else if(hei!=HEIGHT){
					for(int j=0; j<sizexEnemy; j++ )
					{	
						for(int i=1; i<sizeyEnemy; i++ ){
							c.alien[j][i].setY(c.alien[j][i-1].getY()+((Game.HEIGHT/60+Game.HEIGHT/15)));
						}
						}
				//}
		p.render(g);

		if(points>=heart){
			Random generator = new Random();
			int rnd1 = generator.nextInt(WIDTH-32);
			c.addEntity(new Heart(rnd1,0,tex,this));
			heart+=heart;
		}
		
		c.render(g);

	/*	//pasek ¿ycia
		g.setColor(Color.gray);
		g.fillRect((int) (WIDTH-WIDTH/(3.2)), 5, (int) (WIDTH/(3.2)), (int) (HEIGHT/(9.6)) );   //WYMIARY TEGO W LEWYM GÓRNYM ROGU
		//g.fillRect(WIDTH-200-sclx, 5, 200+sclx,50+scly );   //WYMIARY TEGO W LEWYM GÓRNYM ROGU
		
		g.setColor(Color.blue);
		g.fillRect((int) (WIDTH-WIDTH/(3.2)), 5, HEALTH , (int) (HEIGHT/(9.6)) );   //WYMIARY TEGO W LEWYM GÓRNYM ROGU
		//g.fillRect(WIDTH-200-sclx, 5, HEALTH+sclx,50+scly );
		
		
		g.setColor(Color.white);
		g.drawRect((int) (WIDTH-WIDTH/(3.2)), 5, (int) (WIDTH/(3.2)), (int) (HEIGHT/(9.6)) );
		//g.drawRect(WIDTH-200-sclx, 5, 200+sclx,50+scly );*/
		
		//napis Points		
		Font fnt0=new Font("arial", Font.PLAIN,(Game.WIDTH+Game.HEIGHT)/40);
		g.setFont(fnt0);
		g.setColor(Color.green);
		g.drawString("Points:"+ String.valueOf(getPoints()), 0, fnt0.getSize());
		
		
		//napis level
		Font fnt1= new Font("arial", Font.PLAIN, (Game.WIDTH+Game.HEIGHT)/40);
		g.setFont(fnt1);
		g.setColor(Color.green);
		g.drawString("Level:"+ String.valueOf(level),WIDTH/2-50 , fnt1.getSize());
		
		//napis lives
		Font fnt2= new Font("arial", Font.PLAIN, (Game.WIDTH+Game.HEIGHT)/40);
		g.setFont(fnt1);
		g.setColor(Color.green);
		g.drawString("Lives:"+ String.valueOf(lives),WIDTH-(Game.WIDTH)/6 , fnt2.getSize());
		
		
		//rysowanie boom bo zabiciu przeciwnika
		if(points>count){
			g.drawImage(tex.boom,(int) c.getwspx(), (int) c.getwspy(),Game.WIDTH/20 ,Game.HEIGHT/15, null);
			drawboom=true;
			count=points;
			time=0;
		}
		
		if(drawboom==true){
		if(time<100){
			g.drawImage(tex.boom,(int) c.getwspx(), (int) c.getwspy(),Game.WIDTH/20 ,Game.HEIGHT/15, null);
		}else {drawboom=false;}
		}
		time+=1;
		
		//rysowanie boom po trafieniu strza³em gracza
		if(lives<count2){
			g.drawImage(tex.boomplayer,(int) p.getX(), (int) p.getY(),Game.WIDTH/20 ,Game.HEIGHT/15, null);
			drawdestroy=true;
			count2=lives;
			time2=0;
		}
		
		if(drawdestroy==true){
		if(time2<100){
			g.drawImage(tex.boomplayer,(int)  p.getX(), (int) p.getY()-15,Game.WIDTH/20 ,Game.HEIGHT/15, null);
		}else {drawdestroy=false;}
		}
		time2+=1;
		
		
		}else if(State==STATE.MENU){
			menu=new Menu();
			menu.doDrawing(g);
		
		}else if(State==STATE.HELP){
			help=new Help();
			help.doDrawing(g);
		        
		}else if(State==STATE.GAMEOVER){
			CheckScore();
			gameover=new GameOver();
			gameover.doDrawing(g);
            time=0;
            time2=0;
            drawdestroy=false;
            drawboom=false;
			ea.clear();
			eb.clear();
			ec.clear();
			enemy_killed=0;
			init();
		}else if(State==STATE.HIGHSCORES){
			highscores=new HighScores();
			highscores.doDrawing(g);
		}else if(State==STATE.LASTLEVEL){
			CheckScore();
			lastlevel=new LastLevel();
			lastlevel.doDrawing(g);
            time=0;
            time2=0;
            drawdestroy=false;
            drawboom=false;
			ea.clear();
			eb.clear();
			ec.clear();
			enemy_killed=0;
			init();
		}
		wid=getWidth();
		hei=getHeight();
		
		
		g.dispose();
		bs.show();
	}
	
	/**Metoda porównuj¹ca wynik osi¹gnêty przez gracza z tymi znajduj¹cymi siê w tablicy wyników, po sprawdzeniu wynik gracza jest porz¹dkowany wraz z tymi istniej¹cymi*/
	public  void CheckScore(){
		
		if(highScore.equals(""))
			return;
		if(points> Integer.parseInt(high5.split(":")[1])){
			//user has set new record
			String name= JOptionPane.showInputDialog("Whast is your name?");
			highScore=name+":"+points;
			
			File scoreFile=new File("highscore.txt");
			if(!scoreFile.exists()){
				try{
					scoreFile.createNewFile();
					
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
			FileWriter writeFile=null;
			BufferedWriter writer=null;
			try{
				writeFile= new FileWriter(scoreFile);
				writer= new BufferedWriter(writeFile);
				if(points>Integer.parseInt(high1.split(":")[1])){
					high5=high4;
					high4=high3;
					high3=high2;
					high2=high1;
					high1=highScore;
				writer.write("1="+highScore+System.lineSeparator()+"2="+high2+System.lineSeparator()+"3="+high3+System.lineSeparator()+"4="+high4+System.lineSeparator()+"5="+high5+System.lineSeparator());
				}else if(points>Integer.parseInt(high2.split(":")[1])){
					high5=high4;
					high4=high3;
					high3=high2;
					high2=highScore;
				writer.write("1="+high1+System.lineSeparator()+"2="+highScore+System.lineSeparator()+"3="+high3+System.lineSeparator()+"4="+high4+System.lineSeparator()+"5="+high5+System.lineSeparator());
				}else if(points>Integer.parseInt(high3.split(":")[1])){
					high5=high4;
					high4=high3;
					high3=highScore;
				writer.write("1="+high1+System.lineSeparator()+"2="+high2+System.lineSeparator()+"3="+highScore+System.lineSeparator()+"4="+high4+System.lineSeparator()+"5="+high5+System.lineSeparator());
				}else if(points>Integer.parseInt(high4.split(":")[1])){
					high5=high4;
					high4=highScore;
				writer.write("1="+high1+System.lineSeparator()+"2="+high2+System.lineSeparator()+"3="+high3+System.lineSeparator()+"4="+highScore+System.lineSeparator()+"5="+high5+System.lineSeparator());
				}else if(points>Integer.parseInt(high5.split(":")[1])){
					high5=highScore;
				writer.write("1="+high1+System.lineSeparator()+"2="+high2+System.lineSeparator()+"3="+high3+System.lineSeparator()+"4="+high4+System.lineSeparator()+"5="+high5+System.lineSeparator());
				}
				
				
			}catch(Exception e){
				
			}
			finally{
				try{
				if(writer!=null){
					writer.close();
					}
					}catch(Exception e){
						
					}
			}
			points=0;
			return;
		}
	}

	/**
	 * Meotda obs³uguj¹ca wciœniêcia przycisków klawiatury.
	 *
	 * @param e zdarzenie klawiaturowe
	 */
	public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			
			if(State==STATE.GAME){
				
			if(key==KeyEvent.VK_RIGHT){
				p.setVelX(5);
			} else if(key==KeyEvent.VK_LEFT){
				p.setVelX(-5);
			} else if(key==KeyEvent.VK_SPACE&& !is_shooting){
				is_shooting=true;
				c.addEntity(new Bullet(p.getX(),p.getY(),tex,this,c));
			}else if(key==KeyEvent.VK_P){
				isPaused = true;
			}else if(key==KeyEvent.VK_L){
				if(isPaused==true){
				isPaused = false;
				resumeGame();
				}
			}else if(key==KeyEvent.VK_ESCAPE){
				System.exit(1);
			}
			}
			
	}
		
		/**
		 * Meotda realizuj¹ca kolejne wciœniêcia przycisków, dziêki niej dany przycisk mo¿e byæ wciœniêty kilka razy.
		 *
		 * @param e zdarzenie klawiaturowe
		 */
		
	/**Metoda obs³uguj¹ca zdarzenia klawiturowe*/
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_RIGHT){
			p.setVelX(0);
		} else if(key==KeyEvent.VK_LEFT){
			p.setVelX(0);
		} else if(key==KeyEvent.VK_SPACE){
			is_shooting=false;
		}
		
	}
	
	/**
	 * Main gry.
	 *
	 * @param args argumenty
	 */
	public static void main(String args[]){
		
		fileReader();
		imageReader();
		
		Game game=new Game();
		
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//game.setMaximumSize(new Dimension(WIDTH* SCALE, HEIGHT*SCALE));
		//game.setMinimumSize(new Dimension(WIDTH* SCALE, HEIGHT*SCALE));
       
		//JFrame frame= new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.repaint();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
		
	}
	

	/**
	 * Metoda zwracaj¹ca zmienn¹ przchowuj¹ca obrazek z postaciami gry.
	 *
	 * @return spriteSheet
	 */
	public BufferedImage getSpriteSheet(){
	return spriteSheet;
	}
	
	/**
	 * Metoda zwracaj¹ca liczbê przeciwników.
	 *
	 * @return int enemy_count liczba przeciwnikow
	 */
	public int getEnemy_count() {
	return enemy_count;
	}

	/**
	 * Metoda zliczaj¹ca liczbê przeciwników.
	 *
	 * @param enemy_count liczba przeciwnikow
	 */
	public void setEnemy_count(int enemy_count) {
	this.enemy_count = enemy_count;
	}

	/**
	 * Metoda zwracaj¹ca liczbê zabitych przeciwników.
	 *
	 * @return int enemy_killed zabici przeciwnicy
	 */
	public int getEnemy_killed() {
	return enemy_killed;
	}

	/**
	 * Metoda zliczaj¹ca liczbê zabitych przeciwników.
	 *
	 * @param enemy_killed zabici przeciwnicy
	 */
	public void setEnemy_killed(int enemy_killed) {
	this.enemy_killed = enemy_killed;
	}
	
	/**
	 * Metoda zwracaj¹ca liczbê punktów.
	 *
	 * @return int points punkty zdobyte przez gracza
	 */
	public int getPoints() {
	return points;
	}

	/**
	 * Metoda zliczaj¹ca punkty.
	 *
	 * @param points punkty zdobyte przez gracza
	 */
	public void setPoints(int points) {
	this.points = points;
	}
		
}
