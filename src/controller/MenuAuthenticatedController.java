package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;

public class MenuAuthenticatedController {

	private MainApp mainApp;
	
	@FXML
	AnchorPane component;
	
	@FXML
	AnchorPane registerComponent;
	
	@FXML
	AnchorPane menuLogin;
	
	@FXML
	AnchorPane tutorial;
	
	@FXML
	AnchorPane signIn;
	
	@FXML
	AnchorPane removeComponent;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void handlerHome(){
		//TODO URGENTE iterar a listar de componentes
		
//		
//		List<Componente> componentes = eu.getUsuarioComponentes();
//		for (Componente componente : componentes) {
//			List<Estatistica> estatisticas = componente.getComponenteEstatisticas();
//			for(Estatistica estatistica : estatisticas){
//				System.out.println(estatistica.getHorario());
//				System.out.println(estatistica.isValor());
//			}
//		}
		Util.gotoPage(component, "../view/Component.fxml", "Component", mainApp);
		
	}
	
	@FXML
	public void handlerRegisterComponent(){
		
		Util.gotoPage(registerComponent, "../view/RegisterComponent.fxml", "RegisterComponentController", mainApp);
		
	}
	
	@FXML
	public void handlerRemoveComponent(){
		
		Util.gotoPage(removeComponent, "../view/RemoveComponent.fxml", "RemoveComponentController", mainApp);
		
	}
	
	@FXML
	public void handlerTutorial(){
		
		Util.gotoPage(tutorial, "../view/Tutorial.fxml", "TutorialController", mainApp);
		
	}
	
	@FXML
	public void handlerBack(){
		
		Util.gotoPage(menuLogin, "../view/MenuLogin.fxml", "MenuLoginController", mainApp);
		Util.gotoPage(signIn, "../view/SignIn.fxml", "SignInController", mainApp);
		
	}
	
	
}
