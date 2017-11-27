package movie.model;

import movie.view.MovieController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MovieListeners {
	public static void setTitleListener() {
		movieTitle.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> movieStat, String oldPropertyValue, String newPropertyValue) {
		    	sendChange(movie, movieTitle.getText(), "TITLE");
		    }
		});
	}
	
	public static void setDirectorListener() {
		director.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> movieStat, String oldPropertyValue, String newPropertyValue) {
		    	sendChange(movie, director.getText(), "DIRECTOR");
		    }
		});
	}
	
	public static void setYearListener() {
		releaseYear.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> movieStat, String oldPropertyValue, String newPropertyValue) {
		    	handleChanged(oldPropertyValue, newPropertyValue);
		    }
		});
	}
	
	public static void setWriterListener() {
		writer.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> movieStat, String oldPropertyValue, String newPropertyValue) {
		    	sendChange(movie, writer.getText(), "WRITER");
		    }
		});
	}
	
	public static void setRatingListener() {
		ratingSlider.valueProperty().addListener(new ChangeListener<Object>() {
	        @Override
	        public void changed(ObservableValue<?> movieStat, Object oldPropertyValue, Object newPropertyValue) {
	        	ratingText.textProperty().setValue(String.valueOf((int) ratingSlider.getValue()));
	        	sendChange(movie, ratingText.getText(), "RATING");
	        }
	    });
	}
}
