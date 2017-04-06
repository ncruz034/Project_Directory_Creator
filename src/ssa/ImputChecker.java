package ssa;

import javax.swing.JOptionPane;

public class ImputChecker {

	public void imputChecker(String section, String project, String municipality){
		
		if(section.equals("")  || project.equals("")){  //Check if both fields have data
			JOptionPane.showMessageDialog(null, "You must fill both fields before continuing.");//Output a message box asking the user to input information in both fields
								
	    }else{
            if (section.matches("[0-9]+") && section.length() == 6){				
				EventHandeler eh = new EventHandeler();
				eh.btnEnter_Clicked(section, project, municipality);	
				JOptionPane.showMessageDialog(null, "The directory was successfully created");
			}else{
				JOptionPane.showMessageDialog(null, "Section number must be six characters long.");
			}
	    }
	}
	
	/*public void directoryCheck(String path){
		randomDir=new File(drive + "\\" + section);
		randomDir.mkdir();
	}*/
	
	
}