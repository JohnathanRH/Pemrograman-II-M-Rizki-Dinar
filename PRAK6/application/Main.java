package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = null;
        try
        {
//            System.out.println(getClass().getResource("/views/table.fxml"));
            root = FXMLLoader.load(getClass().getResource("/views/table.fxml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}