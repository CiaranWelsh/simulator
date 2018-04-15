package species;
import java.lang.Math;

public class Cube extends Species {
	public Cube(String name, int size){
		super(name, size);
	}
	
	public int closest_cube(){
		//Convert Integer to int so that to can be 
		//cast to double for math operations
		double size = (int) this.size;
		size = (double) size;
		
		// get ceil and floor
		double ceil = Math.ceil(Math.cbrt(size));
		double floor = Math.floor(Math.cbrt(size));
		
		//
		if (Math.abs(Math.pow(floor, 3) - size) < Math.abs(Math.pow(ceil, 3)- size)){
			return (int) floor;
		}
		else{
			return (int) ceil;
		}
	}
}
