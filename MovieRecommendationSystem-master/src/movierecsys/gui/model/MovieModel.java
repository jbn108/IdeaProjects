package movierecsys.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movierecsys.be.Movie;
import movierecsys.bll.MovieManager;
import movierecsys.bll.util.MovieSearcher;
import movierecsys.dal.MovieDAO;

import java.io.IOException;
import java.util.List;

public class MovieModel {

    private ObservableList<Movie> movies;
    private ObservableList<Movie> movies2;
    private MovieSearcher movieSearcher;
    MovieManager movieManager = new MovieManager();

    public MovieModel() throws IOException {
        movieSearcher = new MovieSearcher();
        movies = FXCollections.observableArrayList();
        movies2 = FXCollections.observableArrayList();
        movies.addAll(movieManager.getMovies());
        movies2.add(new Movie(50,1950,"no title"));
    }

    public ObservableList<Movie> getMovies(){
        return movies;
    }
    public ObservableList<Movie> getMovies2(){
        return movies2;
    }

    public void searchMovies(String query) throws IOException {
        List<Movie> foundMovies = movieSearcher.search(movies, query);
        movies.clear();
        movies.addAll(foundMovies);
    }

}
