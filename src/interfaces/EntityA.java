package interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * Interfejs obiekt�w gracza,obiekt gracza i pociski gracza.
 */
public interface EntityA {
	
	/**
	 * Metoda aktualizacji
	 */
	public void tick();
	
	/**
	 * Metoda od�wiezajaca ekran
	 *
	 * @param g the g
	 */
	public void render(Graphics g);
	
	/**
	 * Konstrukcja obszaru jaki b�dzie zajmowa� obiekt niezale�nie od wielko�ci obrazka.
	 *
	 * @return Rectangle obszar prostokatny
	 */
	public Rectangle getBounds();
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� x obiektu.
	 *
	 * @return the x
	 */
	public double getX();
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� y obiektu.
	 *
	 * @return the y
	 */
	public double getY();

}
