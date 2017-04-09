package ssa;

import javax.swing.JOptionPane;

public class InputChecker {
	
	private String section;
	private String project;
	private String municipality;
	
	public InputChecker(String section, String project, String municipality){
		this.section = section;
		this.project = project;
		this.municipality = municipality;
	}
	
	public void checkInput(){
		if(section.equals("")  || project.equals("")){
			JOptionPane.showMessageDialog(null, "You must fill both fields before continuing.");								
	    }else{
	        if (section.matches("[0-9]+") && section.length() == 6){	
	        	DirectoryWriter dw = new DirectoryWriter(section, project, municipality);
				dw.writeDirectoryStructure();				
			}else{
				JOptionPane.showMessageDialog(null, "Section number must be six characters long.");
			}
	    }	
	}
}
