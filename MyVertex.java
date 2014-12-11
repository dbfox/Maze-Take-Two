import java.util.ArrayList;

/**
 * 
 * @author Spencer Miskoviak
 * @author Duncan Fox
 * 
 * CS2321 | Data Structures | Fall 2014
 * 
 * This program implements a Vertex structure
 *
 */
public class MyVertex implements Vertex {

	ArrayList< Edge > edges = new ArrayList< Edge >();
	ArrayList< Vertex > vertices = new ArrayList< Vertex >();
	Pair xyCoord = null;
	
	@Override
	/**
	 * Returns the x,y coordinate pair that represents where the vertex
	 * is located in the graph
	 * 
	 * @return The x,y pair that identifies the vertex's position
	 */
	public Pair getElement() {
		return xyCoord;
	}

	@Override
	/**
	 * Sets the x,y coordinate pair that represents where the vertex
	 * is located in the graph
	 * 
	 * @param e The x,y pair that identifies the vertex's position
	 */
	public void setElement(Pair e) {
		xyCoord = e;
	}

	@Override
	/**
	 * Returns a list of all edges that connect to the vertex
	 * 
	 * @return An ArrayList of all edges that connect to the vertex
	 */
	public ArrayList<Edge> incidentEdges() {
		return edges;
	}

	@Override
	/**
	 * Returns a list of all vertices that share an edge with the vertex
	 * 
	 * @return An ArrayList of all vertices that share an edge with the vertex
	 */
	public ArrayList<Vertex> adjacentVertices() {
		return vertices;
	}

	@Override
	/**
	 * Returns a string representation of the vertex, including the
	 * coordinate pair that represents where it is located in a graph
	 * 
	 * @return A string representing the vertex and its position
	 */
	public String toString() {
		return "<v" + xyCoord + ">";
	}
}
