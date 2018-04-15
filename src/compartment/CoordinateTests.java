package compartment;
import org.junit.*;
import species.*;

public class CoordinateTests {


	@Test
	public void test_coordinate_equals(){
		Coordinate coord1 = new Coordinate(1, 1, 1);
		Coordinate coord2 = new Coordinate(1, 1, 1);
		org.junit.Assert.assertEquals(true, coord1.equals(coord2));
	}
	
	@Test
	public void test_coordinate_hash_code(){
		Coordinate coord1 = new Coordinate(1, 1, 1);
		Coordinate coord2 = new Coordinate(1, 1, 1);
		org.junit.Assert.assertEquals(true, coord1.hashCode() == coord2.hashCode());
	}

}














	
