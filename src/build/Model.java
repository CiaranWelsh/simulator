package build;
import java.util.Random;

import species.*;
import compartment.*;
import java.util.HashMap;
/*
 * Make a model. 
 * Build a lattice. 
 * Make a protein
 * Define diffusion behaviour for that protein
 * Then simulate. 
 * I may be able to build a super class for subclassing and 
 * building custom models using components I have built - for now, just build the model
 */
public class Model {

	public compartment.Lattice lattice = new compartment.Lattice(100, 1);
	public ProteinX proteinx;
	
	public Model(){
		this.proteinx = new ProteinX("proteinX", 52);
		this.build();

	}
	
	public Lattice build(){
		Coordinate coord = new Coordinate(1, 1, 1);
		this.lattice.set(1, 1, 1, this.proteinx);
		return this.lattice;
	}
}


final class ProteinX extends species.Cube {
	public ProteinX(String name, int size){
		super(name, size);
//		this.diffusion();
	}
	
	public Coordinate diffusion(){
		// randomly pick an x, y and z coordinate for protein x to go to
//		HashMap<String, Integer> coords = new HashMap<String, Integer>();
		int[] squares = new int[3];
		for (int i = -1; i <= 1 ; i++){
			squares[i] = i;
		}
		int x = Species.getRandom(squares);
		int y = Species.getRandom(squares);
		int z = Species.getRandom(squares);
		Coordinate coord = new Coordinate(x, y, z);
		return coord;

	}
	

}











