package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import model.Componente;

public class RemoveComponentController {
	
	private MainApp mainApp;
	
	@FXML
	Spinner<String> spinner;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}

	List<String> nomesComponentes;
	SpinnerValueFactory valueFactory;
	
    public void initialize() throws ClassNotFoundException, SQLException{
		List<Componente> componentes = MainApp.getUsuario().getUsuarioComponentes();
		nomesComponentes =  new ArrayList<String>();
		for (Componente componente : componentes) {
			nomesComponentes.add(componente.getNome());			
		}
		
    	valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(FXCollections.observableArrayList(nomesComponentes));
    	spinner.setValueFactory(valueFactory);
    }
	
	@FXML
	public void handlerRemove() throws ClassNotFoundException, SQLException{
		
		//TODO URGENTE iterar listar de componentes
    	Componente.delComponente(spinner.getValue());
		Iterator<String> it = nomesComponentes.iterator();
		while(it.hasNext()){
			if(it.next().equals(spinner.getValue())){
				it.remove();
			}
		}
		
		valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(FXCollections.observableArrayList(nomesComponentes));
		spinner.setValueFactory(valueFactory);
		
//		List<Componente> componentes =  MainApp.getUsuario().getUsuarioComponentes();
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
