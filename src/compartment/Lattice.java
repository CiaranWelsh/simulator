package compartment;
import java.text.MessageFormat;
import java.util.*;

import species.Empty;
import species.Species;

/*
 * Cube is a shape for the overall geometry
 * of the simulation. It contains a list of 
 * cells size*size*size in dimensions. 
 * @param size The size of x, y, and z dimensions of cubic lattice
 * @param scale How to scale Species. A scale of 1 == 1kDa
 */ 
public class Lattice extends Geometry{

	/**
	 * 
	 */
	private int size;
	

	public Lattice(int size, int scale) {
		super(scale);
		this.size = size;
		this.cells = this.make();
	}

	public String toString(){
		return MessageFormat.format("Lattice(size={0}, scale={1})", this.size, this.scale);
	}
	
	private LinkedHashMap<Coordinate, Cell> make(){
		for (int i = 1; i <= this.size; i++){
			for (int j = 1; j <= this.size; j++){
				for (int k = 1; k <= this.size; k++){
					Coordinate coord = new Coordinate(i, j, k);
					Empty empty = new species.Empty("empty", 0);
					Cell cell = new Cell(coord, empty);
					this.cells.put(coord, cell);
				}
			}
		}
		return this.cells;
	}
	
	public int size(){
		return this.cells.size();
	}

//	public void put(int x, int y, int z, Species species) {
//		// Put a species into lattice at coord
//		this.set(x, y, z, species);
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
