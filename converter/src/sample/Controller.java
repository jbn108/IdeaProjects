package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ComboBox conversionType;
    public TextField unitInput;
    public TextField unitOutput;

    public void handleInput(ActionEvent actionEvent) {
        String choice = (String) conversionType.getSelectionModel().getSelectedItem();
        String input =  unitInput.getText();
        unitOutput.setText(String.valueOf(input + 5));

        switch (choice){
            case "Celcius to Fahrenheit":
                unitOutput.setText(String.valueOf(conversionMethods.celciusToFahrenheit(input)));
                break;
            case "Meter to Yards":
                unitOutput.setText(String.valueOf(conversionMethods.meterToYards(input)));
                break;
            case "Cm to inches":
                unitOutput.setText(String.valueOf(conversionMethods.cmToInch(input)));
                break;
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        conversionType.getItems().addAll("Celcius to Fahrenheit", "Meter to Yards", "Cm to inches");
    }
}
