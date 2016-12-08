package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Util {

	public static void gotoPage(AnchorPane anchorPane, String pathFXML, String nameController, MainApp mainApp){
		
		// Carrega o sign in.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource(pathFXML));
		
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(nameController.equals("Component")){
			
			ComponentController componentController = loader.getController();
			componentController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		} else if (nameController.equals("MenuAuthenticatedController")) {
			
			MenuAuthenticatedController menuAuthenticatedController = loader.getController();
			menuAuthenticatedController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setLeft(anchorPane);
			
		} else if (nameController.equals("RegisterComponentController")) {
			
			RegisterComponentController registerComponentController = loader.getController();
			registerComponentController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		} else if (nameController.equals("MenuLoginController")) {
			
			MenuLoginController menuLoginController = loader.getController();
			menuLoginController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setLeft(anchorPane);
			
		}  else if (nameController.equals("SignInController")) {
			
			SignInController signInController = loader.getController();
			signInController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		}  else if (nameController.equals("TutorialController")) {
			
			TutorialController tutorialController = loader.getController();
			tutorialController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		}  else if (nameController.equals("RemoveComponentController")) {
			
			RemoveComponentController removeComponentController = loader.getController();
			removeComponentController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		} else if (nameController.equals("ComponentDetailController")) {
			
			ComponentDetailController componentDetailController = loader.getController();
			componentDetailController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		} else if (nameController.equals("SignUpController")) {
			
			SignUpController signUpController = loader.getController();
			signUpController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setCenter(anchorPane);
			
		}  else if (nameController.equals("MenuLoginController")) {
			
			MenuLoginController menuLoginController = loader.getController();
			menuLoginController.setMainApp(mainApp);
			mainApp.getRootBorderLayout().setLeft(anchorPane);
			
		}
		
	}
		
	public static String getCurrentTime(){
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("America/Recife"));
		
		return ""+df.format(date);
	}
	
}
