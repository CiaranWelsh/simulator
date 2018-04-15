package simulation;

import java.io.File;
import java.util.*;

import build.Model;
import compartment.Cell;
import compartment.Coordinate;
import compartment.Lattice;

public class TimeCourse {
	
	public Model model;
	private int end;
	private int step_size;
	private List<Integer> time;
	public Report report;

	public TimeCourse(Model model, int end, int step_size){
		this.model = model;
		this.end = end;
		this.step_size = step_size;
		this.time = this.getTime();
		this.iterate();
		
	}
	
	public Model update(int time){
		// For every proteinX, pick a direction and move
		// Somewhere I am going to need to translate relative coordinates into absolute coordinates
//		System.out.println(this.model.lattice);
		// if cell is empty update
		// Also I should randomize the order in which cells are updated
		File db_f = new File("C:\\Users\\Ciaran\\Documents\\JavaProjects\\Simulator\\src\\oneProteinX.db");
		Report report = new Report(db_f, "sim1");
		for (Coordinate i: this.model.lattice){
			// I could try and define conflict behaviour
			// this would be different from update behaviour
			// 
			//First just implement simple only update if free 
			// behaviour
			Cell cell = this.model.lattice.getByCoord(i);
			if (cell.free == false) {
				cell.update_cell(this.model.lattice);
				report.insert(time, i, cell.species);
			}
		}
		return this.model;
	}
	
	/*
	 * Iterate over time and update lattice
	 * Store the results in an sqlite db
	 */
	public void iterate(){
		for (int i = 0; i<this.end; i++){
			if ( this.time.contains(i)){
				this.model = this.update(i);
			}
		}
	}
	
	/*
	 * produce an array for time
	 */
	private List<Integer> getTime(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		int time = 0;
		while (time < this.end){
			time = time + this.step_size;
			list.add(time);
		}
		return list;
	}
	

}























