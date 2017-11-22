package movie.model;

import java.util.Observable;

import movie.view.MovieController;

public class MovieObservable extends Observable{

	private Movie movie;
	private String lastStringChange;
	private int lastIntegerChange;
	private String lastChangedStat;
	private MovieController lastController;
	
	public MovieObservable() {
		movie = Movie.getInstanceOfMovie();
		lastStringChange = null;
		lastIntegerChange = -1;
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
	
	public void ChangeMovieString(MovieController controller, String newString, String changedStat) {
		System.out.println("Making Change: " + lastStringChange + " " + lastChangedStat);
		lastStringChange = newString;
		lastController = controller;
		lastChangedStat = changedStat;
		this.setChanged();
		this.notifyObservers("STRING");
	}
	
	public void ChangeMovieInteger(MovieController controller, int newInteger, String changedStat) {
		System.out.println("Making Change: " + lastIntegerChange + " " + lastChangedStat);
		lastIntegerChange = newInteger;
		lastController = controller;
		lastChangedStat = changedStat;
		this.setChanged();
		this.notifyObservers("INTEGER");
	}

	public String getLastStringChange() {
		return lastStringChange;
	}
	
	public int getLastIntegerChange() {
		return lastIntegerChange;
	}

	public MovieController getLastController() {
		return lastController;
	}
	
	public String getLastChangedStat() {
		return lastChangedStat;
	}
}
