/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import movierecsys.OwsMain;
import movierecsys.be.Movie;
import movierecsys.gui.model.MovieModel;

import static java.lang.String.valueOf;
import static javafx.scene.control.SelectionMode.*;

/**
 *
 * @author pgn
 */
public class MovieRecController implements Initializable
{

    /**
     * The TextField containing the URL of the targeted website.
     */
    @FXML
    private TextField txtMovieSearch;
    @FXML
    private TextField titleField;
    @FXML
    private TextField yearField;
    @FXML
    private Label idField;
    @FXML
    private MovieModel movieModel;

    /**
     * The TextField containing the query word.
     */
    @FXML
    private ListView<Movie> lstMovies;
    private boolean createNewMovie = false;


    public MovieRecController() {
        txtMovieSearch = new TextField();
        titleField = new TextField();
        yearField = new TextField();
        idField = new Label();
        try {
            movieModel = new MovieModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstMovies.setItems(movieModel.getMovies());
        updateTextFields();


    }
    @FXML
    public void handleSearchButton(ActionEvent actionEvent) throws IOException {
        movieModel.searchMovies(txtMovieSearch.getText());
        lstMovies.setItems(movieModel.getMovies());
    }


    public void handleCreate(ActionEvent actionEvent) throws IOException {
        if(!createNewMovie){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Create New Movie");
            alert.setHeaderText("Enter the movies title, and year of release\r\n " +
                    "Then click the Create-button again to create.");
            alert.setContentText("Are you sure you want to create a new movie?");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                createNewMovie = true;
                yearField.setText("");
                titleField.setText("");
                idField.setText("");
            }
        }

        if (createNewMovie){
            if(!yearField.getText().isEmpty() && !titleField.getText().isEmpty()){
                movieModel.createMovie(Integer.parseInt(yearField.getText()), titleField.getText());
                updateMovies();
                createNewMovie = false;
            }

        }

    }

    public void handleEdit(ActionEvent actionEvent) throws IOException {
        Movie movie = lstMovies.getSelectionModel().getSelectedItem();
        String title = titleField.getText();
        int year = Integer.parseInt(yearField.getText());
        int id = movie.getId();
        movieModel.updateMovie(new Movie(id, year, title));
        updateMovies();

    }

    public void handleDelete(ActionEvent actionEvent) throws IOException {
        Movie movie = lstMovies.getSelectionModel().getSelectedItem();
        if (!movie.getTitle().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Warning: Deleting a movie can not be undone!");
            alert.setContentText("Are you sure you want to delete the movie: \r\n" + movie.getTitle() + "?");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                movieModel.deleteMovie(movie);
            }
        }
    }

    public void updateMovies() throws IOException {
        movieModel.updateMovies();
        lstMovies.setItems(movieModel.getMovies());
    }

    public void handleSelectedMovie(){
        updateTextFields();
    }

    private void updateTextFields(){
        if(lstMovies.getSelectionModel().getSelectedItem() != null){
            Movie movie = lstMovies.getSelectionModel().getSelectedItem();
            titleField.setText(movie.getTitle());
            yearField.setText(String.valueOf(movie.getYear()));
            idField.setText(String.valueOf(movie.getId()));
        }
        else {
            titleField.setText("");
            yearField.setText("");
            idField.setText("");
        }
    }

    public void handleLogin(ActionEvent actionEvent) {
    }
}