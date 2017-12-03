package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**Klasa do animacji obiektów- obiekty zmieniaj¹ kolory */
public class Animation {

	/**Zmienna okreœlaj¹ca prêdkoœæ animacji*/
	private int speed;
	/**Zmienna okreœlaj¹ca liczbê obrazków do animacji*/
	private int frames;
	/**Zmienna okreœlaj¹ca czas kiedy ma nast¹piæ zmiana obrazka animacji*/
	private int index = 0;
	/**Zmienna pomocnicza do zmiany kolejnego obrazka animacji*/
	private int count = 0;
	/**pierwszy obrazek animacji*/
	private BufferedImage img1;
	/**drugi obrazek animacji*/
	private BufferedImage img2;
	/**trzeci obrazek animacji*/
	private BufferedImage img3;
	/**aktualny obrazek animacji*/
	private BufferedImage currentImg;
	
	/**Konstruktor klasy Animation
	 * @param speed prêdkoœæ animacji
	 * @param img1 pierwszy obrazek animacji
	 * @param img2 drugi obrazek animacji
	 * @param img3 trzeci obrazek animacji*/
	public Animation(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3){
		this.speed = speed;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		frames = 3;
	}
	
	/**Metoda do przebiegu ca³ej animacji*/
	public void runAnimation(){
		index++;
		if(index > speed){
			index = 0;
			nextFrame();
		}	
	}
	
	/**Metoda do prze³¹cznia kolejnych obrazków animacji*/
	public void nextFrame(){
				
			if(count == 0)
				currentImg = img1;
			if(count == 1)
				currentImg = img2;
			if(count == 2)
				currentImg = img3;
			
			count++;
			
			if(count > frames)
				count = 0;		
	}
	
	/**Meotda rysuj¹ca obrazki animacji
	 * @param g obiekt graficzny
	 * @param x wspo³rzêdna 
	 * @param y wspolrzedna*/
	public void drawAnimation(Graphics g, double x, double y){
		g.drawImage(currentImg, (int)x , (int)y,Game.WIDTH/40 ,Game.HEIGHT/30,null);
	}
	
	/**Meotoda zwaracaj¹ca bie¿acy obrazek animacji, ten ktory aktualnie jest wyœwietlany*/
	public BufferedImage getCurrentImage(){
		return currentImg;
	}
	
}