package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import interfaces.EntityHeart;

/**Klasa Heart opisuj¹ca obiekt w kszta³cie serca spadaj¹cy w do³ planszy po zdobyciu konkrentej liczby punktow przez u¿ytkownika.
 * Kiedy u¿ytkownik z³apie ten obiekt zyskuje jedno ¿eycie za ka¿de z³apane serce*/
public class Heart extends GameObject implements EntityHeart
{	
	/**Textures*/
	private Textures tex;

		
	/**
	 * Konstruktor klasy Heart.
	 *
	 * @param x wspo³rzedna
	 * @param y wspo³rzedna
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
		y+=5;  //szybkoœæ	
	}
	
	/**
	 * Konstrukcja obszaru jaki bêdzie zajmowaæ obiekt niezale¿nie od wielkoœci obrazka.
	 *
	 * @return Rectangle zwraca okreslony obszar prostokatny
	 */
	public Rectangle getBounds(){
	return new Rectangle((int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30);
	}

	/**
	 * Metoda odœwie¿ania ekranu
	 *
	 * @param g obiekt graficzny
	 */ 
	public void render(Graphics g){
		g.drawImage(tex.heart, (int)x, (int)y,Game.WIDTH/40 ,Game.HEIGHT/30, null);
	}
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ y pocisku.
	 *
	 * @return double  y wspolrzedna
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ x pocisku.
	 *
	 * @return double  x wspolrzedna
	 */ 
	public double getX(){
		return x;
	}
}
