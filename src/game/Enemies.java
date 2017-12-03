package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import interfaces.EntityA;
import interfaces.EntityB;

// TODO: Auto-generated Javadoc
/**
 * Klasa Enemies opisuj¹ca przeciwników.
 */
public class Enemies extends GameObject implements EntityB {
		
	/**BufferedImage*/
	private BufferedImage im;
	/**Game*/
	private Game game;
	/**Controller*/
	private Controller c;
	
	/** Zmienna okreœlaj¹ca czy dany obiekt istnieje jeszcze w grze. */
	public boolean enemyState=true; 
	/** Zmienna okreœlaj¹ca szybkoœæ poruszania siê przeciwnikow. */
	public static int vx=Game.speed;
	/** Zmienna okreœlaj¹ca kolejne przesuniêcie przeciwnikow wzd³u¿ osi x. */
	private double velX=0;
	/** Zmienna okreœlaj¹ca kolejne przesuniêcie przeciwnikow wzd³u¿ osi y. */
	private double velY=0;
	
	/**
	 * Konstruktor klasy Enemies.
	 *
	 * @param x wspolrzedna
	 * @param y wspolrzedna
	 * @param im obrazek
	 * @param c controller
	 * @param game game
	 */
	public Enemies(double x, double y, BufferedImage im, Controller c, Game game){
		super(x,y);
		this.im=im;
		this.c=c;
		this.game=game;
	}
	  
	/**
	 * Metoda aktualizacji
	 */
	public synchronized void tick(){

		//x+=vx; ///szybkoœæ wrogów
		//x+=velX;
	//	y+=velY;

		if( x<-15){
			vx=Game.speed;
			
		}else if(x>(Game.WIDTH)-(Game.WIDTH/20))
		{
			vx=-Game.speed;
		}
			
			
		for(int ii=0; ii<game.ea.size();ii++){

			EntityA tempEnt=game.ea.get(ii);

			if(Physics.Collision(tempEnt, this)){
				
			c.mojeX(tempEnt.getX());
			c.mojeY(tempEnt.getY());			
			
			c.RemoveEntity(tempEnt);
			c.RemoveEntity(this);
			game.setEnemy_killed(game.getEnemy_killed()+1);
			
			
			for(int j=0; j<Game.sizexEnemy; j++ ){
			if(this==c.alien[j][0]){
				game.setPoints(game.getPoints()+Game.enemyPoints3);
			}
			}
			
			for(int j=0; j<Game.sizexEnemy; j++ ){
				if(this==c.alien[j][1]){
				game.setPoints(game.getPoints()+Game.enemyPoints2);
			}
				}
			
			for(int j=0; j<Game.sizexEnemy; j++ ){	
				for(int i=2; i<Game.sizeyEnemy; i++ ){
					if(this==c.alien[j][i]){
					game.setPoints(game.getPoints()+Game.enemyPoints1);
				}
				}
				}
			enemyState=false;		
		}
		
		}
	}

	/**
	 * Metoda odœwie¿aj¹ca ekran
	 *
	 * @param g obiekt graficzny
	 */
	public synchronized void render(Graphics g){
		g.drawImage(im, (int)x, (int)y,Game.WIDTH/20 ,Game.HEIGHT/15, null);

	}
	
	/**
	 * Konstrukcja obszaru jaki bêdzie zajmowaæ przeciwnik niezale¿nie od wielkoœci obrazka.
	 *
	 * @return Reactangle zwraca obszar prostokatny
	 */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/20 ,Game.HEIGHT/15);
	}
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ x przeciwnika.
	 *
	 * @return double x wspolrzedna 
	 */
	public double getX(){
	return x;
	}

	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ y przeciwnika.
	 *
	 * @return double y wspolrzedna
	 */ 
	public double getY() {
	return y;
	}
	
	/**Meotda dziêki ktorej mo¿emy zmieniæ wspo³rzêdn¹ x przeciwnikow
	 * @param x nowa wspo³rzêdna
	 * */
	public void setX(double x){
	this.x=x;
	}

	/**Meotda dziêki ktorej mo¿emy zmieniæ wspo³rzêdn¹ y przeciwnikow
	 * @param y nowa wspo³rzêdna
	 * */
	public void setY(double y){
	this.y=y;
	}
	
	/**
	 * Metoda do kolejnego przesuniêcia wzd³u¿ osi x przeciwnikow
	 *
	 * @param velX zwraca wspolrzedna po przesunieciu
	 */
	public void setVelX(double velX){
	this.velX=velX;
	}
	
	/**
	 * Metoda do kolejnego przesuniêcia wzd³u¿ osi y przeciwnikow
	 *
	 * @param velY zwraca wspolrzedna po przesunieciu
	 */
	public void setVelY(double velY){
	this.velY=velY;
	}
}
