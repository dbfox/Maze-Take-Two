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
	
	@Override
	/**
	 * create a random maze with the specified number of rows and columns
	 * @param rows - number of rows in the maze
	 * @param columns - number of columns in the maze
	 */
	public void generateMaze(int rows, int columns) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
		return "";
	}

}
