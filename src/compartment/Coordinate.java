package compartment;

import java.text.MessageFormat;

public class Coordinate {
	
	public int x;
	public int y;
	public int z;
	
	public Coordinate(int x, int y, int z){
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	public String toString(){
		return MessageFormat.format("Coordinate(x={0}, y={1}, z={2})", this.x,  this.y, this.z);
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	
	@Override
	public int hashCode(){
		String code = "" + this.x + this.y + this.z;
		return Integer.parseInt(code);
	}

	@Override
	public boolean equals(Object that){
	  if(this == that) {
		  return true;//if both of them points the same address in memory
	  }
	
	  if(!(that instanceof Coordinate)) 
		  return false; // if "that" is not a Coordinate or a childclass
	
	  Coordinate thatCoordinate = (Coordinate) that; // than we can cast it to People safely
	  return this.x == thatCoordinate.x && this.y == thatCoordinate.y && this.z == thatCoordinate.z;
	}
	
	public Coordinate add(Coordinate other){
		int x = this.x + other.x;
		int y = this.y + other.y;
		int z = this.z + other.z;
		Coordinate coord = new Coordinate(x, y, z);
		return coord;
	}




}
















