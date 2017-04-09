package ssa;

public class EventHandeler {
	
	public void btnEnter_Clicked(String section, String project, String municipality){
		InputChecker ic = new InputChecker(section, project, municipality);
		ic.checkInput();
	}

	public void btnExit_Clicked(){
		System.out.println("Clicked");
	}
}
