/**
 * 
 */
package labGen;

/**
 * This is basically a tuple of integers called x and y.
 * @author Valentin "Alzaï" Pearce
 *
 */
public class Coord {

	private int x;
	private int y;
	
	public Coord (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
}
