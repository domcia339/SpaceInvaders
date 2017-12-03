package interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * Interfejs obiektu przeciwnika
 */
public interface EntityB {
	
	/**
	 * Metoda aktualizacji
	 */
	public void tick();
	
	/**
	 * Metoda odœwie¿ania ekranu
	 *
	 * @param g obiekt graficzny
	 */
	public void render(Graphics g);
	
	/**
	 * Konstrukcja obszaru jaki bêdzie zajmowaæ obiekt niezale¿nie od wielkoœci obrazka.
	 *
	 * @return Rectangle obszar prostok¹tny
	 */
	public Rectangle getBounds();
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ x obiektu.
	 *
	 * @return x wspolrzedna
	 */
	public double getX();
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ y obiektu.
	 *
	 * @return y wspolrzedna
	 */
	public double getY();

}
