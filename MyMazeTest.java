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

	@Test
	/**
	 * Creates a maze and prints out the different properties of it
	 * to be reviewed.
	 */
	public void test( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		System.out.println( "startVertext( ): " + maze.startVertex( ) );
		System.out.println( "finishVertext( ): " + maze.finishVertex( ) );
		System.out.println( "solveMaze( ): " + maze.solveMaze( ) );
		System.out.println( "maze.toString( ):\n" + maze );
	}

	@Test
	/**
	 * Tests to make sure the correct number of edges are stored within
	 * the maze/spanning tree.
	 */
	public void testNumberOfEdges( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		Graph graph = maze.toGraph( );
		if ( graph.edges( ).size( ) != graph.vertices( ).size( ) - 1 ) {
			fail( "For a 5 x 5 maze, there should be 24 edges. "
					+ "Instead, there are " + graph.edges( ).size( ) + " edges." );
		}
		
		// Test again with much larger maze
		maze = new MyMaze( );
		maze.generateMaze( 25, 25 );
		graph = maze.toGraph( );
		if ( graph.edges( ).size( ) != graph.vertices( ).size( ) - 1 ) {
			fail( "For a 25 x 25 maze, there should be 624 edges. "
					+ "Instead, there are " + graph.edges( ).size( ) + " edges." );
		}
	}

	@Test
	/**
	 * Tests to make sure the start and finish vertices are distinct and
	 * in the correct columns.
	 */
	public void testDistinctStartFinish( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		
		// Make sure start and finish vertices are in the correct places
		if ( maze.startVertex( ) == maze.finishVertex( ) ) {
			fail( "startVertex and finishVertex are not unique." );
		}
		if ( maze.startVertex().getElement().getX() != 0 ) {
			fail ( "startVertex should be in leftmost column of the graph" );
		}
		if ( maze.finishVertex().getElement().getX() != 4 ) {
			fail ( "finishVertex should be in rightmost column of the graph" );
		}
	}

	@Test
	/**
	 * Checks to make sure the dimensions of the maze are correct.
	 */
	public void testArrayIsCorrectSize( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 10 );
		Vertex[ ][ ] mazeArray = maze.toArray( );
		
		// Check to make sure the maze is proportioned properly
		if ( mazeArray.length != 5 || mazeArray[0].length != 10 ) {
			fail( "Maze array is not 5 x 10." );
		}
	}

	@Test
	/**
	 * Tests to make sure the maze is a proper spanning tree (all vertices
	 * are connected to all other vertices).
	 */
	public void testPathBetweenAllVertices( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 5, 5 );
		Graph graph = maze.toGraph( );
		ArrayList< Vertex > vertices = graph.vertices( );
		
		// Make sure the maze is a true spanning tree
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
	/**
	 * Tests to make sure the correct path is created when solving the maze.
	 */
	public void testSolutionPath( ) {
		MyMaze maze = new MyMaze( );
		maze.generateMaze( 4, 4 );
		Graph graph = maze.toGraph( );
		ArrayList< Vertex > path = graph.shortestPath( maze.startVertex( ), maze.finishVertex( ) );
		ArrayList< Vertex > solve = maze.solveMaze( );
		
		// Make sure the maze is solved correctly
		if ( path.size( ) != solve.size( ) ) {
			fail( "Path between start and finish differs in size from solution path." );
		}
		for ( Vertex v: path ) {
			if ( !solve.contains( v ) ) {
				fail( "Vertex " + v + " not found in solution: " + solve );
			}
		}
	}
}
