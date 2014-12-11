
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Spencer Miskoviak
 * @author Duncan Fox
 * 
 * CS2321 | Data Structures | Fall 2014
 * 
 * This program test the MyMaze structure
 *
 */
public class MyMazeTest {
	
	@Test
	public void generateMazeTest() {
		
		MyMaze maze = new MyMaze();
		
		// normal maze test
		int mazeSize = 10;
		maze.generateMaze(mazeSize, mazeSize);
		
		// check vertices count
		if(maze.toGraph().vertices().size() != (mazeSize * mazeSize)) {
			fail(mazeSize + " x " + mazeSize + " maze should have " + (mazeSize * mazeSize) + " vertices");
		}

		// check start point
		if(maze.startVertex() == null) {
			fail("start vertex is not set after generating maze");
		}
		if(maze.startVertex().getElement().getX() != 0) {
			fail("start vertex should be on the left side of the maze");
		}
		
		// check end point
		if(maze.finishVertex() == null) {
			fail("finish vertex is not set after generating maze");
		}
		if(maze.finishVertex().getElement().getX() != mazeSize) {
			fail("finish vertex should be on the right side of the maze");
		}
		
		// small maze test
		mazeSize = 1;
		maze.generateMaze(mazeSize, mazeSize);
		
		// check vertices count
		if(maze.toGraph().vertices().size() != (mazeSize * mazeSize)) {
			fail(mazeSize + " x " + mazeSize + " maze should have " + (mazeSize * mazeSize) + " vertices");
		}

		// check start point
		if(maze.startVertex() == null) {
			fail("start vertex is not set after generating maze");
		}
		if(maze.startVertex().getElement().getX() != 0) {
			fail("start vertex should be on the left side of the maze");
		}
		
		// check end point
		if(maze.finishVertex() == null) {
			fail("finish vertex is not set after generating maze");
		}
		if(maze.finishVertex().getElement().getX() != mazeSize) {
			fail("finish vertex should be on the right side of the maze");
		}
		
		// small maze test
		mazeSize = 2;
		maze.generateMaze(mazeSize, mazeSize);
		
		// check vertices count
		if(maze.toGraph().vertices().size() != (mazeSize * mazeSize)) {
			fail(mazeSize + " x " + mazeSize + " maze should have " + (mazeSize * mazeSize) + " vertices");
		}

		// check start point
		if(maze.startVertex() == null) {
			fail("start vertex is not set after generating maze");
		}
		if(maze.startVertex().getElement().getX() != 0) {
			fail("start vertex should be on the left side of the maze");
		}
		
		// check end point
		if(maze.finishVertex() == null) {
			fail("finish vertex is not set after generating maze");
		}
		if(maze.finishVertex().getElement().getX() != mazeSize) {
			fail("finish vertex should be on the right side of the maze");
		}
	}

	@Test
	public void solveMazeTest() {
		fail("Not yet implemented");
	}

	@Test
	public void toGraphTest() {
		fail("Not yet implemented");
	}

	@Test
	public void toArrayTest() {
		
		MyMaze maze = new MyMaze();
		int mazeSize = 10;
		maze.generateMaze(mazeSize, mazeSize);

		// check array size
		if(maze.toArray().length != mazeSize) {
			fail("Array length is not " + mazeSize);
		}
		if(maze.toArray()[0].length != mazeSize) {
			fail("Array[0] length is not " + mazeSize);
		} 
		
		mazeSize = 1;
		maze.generateMaze(mazeSize, mazeSize);

		// check array size
		if(maze.toArray().length != mazeSize) {
			fail("Array length is not " + mazeSize);
		}
		if(maze.toArray()[0].length != mazeSize) {
			fail("Array[0] length is not " + mazeSize);
		}
		
		mazeSize = 2;
		maze.generateMaze(mazeSize, mazeSize);

		// check array size
		if(maze.toArray().length != mazeSize) {
			fail("Array length is not " + mazeSize);
		}
		if(maze.toArray()[0].length != mazeSize) {
			fail("Array[0] length is not " + mazeSize);
		}
	}

	@Test
	public void startVertexTest() {
		fail("Not yet implemented");
	}

	@Test
	public void finishVertexTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void toStringTest() {
		fail("Not yet implemented");
	}

}
