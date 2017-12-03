package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Klasa Help opisuj¹ca stan kiedy wciœniêty jest przycisk HELP.
 */
public class Help extends JPanel{
	
	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 1L;
	
	/** Zmienna tworz¹ca przycisk backButton. */
	public Rectangle backButton= new Rectangle(Game.WIDTH/2-Game.WIDTH/5, (int) ( Game.HEIGHT- Game.HEIGHT/7), Game.WIDTH/2, Game.HEIGHT/9);

	/**
	 * Metoda opisuj¹ca widok w stanie HELP.
	 *
	 * @param g obiekt graficzny
	 */
	public void doDrawing(Graphics g){
	Graphics2D g2d=(Graphics2D) g; 
	
	/**Nag³ówek w stanie HELP*/
	Font fnt0= new Font("arial", Font.BOLD, (Game.WIDTH+Game.HEIGHT)/20);
	g.setFont(fnt0);
	g.setColor(Color.white);
	g.drawString("HELP", Game.WIDTH/2-(Game.WIDTH+Game.HEIGHT)/20, (Game.HEIGHT)/6);
	
	/**Napis na przycisku backButton w stanie HELP*/
	Font fnt1= new Font("arial", Font.ITALIC, (Game.WIDTH+Game.HEIGHT)/40);
	g.setFont(fnt1);
	g.drawString("BACK TO MENU", (int) (backButton.x+(Game.WIDTH+Game.HEIGHT)/40), backButton.y+(Game.WIDTH+Game.HEIGHT)/40);
	g2d.draw(backButton);
	
	g.drawString("Celem gry jest zdobycie jak najwiêkszej liczby ", Game.WIDTH/64,Game.HEIGHT/4);
	g.drawString("punktow i zabicie wszystkich przeciwnikow.", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14);
	g.drawString("Za ka¿dego przeciwnika inna liczba punktow:", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*2);
	g.drawString(Game.enemyPoints1+ " lub  "+ Game.enemyPoints2+ " lub "+Game.enemyPoints3+ " lub "+ Game.enemyPointsspecial, Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*3);
	g.drawString("Poruszanie w lewo lub w prawo za pomoc¹", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*4);
	g.drawString("klawiszy strza³ek", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*5);
	g.drawString("Strza³y klawiszem SPACJA", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*6);
	g.drawString("P-pausa", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*7);
	g.drawString("L-wznowienie gry", Game.WIDTH/64,Game.HEIGHT/4+ Game.HEIGHT/14*8);
	
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
