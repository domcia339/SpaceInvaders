package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import interfaces.EntityA;

/**Klasa Bullet opisuj¹ca pociski gracza*/
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
	 *@param x wspó³rzêdna pocisku
	 *@param y wspó³rzêdna pocisku
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
		y-=6;  //szybkoœæ pocisku	
		anim.runAnimation();
		
		//tutaj usuwane s¹ obikety, ktore wysz³y po za plansze
		for(int ii=0; ii<game.ea.size();ii++){

			EntityA tempEnt=game.ea.get(ii);

			if(tempEnt.getY()<0){			
			c.RemoveEntity(tempEnt);
			}
		}
	}
	
	/**Konstrukcja obszaru jaki bêdzie zajmowaæ pocisk niezale¿nie od wielkoœci obrazka
	 *@return Rectangle zwraca okreœlony obszar prostokatny */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30);
	}

	/**Metoda odœwie¿ajaca ekran
	*@param g obiekt graficzny*/ 
	public void render(Graphics g){
		anim.drawAnimation(g, x, y);
	}
	
	/**Metoda zwracaj¹ca wspó³rzêdn¹ x pocisku
	*@return  x wspolrzedna pocisku*/ 
	public double getX(){
		return x;
	}
	
	/**Metoda zwracaj¹ca wspó³rzêdn¹ y pocisku
	*@return  y wspó³rzêdna pocisku*/
	public double getY(){
		return y;
	}
}
