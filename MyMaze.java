import java.util.ArrayList;

/**
 * 
 * @author Spencer Miskoviak
 * @author Duncan Fox
 * 
 * CS2321 | Data Structures | Fall 2014
 * 
 * This program implements a Maze structure
 * that can find a path through the maze
 *
 */
public class MyMaze implements Maze {

	// Class properties
	private Vertex start = null;
	private Vertex finish = null;
	private Graph maze = null;
	private Vertex[][] mazeArray = null;

	@Override
	/**
	 * create a random maze with the specified number of rows and columns
	 * @param rows - number of rows in the maze
	 * @param columns - number of columns in the maze
	 */
	public void generateMaze(int rows, int columns) {

		// Create a grid graph to generate a random maze
		MyGraph graph = new MyGraph();
		mazeArray = new Vertex[rows][columns];

		for ( int r = 0; r < rows; r++ ) {

			for ( int c = 0; c < columns; c++ ) {
				
				// Create the vertex's pair
				MyPair p = new MyPair();
				p.setX(c);
				p.setY(r);
				
				// Create the vertex
				MyVertex m = new MyVertex();
				m.setElement(p);
				
				// Add the vertex to the graph
				mazeArray[r][c] = m;
				graph.addVertex(m);

				// Add the edge to the vertex above
				if ( r != 0 ) {
					graph.addEdge( mazeArray[r - 1][c], m );
				}
				
				// Add the edge to the vertex to the left
				if ( c != 0 ) {
					graph.addEdge( mazeArray[r][c - 1], m );
				}
			}
		}
		
		// Generate the maze
		maze = graph.minimumSpanningTree();
		
		// Pick a random row in the first column for the start
		start = mazeArray[( int )( Math.random() * rows )][0];
		
		// Pick a random row in the last column for the finish
		finish = mazeArray[( int )( Math.random() * rows )][rows - 1];
		
	}

	@Override
	/**
	 * an ordered list representing a path of vertices from the start to the finish
	 * @return list of vertices representing the path
	 */
	public ArrayList<Vertex> solveMaze() {
		return maze.shortestPath(start, finish);
	}

	@Override
	/**
	 * @return a graph representing the maze
	 */
	public Graph toGraph() {
		return maze;
	}

	@Override
	/**
	 * @return an array of vertices representing the maze
	 */
	public Vertex[][] toArray() {
		return mazeArray;
	}

	@Override
	/**
	 * @return the start vertex
	 */
	public Vertex startVertex() {
		return start;
	}

	@Override
	/**
	 * @return the end vertex
	 */
	public Vertex finishVertex() {
		return finish;
	}

	/**
	 * captures the current state of the object into a string
	 * @return a string representation of the object
	 */
	public String toString() {
		return "\u2022";
	}

}
