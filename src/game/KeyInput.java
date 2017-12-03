package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// TODO: Auto-generated Javadoc
/**
 * Klasa KeyInput s³u¿aca do odbierania zdarzeñ klawiaturowych.
 */
public class KeyInput extends KeyAdapter{
	/**Game*/
	Game game;
	
	/**
	 * Konstruktor klasy KeyInput.
	 *
	 * @param game game
	 */
	public KeyInput(Game game){
		this.game=game;
	}
	
	/**
	 * Metoda wykrywaj¹ca zdarzenie klawiaturowe.
	 *
	 * @param e zdarzenie klawiaturowe
	 */
	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}
	
	/**
	 * Metoda realizuj¹ca ka¿de zdarzenie klawiaturowe.
	 *
	 * @param e zdarzenie klawiaturowe
	 */
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}

}
