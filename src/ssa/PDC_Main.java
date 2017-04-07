package ssa;

public class PDC_Main{
		
	public static void main(String[] args){	
		
		/*
		 *
		 * TO DO
		 * 1- Provide execution through the command line.
		 * 2- Mantain the option of using the gui to execute the app.
		 * 3- I can pass the name of an alternative file with the location
		 * of a new Municipalities file to the initialize method in the GUI 
		 * Object.
		 */
		try {
			GUI g = new GUI();
			g.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}
}	
