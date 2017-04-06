package ssa;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class readfile {
	private Scanner x;
	
	public void openFile() {
		try{			
				//x = new Scanner(new File("C:\\test\\directories.txt"));
				x = new Scanner(new File("directories.txt"));
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "The File was not found in the root directory of the application");
				//System.out.println("Could not find file");
			}		
		}

	public void closeFile(){
		x.close();
	}	
	public void readFile() {
		ArrayList<String> dirArrayList = new ArrayList<String>();
		while (x.hasNext()){
			String a = x.next();
			dirArrayList.add(a);
			System.out.printf("%s\n",a);		
		}
		
	}
}
