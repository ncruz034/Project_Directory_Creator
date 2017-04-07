package ssa;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Municipalities {
	
	private static Scanner x;
		
	public ArrayList<String> getMunicipalities(){
		try{				
			 x = new Scanner(new File("municipalities.txt"));
		}
			catch(Exception e){
		}
		
	    ArrayList<String> municipalitiesList = new ArrayList<String>();

		while (x.hasNext()){
			municipalitiesList.add(x.next());
		}	
		x.close();
		return municipalitiesList;
	}
}