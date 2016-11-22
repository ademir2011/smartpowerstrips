package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	
	private Stage primaryStage;
	Scene scene;
	FXMLLoader loader;
	
	@FXML
	AnchorPane menuLogin;
	
	@FXML
	AnchorPane signIn;
	
	@FXML
	AnchorPane signUp;
	
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

		try {
			
			// Carrega o root layout do arquivo fxml.
			loader = new FXMLLoader();
			loader.setController(this);
			loader.setLocation(MainApp.class.getResource("../view/MainApp.fxml"));
			rootBorderLayout = (BorderPane) loader.load();
			
			// Carrega o sign up.
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/SignIn.fxml"));
			signIn = (AnchorPane) loader.load();
			
			// Carrega o sign up.
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/MenuLogin.fxml"));
			menuLogin = (AnchorPane) loader.load();
			
			MenuLoginController menuLoginController = loader.getController();
			menuLoginController.setMainApp(this);

			rootBorderLayout.setCenter(signIn);
			rootBorderLayout.setLeft(menuLogin);
			
			// Mostra a scene (cena) contendo o root layout.
			scene = new Scene(rootBorderLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

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
