package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.function.LongBinaryOperator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ComponentDetailController {

	private MainApp mainApp;
	
	@FXML
	Label pane1, pane2, pane3;
	
	@FXML private LineChart<String, Integer> lineChart;

	private final ObservableList<XYChart.Data<String,Integer>> xyList1 = FXCollections.observableArrayList();

	private final XYChart.Series series1 = new XYChart.Series(xyList1);

	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	@FXML
    public void initialize() {
		series1.setName("Ponto de fechamento de ciclo");
	    lineChart.getData().addAll(series1);
	    System.out.println(MainApp.getComponenteMain().getNome());
	}
	
	boolean close = false;
	
	@FXML
	public void handlerLigar(){
		
		close = false;
		
		new Thread( new Runnable() {
			
			@Override
			public void run() {
//				Estatistica e = new Estatistica(null,true);
//				e.addEstatistica(c.getNome());
				for(int i = 0; i < 100; i++){
					Platform.runLater(new Runnable() {
		                 @Override public void run() {
		                	 series1.getData().add(new XYChart.Data<>(Util.getCurrentTime(), new Random().nextInt(3000)));
		                	 if(series1.getData().size() > 10){
		                		 series1.getData().remove(0);
		                	 }
		                 }
					});
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (close) break;
				}
			    
			}
			
		}).start();
		
	}
	
	@FXML
	public void handlerDesligar(){
		
		close = true;
		
	}
	
}
