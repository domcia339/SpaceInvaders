package game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import interfaces.EntityA;
import interfaces.EntityC;

// TODO: Auto-generated Javadoc
/**
 * Klasa Bullet opisuj�ca pociski gracza.
 */
public class EnemyBullet extends GameObject implements EntityC
{		
	/**Textures*/
	private Textures tex;
	/**Controller*/
	private Controller c;
	/**Game*/
	Game game;
	/**Animacja*/
	Animation anim;
	
	/**
	 * Konstruktor klasy Bullet.
	 *
	 * @param x wspo�rzedna
	 * @param y wspo�rzedna
	 * @param tex obrazek
	 * @param c controller
	 */
	public EnemyBullet(double x, double y, Textures tex,Controller c,Game game){
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		anim= new Animation(Game.speedanimation, tex.enemybullet[0], tex.enemybullet[1], tex.enemybullet[2]);
	}
	
	/**
	 * Metoda aktualizacji
	 */
	public void tick(){
		y+=5;  //szybko�� pocisku	
		anim.runAnimation();
		if(anim.getCurrentImage()==tex.enemybullet[2]){
			Game.bulletPower=2;
		}else {Game.bulletPower=1;}
		
		for(int ii=0; ii<game.ec.size();ii++){

			EntityC tempEnt=game.ec.get(ii);

			if(tempEnt.getY()>Game.HEIGHT){			
			c.RemoveEntity(tempEnt);
			}
		}
	}
	
	/**
	 * Konstrukcja obszaru jaki b�dzie zajmowa� pocisk niezale�nie od wielko�ci obrazka.
	 *
	 * @return Rectangle zwraca okreslony obszar prostokatny
	 */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30);
	}

	/**
	 * Metoda od�wiezajaca ekran
	 *
	 * @param g obiekt graficzny
	 */ 
	public void render(Graphics g){
		anim.drawAnimation(g, x, y);
	}
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� x pocisku.
	 *
	 * @return double  x wspo�rzedna
	 */ 
	public double getX(){
		return x;
	}
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� y pocisku.
	 *
	 * @return double  y wspo�rzedna
	 */
	public double getY(){
		return y;
	}
}
