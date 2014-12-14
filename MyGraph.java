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

			if ( ver.getElement().getX() == v.getElement().getX() && 
					ver.getElement().getY() == v.getElement().getY() ) {
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

			// Remove adjacent vertices and incident edges appropriately
			for ( Edge e1 : ver.incidentEdges() ) {

				e1.vertices().remove( ver );

				Vertex v1 = e1.vertices().get( 0 );
				v1.incidentEdges().remove( e1 );
				v1.adjacentVertices().remove( ver );

				edges.remove( e1 );
			}

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

		// Create new edge
		Edge edge = new MyEdge();

		edge.vertices().add( v1 );
		edge.vertices().add( v2 );

		// Add edge
		return addEdge( edge );
	}

	@Override
	/**
	 * add an edge to a graph
	 * @param e - edge to add to the graph
	 * @return Edge - the new edge that was added
	 */
	public Edge addEdge(Edge e) {

		// Make sure graph contains both vertices
		if ( vertices.contains( e.vertices().get( 0 ) ) && vertices.contains( e.vertices().get( 1 ) ) ) {

			// Check if the edge already exists & add it if non-existant
			Edge edge = findEdge(e.vertices().get(0), e.vertices().get(1));	
			if( edge == null ) {
				edges.add(e);

				// Add vertices and edge to adjacent vertices and incident edges lists
				e.vertices().get( 0 ).adjacentVertices().add( e.vertices().get( 1 ) );
				e.vertices().get( 0 ).incidentEdges().add( e );
				e.vertices().get( 1 ).adjacentVertices().add( e.vertices().get( 0 ) );
				e.vertices().get( 1 ).incidentEdges().add( e );

				return e;
			} else {
				return edge;
			}
		}
		// If vertices did not exist
		return null;
	}

	@Override
	/**
	 * remove an edge from the graph
	 * @param v1 - first edge vertex to remove
	 * @param v2 - second edge vertex to remove
	 * @return boolean - true if the edge was successfully removed
	 */
	public boolean removeEdge(Vertex v1, Vertex v2) {

		// Create new edge
		Edge edge = new MyEdge();

		edge.vertices().add( v1 );
		edge.vertices().add( v2 );

		// Remove edge
		return removeEdge( edge );
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
			edges.remove(edge);

			// Remove adjacent vertices and incident edges appropriately
			e.vertices().get( 0 ).adjacentVertices().remove( e.vertices().get( 1 ) );
			e.vertices().get( 0 ).incidentEdges().remove( edge );
			e.vertices().get( 1 ).adjacentVertices().remove( e.vertices().get( 0 ) );
			e.vertices().get( 1 ).incidentEdges().remove( edge );

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
			Pair p2 = ver.get(1).getElement();
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
	 * find the shortest path between two vertices
	 * @param v1 - start vertex
	 * @param v2 - finish vertex
	 * @return Vertex List - the shortest path between two vertices
	 */
	public ArrayList<Vertex> shortestPath(Vertex v1, Vertex v2) {

		System.out.println("Start");
		return shortestPathHelper(v1, v2, null);
	}

	private ArrayList<Vertex> shortestPathHelper(Vertex v1, Vertex v2, Vertex prev) {
		
		// TODO: PROBLEM - OCCASIONALLY STACK OVERFLOWS (NOT ALWAYS)
		//System.out.println("v1: " + v1 + " v2: " + v2 + " prev: " + prev);
		ArrayList<Vertex> path = new ArrayList<Vertex>();

		// Check if we reached the desired vertex
		if (v1.getElement().getX() == v2.getElement().getX() &&
				v1.getElement().getY() == v2.getElement().getY()) {

			path.add(v2);
			return path;
		}

		// Check if the path was a dead end
		if ( v1.adjacentVertices().size() <= 1) return path;
		
		// Follow all of the starting vertex adjacent vertices
		for ( Vertex ver : v1.adjacentVertices() ) {

			// Don't go back to the previous vertex
			if ( prev != null && 
					prev.getElement().getX() == ver.getElement().getX() &&
					prev.getElement().getY() == ver.getElement().getY()) {
				continue;
			}

			path = shortestPathHelper( ver, v2, v1 );

			// If this path was successful insert this vertex at the start
			if ( !path.isEmpty() ) {

				path.add(0, ver);
				break;
			}
		}

		return path;
	}
	@Override
	/**
	 * a minimum spanning tree for the graph
	 * @return Graph - a minimum spanning tree for the graph
	 */
	public Graph minimumSpanningTree() {

		// Create new graph to represent tree
		MyGraph tempTree = new MyGraph();

		// Make a copy of all available vertices
		ArrayList< Vertex > outV = new ArrayList< Vertex >();

		for ( Vertex v : vertices ) {
			outV.add( v );
		}

		// Pick a vertex to start with
		int vert = ( int ) ( Math.random() * outV.size() );

		tempTree.addVertex( outV.get( vert ) );
		outV.remove( vert );

		// PROBLEM: A SPANNING TREE DOES NOT EXIST = INFINITE LOOP
		while ( outV.size() > 0 ) {

			// Pick a random vertex in tree
			vert = ( int ) ( Math.random() * tempTree.vertices().size() );

			Vertex temp = tempTree.vertices().get( vert );

			// Get a modifiable list of adjacent vertices
			ArrayList< Vertex > adjV = new ArrayList< Vertex >();

			for ( Vertex v : temp.adjacentVertices() ) {
				adjV.add( v );
			}

			while ( adjV.size() > 0 ) {

				// Choose an adjacent vertex to try
				int grab = ( int ) ( Math.random() * adjV.size() );

				Vertex next = adjV.get( grab );

				// If the adjacent vertex still needs to be added to the tree
				if ( outV.contains( next ) ) {

					// Add new vertex and edge to spanning tree
					tempTree.addVertex( next );
					tempTree.addEdge( temp, next );

					// Remove new vertex from available ones to choose from
					outV.remove( next );

					// Pick a new vertex in tree and continue
					break;
				} else {

					// Remove next from list of adjacent vertices
					adjV.remove( next );
				}
			}
		}

		// Create new graph based on spanning tree
		// This will remove all adjacent vertices and incident edges that no longer exist
		// Also results in new vertices and edges so they can be modified if needed
		MyGraph result = new MyGraph();

		for ( Vertex ver : tempTree.vertices() ) {

			result.addVertex( ver.getElement() );
		}

		for ( Edge edge : tempTree.edges() ) {

			Vertex v1 = result.findVertex( edge.vertices().get( 0 ).getElement() );
			Vertex v2 = result.findVertex( edge.vertices().get( 1 ).getElement() );

			result.addEdge( v1, v2 );
		}

		return result;
	}

	/**
	 * create a string representation of the current object state
	 * 
	 * @return String - current state of the object
	 */
	public String toString() {
		return "";
	}
}
