package build;

import simulation.*;

public class Main {
	
	public static void main(String[] args){
		Model model = new Model();
		TimeCourse timecourse = new TimeCourse(model, 10, 1);
		System.out.println(timecourse);
		
	}
}
