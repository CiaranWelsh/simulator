package compartment;
import java.text.MessageFormat;

import species.Empty;
import species.Species;


/*
 * A single cell of the geometry 
 * for the simulation. It has x, y and z coordinates 
 * and an entity. The entity is initialized as empty
 * 
 */
public class Cell {
	
	public Coordinate coord;
	public Species species;
	// indicates whether cell is free
	public boolean free = false;
	
	public Cell(Coordinate coord, Species species){
		this.species= species; 
		this.coord = coord;
	}
	
	public String toString(){
		return MessageFormat.format("Cell({0})", this.species);
	}
	
	@Override
	public int hashCode(){
		String code = "" + this.coord.x + this.coord.y + this.coord.z;
		return Integer.parseInt(code);
	}

	@Override
	public boolean equals(Object that){
	  if(this == that) {
		  return true;//if both of them points the same address in memory
	  }
	
	  if(!(that instanceof Cell)) 
		  return false; // if "that" is not a Coordinate or a childclass
	
	  Cell thatCell = (Cell) that; // than we can cast it to People safely
	  return this.coord.equals(thatCell.coord) && this.species.equals(thatCell.species);
	}
	
	public void setSpecies(Species species){
		this.species = species;
	}

	public Species getSpecies(){
		return this.species;
	}
	
	public void delSpecies(){
		Empty empty = new Empty("empty", 0);
		this.setSpecies(empty);
	}
	
	public Lattice update_cell(Lattice lattice){
		// get the relative coordinate from species Diffusion behaviour
		Coordinate relCoord = this.species.movement();
		
		// add to absolute coord to get new position
		Coordinate newPos = this.coord.add(relCoord);
		
		// get the cell that is in the new position
		Cell newCell = lattice.getByCoord(newPos);
		
		// if the new cell species string is Empty
		if (newCell.species.toString() == "Empty"){
//			// if new position is already taken this update
//			if (newCell.free == false){
//				//sample from 
//			}
			//set the species field to that of the current cell
			lattice.setByCoord(newPos, this.species);
			// and remove species from current cell
			this.delSpecies();
			
			// set indicator free variabels. new position is taken 
			// and old has been freed
			newCell.free = false;
			this.free = true;
		}
		return lattice;
	}
	
	

}
