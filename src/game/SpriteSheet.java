package game;

import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * Klasa w kt�rej jest pobierany konkretny obszar obrazka.
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
	 *Dzieli du�y obraz na kolumny i wiersze, dzi�ki temu mo�emy pobra� konkrtny obrazek wybieraj�c kolumne i wiersz, w ktorym sie znajduje
	 *
	 * @param col kolumna
	 * @param row wiersz
	 * @param width szeroko��
	 * @param height wysoko��
	 * @return BufferedImage img obrazek
	 */
	public BufferedImage grabImage(int col, int row, int width, int height){
		BufferedImage img=image.getSubimage((col*32)-32, (row*32)-32,width, height);
		return img;
	}
}
