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
	public ArrayList<Vertex> vertices() {
		return vertices;
	}

	@Override
	public Vertex addVertex(Pair p) {
		
		// Check to see if vertex already exists
		for ( Vertex ver : vertices ) {
			
			if ( ver.getElement().getX() == p.getX() && ver.getElement().getY() == p.getY() ) {
				return ver;
			}
		}
		
		MyVertex temp = new MyVertex();
		temp.setElement( p );
		
		vertices.add( temp );
		return temp;
	}

	@Override
	public Vertex addVertex(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVertex(Pair p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVertex(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vertex findVertex(Pair p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Edge> edges() {
		return edges;
	}

	@Override
	public Edge addEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge addEdge(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Edge findEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areConnected(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Vertex> adjacentVertices(Vertex v1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Edge> incidentEdges(Vertex v1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vertex> shortestPath(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graph minimumSpanningTree() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "";
	}
}
