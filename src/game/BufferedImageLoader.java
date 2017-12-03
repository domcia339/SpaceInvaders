package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * Klasa do wczytywania obrazków.
 */
public class BufferedImageLoader {
	
	private BufferedImage image;
	
	/**
	 * loadImage metoda ³adowania obrazkow
	 *
	 * @param path œcie¿ka pliku
	 * @return image obrazek
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public BufferedImage loadImage(String path) throws IOException
	{
		image=ImageIO.read(getClass().getResource(path));
		return image;
	}
}
