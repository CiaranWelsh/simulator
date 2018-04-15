package compartment;
import java.util.*;

import species.*;

/*
 * Geometry is intended to be superclass for 
 * any shape. Eventually shapes will be 
 * put inside one another and in doing so
 * the cells of the smaller shape will *take 
 * some of the cells from the larger shape so 
 * that space isn't dual occupied. 
 */
public class Geometry implements Iterable<Coordinate>{
	/**
	 * 
	 */
	protected int scale;
	protected LinkedHashMap<Coordinate, Cell> cells = new LinkedHashMap<Coordinate, Cell>();

//	protected List<Cell> cells = new ArrayList<Cell>();

	public Geometry(int scale){
		this.scale= scale; 
		
	}

	@Override
	public Iterator<Coordinate> iterator() {
		return cells.keySet().iterator();
	}
	
	public int size(){
		return cells.size();
	}
	
	public Cell get(int x, int y, int z){
		Coordinate coord = new Coordinate(x, y, z);

		return cells.get(coord);
	}
	

	public void set(int x, int y, int z, Species species){
		Coordinate coord = new Coordinate(x, y, z);
		Cell cell = new Cell(coord, species);
		this.cells.put(coord, cell);
	}

	public void setByCoord(Coordinate coord, Species species){
		Cell cell = new Cell(coord, species);
		this.cells.put(coord, cell);
	}
	
	public Cell getByCoord(Coordinate coord){
		return cells.get(coord);
	}
	
}





































