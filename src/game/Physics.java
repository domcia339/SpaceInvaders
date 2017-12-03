package game;

//import java.util.LinkedList;

import interfaces.EntityA;
import interfaces.EntityB;
import interfaces.EntityC;
import interfaces.EntityHeart;

// TODO: Auto-generated Javadoc
/**
 * Klasa Physics obs³uguj¹ca kolizje obiektów.
 */
public class Physics {
	
	/**
	 * Kolizja gracza z wrogiem.
	 *
	 * @param enta obiekt interfejsu A
	 * @param entb obiekt interfejsu B
	 * @return true, if successful
	 */
	public static boolean Collision(EntityA enta, EntityB entb){
				
			if(enta.getBounds().intersects(entb.getBounds())){
				return true;
			}
		
		return false;

}	
	
/**
	 * Kolizja gracza z pociskiem wroga.
	 *
	 * @param enta obiekt interfejsu A
	 * @param entc obiekt interfejsu C
	 * @return true, if successful
	 */
public static boolean Collision(EntityA enta, EntityC entc){
	
	if(enta.getBounds().intersects(entc.getBounds())){
		return true;
	}

return false;
}
/**
 * Kolizja gracza ze spadajacym ¿yciem
 *
 * @param enta obiekt interfejsu A
 * @param enth obiekt interfejsu Heart
 * @return true, if successful
 */
public static boolean Collision(EntityA enta, EntityHeart enth){

if(enta.getBounds().intersects(enth.getBounds())){
	return true;
}

return false;
}

}
