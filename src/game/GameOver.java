package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Klasa GameOver opisuj¹ca stan kiedy u¿ytkownik przegra grê.
 */
public class GameOver extends JPanel{
	
	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 1L;
	
	/** Zmienna tworz¹ca przycisk backButton. */
	public Rectangle backButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/5, (int) ( Game.HEIGHT- Game.HEIGHT/7), Game.WIDTH/2, Game.HEIGHT/9);

	/**
	 * Metoda opisuj¹ca widok w stanie GAMEOVER.
	 *
	 * @param g obiekt graficzny
	 */
	public void doDrawing(Graphics g){
	
		Graphics2D g2d=(Graphics2D) g; 
	
	/**Nag³ówek w stanie HELP*/
	Font fnt0= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/20);
	g.setFont(fnt0);
	g.setColor(Color.white);	
	g.drawString("GAME OVER", Game.WIDTH/2-(Game.WIDTH+Game.HEIGHT)/20, (Game.HEIGHT)/6);
	
	/**Napis na przycisku backButton w stanie GAMEOVER*/
	Font fnt1= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/40);
	g.setFont(fnt1);
	g.drawString("BACK TO MENU", (int) (backButton.x+(Game.WIDTH+Game.HEIGHT)/40), backButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(backButton);
	
	}
	
		/**
 	 * Metoda rysuj¹ca wszystko w stanie GAMEOVER.
 	 *
 	 * @param g obiekt graficzny
 	 */
	    public void paintComponent(Graphics g) {
		  
		  super.paintComponent(g);
	      doDrawing(g);
	    }


}

