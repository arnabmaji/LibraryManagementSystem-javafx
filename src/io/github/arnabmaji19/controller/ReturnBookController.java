package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.client.result.DeleteResult;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.IssueDetail;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ReturnBookController {

    @FXML private StackPane stackPane;
    @FXML private JFXTextField bookIdTextField;
    @FXML private JFXTextField studentIdTextField;

    @FXML private void onReturnBook(){
        int bookId = Integer.parseInt(bookIdTextField.getText());
        int studentId = Integer.parseInt(studentIdTextField.getText());

        IssueDetail issueDetail = Database.getInstance()
                .getIssueDetailCollection()
                .findOneAndDelete(and(eq("bookId", bookId), eq("studentId", studentId)));
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Text("Status"));
        if(issueDetail == null){
            layout.setBody(new Text("Invalid Selection"));
        } else {
            layout.setBody(new Text("Book successfully returned"));
        }
        new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER).show();

    }
}
