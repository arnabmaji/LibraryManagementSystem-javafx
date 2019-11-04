package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.Librarian;
import io.github.arnabmaji19.model.WindowSize;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class AddLibrarianController implements Initializable {

    @FXML private StackPane stackPane;
    @FXML private JFXTextField nameTextField;
    @FXML private JFXTextField emailTextField;
    @FXML private JFXPasswordField passwordTextField;
    @FXML private JFXTextField contactTextField;

    private MongoCollection<Librarian> librarianMongoCollection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        librarianMongoCollection = Database.getInstance().getLibrarianCollection();
    }

    @FXML
    private void onAddLibrarian(ActionEvent event){
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String contactNumber = contactTextField.getText();

        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Text("Status"));
        if(createNewLibrarian(name,email,password,contactNumber)){
            layout.setBody(new Text("Successfully created Librarian: " + name));
        } else {
            layout.setBody(new Text("Failed to create Librarian"));
        }
        JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }

    private boolean createNewLibrarian(String name, String email, String password, String contactNumber){
        if(name.isBlank() ||
            email.isBlank() ||
            password.isBlank() ||
            contactNumber.isBlank() ||
            librarianMongoCollection.find(eq("email",email)).first() != null){
            return false;
        }

        //Adding new Librarian in Background Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                Librarian librarian = new Librarian(name, email, password, contactNumber);
                librarianMongoCollection.insertOne(librarian);
            }
        }).start();
        return true;
    }
}
