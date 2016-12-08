package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Usuario;

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
	public void handlerLoginUser() throws ClassNotFoundException, SQLException{
		
		Usuario usuario = new Usuario(tfName.getText(),tfPassword.getText());

		if(usuario.autenticate()){
			MainApp.setUsuario(usuario);
			Util.gotoPage(menuAuthenticated, "../view/MenuAuthenticated.fxml", "MenuAuthenticatedController", mainApp);
			Util.gotoPage(component, "../view/Component.fxml", "Component", mainApp);
			
		}else{
			//Mensagem dizendo que houve falha na autenticação
		}
		
	}
	
	
}
