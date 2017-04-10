package ssa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import net.jimmc.jshortcut.JShellLink;

public class Shortcut2 {
	JShellLink link;
	String filePath;
	static File randomDir;
		
	public Shortcut2(String projectPath) { 
		try {
			link = new JShellLink();
			filePath = JShellLink.getDirectory("") + projectPath; 
		} catch (Exception e) {
		}
	}
	
	public void createDesktopShortcut(String projectName) {
		try {
			
			link.setFolder("S:\\Projects");
			link.setName(projectName);
			link.setPath(filePath);
			link.save();
		} catch (Exception ex) {
			System.out.println("Error in creating short cut");
		    //ex.printStackTrace();
		}
		
		/*Check if the municipality folder exists, if not then create it before
		 * creating the shortcut.
		 */
		try {			
			link.setFolder("S:\\Projects\\" + "NELSON");
			link.setName(projectName);
			link.setPath(filePath);
			link.save();
		} catch (Exception ex) {
			System.out.println("Error in creating short cut");
		    //ex.printStackTrace();
		}
		
	}
	 
    @SuppressWarnings("resource")
	private  void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination= null;
    
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

    public void moveShortCuts(String section, String project, String municipality) throws IOException{
		File desktop =new File(JShellLink.getDirectory("desktop") + "\\" + project + ".lnk");		
	    File sProjectsFile =new File("S:\\projects\\" + project + ".lnk");    
	    File sProjectsMunicipalitiesFile =new File("S:\\projects\\" + municipality + 
	    											           "\\" + project + ".lnk");			
		try {
			copyFile(desktop, sProjectsFile); 
		} catch (IOException e) {
			System.out.println("Error in copying short cut to s projects");
			//e.printStackTrace();
		}		
		
		if(municipality.compareTo("Unknown") != 0){
			try {
				//Copy shortcut from desktop to s:/projects/municipality
				randomDir=new File("S:\\projects\\" + municipality);
				randomDir.mkdir();
				copyFile(desktop,sProjectsMunicipalitiesFile);  
			} catch (IOException e) {
				System.out.println("Error in copying short cut to s projects/municipalities");
				//e.printStackTrace();
			}
		}		
		desktop.delete();		
    }
}
