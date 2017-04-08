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
		int argsNum = args.length;
		switch(argsNum){
		case 1:
			System.out.println("Arg 1: " + args[0]);
		case 2:
			System.out.println("Arg 1 2: " + args[0] + "" + args[1]);
		case 3:
			System.out.println("Arg 1 2 3: " + args[0] + "" + args[1] + "" + args[2]);
		
		default :
			System.out.println("No argument passed");
		}
		try {
			GUI g = new GUI();
			g.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}
}	
