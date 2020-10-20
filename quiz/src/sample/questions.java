package sample;

import javafx.scene.control.Label;

public class questions {
    private static int page = 1;
    private static int top = 1;
    private static int bottom = 2;

    public static void updateLabels(Label pageLabel, Label qTopLabel, Label qBottomLabel) {

        pageLabel.setText("Page " + (++page) + ":" );
        qTopLabel.setText("Question " + (top += 2) + ":");
        qBottomLabel.setText("Question " + (bottom +=2) + ":");
    }

    public static int getPage(){
        return page;
    }
}
