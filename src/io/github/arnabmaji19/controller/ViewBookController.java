package io.github.arnabmaji19.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import io.github.arnabmaji19.model.Book;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.Librarian;
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

public class ViewBookController implements Initializable {

    @FXML private TableView<Book> bookTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Book> bookList = new ArrayList<>();
        MongoCursor<Book> cursor = Database.getInstance().getBookCollection().find().iterator();
        while(cursor.hasNext()){
            bookList.add(cursor.next());
        }
        ObservableList<Book> tableData = FXCollections.observableArrayList(bookList);

        TableColumn<Book, String> bookIdColumn = new TableColumn<>("ID");
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<Book, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<Book, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Book, String> issuedQuantityColumn = new TableColumn<>("Issued Quantity");
        issuedQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("issuedQuantity"));

        bookTableView.setEditable(true);
        bookTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        bookTableView.getColumns().addAll(bookIdColumn, nameColumn, authorColumn, publisherColumn, quantityColumn, issuedQuantityColumn);
        bookTableView.getItems().addAll(tableData);
    }
}
