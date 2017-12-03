package game;


import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
//trzyma wrogów i graczy
/**
 * Klasa przechowuj¹ca obrazki obiektów gry.
 */
public class Textures {
	
	/**Nazwy konkretnych obrazkow*/
	public BufferedImage  player, enemy,enemy2,enemy1,specialenem,boom, heart, boomplayer;
	/**Obrazki pociskow gracza*/
	public BufferedImage missile[]= new BufferedImage[3];
	/**Obrazki pociskow przeciwnikow*/
	public BufferedImage enemybullet[]= new BufferedImage[3];
	/**SpriteSheet*/
	private SpriteSheet ss;
	
	/**
	 * Konstruktor klasy Textures.
	 *
	 * @param game the game
	 */
	public Textures(Game game){
		 ss=new SpriteSheet(game.getSpriteSheet()); //
		 getTextures();
	}
	
	/**
	 * Metoda przechowuj¹ca obrazki obiektów.
	 */
	private void getTextures(){
		player=ss.grabImage(1, 1, 32, 32);
		
		missile[0]=ss.grabImage(2, 1, 32, 32);
		missile[1]=ss.grabImage(2, 2, 32, 32);
		missile[2]=ss.grabImage(2, 3, 32, 32);
		
		enemybullet[0]=ss.grabImage(4, 1, 32, 32);
		enemybullet[1]=ss.grabImage(4, 2, 32, 32);
		enemybullet[2]=ss.grabImage(4, 3, 32, 32);
		
		enemy=ss.grabImage(3, 1, 32, 32);
		enemy1=ss.grabImage(3, 2, 32, 32);
		enemy2=ss.grabImage(3, 3, 32, 32);
		specialenem=ss.grabImage(3, 4, 32, 32);
		boom=ss.grabImage(5, 1, 32, 32);
		boomplayer=ss.grabImage(5, 2, 32, 32);
		heart=ss.grabImage(1, 2, 32, 32);
	}

}
