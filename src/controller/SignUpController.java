package controller;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Usuario;

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
	public void handlerCadastrarUsuario() throws ClassNotFoundException, SQLException{
		if(tfPassword.getText().equals(tfConfirmPassword.getText())){
			Usuario usuario = new Usuario(tfName.getText(),tfPassword.getText());
			usuario.addUsuario();
			if(usuario.autenticate()){
				//TODO	dialog com mensagem de sucesso
			}else{
				//TODO dialog com mensagem de falha
			}
		}else{
			//TODO dialog com mensagem dizendo que as senhas diferem
		}
		
		
		
		System.out.println("teste"+tfPassword.getText());
		
	}
	
}
