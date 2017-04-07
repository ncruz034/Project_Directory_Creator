package ssa;

import java.io.File;
import java.io.IOException;

import net.jimmc.jshortcut.JShellLink;

public class EventHandeler {
	
	public void btnEnter_Clicked(String section, String project, String municipality){
		
		DirectoryWriter dw = new DirectoryWriter(section,project);
		dw.writeDirectoryStructure();
		Shortcut sc = new Shortcut(dw.getProjectPath());
		sc.createDesktopShortcut(project);
		
		//String municipalityShortcutPath = "S:\\projects\\" + municipality;
		File desktop =new File(JShellLink.getDirectory("desktop") + "\\" + project + ".lnk");
		
	    File sProjectsFile =new File("S:\\projects\\" + project + ".lnk");
	    
	    File sProjectsMunicipalitiesFile =new File("S:\\projects\\" + municipality + 
	    											           "\\" + project + ".lnk");
				
		MoveShortcut msc = new MoveShortcut(); 
		
		try {
			//Copy shortcut from desktop to s:/projects
			msc.copyFile(desktop, sProjectsFile); 
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		if(municipality.compareTo("Unknown") != 0){
			try {
				//Copy shortcut from desktop to s:/projects/municipality
				msc.copyFileToMunicipality(desktop, 
					   sProjectsMunicipalitiesFile,
				   "S:\\projects\\" + municipality);  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			msc.deleteFile(desktop);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnExit_Clicked(){
		System.out.println("Clicked");
	}
}
