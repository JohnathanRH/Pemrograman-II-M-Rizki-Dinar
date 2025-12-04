package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/app.fxml"));
            Parent root = loader.load();
            root.requestFocus();

            Scene scene = new Scene(root);
            primaryStage.setTitle("Program Transaksi Buku");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
