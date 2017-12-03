package game;

import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * Klasa konstruuj�ca  wszystkie obiekty w grze.
 */
public class GameObject {
	
	/** Zmienna okre�laj�ca wsp�rz�dna x obiektu. */
	public double x;
	/** Zmienna okre�laj�ca wsp�rz�dna y obiektu. */
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
	 * Konstrukcja obszaru jaki b�dzie zajmowa� obiekt niezale�nie od wielko�ci obrazka.
	 *
	 * @param width szeroko��
	 * @param height wysoko��
	 * @return Rectangle zwraca obszar prostokatny
	 */
	public Rectangle getBounds(int width, int height){
		return new Rectangle((int)x, (int)y, width,height);
	}

}
