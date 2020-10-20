package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ResourceBundle;
import java.net.URL;

public class Controller implements Initializable{



    @FXML
    private TextField txtInput;
    @FXML
    private TextArea txtOutput;
    public ChoiceBox<String> choiceAssignment;


    @FXML
    private void handleInput(ActionEvent actionEvent) {
        String choice = choiceAssignment.getSelectionModel().getSelectedItem();
        String input = txtInput.getText();
        txtOutput.setText(input);

        switch (choice){
            case "Assignment 1":
                txtOutput.setText(stringUtils.ex1(input));
                break;
            case "Assignment 2":
                txtOutput.setText(stringUtils.ex2(input));
                break;
            case "Assignment 3":
                txtOutput.setText(stringUtils.ex3(input));
                break;
            case "Assignment 4":
                txtOutput.setText(stringUtils.ex4(input));
                break;
            case "Assignment 5":
                txtOutput.setText(stringUtils.ex5(input));
                break;
            case "Assignment 6":
                txtOutput.setText(stringUtils.ex6(input));
                break;
            case "Assignment 7":
                txtOutput.setText(stringUtils.ex7(input));
                break;
            case "Assignment 8":
                txtOutput.setText(stringUtils.ex8(input));
                break;
            case "Assignment 9":
                txtOutput.setText(stringUtils.ex9(input));
                break;
            case "Assignment 10":
                txtOutput.setText(stringUtils.ex10(input));
                break;
            default: input = "Unknown selection";
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        choiceAssignment.getItems().addAll("Assignment 1", "Assignment 2", "Assignment 3", "Assignment 4",
                "Assignment 5", "Assignment 6", "Assignment 7", "Assignment 8", "Assignment 9", "Assignment 10");
    }
}
