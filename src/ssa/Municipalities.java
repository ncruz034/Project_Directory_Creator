package ssa;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Municipalities {
	
	private static Scanner x;
	private static ArrayList<String> municipalitiesList = new ArrayList<String>();
	
	public ArrayList<String> getMunicipalities(){
		openFile();
		return municipalitiesList;
	}
	
	private void openFile() {
		try{				
				x = new Scanner(new File("municipalities.txt"));
			}
			catch(Exception e){
				//System.out.println("Could not find Municipalities file");
			}	
		readFile();
		closeFile();
	}
	
	private static void closeFile(){
		x.close();
	}
	
	private static void readFile() {
		while (x.hasNext()){
			municipalitiesList.add(x.next());
		}	
	}	
}
