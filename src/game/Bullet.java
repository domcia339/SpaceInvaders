package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import interfaces.EntityA;

/**Klasa Bullet opisuj�ca pociski gracza*/
public class Bullet extends GameObject implements EntityA
{	/**Textures*/
	private Textures tex;
	/**Controller*/
	private Controller c;
	/**Game*/
	Game game;
	/**Animacja*/
	Animation anim;
	
	/**Konstruktor klasy Bullet
	 *@param x wsp�rz�dna pocisku
	 *@param y wsp�rz�dna pocisku
	 *@param tex obrazek pocisku
	 *@param game game 
	  */
	public Bullet(double x, double y, Textures tex, Game game,Controller c){
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		anim= new Animation(Game.speedanimation, tex.missile[0], tex.missile[1], tex.missile[2]);
	}
	
	/**Metoda aktualizacji*/
	public void tick(){
		y-=6;  //szybko�� pocisku	
		anim.runAnimation();
		
		//tutaj usuwane s� obikety, ktore wysz�y po za plansze
		for(int ii=0; ii<game.ea.size();ii++){

			EntityA tempEnt=game.ea.get(ii);

			if(tempEnt.getY()<0){			
			c.RemoveEntity(tempEnt);
			}
		}
	}
	
	/**Konstrukcja obszaru jaki b�dzie zajmowa� pocisk niezale�nie od wielko�ci obrazka
	 *@return Rectangle zwraca okre�lony obszar prostokatny */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30);
	}

	/**Metoda od�wie�ajaca ekran
	*@param g obiekt graficzny*/ 
	public void render(Graphics g){
		anim.drawAnimation(g, x, y);
	}
	
	/**Metoda zwracaj�ca wsp�rz�dn� x pocisku
	*@return  x wspolrzedna pocisku*/ 
	public double getX(){
		return x;
	}
	
	/**Metoda zwracaj�ca wsp�rz�dn� y pocisku
	*@return  y wsp�rz�dna pocisku*/
	public double getY(){
		return y;
	}
}
