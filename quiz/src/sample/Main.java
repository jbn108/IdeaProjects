package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage guiStage;



    @Override
    public void start(Stage primaryStage) throws Exception{
        guiStage = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dosha");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        primaryStage.show();
    }

    public static Stage getStage(){
        return guiStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
