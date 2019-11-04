package io.github.arnabmaji19.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.IssueDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewIssuedBooksController implements Initializable {

    @FXML private TableView<IssueDetail> issuedBooksTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MongoCursor<IssueDetail> cursor = Database.getInstance()
                                                    .getIssueDetailCollection()
                                                    .find().iterator();
        List<IssueDetail> list = new ArrayList<>();
        while (cursor.hasNext()){
            list.add(cursor.next());
        }
        ObservableList<IssueDetail> tableData = FXCollections.observableArrayList(list);

        TableColumn<IssueDetail, Integer> bookIdColumn = new TableColumn<>("Book ID");
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        TableColumn<IssueDetail, Integer> studentIdColumn = new TableColumn<>("Student ID");
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        TableColumn<IssueDetail, String> issueDateColumn = new TableColumn<>("Issue Date");
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        TableColumn<IssueDetail, String> returnDateColumn = new TableColumn<>("Return Date");
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        issuedBooksTableView.setEditable(true);
        issuedBooksTableView.getColumns().addAll(bookIdColumn, studentIdColumn, issueDateColumn, returnDateColumn);
        issuedBooksTableView.getItems().setAll(tableData);
        issuedBooksTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
