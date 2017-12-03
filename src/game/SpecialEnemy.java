package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import interfaces.EntityA;
import interfaces.EntityB;

// TODO: Auto-generated Javadoc
/**
 * Klasa SpecialEnemy opisuj�ca wysoko punktowane przeciwnika kt�ry b�dzie przleatywa� na gorze ekranu w losowym czasie.
 */
public class SpecialEnemy extends GameObject implements EntityB {
		
	/**Textures*/
	private Textures tex;
	/**Game*/
	private Game game;
	/**Controller*/
	private Controller c;
	
	/** Zmienna okre�laj�ca czy dany obiekt istnieje jeszcze w grze. */
	public boolean enemyState=true; 
	
	/** Zmienna okre�laj�ca szybko�� poruszania si� wroga.*/
	public static int vx=4;
	
	/** Zmienna okre�laj�ca kolejne przesuni�cie obiektu wzd�u� osi x. */
	private double velX=0;
	
	/** Zmienna okre�laj�ca kolejne przesuni�cie obiektu wzd�u� osi y. */
	private double velY=0;
	
	/**
	 * Konstruktor klasy Enemies.
	 *
	 * @param x wspo�rzedna
	 * @param y wspo�rzedna
	 * @param tex obrazek
	 * @param c the c
	 * @param game the game
	 */
	public SpecialEnemy(double x, double y, Textures tex, Controller c, Game game){
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.game=game;
	}
	  
	/**
	 * Metoda aktualizacji
	 */
	public synchronized void tick(){
		
		x+=vx; ///szybko�� wrog�w
		x+=velX;
		y+=velY;
		
		if(x>(Game.WIDTH)-32){
			c.RemoveEntity(this);
		}
		
		for(int i=0; i<game.ea.size();i++){

			EntityA tempEnt=game.ea.get(i);

			if(Physics.Collision(tempEnt, this)){

			c.RemoveEntity(tempEnt);
			c.RemoveEntity(this);
			game.setPoints(game.getPoints()+Game.enemyPointsspecial);
			enemyState=false;
		}
		
		}
	}

	/**
	 * Metoda od�wie�aj�ca ekran
	 *
	 * @param g obiekt graficzny
	 */
	public synchronized void render(Graphics g){
		g.drawImage(tex.specialenem, (int)x, (int)y,Game.WIDTH/20,Game.HEIGHT/15, null);
	}
	
	/**
	 * Konstrukcja obszaru jaki b�dzie zajmowa� przeciwnik niezale�nie od wielko�ci obrazka.
	 *
	 * @return Rectangle obszar prostok�tny
	 */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/20,Game.HEIGHT/15);
	}
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� x przeciwnika.
	 *
	 * @return double x wspo�rzedna
	 */
	public double getX(){
	return x;
	}

	/**
	 * Metoda zwracaj�ca wsp�rz�dn� y przeciwnika.
	 *
	 * @return double y wspo�rzedna
	 */ 
	public double getY() {
	return y;
	}
	
	/**
	 * Metoda do kolejnego przesuni�cia wzd�u� osi x gracza.
	 *
	 * @param velX zwraca wspolrzedna po przesunieciu
	 */
	public void setVelX(double velX){
	this.velX=velX;
	}
	
	/**
	 * Metoda do kolejnego przesuni�cia wzd�u� osi y gracza.
	 *
	 * @param velY zwraca wspolrzedna po przesunieciu
	 */
	public void setVelY(double velY){
	this.velY=velY;
	}
}

