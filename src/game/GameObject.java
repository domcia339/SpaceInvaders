package game;

import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * Klasa konstruuj¹ca  wszystkie obiekty w grze.
 */
public class GameObject {
	
	/** Zmienna okreœlaj¹ca wspó³rzêdna x obiektu. */
	public double x;
	/** Zmienna okreœlaj¹ca wspó³rzêdna y obiektu. */
	public double y;
		
	/**
	 * Konstruktor klasy GameObject.
	 *
	 * @param x wspolrzedna
	 * @param y wspolrzedna
	 */
	public GameObject(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Konstrukcja obszaru jaki bêdzie zajmowaæ obiekt niezale¿nie od wielkoœci obrazka.
	 *
	 * @param width szerokoœæ
	 * @param height wysokoœæ
	 * @return Rectangle zwraca obszar prostokatny
	 */
	public Rectangle getBounds(int width, int height){
		return new Rectangle((int)x, (int)y, width,height);
	}

}
