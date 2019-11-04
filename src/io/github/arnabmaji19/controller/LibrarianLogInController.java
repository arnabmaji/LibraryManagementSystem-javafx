package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.client.MongoCollection;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.Librarian;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.mongodb.client.model.Filters.eq;

public class LibrarianLogInController {

    @FXML private StackPane stackPane;
    @FXML private JFXTextField librarianEmailTextField;
    @FXML private JFXPasswordField librarianPasswordField;

    @FXML
    private void onLibrarianLogIn(){
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
            } else{
                //Log In failed
                layout.setBody(new Text("Log in failed!"));
            }
        }
        JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }
}
