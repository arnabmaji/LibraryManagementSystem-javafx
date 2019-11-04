package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.github.arnabmaji19.model.Book;
import io.github.arnabmaji19.model.Database;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class AddBookController {
    @FXML private StackPane stackPane;
    @FXML private JFXTextField bookIdTextField;
    @FXML private JFXTextField bookNameTextField;
    @FXML private JFXTextField authorTextField;
    @FXML private JFXTextField publisherTextField;
    @FXML private JFXTextField quantityTextField;

    @FXML private void onAddBook(){
        String bookId = bookIdTextField.getText();
        String bookName = bookNameTextField.getText();
        String author = authorTextField.getText();
        String publisher = publisherTextField.getText();
        String quantity = quantityTextField.getText();

        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Text("Status"));
        if( bookId.isBlank() ||
            bookName.isBlank() ||
            author.isBlank() ||
            publisher.isBlank() ||
            quantity.isBlank()){
            layout.setBody(new Text("Field can't be empty!"));
        } else{
            layout.setBody(new Text("Book added successfully!"));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Book book = new Book(Integer.parseInt(bookId), bookName, author, publisher ,Integer.parseInt(quantity), 0);
                    Database.getInstance().getBookCollection().insertOne(book);
                }
            }).start();
        }
        new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER).show();
    }
}
