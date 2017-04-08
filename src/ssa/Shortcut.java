package ssa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import net.jimmc.jshortcut.JShellLink;

public class Shortcut {
	JShellLink link;
	String filePath;
	static File randomDir;
		
	public Shortcut(String projectPath) { 
		try {
			link = new JShellLink();
			filePath = JShellLink.getDirectory("") + projectPath; 
		} catch (Exception e) {
		}
	}
	
	public void createDesktopShortcut(String projectName) {
		try {
			link.setFolder(JShellLink.getDirectory("desktop"));
			link.setName(projectName);
			link.setPath(filePath);
			link.save();
		} catch (Exception ex) {
		ex.printStackTrace();
		}
	}
	 
    public  void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }
	
    public  void copyFileToMunicipality(File sourceFile, File destFile,String newShortcutMunicipalityPath) throws IOException {
    	randomDir=new File(newShortcutMunicipalityPath);
		randomDir.mkdir();
 	
    	if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }

    public void cleanShortCuts(String section, String project, String municipality){
    	//String municipalityShortcutPath = "S:\\projects\\" + municipality;
		File desktop =new File(JShellLink.getDirectory("desktop") + "\\" + project + ".lnk");
		
	    File sProjectsFile =new File("S:\\projects\\" + project + ".lnk");
	    
	    File sProjectsMunicipalitiesFile =new File("S:\\projects\\" + municipality + 
	    											           "\\" + project + ".lnk");
				
		try {
			copyFile(desktop, sProjectsFile); 
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		if(municipality.compareTo("Unknown") != 0){
			try {
				//Copy shortcut from desktop to s:/projects/municipality
				copyFileToMunicipality(desktop,
					   sProjectsMunicipalitiesFile,
				   "S:\\projects\\" + municipality);  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			deleteFile(desktop);
		} catch (IOException e) {
			e.printStackTrace();
		}  		
    }
    
	public  void deleteFile(File sourceFile) throws IOException {	
		sourceFile.delete();	
	}  
}