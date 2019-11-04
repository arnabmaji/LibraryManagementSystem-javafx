package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.Librarian;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.mongodb.client.model.Filters.eq;

public class DeleteLibrarianController {

    @FXML private JFXTextField librarianEmail;
    @FXML private StackPane stackPane;

    @FXML private void onDelete(){
        MongoCollection<Librarian> librarianMongoCollection = Database.getInstance().getLibrarianCollection();
        String email = librarianEmail.getText();
        Librarian librarian = librarianMongoCollection.findOneAndDelete(eq("email", email));

        //Showing status Dialog
        JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
        jfxDialogLayout.setHeading(new Text("Status"));
        if(librarian != null){
            jfxDialogLayout.setBody(new Text("Successfully deleted: " + email));
        } else {
            jfxDialogLayout.setBody(new Text("Couldn't delete: " + email));
        }
        JFXDialog dialog = new JFXDialog(stackPane, jfxDialogLayout, JFXDialog.DialogTransition.CENTER);
        dialog.show();
    }
}
