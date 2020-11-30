package movierecsys.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import movierecsys.be.Movie;
import movierecsys.bll.MovieManager;

import java.awt.*;
import java.io.IOException;

public class CreateMovieDialogController {

    @FXML
    private TextField titleField;
    @FXML
    private TextField yearField;

    private int ID;
    private Stage dialogStage;
    private Movie movie;
    private boolean okClicked;
    private MovieManager movieManager;

    @FXML
    private void initialize() throws IOException {
        movieManager = new MovieManager();
        okClicked = false;
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void handleAdd(ActionEvent actionEvent) throws IOException {

            String title = titleField.getText();
            int year = Integer.parseInt(yearField.getText());
            movieManager.createMovie(year, title);
            okClicked = true;
            dialogStage.close();

    }


    public void handleCancel(ActionEvent actionEvent) {
        dialogStage.close();
    }
}
