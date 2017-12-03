package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import interfaces.EntityHeart;

/**Klasa Heart opisuj�ca obiekt w kszta�cie serca spadaj�cy w do� planszy po zdobyciu konkrentej liczby punktow przez u�ytkownika.
 * Kiedy u�ytkownik z�apie ten obiekt zyskuje jedno �eycie za ka�de z�apane serce*/
public class Heart extends GameObject implements EntityHeart
{	
	/**Textures*/
	private Textures tex;

		
	/**
	 * Konstruktor klasy Heart.
	 *
	 * @param x wspo�rzedna
	 * @param y wspo�rzedna
	 * @param tex obrazek
	 * @param game game
	 */
	public Heart(double x, double y, Textures tex,Game game){
		super(x,y);
		this.tex=tex;
	}
	
	/**
	 * Metoda aktualizacji
	 */
	public void tick(){
		y+=5;  //szybko��	
	}
	
	/**
	 * Konstrukcja obszaru jaki b�dzie zajmowa� obiekt niezale�nie od wielko�ci obrazka.
	 *
	 * @return Rectangle zwraca okreslony obszar prostokatny
	 */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30);
	}

	/**
	 * Metoda od�wie�ania ekranu
	 *
	 * @param g obiekt graficzny
	 */ 
	public void render(Graphics g){
		g.drawImage(tex.heart, (int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30, null);
	}
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� y pocisku.
	 *
	 * @return double  y wspolrzedna
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� x pocisku.
	 *
	 * @return double  x wspolrzedna
	 */ 
	public double getX(){
		return x;
	}
}
