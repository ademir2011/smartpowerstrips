package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Componente;
import model.Usuario;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	
	private static Usuario usuario;
	private static Componente componenteMain;
	
	public static Componente getComponenteMain() {
		return componenteMain;
	}

	public static void setComponenteMain(Componente componenteMain) {
		MainApp.componenteMain = componenteMain;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		MainApp.usuario = usuario;
	}

	
	private Stage primaryStage;
	Scene scene;
	FXMLLoader loader;
	
	@FXML
	AnchorPane menuLogin;
	
	@FXML
	AnchorPane signIn;
  
	@FXML
	private BorderPane rootBorderLayout;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Smart Power Strips");
		initRootLayout();
		

	}

	/**
	 * Inicializa o root layout (layout base).
	 */
	public void initRootLayout() {

		// Carrega o root layout do arquivo fxml.
		loader = new FXMLLoader();
		loader.setController(this);
		loader.setLocation(MainApp.class.getResource("../view/MainApp.fxml"));
		
		try {
			rootBorderLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Util.gotoPage(signIn, "../view/SignIn.fxml", "SignInController", this);
		Util.gotoPage(menuLogin, "../view/MenuLogin.fxml", "MenuLoginController", this);
		
		// Mostra a scene (cena) contendo o root layout.
		scene = new Scene(rootBorderLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public BorderPane getRootBorderLayout() {
		return rootBorderLayout;
	}

	public void setRootBorderLayout(BorderPane rootBorderLayout) {
		this.rootBorderLayout = rootBorderLayout;
	}
	
	
	
}
