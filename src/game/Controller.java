package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import interfaces.EntityA;
import interfaces.EntityB;
import interfaces.EntityC;
import interfaces.EntityHeart;


/**Klasa do kontroli obiektów przeciwnikow i ich pocisków, tu tworzona jest ca³a armia przciwnikow*/
public class Controller extends Canvas {
	
	/**Lista obiektow interfejsu A*/
	private LinkedList<EntityA> ea=new LinkedList<EntityA>();
	/**Lista obiektow interfejsu B*/
	private LinkedList<EntityB> eb=new LinkedList<EntityB>();
	/**Lista obiektow interfejsu C*/
	private LinkedList<EntityC> ec=new LinkedList<EntityC>();
	/**Lista obiektow interfejsu Heart*/
	private LinkedList<EntityHeart> eh=new LinkedList<EntityHeart>();
	
	/**Zmienna zliczj¹ca koljne poziomy, dziêki niej obni¿amy wyskoœæ poruszania siê wrogów z ka¿dym poziomem*/
	public static int licz=1;
	/**Zmienna okreœlaj¹ca wspo³rzêdn¹ x danego obiektu*/
	public double wspx;
	/**Zmienna okreœlaj¹ca wspo³rzêdn¹ y danego obiektu*/ 
	public double wspy;
	
	/**Obiekt interfejsu A*/
	EntityA enta;
	/**Obiekt interfejsu B*/
	EntityB entb;
	/**Obiekt interfejsu C*/
	EntityC entc;
	/**Obiekt interfejsu Heart*/
	EntityHeart enth;
	/**Textures*/
	private Textures tex;
	/**Game*/
	private Game game;
	/**Tablica obiektow przeciwnikow*/
	Enemies alien[][]= new Enemies[Game.sizexEnemy+100][Game.sizeyEnemy+100];
	/**Obiekt dodatkowego przeciwnika*/
	SpecialEnemy enem;
		
	/**Konstruktor klasy Controller
	 * @param tex obrazek
	 * @param game game*/
	public Controller(Textures tex, Game game){
		this.tex=tex;
		this.game=game;
		licz=0;
		createEnemy();
	}
	
	/**Metoda tworz¹ca dodatkowego przeciwnika, ktory bêdzie siê porusza³ u gory ekranu w losowym czasie*/
	public void createEnemyone(){
		addEntity(enem=new SpecialEnemy(10,50, tex, this, game));
	}
	
	/**Metoda obs³uguj¹ca losowe strza³y przeciwników, losuje przeciwnikow, od korych ma paœæ strza³*/
	public void shootEnemy(){
		
		Random generator = new Random();
		int rnd1 = generator.nextInt(Game.sizexEnemy);
		int rnd2 = generator.nextInt(Game.sizeyEnemy);
		
		if (alien[rnd1][rnd2].enemyState==true) {
		    EnemyBullet as = new EnemyBullet(alien[rnd1][rnd2].getX()+(int)(16), alien[rnd1][rnd2].getY(), tex,this,game);
			addEntity(new EnemyBullet(as.getX(), as.getY(), tex, this,game));
		}
	}
	
	/**Metoda aktualizacji*/
	public synchronized void tick(){
		if(Game.State==Game.STATE.GAME){
			move();
			//A class
		for(int i=0; i<ea.size(); i++){
			enta=ea.get(i);
			
			enta.tick();
			}
		//B class
				for(int i=0; i<eb.size(); i++){
					entb=eb.get(i);	
					entb.tick();
					}
		
				//C class
				for(int i=0; i<ec.size(); i++){
					entc=ec.get(i);	
					entc.tick();
					}
				//Heart class
				for(int i=0; i<eh.size(); i++){
					enth=eh.get(i);	
					enth.tick();
					}
		}
	}
	
