package species;

import java.text.MessageFormat;
import java.util.Random;

import compartment.Coordinate;

public class Species {
	
	public String name;
	public Object size;

	public Species(String name, int size){
		this.name = name;
		this.size = size;
	}
	

	public static int getRandom(int[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
		}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}


	@Override
	public boolean equals(Object that){
	  if(this == that) {
		  return true;//if both of them points the same address in memory
	  }
	
	  if(!(that instanceof Species)) 
		  return false; 
	  
	  Species thatSpecies = (Species) that;
	  return (this.name.equals(thatSpecies.name) && this.size.equals(thatSpecies.size));
	  }

	@Override
	public String toString(){
		return MessageFormat.format("name={0}, size={1}", this.name, this.size);
	}
	
	public Coordinate movement(){
		// base behaviour is to stay put Coordinate(0, 0, 0)
		Coordinate coord = new Coordinate(0, 0, 0);
		return coord;
	}
}
