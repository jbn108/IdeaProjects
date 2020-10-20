package sample;

import javafx.fxml.FXMLLoader;

import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class buttonReader {
    private static int ones = 0;
    private static int twos = 0;
    private static int threes = 0;

    public static void readButton(ToggleGroup grp){
        String test = String.valueOf(grp.getSelectedToggle());

        if (test.contains("bOneOne") || test.contains("bTwoOne")){
            ones++;
        } else if (test.contains("bOneTwo") || test.contains("bTwoTwo")){
            twos++;
        } else if (test.contains("bOneThree") || test.contains("bTwoThree")){
            threes++;
        }
    }

    public static String getScore(){
        return "One's: " + ones + " Two's: " + twos + " Three's: " + threes;
    }

    public static void resetButtons(ToggleGroup grp) {
        grp.selectToggle(null);
    }
}
