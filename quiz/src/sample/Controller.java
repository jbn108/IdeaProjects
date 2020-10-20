package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;



public class Controller {

    public Label pageLabel;
    public Label qTopLabel;
    public Label qBottomLabel;
    public TextField txtField = null;
    public ToggleGroup grp1 = new ToggleGroup();
    public ToggleGroup grp2 = new ToggleGroup();


    public void handleQuestion(ActionEvent actionEvent) {
        buttonReader.readButton(grp1);
        buttonReader.readButton(grp2);
        txtField.setText(buttonReader.getScore());
        buttonReader.resetButtons(grp1);
        buttonReader.resetButtons(grp2);
        questions.updateLabels(pageLabel, qTopLabel, qBottomLabel);
    }
}

