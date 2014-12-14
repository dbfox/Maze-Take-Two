import static org.junit.Assert.*;

import java.util.ArrayList;

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

	public void test( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		System.out.println( "startVertext( ): " + maze.startVertex( ) );
		System.out.println( "finishVertext( ): " + maze.finishVertex( ) );
		System.out.println( "solveMaze( ): " + maze.solveMaze( ) );
		System.out.println( "maze.toString( ):\n" + maze );
	}

	@Test
	public void testNumberOfEdges( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		Graph graph = maze.toGraph( );
		if ( graph.edges( ).size( ) != graph.vertices( ).size( ) - 1 ) {
			fail( "For a 5 x 5 maze, there should be 24 edges. Instead, there are " + graph.edges( ).size( ) + " edges." );
		}
	}

	@Test
	public void testDistinctStartFinish( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		if ( maze.startVertex( ) == maze.finishVertex( ) ) {
			fail( "startVertex and finishVertex are not unique." );
		}
	}

	@Test
	public void testArrayIsCorrectSize( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		Vertex[ ][ ] mazeArray = maze.toArray( );
		if ( mazeArray.length != 5 || mazeArray[0].length != 5 ) {
			fail( "Maze array is not 5 x 5." );
		}
	}

	@Test
	public void testPathBetweenAllVertices( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 4, 4 );
		Graph graph = maze.toGraph( );
		ArrayList< Vertex > vertices = graph.vertices( );
		for ( int i = 0; i < vertices.size( ); i++ ) {
			for ( int j = 0; j < vertices.size( ); j++ ) {
				Vertex v1 = vertices.get( i );
				Vertex v2 = vertices.get( j );
				if ( v1 != v2 ) {
					if ( graph.shortestPath( (MyVertex) v1, (MyVertex) v2 ).isEmpty( ) ) {
						fail( "Vertex " + v1 + " is not connected to vertex " + v2 + " in graph:" + graph );
					}
				}
			}
		}
	}

	@Test
	public void testSolutionPath( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 4, 4 );
		Graph graph = maze.toGraph( );
		ArrayList< Vertex > path = graph.shortestPath( maze.startVertex( ), maze.finishVertex( ) );
		ArrayList< Vertex > solve = maze.solveMaze( );
		if ( path.size( ) != solve.size( ) ) {
			fail( "Path between start and finish differs in size from solution path." );
		}
		for ( Vertex v: path ) {
			if ( !solve.contains( v ) ) {
				fail( "Vertex " + v + " not found in solution: " + solve );
			}
		}
	}

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

		mazeSize = 3;
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


//	public ArrayList<Vertex> shortestPath(Vertex v1, Vertex v2) {
//
//		ArrayList< Vertex > result = new ArrayList< Vertex >();
//		shortestPathHelper(v1, v2, null, result);
//
//		return result;
//	}
//
//	private boolean shortestPathHelper(Vertex v1, Vertex v2, Vertex prev, 
//			ArrayList< Vertex > result ) {
//
//		result.add( v1 );
//
//		if ( v1 == v2 ) {
//			return true;
//		}
//
//		// Check if the path was a dead end
//		if ( v1.adjacentVertices().size() == 1) {
//			
//			result.remove( v1 );
//			return false;
//		}
//
//		// Follow all of the starting vertex adjacent vertices
//		for ( Vertex ver : v1.adjacentVertices() ) {
//
//			// Don't go back to the previous vertex
//			if ( ver != prev ) {
//				if ( shortestPathHelper( ver, v2, v1, result ) ) return true;
//			}
//		}
//
//		result.remove( v1 );
//		return false;
//	}
}
