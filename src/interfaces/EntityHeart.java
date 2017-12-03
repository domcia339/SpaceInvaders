package interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

/**Interfejs obiektu spdaj�cego serca (dodatkowe �ycie)*/
public interface EntityHeart {
	
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
	 * @return Reactangle obszar prostok�tny
	 */
	public Rectangle getBounds();
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� x obiektu.
	 *
	 * @return  x wspolrz�dna
	 */
	public double getX();
	
	/**
	 * Metoda zwracaj�ca wsp�rz�dn� y obiektu.
	 *
	 * @return y wspo�rz�dna
	 */
	public double getY();

}
