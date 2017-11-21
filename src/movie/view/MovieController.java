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
import javafx.scene.input.InputMethodEvent;
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

    public MovieController(MovieObservable movie) {
    	this.movie = movie;
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
