package ssa;

public class EventHandeler {
	
	public void btnEnter_Clicked(String section, String project, String municipality){
		
		DirectoryWriter dw = new DirectoryWriter(section,project, municipality);
		dw.writeDirectoryStructure();
	}
	
	public void btnExit_Clicked(){
		System.out.println("Clicked");
	}
}
