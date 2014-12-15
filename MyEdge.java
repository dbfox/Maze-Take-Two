import java.util.ArrayList;

/**
 * 
 * @author Spencer Miskoviak
 * @author Duncan Fox
 * 
 * CS2321 | Data Structures | Fall 2014
 * 
 * This program implements an Edge structure
 *
 */
public class MyEdge implements Edge {

	private int element = 0;
	private ArrayList< Vertex > vertices = new ArrayList< Vertex >();
	
	@Override
	/**
	 * 
	 */
	public int getElement() {
		return element;
	}

	@Override
	/**
	 * 
	 */
	public void setElement(int e) {
		element = e;
	}

	@Override
	/**
	 * Returns a list of the two vertices the edge connects
	 * 
	 * @return An ArrayList containing the two vertices the edge connects
	 */
	public ArrayList<Vertex> vertices() {
		return vertices;
	}

	@Override
	/**
	 * Returns a string representation of the edge
	 * 
	 * @return A visualization of the edge
	 */
	public String toString() {
		
		return "{" + vertices.get( 0 ).getElement() + "," + vertices.get( 1 ).getElement() + "}";
	}
}
