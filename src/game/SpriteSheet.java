package game;

import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * Klasa w której jest pobierany konkretny obszar obrazka.
 */
public class SpriteSheet {

	/**BufferedImage*/
	private BufferedImage image;
	
	/**
	 * Konstruktor klasy SpriteSheet.
	 *
	 * @param image obrazek
	 */
	public SpriteSheet(BufferedImage image){
		this.image=image;
	}
	
	/**
	 *Dzieli du¿y obraz na kolumny i wiersze, dziêki temu mo¿emy pobraæ konkrtny obrazek wybieraj¹c kolumne i wiersz, w ktorym sie znajduje
	 *
	 * @param col kolumna
	 * @param row wiersz
	 * @param width szerokoœæ
	 * @param height wysokoœæ
	 * @return BufferedImage img obrazek
	 */
	public BufferedImage grabImage(int col, int row, int width, int height){
		BufferedImage img=image.getSubimage((col*32)-32, (row*32)-32,width, height);
		return img;
	}
}
