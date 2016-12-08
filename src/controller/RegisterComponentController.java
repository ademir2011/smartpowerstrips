package controller;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Componente;
import model.Usuario;

public class RegisterComponentController {

	private MainApp mainApp;
	
	@FXML
	TextField tfName;
	
	@FXML
	TextArea tfInfo;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	
	@FXML
	public void handlerRegisterComponent() throws ClassNotFoundException, SQLException{
		
		Componente componente = new Componente(tfName.getText(),tfInfo.getText(), null);
		System.out.println(MainApp.getUsuario().getLogin());
		componente.addComponente(MainApp.getUsuario().getLogin());
		//TODO mensagem de sucesso ou de voltar para alguma página

	}
	
	
	
}
