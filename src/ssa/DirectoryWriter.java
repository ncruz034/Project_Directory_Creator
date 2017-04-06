package ssa;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DirectoryWriter {

	private static Scanner x;
	static String filepath,parentDirectory;
	static File randomDir,randomFile;
	private String drive = "";
	private String SECTION_PATH;
	private String PROJECT_PATH;
	
	public String getDrive(){
		return drive;
	}
	public String getProjectPath(){
		return PROJECT_PATH;
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
	
	
	public DirectoryWriter(String section, String project) {
		openFile();
		//Stores the drive letter where the directory structure
		//will be created
		drive = x.next();
		SECTION_PATH = drive + "\\" + section;
		PROJECT_PATH = SECTION_PATH + "\\" + project;
		randomDir = new File(SECTION_PATH);
		randomDir.mkdir();
		
		randomDir= new File(PROJECT_PATH);
		//System.out.println(randomDir.exists());
			if(!randomDir.exists()){
				randomDir.mkdir();			
				while (x.hasNext()){
					//String a = x.next();								
					//makeDirectory(projectPath + a);	
					randomDir = new File(PROJECT_PATH + x.next());
					randomDir.mkdir();
				}
			}else{
				JOptionPane.showMessageDialog(null, 
				"The project (" + project + ") already exists.");
			}	
			
			closeFile();
		}			
		/*
		public void makeDirectory(String fullPath) {
			//System.out.println(fullPath);
			randomDir = new File(fullPath);
			randomDir.mkdir();
		}
		*/

}
