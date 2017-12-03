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
	 * Metoda od�wie�ania ekranu
	 *
	 * @param g obiekt graficzny
	 */
	public void render(Graphics g);
	
	/**
	 * Konstrukcja obszaru jaki b�dzie zajmowa� obiekt niezale�nie od wielko�ci obrazka.
	 *
	 * @return Rectangle obszar prostok�tny
	 */
	public Rectangle getBounds();
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� x obiektu.
	 *
	 * @return x wspolrzedna
	 */
	public double getX();
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� y obiektu.
	 *
	 * @return y wspolrzedna
	 */
	public double getY();

}
