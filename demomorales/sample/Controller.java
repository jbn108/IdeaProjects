package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    public TextArea txtOutput;
    public TextField txtInput;
    public ChoiceBox<String> choiceAssignment;

    public void HandleInput(ActionEvent actionEvent) {
        String choice = choiceAssignment.getSelectionModel().getSelectedItem();
        String input = txtInput.getText();
        txtOutput.setText(input);


        switch (choice)
        {
            case "Assignment 1":
                txtOutput.setText(StringUtils.exc1(input));
                break;
            case "Assignment 2":
                txtOutput.setText(StringUtils.exc2(input)+"");
                break;
            case "Assignment 3":
                txtOutput.setText(StringUtils.exc3(input));
                break;
            case "Assignment 4":
                txtOutput.setText(StringUtils.exc4(input));
                break;
            case "Assignment 5":
                txtOutput.setText(StringUtils.exc5(input));
                break;
            case "Assignment 6":
                txtOutput.setText(StringUtils.exc6(input));
                break;
            case "Assignment 7":
                txtOutput.setText(StringUtils.exc7(input));
               break;
            case "Assignment 8":
                txtOutput.setText(StringUtils.exc8(input));
                default:
                    input = "Unknown selection";
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceAssignment.getItems().addAll("Assignment 1", "Assignment 2", "Assignment 3", "Assignment 4",
                "Assignment 5", "Assignment 6", "Assignment 7", "Assingment 8");

    }
}
