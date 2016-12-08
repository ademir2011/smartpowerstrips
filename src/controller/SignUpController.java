package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignUpController {

	private MainApp mainApp;
	
	@FXML
	TextField tfName;

	@FXML
	TextField tfPassword;

	@FXML
	TextField tfConfirmPassword;

	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void handlerCadastrarUsuario(){
		
		System.out.println("teste"+tfPassword.getText());
		
	}
	
}
