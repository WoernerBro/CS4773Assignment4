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
		movieTitle.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> arg0, String oldPropertyValue, String newPropertyValue) {
		    	//Set variable, send signal
		    	System.out.println("Title changed");
		    }
		});
		director.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> arg0, String oldPropertyValue, String newPropertyValue) {
		    	//Set variable, send signal
		    	System.out.println("Director changed");
		    }
		});
		releaseYear.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> arg0, String oldPropertyValue, String newPropertyValue) {
		    	//Validate input as integer, set variable, send signal
		    	System.out.println("Year changed");
		    }
		});
		writer.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> arg0, String oldPropertyValue, String newPropertyValue) {
		    	//Set variable, send signal
		    	System.out.println("Writer changed");
		    }
		});
		ratingSlider.valueProperty().addListener(new ChangeListener<Object>() {
	        @Override
	        public void changed(ObservableValue<?> arg0, Object arg1, Object arg2) {
	        	ratingText.textProperty().setValue(String.valueOf((int) ratingSlider.getValue()));
	        	//Set variable, send signal
	        }
	    });
	}
	
	public void sendStringChange(MovieObservable movie, String newString, String changedStat) {
		System.out.println("Send Change: " + newString);
		movie.ChangeMovieString(this, newString, changedStat);
	}
	
	public void sendIntegerChange(MovieObservable movie, int newInteger, String changedStat) {
		System.out.println("Send Change: " + newInteger);
		movie.ChangeMovieInteger(this, newInteger, changedStat);
	}
	
	private void receiveStringChange(String newString) {
		System.out.println("Recieve Change: " + newString);
	}
	
	private void receiveIntegerChange(int newInteger) {
		System.out.println("Recieve Change: " + newInteger);
	}

	@Override
	public void update(Observable o, Object changeType) {
		MovieObservable movie = (MovieObservable) o;
		if(movie.getLastController() != this) {
			if (String.valueOf(changeType).equals("STRING"))
				receiveStringChange(movie.getLastStringChange());
			if (String.valueOf(changeType).equals("INTEGER"))
				receiveIntegerChange(movie.getLastIntegerChange());
		}
	}
}
