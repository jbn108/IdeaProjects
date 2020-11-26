/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import movierecsys.be.Movie;
import movierecsys.gui.model.MovieModel;

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
    private MovieModel movieModel;

    /**
     * The TextField containing the query word.
     */
    @FXML
    private ListView<Movie> lstMovies;


    public MovieRecController() {
        txtMovieSearch = new TextField();
        try {
            movieModel = new MovieModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstMovies.setItems(movieModel.getMovies());

    }
    @FXML
    public void handleSearchButton(ActionEvent actionEvent) throws IOException {
        StringProperty input = new SimpleStringProperty();
        input.set(txtMovieSearch.getText());

        System.out.println(input);
        //lstMovies.setItems(movieModel.getMovies2());


    }



}