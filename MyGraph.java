import java.util.ArrayList;

/**
 * 
 * @author Spencer Miskoviak
 * @author Duncan Fox
 * 
 * CS2321 | Data Structures | Fall 2014
 * 
 * This program implements a Graph structure
 *
 */
public class MyGraph implements Graph {

	ArrayList< Vertex > vertices = new ArrayList< Vertex >();
	ArrayList< Edge > edges = new ArrayList< Edge >();

	@Override
	/**
	 * @return a list of all vertices in the graph
	 */
	public ArrayList<Vertex> vertices() {
		return vertices;
	}

	@Override
	/**
	 * add a vertex to the graph
	 * @param p - a Pair to add to the graph
	 * @return Vertex - the vertex that was added
	 */
	public Vertex addVertex(Pair p) {

		// Create a vertex from the pair
		MyVertex temp = new MyVertex();
		temp.setElement( p );

		return addVertex( temp );
	}

	@Override
	/**
	 * add a vertex to the graph
	 * @param v - a Vertex to add to the graph
	 * @return Vertex - the vertex that was added
	 */
	public Vertex addVertex(Vertex v) {

		// Check to see if vertex already exists
		for ( Vertex ver : vertices ) {

			if ( ver.getElement().getX() == v.getElement().getX() && ver.getElement().getY() == v.getElement().getY() ) {
				return ver;
			}
		}

		vertices.add( v );
		return v;
	}

	@Override
	/**
	 * remove a vertex from the graph
	 * @param p - the Pair removed from the graph
	 * @return boolean - true if successfully removed
	 */
	public boolean removeVertex(Pair p) {

		// Find the vertex
		Vertex ver = findVertex(p);

		// Remove the vertex if it exists
		if(ver != null) {
			vertices.remove(ver);
			return true;
		}
		return false;
	}

	@Override
	/**
	 * remove a vertex from the graph
	 * @param v - the Vertex to be removed from the graph
	 * @return boolean - true if successfully removed
	 */
	public boolean removeVertex(Vertex v) {

		return removeVertex(v.getElement());
	}

	@Override
	/**
	 * find a vertex in the graph by its element
	 * @param p - the element of the vertex to find
	 */
	public Vertex findVertex(Pair p) {

		// Find the vertex
		for( Vertex ver : vertices ) {

			if ( ver.getElement().getX() == p.getX() && ver.getElement().getY() == p.getY() ) {

				// Vertex found
				return ver;
			}
		}

		// Not found
		return null;
	}

	@Override
	/**
	 * @return a list of edges in the graph
	 */
	public ArrayList<Edge> edges() {
		return edges;
	}

	@Override
	/**
	 * add an edge to a graph
	 * @param v1 - first edge vertex to add
	 * @param v2 - second edge vertex to add
	 * @return Edge - the new edge that was added
	 */
	public Edge addEdge(Vertex v1, Vertex v2) {

		// TODO: Need to make a way to make an edge & simply call addEdge(Edge e)
		return null; 
	}

	@Override
	/**
	 * add an edge to a graph
	 * @param e - edge to add to the graph
	 * @return Edge - the new edge that was added
	 */
	public Edge addEdge(Edge e) {

		// Check if the edge already exists & add it if non-existant
		Edge edge = findEdge(e.vertices().get(0), e.vertices().get(1));	
		if(edge == null) {
			edges.add(e);
		}
		return e;
	}

	@Override
	/**
	 * remove an edge from the graph
	 * @param v1 - first edge vertex to remove
	 * @param v2 - second edge vertex to remove
	 * @return boolean - true if the edge was successfully removed
	 */
	public boolean removeEdge(Vertex v1, Vertex v2) {

		// TODO: Need to make a way to make an edge & simply call removeEdge(Edge e)
		return false;
	}

	@Override
	/**
	 * remove an edge from the graph
	 * @param e - edge to remove from the graph
	 * @return boolean - true if the edge was successfully removed
	 */
	public boolean removeEdge(Edge e) {

		// Find the edge
		Edge edge = findEdge(e.vertices().get(0), e.vertices().get(1));
		if(edge != null) {
			edges.remove(e);
			return true;
		}
		return false;
	}

	@Override
	/**
	 * find an edge in the graph by its vertices
	 * @param v1 - first edge vertex to find
	 * @param v2 - second edge vertex to find
	 * @return Edge - the edge that was found
	 */
	public Edge findEdge(Vertex v1, Vertex v2) {

		// Find the edge
		for ( Edge edge : edges ) {

			// Check if the edges (p1 == v1 and p2 == v2) or (p1 == v2 and p2 == v1)
			ArrayList<Vertex> ver = edge.vertices();
			Pair p1 = ver.get(0).getElement();
			Pair p2 = ver.get(0).getElement();
			if ( ( p1.getX() == v1.getElement().getX() && p1.getY() == v1.getElement().getY() &&
					p2.getX() == v2.getElement().getX() && p2.getY() == v2.getElement().getY() ) || 
					( p2.getX() == v1.getElement().getX() && p2.getY() == v1.getElement().getY() &&
					p1.getX() == v2.getElement().getX() && p1.getY() == v2.getElement().getY() ) ) {

				return edge;
			}
		}

		return null;
	}

	@Override
	/**
	 * find if two vertices are connected
	 * @param v1 - first edge vertex to find
	 * @param v2 - second edge vertex to find
	 * @return boolean - true if two vertices are connected by an edge
	 */
	public boolean areConnected(Vertex v1, Vertex v2) {
		
		return (findEdge(v1, v2) != null);
	}

	@Override
	/**
	 * find all vertices adjacent to a vertex
	 * @param v1 - vertex to find adjacentVertices
	 * @return Vertex List - a list of all vertices that are adjacent to the given vertex
	 */
	public ArrayList<Vertex> adjacentVertices(Vertex v1) {
		
		return v1.adjacentVertices();
	}

	@Override
	/**
	 * find all edges that connect to the given vertex
	 * @param v1 - vertex to find incident edges
	 * @return Edge List - a list of all incident edges with the vertex
	 */
	public ArrayList<Edge> incidentEdges(Vertex v1) {
		
		return v1.incidentEdges();
	}

	@Override
	/**
	 * find the shortest path between to vertices
	 * @param v1 - start vertex
	 * @param v2 - finish vertex
	 * @return Vertex List - the shortest path between two vertices
	 */
	public ArrayList<Vertex> shortestPath(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * a minimum spanning tree for the graph
	 * @return Graph - a minimum spanning tree for the graph
	 */
	public Graph minimumSpanningTree() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * create a string representation of the current object state
	 * @return String - current state of the object
	 */
	public String toString() {
		return "";
	}
}
