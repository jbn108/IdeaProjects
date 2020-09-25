package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private TextField txtInput;

    @FXML
    private void clickButton(ActionEvent actionEvent) {
        System.out.println("You clicked!");
        label.setText(txtInput.getText());

        Stage stage =  (Stage) label.getScene().getWindow();
        stage.setTitle(txtInput.getText());
    }
}
