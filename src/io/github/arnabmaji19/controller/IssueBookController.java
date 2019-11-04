package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import io.github.arnabmaji19.model.Book;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.IssueDetail;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.bson.Document;

import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class IssueBookController {
    @FXML private StackPane stackPane;
    @FXML private JFXTextField bookIdTextField;
    @FXML private JFXTextField studentIdTextField;

    @FXML
    private void onIssueBook(){
        MongoCollection<Book> bookMongoCollection = Database.getInstance().getBookCollection();
        int bookId = Integer.parseInt(bookIdTextField.getText());
        int studentId = Integer.parseInt(studentIdTextField.getText());
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Text("Status"));

        Book currentBook = bookMongoCollection.find(eq("bookId", bookId)).first();
        if(currentBook != null){
            int itemsAllowedForIssue = currentBook.getQuantity() - currentBook.getIssuedQuantity();
            if(itemsAllowedForIssue > 0){
                layout.setBody(new Text("Book Issued successfully!"));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LocalDate date = LocalDate.now();
                        bookMongoCollection.updateOne(eq("bookId",bookId), inc("issuedQuantity", 1));
                        IssueDetail issueDetail = new IssueDetail(bookId, studentId, date.toString(), date.plusMonths(1).toString());
                        Database.getInstance().getIssueDetailCollection().insertOne(issueDetail);
                    }
                }).start();
            } else {
                layout.setBody(new Text("Out of stock!"));
            }
        } else {
            layout.setBody(new Text("Book ID not valid!"));
        }
        new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER).show();
    }

}
