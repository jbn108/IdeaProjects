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

}
