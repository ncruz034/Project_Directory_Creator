package ssa;

import java.io.File;
import java.io.IOException;

import net.jimmc.jshortcut.JShellLink;

public class EventHandeler {
	
	public void btnEnter_Clicked(String section, String project, String municipality){
		
		//CreateDirectories of = new CreateDirectories();
		DirectoryWriter dw = new DirectoryWriter(section,project);
		//of.openFile();
		//of.readFile(section, project);
		//of.closeFile();
		
		//String path = of.getDrive() + "\\" + section + "\\" + project;					
		//String path = dw.getDrive() + "\\" + section + "\\" + project;
		//String PROJECT_PATH = dw.getProjectPath();
		Shortcut sc = new Shortcut(dw.getProjectPath());
		sc.createDesktopShortcut(project);
		
		String shortcutPath = JShellLink.getDirectory("desktop") + "\\"   + project +  ".lnk";
		String projectShortcutPath = "S:\\projects\\" + project + ".lnk";
		String municipalityShortcutPath ="S:\\projects\\" + municipality;
		
	
		File afile =new File(shortcutPath);
	    File bfile =new File(projectShortcutPath);
	    File cfile =new File(municipalityShortcutPath + "\\" + project + ".lnk");
		
		
		MoveShortcut msc = new MoveShortcut(); 
		try {
			//Copy shortcut from desktop to s:/projects
			msc.copyFile(afile, bfile); 
		} catch (IOException e) {
			e.printStackTrace();
		}		
		if(municipality.compareTo("Unknown") != 0){
			try {
				//Copy shortcut from desktop to s:/projects/municipality
				msc.copyFileToMunicipality(afile, cfile,municipalityShortcutPath);  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			msc.deleteFile(afile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnExit_Clicked(){
		System.out.println("Clicked");
	}

}
