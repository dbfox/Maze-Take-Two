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
		MyPair p1 = new MyPair();
		p1.setX( 0 );
		p1.setY( ( int ) ( Math.random() * rows ) );
		start = maze.findVertex( p1 );
		
		// Pick a random row in the last column for the finish
		MyPair p2 = new MyPair();
		p2.setX( columns - 1 );
		p2.setY( ( int ) ( Math.random() * rows ) );
		finish = maze.findVertex( p2 );
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

		String str = "";
//		ArrayList<Vertex> path = solveMaze();

		// Iterate rows and columns
		for ( int row = 0; row < mazeArray.length; row++ ) {

			String nextRow = "";

			for ( int col = 0; col < mazeArray[0].length; col++ ) {

				if ( mazeArray[row][col] == start ) {
					str += "S";
				}
				else if( mazeArray[row][col] == finish ) {
					str += "F";
				}
				else {
					str += "\u2022";
				}

				// Check if there is an edge between the two vertical nodes
				if ( row < mazeArray.length - 1 && 
						maze.areConnected( mazeArray[row ][col], mazeArray[row + 1][col] ) ) {
					nextRow += "|";
				}
				else {
					nextRow += " ";
				}

				// Space out the next row properly
				if( col < mazeArray[0].length - 1 ) nextRow += "  ";

				// Check if there is an edge between the two horizontal nodes
				if ( col < mazeArray[0].length - 1 && 
						maze.areConnected( mazeArray[row][col], mazeArray[row][col + 1] ) ) {
					str += "--";
				}
				else {
					str += "  ";
				}

			}

			str += "\n" + nextRow + "\n";
		}

		return str;
	}

}
