
/**
 * 
 * @author Spencer Miskoviak
 * @author Duncan Fox
 * 
 * CS2321 | Data Structures | Fall 2014
 * 
 * This program implements a stored pair of coordinates
 *
 */
public class MyPair implements Pair {

	private int x = 0;
	private int y = 0;
	
	@Override
	/**
	 * Returns the x value of the (x,y) pair
	 * 
	 * @return The x axis position of the coordinate pair
	 */
	public int getX() {
		return x;
	}

	@Override
	/**
	 * Sets the x value of the (x,y) pair
	 * 
	 * @param newVal The x axis position of the coordinate pair
	 */
	public void setX(int newVal) {
		x = newVal;
	}

	@Override
	/**
	 * Returns the y value of the (x,y) pair
	 * 
	 * @return The y axis position of the coordinate pair
	 */
	public int getY() {
		return y;
	}

	@Override
	/**
	 * Sets the y value of the (x,y) pair
	 * 
	 * @param newVal The y axis position of the coordinate pair
	 */
	public void setY(int newVal) {
		y = newVal;
	}

	@Override
	/**
	 * Returns a string representation of the coordinate pair
	 * 
	 * @return A string containing the x and y axis positions
	 * 		   of the coordinate pair
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
