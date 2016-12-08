package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignInController {

	private MainApp mainApp;
	
	@FXML
	TextField tfName;

	@FXML
	TextField tfPassword;
	
	@FXML
	AnchorPane menuAuthenticated;
	
	@FXML
	AnchorPane component;
	
	FXMLLoader loaderMenuAutheticated;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void handlerLoginUser(){
		
		
		
		Util.gotoPage(menuAuthenticated, "../view/MenuAuthenticated.fxml", "MenuAuthenticatedController", mainApp);
		Util.gotoPage(component, "../view/Component.fxml", "Component", mainApp);
		
	}
	
	
}
