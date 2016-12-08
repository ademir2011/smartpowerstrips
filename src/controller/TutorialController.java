package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class TutorialController {

	private MainApp mainApp;
	
	@FXML
	MediaView mvMedia;
	
	@FXML
	Slider sliderMedia;
	
	MediaPlayer mp;
	Media media;
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		
	}
	
	public void initialize(){
    	
//		media = new Media("file:///C://Users//ademi//Downloads//vangelis.mp4");
//    	
//    	mp = new MediaPlayer(media);
//    	mvMedia.setMediaPlayer(mp);
//    	mp.setAutoPlay(true);
//    	
//    	sliderMedia.setOnMousePressed(new EventHandler<MouseEvent>(){
//    	    @Override
//    	    public void handle(MouseEvent event) {
//    	    	mp.seek(Duration.seconds(sliderMedia.getValue()));
//    	    }
//    	});
    	
    }
    
    @FXML
    public void handlerRefresh(){
    	
//		media = new Media("file:///"+mediathis.getFilePath().replace("\\", "/"));
//    	
//    	mp = new MediaPlayer(media);
//    	mvMedia.setMediaPlayer(mp);
//    	mp.setAutoPlay(true);
//    	
//    	sliderMedia.setOnMousePressed(new EventHandler<MouseEvent>(){
//    	    @Override
//    	    public void handle(MouseEvent event) {
//    	    	mp.seek(Duration.seconds(sliderMedia.getValue()));
//    	    }
//    	});
    	
    }
    
    @FXML
    public void handlerPlay(){
    	
    	mp.play();
    	
    }
    
    @FXML
    public void handlerPause(){
    	
    	mp.pause();
    	
    }
    
    @FXML
    public void handlerPositive(){
    	
    	if( mp.getVolume() < 1 ){
        	mp.setVolume(mp.getVolume() + 0.1);
    	}
    	
    }
    
    @FXML
    public void handlerNegative(){
    	
    	if( mp.getVolume() >= 0 ){
        	mp.setVolume(mp.getVolume() - 0.1);
    	}
    	
    }
	
}
