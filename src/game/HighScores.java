package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Klasa Help opisuj¹ca stan kiedy wciœniêty jest przycisk HIGHSCORES, wyœwietlane tu s¹ najwy¿sze wyniki
 */
public class HighScores extends JPanel{
	
	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 1L;
	
	/** Zmienna tworz¹ca przycisk backButton. */
	public Rectangle backButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/5, (int) ( Game.HEIGHT- Game.HEIGHT/7), Game.WIDTH/2, Game.HEIGHT/9);

	/**
	 * Metoda opisuj¹ca widok w stanie HIGHSCORES
	 *
	 * @param g obiekt graficzny
	 */
	public void doDrawing(Graphics g){
	Graphics2D g2d=(Graphics2D) g; 
	
	/**Nag³ówek w stanie HIGHSCORES*/
	Font fnt0= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/20);
	g.setFont(fnt0);
	g.setColor(Color.white);
	g.drawString("High Scores", Game.WIDTH/2-(Game.WIDTH+Game.HEIGHT)/10, (Game.HEIGHT)/6);
	
	/**Napis na przycisku backButton w stanie HIGHSCORES*/
	Font fnt1= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/40);
	g.setFont(fnt1);
	g.drawString("BACK TO MENU", (int) (backButton.x+(Game.WIDTH+Game.HEIGHT)/40), backButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(backButton);
	
	Font fnt2= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/40);
	g.setFont(fnt2);
	g.setColor(Color.white);
	g.drawString("1."+ String.valueOf(Game.high1),Game.WIDTH/12 , Game.HEIGHT/4);
	
	g.drawString("2."+ String.valueOf(Game.high2),Game.WIDTH/12 , Game.HEIGHT/4+Game.HEIGHT/10);
	
	g.drawString("3."+ String.valueOf(Game.high3),Game.WIDTH/12 , Game.HEIGHT/4+2*Game.HEIGHT/10);
	
	g.drawString("4."+ String.valueOf(Game.high4),Game.WIDTH/12 , Game.HEIGHT/4+3*Game.HEIGHT/10);
	
	g.drawString("5."+ String.valueOf(Game.high5),Game.WIDTH/12 , Game.HEIGHT/4+4*Game.HEIGHT/10);
	
	}
	
		/**
 	 * Metoda rysuj¹ca wszystko w stanie HELP.
 	 *
 	 * @param g obiekt graficzny
 	 */
	    public void paintComponent(Graphics g) {
	 
		  super.paintComponent(g);
	      doDrawing(g);
	    }
}
