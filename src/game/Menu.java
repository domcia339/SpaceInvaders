package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Klasa opisuj�ca menu g��wne gry.
 */
public class Menu extends JPanel {
	
	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 1L;
	
	/** Zmienna tworz�ca przycisk backButton. */
	public Rectangle playButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/6, (int) ( Game.HEIGHT/(3.2)), Game.WIDTH/3, Game.HEIGHT/9);
	
	/** Zmienna tworz�ca przycisk helpButton. */
	public Rectangle helpButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/6, Game.HEIGHT/8+playButton.y, Game.WIDTH/3, Game.HEIGHT/9);
	
	/** Zmienna tworz�ca przycisk highScoresButton. */
	public Rectangle highScoresButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/6,helpButton.y+Game.HEIGHT/8 , Game.WIDTH/3, Game.HEIGHT/9);
	
	/** Zmienna tworz�ca przycisk quitButton. */
	public Rectangle quitButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/6, highScoresButton.y+Game.HEIGHT/8, Game.WIDTH/3, Game.HEIGHT/9);


	/**
	 * Metoda opisuj�ca widok w stanie MENU.
	 *
	 * @param g obiekt graficzny
	 */
	public void doDrawing(Graphics g){
	
	Graphics2D g2d=(Graphics2D) g; 

	
	/**Nag��wek w stanie MENU*/
	Font fnt0= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/20);
	g.setFont(fnt0);
	g.setColor(Color.white);
	g.drawString("GAME", Game.WIDTH/2-(Game.WIDTH+Game.HEIGHT)/20, (Game.HEIGHT)/6);
	
	/**Napisy na przyciskach w stanie MENU*/
	Font fnt1= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/40);
	g.setFont(fnt1);
	g.drawString("PLAY", (int) (playButton.x+(Game.WIDTH+Game.HEIGHT)/40), playButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(playButton);
	
	g.setFont(fnt1);
	g.drawString("HELP", (int) (helpButton.x+(Game.WIDTH+Game.HEIGHT)/40), helpButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(helpButton);
	
	g.setFont(fnt1);
	g.drawString("HIGH SCORES", (int) (highScoresButton.x+(Game.WIDTH+Game.HEIGHT)/40)-10, highScoresButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(highScoresButton);
	
	g.setFont(fnt1);
	g.drawString("QUIT", (int) (quitButton.x+(Game.WIDTH+Game.HEIGHT)/40), quitButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(quitButton);
	
	}
	
	/**
 	 * Metoda rysuj�ca wszystko w stanie MENU.
 	 *
 	 * @param g obiekt graficzny
 	 */
	    public void paintComponent(Graphics g) {
		  
		  super.paintComponent(g);
	      doDrawing(g);
	     
	    }
}