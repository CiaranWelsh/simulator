package species;
import org.junit.Test;

public class SpeciesTests {
	
	@Test
	public void test_closest_cube(){
		Cube cube_entity = new Cube("protein", 18);
		org.junit.Assert.assertEquals(3, cube_entity.closest_cube());
	}
	
	@Test
	public void test(){
		Cube cube_entity = new Cube("X", 52);
		compartment.Lattice lattice = new compartment.Lattice(100, 1);
//		System.out.println(lattice);
//		System.out.println(cube_entity.closest_cube());
	}

	@Test
	public void test_equality(){
		Empty empty1 = new Empty("empty", 0);
		Empty empty2 = new Empty("empty", 0);
		System.out.println(empty1.equals(empty2));
//		org.junit.Assert.assertTrue(empty1.equals(empty2));
	}
	
	
	
	
}
