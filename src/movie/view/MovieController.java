package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import movie.model.MovieObservable;
import movie.model.MovieListeners;
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

    public MovieController(MovieObservable movie) {
    	this.movie = movie;
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MovieListeners.setTitleListener();
		MovieListeners.setDirectorListener();
		MovieListeners.setYearListener();
		MovieListeners.setWriterListener();
		MovieListeners.setRatingListener();
	}
	
	public void sendChange(MovieObservable movie, String newStat, String changedStat) {
		movie.ChangeMovieString(this, newStat, changedStat);
	}
	
	private void receiveChange(String newStat, String changedStat) {
		if (changedStat.equals("TITLE"))
			movieTitle.setText(newStat);
		else if (changedStat.equals("DIRECTOR"))
			director.setText(newStat);
		else if (changedStat.equals("YEAR"))
			setYear(newStat);
		else if (changedStat.equals("WRITER"))
			writer.setText(newStat);
		else if (changedStat.equals("RATING"))
			ratingSlider.setValue(Integer.valueOf(newStat));
	}

	public void setYear(String newStat) {
		if (newStat.equals("-1"))
			releaseYear.setText("");
		else
			releaseYear.setText(newStat);
	}
	
	public void handleChanged( String oldPropertyValue, String newPropertyValue) {
		if (!newPropertyValue.matches("\\d*")) {
    		releaseYear.setText(oldPropertyValue);
    	} else {
    		if (releaseYear.getText().equals(""))
    			sendChange(movie, "-1", "YEAR");
    		else
    			sendChange(movie, releaseYear.getText(), "YEAR");
    	}
	}
	
	@Override
	public void update(Observable observer, Object changedItem) {
		MovieObservable movie = (MovieObservable) observer;
		if(movie.getLastController() != this)
			receiveChange(movie.getLastStatChange(), movie.getLastChangedStat());
	}
}
