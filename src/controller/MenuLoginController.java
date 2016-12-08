package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MenuLoginController {

	@FXML
	AnchorPane signIn;
	
	@FXML
	AnchorPane signUp;
	
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	@FXML
	private void handleSignIn(){
		
		// Carrega o sign in.
		FXMLLoader loaderSignIn = new FXMLLoader();
		loaderSignIn.setLocation(MainApp.class.getResource("../view/SignIn.fxml"));
		
		try {
			signIn = (AnchorPane) loaderSignIn.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SignInController signInController = loaderSignIn.getController();
		signInController.setMainApp(mainApp);

		mainApp.getRootBorderLayout().setCenter(signIn);
		
	}

	@FXML
	private void handleSignUp(){
		
		// Carrega o sign up.
		FXMLLoader loaderSignUp = new FXMLLoader();
		loaderSignUp.setLocation(MainApp.class.getResource("../view/SignUp.fxml"));
		
		try {
			signUp = (AnchorPane) loaderSignUp.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SignUpController signUpController = loaderSignUp.getController();
		signUpController.setMainApp(mainApp);
		
		mainApp.getRootBorderLayout().setCenter(signUp);
		
	}
	
}
