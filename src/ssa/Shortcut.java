package ssa;

import java.io.File;

import net.jimmc.jshortcut.JShellLink;

public class Shortcut {
	JShellLink link;
	private String projectPath;
	private String municipality;
	private String project;
	static File randomDir;
		
	public Shortcut(String projectPath, String project, String municipality) {
		this.project = project;
		this.municipality = municipality;
		this.projectPath = projectPath;
	}
	
	public void create() {
		try {
			link = new JShellLink();
			link.setFolder("S:\\Projects");
			link.setName(project);
			link.setPath(projectPath);
			link.save();
		} catch (Exception ex) {
			System.out.println("Error creating project short cut");
		}
		
		/*Check if the municipality folder exists, if not then create it before
		 * creating the shortcut.
		 */
		if(municipality.compareTo("Unknown") != 0 && 
		   municipality.compareTo(" ") != 0){
			try {			
				link.setFolder("S:\\Projects\\" + municipality);
				link.setName(project);
				link.setPath(projectPath);
				link.save();
			} catch (Exception ex) {
				System.out.println("Error creating municipality short cut");
			}	
		}
	}
}
