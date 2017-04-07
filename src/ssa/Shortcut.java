package ssa;
import net.jimmc.jshortcut.JShellLink;

public class Shortcut {
	
	JShellLink link;
	String filePath;
	
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
}