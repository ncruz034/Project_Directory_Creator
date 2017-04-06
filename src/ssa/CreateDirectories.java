package ssa;
import java.io.File;
//import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class CreateDirectories {
	private static Scanner x;
	static String filepath,parentDirectory;
	static File randomDir,randomFile;
	private String drive = "";
	
	public String getDrive(){
		return drive;
	}
	
	public void openFile() {
		try{				
				x = new Scanner(new File("directories.txt"));				
			}
			catch(Exception e){
				System.out.println("Could not find file");
			}		
		}		
	
	public void closeFile(){
		x.close();
	}
	
	public void readFile(String section, String project) {
		drive = x.next();
		randomDir=new File(drive + "\\" + section);
		randomDir.mkdir();
		
		randomDir= new File(drive + "\\" + section + "\\" + project);
		System.out.println(randomDir.exists());
			if(randomDir.exists() == false){
				randomDir.mkdir();			
				while (x.hasNext()){
					String a = x.next();								
					makeDirectory(drive + "\\" + section + "\\" + project + a);	
				}
			}else{
				JOptionPane.showMessageDialog(null, "The project (" + project + ") already exists.");
			}
					
		}			
		
		public void makeDirectory(String fullPath) {
			//System.out.println(fullPath);
			randomDir = new File(fullPath);
			randomDir.mkdir();
		}
}