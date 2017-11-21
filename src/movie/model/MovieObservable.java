package movie.model;

import java.util.Observable;

public class MovieObservable extends Observable{

	private Movie movie;
	
	public MovieObservable() {
		movie = Movie.getInstanceOfMovie();
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
}
