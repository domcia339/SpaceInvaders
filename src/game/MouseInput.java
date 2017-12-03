package game;

//import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// TODO: Auto-generated Javadoc

/**
 * Klasa MouseInput do obs³ugi zdarzeñ myszy.
 */
public class MouseInput implements MouseListener {
	
	/**Menu*/
	Menu menu=new Menu();
	/**Help*/
	Help help=new Help();
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metoda do obs³ugi wszystkich wciœniêtych przycisków.
	 *
	 * @param e zdarzenie myszy
	 */
	public void mousePressed(MouseEvent e) {
		Menu menu=new Menu();
		Help help=new Help();

		int mx=e.getX();
		int my= e.getY();	

		//Play button
		if(mx>=menu.playButton.x && mx<=menu.playButton.x+menu.playButton.width)
		{
			if(my>=menu.playButton.y && my<=menu.playButton.y+menu.playButton.height && Game.State!=Game.STATE.GAME &&Game.State!=Game.STATE.HELP && Game.State!=Game.STATE.HIGHSCORES )
	
			{

				Game.State=Game.STATE.GAME;
				Game.lives=Game.firstlives;
				Game.points=0;
				Game.level=1;
			
			}
		}
		
		
		//HELP Button
				if(mx>menu.helpButton.x && mx<=menu.helpButton.x+menu.helpButton.width )
				{
					if(Game.State==Game.STATE.GAME){
						Game.State=Game.STATE.GAME;
					}else if(Game.State==Game.STATE.GAMEOVER){
						Game.State=Game.STATE.GAMEOVER;
					}else if(Game.State==Game.STATE.HIGHSCORES){
						Game.State=Game.STATE.HIGHSCORES;
					}else if(my>=menu.helpButton.y && my<=menu.helpButton.y+menu.helpButton.height)
					{		
						Game.State=Game.STATE.HELP; 
					}
					}
				
				
				//HighScores Button
				if(mx>=menu.highScoresButton.x && mx<=menu.highScoresButton.x+menu.highScoresButton.width)
				{
					if(Game.State==Game.STATE.GAME){
						Game.State=Game.STATE.GAME;
					}else if(Game.State==Game.STATE.GAMEOVER){
						Game.State=Game.STATE.GAMEOVER;
					}else if(Game.State==Game.STATE.HELP){
						Game.State=Game.STATE.HELP;
					}else if(my>=menu.highScoresButton.y && my<=menu.highScoresButton.y+menu.highScoresButton.height)
					{

						Game.State=Game.STATE.HIGHSCORES;	  
					}
					}
				
		
				
		//QUIT button
				if(mx>=menu.quitButton.x && mx<=menu.quitButton.x+menu.quitButton.width)
				{
					if(Game.State==Game.STATE.GAME){
						Game.State=Game.STATE.GAME;
					}else if(Game.State==Game.STATE.GAMEOVER){
						Game.State=Game.STATE.GAMEOVER;
					}else if(Game.State==Game.STATE.HIGHSCORES){
						Game.State=Game.STATE.HIGHSCORES;
					}else if(Game.State==Game.STATE.HELP){
						Game.State=Game.STATE.HELP;
					}else if(my>=menu.quitButton.y && my<=menu.quitButton.y+menu.quitButton.height)
						{
						System.exit(1);
						}
				
					}
				
				
				//back button
				if(mx>=help.backButton.x && mx<=help.backButton.x+help.backButton.width)
				{
					if(Game.State==Game.STATE.GAME){
						Game.State=Game.STATE.GAME;
					}
					else{
					if(my>=help.backButton.y && my<=help.backButton.y+help.backButton.height)
					{
						//Pressed BACK Button
						Game.State=Game.STATE.MENU;
						  
					}
					}
				}
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
