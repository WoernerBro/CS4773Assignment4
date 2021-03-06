package movie.model;

import java.util.Observable;

import movie.view.MovieController;

public class MovieObservable extends Observable{

	private Movie movie;
	private String lastStatChange;
	private String lastChangedStat;
	private MovieController lastController;
	
	public MovieObservable() {
		movie = Movie.getInstanceOfMovie();
		lastStatChange = null;
		lastChangedStat = null;
		lastController = null;
	}
	
	public String getMovieTitle() {
		return movie.getMovieTitle();
	}

	public void setMovieTitle(String movieTitle) {
		this.movie.setMovieTitle(movieTitle);
	}

	public int getReleaseYear() {
		return movie.getReleaseYear();
	}

	public void setReleaseYear(int releaseYear) {
		this.movie.setReleaseYear(releaseYear);
	}

	public String getDirector() {
		return movie.getDirector();
	}

	public void setDirector(String director) {
		this.movie.setDirector(director);
	}

	public String getWriter() {
		return movie.getWriter();
	}

	public void setWriter(String writer) {
		this.movie.setWriter(writer);
	}

	public int getRating() {
		return movie.getRating();
	}

	public void setRating(int rating) {
		this.movie.setRating(rating);
	}
	
	public void ChangeMovieString(MovieController controller, String newStat, String changedStat) {
		lastStatChange = newStat;
		lastController = controller;
		lastChangedStat = changedStat;
		if (changedStat.equals("TITLE"))
			setMovieTitle(newStat);
		else if (changedStat.equals("DIRECTOR"))
			setDirector(newStat);
		else if (changedStat.equals("YEAR"))
			setReleaseYear(Integer.valueOf(newStat));
		else if (changedStat.equals("WRITER"))
			setWriter(newStat);
		else if (changedStat.equals("RATING"))
			setRating(Integer.valueOf(newStat));
		this.setChanged();
		this.notifyObservers();
	}

	public String getLastStatChange() {
		return lastStatChange;
	}

	public MovieController getLastController() {
		return lastController;
	}
	
	public String getLastChangedStat() {
		return lastChangedStat;
	}
}
