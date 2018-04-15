package compartment;
import org.junit.*;
import species.*;

public class LatticeTests {
	
	@Test
	public void test_to_string(){
		Lattice cube = new Lattice(10, 1); 
		org.junit.Assert.assertEquals(cube.toString(), "Lattice(size=10, scale=1)");
	}
	
	@Test
	public void test_cube_size(){
		Lattice lattice= new Lattice(10, 1);
		org.junit.Assert.assertEquals(lattice.size(), 1000);
	}
	

	@Test
	public void test_get(){
		Lattice lattice = new Lattice(10, 1);
		Species empty = new Empty("empty", 0);
		Coordinate coord = new Coordinate(1, 1, 1);
		Cell cell = new Cell(coord, empty);
		Cell cell_from_lattice = lattice.get(1,  1, 1);
		org.junit.Assert.assertTrue(cell.equals(cell_from_lattice));
	}
	
	@Test
	public void test_set(){
		Lattice lattice = new Lattice(10, 1);
		Species empty = new Empty("empty", 0);
		Coordinate coord = new Coordinate(1, 1, 1);
		Cell cell = new Cell(coord, empty);
		
	}
	
		
}













