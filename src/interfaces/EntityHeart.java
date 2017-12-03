package interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

/**Interfejs obiektu spdaj¹cego serca (dodatkowe ¿ycie)*/
public interface EntityHeart {
	
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
	 * @return Reactangle obszar prostok¹tny
	 */
	public Rectangle getBounds();
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ x obiektu.
	 *
	 * @return  x wspolrzêdna
	 */
	public double getX();
	
	/**
	 * Metoda zwracaj¹ca wspó³rzêdn¹ y obiektu.
	 *
	 * @return y wspo³rzêdna
	 */
	public double getY();

}
