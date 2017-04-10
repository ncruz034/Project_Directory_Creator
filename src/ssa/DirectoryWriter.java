package ssa;

import java.io.File;
import java.io.IOException;
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
	private String municipality;
	
	public DirectoryWriter(String section, String project, String municipality){
		this.section = section;
		this.project = project;
		this.municipality = municipality;
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
		this.projectPath = drive + "\\" + section + "\\" + project;		
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
			JOptionPane.showMessageDialog(null, "The Project's directory was successfully created");
		}else{
			JOptionPane.showMessageDialog(null, 
			"The project (" + project + ") already exists.");
		}	
		x.close();
		
		Shortcut2 sc = new Shortcut2(this.projectPath);
		sc.createDesktopShortcut(this.project);
		/*
		try {
			sc.moveShortCuts(section, project, municipality);
		} catch (IOException e) {
			System.out.println("Error");
			//e.printStackTrace();
		}
		*/			
	}
}
