package game;

//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import interfaces.EntityA;
import interfaces.EntityB;
import interfaces.EntityC;
import interfaces.EntityHeart;

// TODO: Auto-generated Javadoc
/**
 * Klasa Player opisuj¹ca gracza.
 */
public class Player extends GameObject implements EntityA{


	/** Zmienna okreœlaj¹ca kolejne przesuniêcie gracza wzd³u¿ osi x. */
	private double velX=0;
	
	/** Zmienna okreœlaj¹ca kolejne przesuniêcie gracza wzd³u¿ osi y. */
	private double velY=0;
	/**Game*/
	Game game;	
	/**Controller*/
	Controller controller;
	/**Textures*/
	private Textures tex;

	/**
	 * Konstruktor klasy Player.
	 *
	 * @param x wspo³rzedna
	 * @param y wspo³rzedna
	 * @param tex obrazek
	 * @param game the game
	 * @param controller the controller
	 */
	public Player(double x, double y,Textures tex, Game game, Controller controller){
		super(x,y);
		this.tex=tex;
		this.game=game;
		this.controller=controller;
	}

	/**
	 * Metoda aktualizacji
	 */
	public void tick(){
		x+=velX;
		y+=velY;
		
		if(x<=0)
			x=0;
		if(x>=Game.WIDTH-20)
			x=Game.WIDTH-20;
		if(y<=0)
			y=0;
		if(y>=Game.HEIGHT-32)
			y=Game.HEIGHT-32;
		
		//Sprawdzenie kolozji wroga z graczem
		for(int i=0;i<game.eb.size(); i++ ){
			EntityB tempEnt=game.eb.get(i);
			
			if(Physics.Collision(this, tempEnt)){
				controller.RemoveEntity(tempEnt);
				Game.lives-=1;
				if(Game.lives<= 0)
				{
					Game.State=Game.STATE.GAMEOVER;

				}
				game.setEnemy_killed(game.getEnemy_killed()+1);
			}
		}
		//sprawdzenie kolocji pocisku wroga z graczem
			for(int i=0;i<game.ec.size(); i++ ){
				EntityC tempEntc=game.ec.get(i);
				
				if(Physics.Collision(this, tempEntc)){
					
					controller.RemoveEntity(tempEntc);
					Game.lives-=Game.bulletPower;
					if(Game.lives<= 0)
					{
						Game.State=Game.STATE.GAMEOVER;
						}
				}
		}
			//spawdzenie kolozji z spadajacym serecm
			for(int i=0;i<game.eh.size(); i++ ){
				EntityHeart heart=game.eh.get(i);
				
				if(Physics.Collision(this, heart)){
					controller.RemoveEntity(heart);
					Game.lives+=1;
					Game.count2+=1;
				}
		}
	}
	
	
	/**
	 * Konstrukcja obszaru jaki bêdzie zajmowaæ pocisk niezale¿nie od wielkoœci obrazka.
	 *
	 * @return Rectangle obszar prostok¹tny
	 */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/20 ,Game.HEIGHT/15);
	}
	
	/**
	 * Metoda odœwie¿ajaca ekran
	 *
	 * @param g obiekt graficzny
	 */
	public void render(Graphics g){	
		g.drawImage(tex.player, (int)x,(int)y,Game.WIDTH/20 ,Game.HEIGHT/15, null);

	}

	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ x gracza.
	 *
	 * @return x wspo³rzêdna
	 */
	public double getX(){
	return x;
	}

	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ y gracza.
	 *
	 * @return y wspolrzedna
	 */
	public double getY(){
	return y;	
	}

	/**Meotda dziêki ktorej mo¿emy zmieniæ wspo³rzêdn¹ x gracza 
	 * @param x nowa wspo³rzêdna
	 * */
	public void setX(double x){
	this.x=x;
	}

	/**Meotda dziêki ktorej mo¿emy zmieniæ wspo³rzêdn¹ y gracza 
	 * @param y nowa wspo³rzêdna
	 * */
	public void setY(double y){
	this.y=y;
	}
	
	/**
 * Metoda do kolejnego przesuniêcia wzd³u¿ osi x gracza.
 *
 * @param velX nowa wspo³rzêdna x
 */
	public void setVelX(double velX){
	this.velX=velX;
	}
	
	/**
	 * Metoda do kolejnego przesuniêcia wzd³u¿ osi y gracza.
	 *
	 * @param velY nowa wspo³rzêdna y
	 */
	public void setVelY(double velY){
	this.velY=velY;
	}

}
