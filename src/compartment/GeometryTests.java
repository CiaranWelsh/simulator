package compartment;
import org.junit.*;

public class GeometryTests {
	
	
	@Test
	public void instantiateGeometry() {
		Geometry geom = new Geometry(1);
		Assert.assertEquals(geom instanceof Geometry, true);
	}
	
	@Test
	public void test(){
		Geometry geom = new Geometry(1);
		System.out.println(geom);
		
	}
}