package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Componente;

public class ComponentController {
	
	private MainApp mainApp;
	
	@FXML
	Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	
	@FXML
	AnchorPane componentDetail;
	
	List<Button> listbuttons = new ArrayList<>();
	
	@FXML
    public void initialize() throws ClassNotFoundException, SQLException {

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
			key.setVisible(false);
		});
		
		listbuttons.forEach( key -> {
			key.setText("componente"+key.getId().substring(2, 3)+": vazio");
		});
		
		List<Componente> componentes = MainApp.getUsuario().getUsuarioComponentes();
		Iterator<Button> it = listbuttons.iterator();
		for (Componente componente : componentes) {
			
			if(it.hasNext()){
				Button button = it.next();
				button.setText(componente.getNome());
				button.setVisible(true);
			}
		}
		
//		List<Estatistica> estatisticas = componente.getComponenteEstatisticas();
//		for(Estatistica estatistica : estatisticas){
//			System.out.println(estatistica.getHorario());
//			System.out.println(estatistica.isValor());
//		}
		
		listbuttons.forEach( key -> {
			key.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Iterator<Componente> it2 = componentes.iterator();
					while(it2.hasNext()){
						Componente componente = it2.next();
						if(key.getText().equals(componente.getNome())){
							MainApp.setComponenteMain(componente);
						}
					}
					
					Util.gotoPage(componentDetail, "../view/ComponentDetail.fxml", "ComponentDetailController", mainApp);
				}
			});
		});
		
    }

	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	
	
}
