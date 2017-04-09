package ssa;

public class PDC{
		
	public static void main(String[] args){	
		
		switch(args.length){
		case 1:
			System.out.println("Arg 1: " + args[0]);
			if((args[0]).compareTo("-h") == 0){
				System.out.println("Displaying Help!");
			}else if(args[0].compareTo("-v") == 0){
				System.out.println("Displaying Program Version");
			}else{
				System.out.println("Error! invalid argument, use -h for help");
			}
			return ;
		case 2:
			System.out.println("Error! Third argument missing");
			System.out.println(args[0] + " " + args[1] + "[_NULL_]");
			return ;
		case 3:
			System.out.println("Arg 1 2 3: " + args[0] + "" + args[1] + "" + args[2]);
			InputChecker ic = new InputChecker(args[0],args[1], args[2]);
			ic.checkInput();
		default :			
			System.out.println("No argument passed");
			try {
				Municipalities m = new Municipalities();
				GUI g = new GUI();				
				g.initialize(m);
			} catch (Exception e) {
				e.printStackTrace();
			}	 
		}		
	}
}	
