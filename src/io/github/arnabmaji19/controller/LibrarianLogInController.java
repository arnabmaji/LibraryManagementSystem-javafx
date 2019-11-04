package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.client.MongoCollection;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.Librarian;
import io.github.arnabmaji19.model.WindowSize;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.PasswordAuthentication;

import static com.mongodb.client.model.Filters.eq;

public class LibrarianLogInController {

    @FXML private StackPane stackPane;
    @FXML private JFXTextField librarianEmailTextField;
    @FXML private JFXPasswordField librarianPasswordField;

    @FXML
    private void onLibrarianLogIn(ActionEvent event){
        String email = librarianEmailTextField.getText();
        String password = librarianPasswordField.getText();
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Text("Status"));
        if(email.isBlank() && password.isBlank()){
            layout.setBody(new Text("Empty filed"));
        } else{
            MongoCollection<Librarian> librarianMongoCollection = Database.getInstance().getLibrarianCollection();
            Librarian librarian = librarianMongoCollection.find(eq("email",email)).first();
            if(librarian != null && librarian.getPassword().equals(password)){
                //Log In successful
                layout.setBody(new Text("Log In successful!"));
                PauseTransition delay = new PauseTransition(Duration.seconds(2));
                delay.setOnFinished(event1 -> switchSceneToLibrarianPanel(event));
                delay.play();
            } else{
                //Log In failed
                layout.setBody(new Text("Log in failed!"));
            }
        }
        JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }

    private void switchSceneToLibrarianPanel(ActionEvent event){
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/librarian_panel.fxml"));
            primaryStage.setTitle("Librarian Panel");
            primaryStage.setScene(new Scene(root, WindowSize.Width, WindowSize.Height));
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
