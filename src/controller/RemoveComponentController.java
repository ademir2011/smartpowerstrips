package controller;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import model.Componente;

public class RemoveComponentController {
	
	private MainApp mainApp;
	
	@FXML
	Spinner<String> spinner;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void handlerRemove() throws ClassNotFoundException, SQLException{
		
		//TODO URGENTE iterar listar de componentes
		
//		List<Componente> componentes = eu.getUsuarioComponentes();
//		for (Componente componente : componentes) {
//			List<Estatistica> estatisticas = componente.getComponenteEstatisticas();
//			for(Estatistica estatistica : estatisticas){
//				System.out.println(estatistica.getHorario());
//				System.out.println(estatistica.isValor());
//			}
//		}
		
//		Componente componente = new Componente("quarto2","foda-se", null);
//		componente.delComponente();
		
	}
	

}