	/**Metoda odœwie¿ajaca ekran
	 * @param g obiekt graficzny*/
	public synchronized void render(Graphics g){
		if(Game.State==Game.STATE.GAME){
		//A class
		for(int i=0; i<ea.size(); i++){
			enta=ea.get(i);
			
			enta.render(g);
			}
		//B class
				for(int i=0; i<eb.size(); i++){
					entb=eb.get(i);
					
					entb.render(g);
					}
				//C class
				for(int i=0; i<ec.size(); i++){
					entc=ec.get(i);
					
					entc.render(g);
					}
				//Heart class
				for(int i=0; i<eh.size(); i++){
					enth=eh.get(i);
					
					enth.render(g);
					}
		}
				
	}
	/**Metoda tworz¹ca armie przeciwników */
	public void createEnemy() {

		for(int j=0; j<Game.sizexEnemy; j++ )
		{
			addEntity(alien[j][0]=new Enemies((Game.WIDTH/80+Game.WIDTH/20)*j, 70+licz,tex.enemy1,this,game));
		}
		for(int j=0; j<Game.sizexEnemy; j++ )
		{
			addEntity(alien[j][1]=new Enemies((Game.WIDTH/80+Game.WIDTH/20)*j, 70+ (Game.HEIGHT/15+Game.HEIGHT/60)+licz,tex.enemy2,this,game));
		}
		for(int j=0; j<Game.sizexEnemy; j++ )
		{	
			for(int i=2; i<Game.sizeyEnemy; i++ )
			addEntity(alien[j][i]=new Enemies((Game.WIDTH/80+Game.WIDTH/20)*j, 70+(Game.HEIGHT/15+Game.HEIGHT/60)*i+licz,tex.enemy,this,game));
		}
		licz+=Game.downEnemies;
	}

	/**Metoda obslugujaca poruszanie sie calej armii przeciwnikow*/
	public void move(){

		for(int j=0; j<Game.sizexEnemy; j++ ){
			  for (int i = 0; i < Game.sizeyEnemy; i++) {
				  alien[j][i].setX(alien[j][i].getX()+Enemies.vx);
	          } 	
			}
	}	
	
	
	/**Pobiera wspolrzedna x obiektu
	 * @param x wspolrzedna*/
	public void mojeX(double x){
		wspx=x;
	}
	/**Zwraca wspolrzedna x obiektu
	 * @return wspx wspolrzedna obiektu*/
	public double getwspx(){
		return wspx;
	}
	/**Pobiera wspolrzedna y obiektu
	 * @param y wspolrzedna*/
	public void mojeY(double y){
		wspy=y;
	}
	/**Zwraca wspolrzedna y obiektu
	 * @return wspy wspolrzedna obiektu*/
	public double getwspy(){
		return wspy;
	}
	
	/**Metoda dodaj¹ca kolejne obiekty do listy A
	 * @param block obiekt*/
	public void addEntity(EntityA block){
		ea.add(block);
	}
	
	/**Metoda usuwaj¹ca kolejne obiekty z listy A
	 * @param block obiekt*/
	public void RemoveEntity(EntityA block){
		ea.remove(block);
	}
	
	/**Metoda dodaj¹ca kolejne obiekty do listy B
	 * @param block obiekt*/
	public void addEntity(EntityB block){
		eb.add(block);
	}
	
	/**Metoda usuwaj¹ca kolejne obiekty z listy B
	 * @param block obiekt*/
	public void RemoveEntity(EntityB block){
		eb.remove(block);
	}

	/**Metoda dodaj¹ca kolejne obiekty do listy C
	 * @param block obiekt*/
	public void addEntity(EntityC block){
		ec.add(block);
	}
	
	/**Metoda usuwaj¹ca kolejne obiekty z listy C
	 * @param block obiekt*/
	public void RemoveEntity(EntityC block){
		ec.remove(block);
	}
	
	/**Metoda dodaj¹ca kolejne obiekty do listy Heart
	 * @param block obiekt*/
	public void addEntity(EntityHeart block){
		eh.add(block);
	}
	
	/**Metoda usuwaj¹ca kolejne obiekty z listy Heart
	 * @param block obiekt*/
	public void RemoveEntity(EntityHeart block){
		eh.remove(block);
	}
	
	/**Metoda zwracaj¹ca obiekt z listy A
	 * @return LinkedList<EntityA> ea obiet interfejsu A*/
	public LinkedList<EntityA> getEntityA(){
		return ea;
	}
	
	/**Metoda zwracaj¹ca obiekt z listy B
	 *@return LinkedList<EntityB> eb obiekt interfejsu B*/
	public LinkedList<EntityB> getEntityB(){
		return eb;
	}
	/**Metoda zwracaj¹ca obiekt z listy C
	 *@return LinkedList<EntityC> ec obiekt interfejsu C*/
	public LinkedList<EntityC> getEntityC(){
		return ec;
	}
	/**Metoda zwracaj¹ca obiekt z listy Heart
	 *@return LinkedList<EntityHeart> eh obiekt interfejsu Heart*/
	public LinkedList<EntityHeart> getEntityHeart(){
		return eh;
	}
}