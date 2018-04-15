package simulation;
import java.io.File;
import java.sql.ResultSet;

import org.junit.*;

import compartment.Cell;
import compartment.Coordinate;
import compartment.Lattice;
import species.Species;


public class ReportTests {
	
	@Test
	public void test_db_created(){
		// create a lattice
		Lattice lattice = new Lattice(10, 1);
		File db_filename = new File("C:\\Users\\Ciaran\\Documents\\JavaProjects\\Simulator\\src\\text.db");
		Report report = new Report(db_filename, "test");
		org.junit.Assert.assertTrue(db_filename.exists());
	}

	@Test
	public void TestEnterDataToDBAndRetrieveResultSet(){
		// create a lattice
		Lattice lattice = new Lattice(10, 1);
		Species species = new Species("new", 50);
		Coordinate coord = new Coordinate(4, 5, 6);
		lattice.setByCoord(coord, species);
		File db_filename = new File("C:\\Users\\Ciaran\\Documents\\JavaProjects\\Simulator\\src\\text.db");
		Report report = new Report(db_filename, "test");
		report.insert(1, coord, species);
		org.junit.Assert.assertTrue(report.getID(1) instanceof ResultSet);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
