package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ComponentController {
	
	private MainApp mainApp;
	
	@FXML
	Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	
	@FXML
	AnchorPane componentDetail;
	
	List<Button> listbuttons = new ArrayList<>();
	
	@FXML
    public void initialize() {
		
		listbuttons.add(bt1);
		listbuttons.add(bt2);
		listbuttons.add(bt3);
		listbuttons.add(bt4);
		listbuttons.add(bt5);
		listbuttons.add(bt6);
		listbuttons.add(bt7);
		listbuttons.add(bt8);
		listbuttons.add(bt9);
		
		listbuttons.forEach( key -> {
			key.setText("componente"+key.getId().substring(2, 3)+": vazio");
		});
		
		listbuttons.forEach( key -> {
			key.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Util.gotoPage(componentDetail, "../view/ComponentDetail.fxml", "ComponentDetailController", mainApp);
				}
			});
		});
		
    }
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	
	
}
