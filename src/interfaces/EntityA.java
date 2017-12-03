package interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * Interfejs obiektów gracza,obiekt gracza i pociski gracza.
 */
public interface EntityA {
	
	/**
	 * Metoda aktualizacji
	 */
	public void tick();
	
	/**
	 * Metoda odœwiezajaca ekran
	 *
	 * @param g the g
	 */
	public void render(Graphics g);
	
	/**
	 * Konstrukcja obszaru jaki bêdzie zajmowaæ obiekt niezale¿nie od wielkoœci obrazka.
	 *
	 * @return Rectangle obszar prostokatny
	 */
	public Rectangle getBounds();
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ x obiektu.
	 *
	 * @return the x
	 */
	public double getX();
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ y obiektu.
	 *
	 * @return the y
	 */
	public double getY();

}
