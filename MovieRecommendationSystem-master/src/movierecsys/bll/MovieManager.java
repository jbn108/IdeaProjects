package movierecsys.bll;

import javafx.collections.ObservableList;
import movierecsys.be.Movie;
import movierecsys.dal.MovieDAO;

import java.io.IOException;
import java.util.List;

public class MovieManager {
    MovieDAO movieDAO = new MovieDAO();
    List<Movie> movies;

    public MovieManager() throws IOException {
        movies = movieDAO.getAllMovies();
    }

    public List<Movie> getMovies() throws IOException {
        return movieDAO.getAllMovies();
    }

    public void deleteMovie(Movie movie) throws IOException {
        movieDAO.deleteMovie(movie);
    }

    public void updateMovie(Movie movie){
        try {
            movieDAO.updateMovie(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createMovie(int year, String title) throws IOException {
        movieDAO.createMovie(year, title);
    }



}
