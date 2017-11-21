package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import movie.model.MovieObservable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class MovieController implements Initializable, Observer {
	
	private MovieObservable movie;
	
    @FXML
    private TextField movieTitle;

    @FXML
    private TextField director;

    @FXML
    private TextField releaseYear;

    @FXML
    private TextField writer;

    @FXML
    private Label ratingText;

    @FXML
    private Slider ratingSlider;

    public MovieController() {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ratingSlider.valueProperty().addListener(new ChangeListener<Object>() {
	        @Override
	        public void changed(ObservableValue<?> arg0, Object arg1, Object arg2) {
	        	ratingText.textProperty().setValue(
	                    String.valueOf((int) ratingSlider.getValue()));
	        }
	    });
	}
	
	public void sendChange(MovieObservable movie, Object o) {
		System.out.println("Send Change: " + o);
		movie.ChangeMovieStat(this, o);
	}
	
	private void receiveChange(Object o) {
		System.out.println("Recieve Change: " + o);
	}

	@Override
	public void update(Observable o, Object arg1) {
		MovieObservable chat = (MovieObservable) o;
		if(chat.getLastController() != this)
			receiveChange(chat.getLastChange());
	}
}
