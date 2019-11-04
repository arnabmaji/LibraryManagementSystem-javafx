package io.github.arnabmaji19;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.WindowSize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Database.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/main_window.fxml"));
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root, WindowSize.Width, WindowSize.Height));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
