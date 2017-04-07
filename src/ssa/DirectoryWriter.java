package ssa;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DirectoryWriter {

	private static Scanner x;
	static String filepath,parentDirectory;
	static File randomDir,randomFile;
	private String drive = "";
	private String section;
	private String project;
	private String projectPath;
	
	public DirectoryWriter(String section, String project){
		this.section = section;
		this.project = project;
	}
	
	public String getDrive(){
		return drive;
	}
	
	public String getProjectPath(){
		return projectPath;
	}
	
	public void writeDirectoryStructure() {
		try{				
			x = new Scanner(new File("directories.txt"));				
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}	
			
		/*Stores the drive letter where the directory structure
		  will be created.*/	
		this.drive = x.next();
		this.projectPath = drive + "\\" + section+ "\\" + project;
		
		randomDir = new File(drive + "\\" + section);
		randomDir.mkdir();
		
		randomDir = new File(drive + "\\" + section+ "\\" + project);
			if(!randomDir.exists()){
				randomDir.mkdir();			
				while (x.hasNext()){	
					randomDir = new File(drive + "\\" + section + 
							                     "\\" + project + x.next());
					randomDir.mkdir();
				}
			}else{
				JOptionPane.showMessageDialog(null, 
				"The project (" + project + ") already exists.");
			}	
			x.close();
		}			
}
