package io.github.arnabmaji19.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import io.github.arnabmaji19.model.Database;
import io.github.arnabmaji19.model.Librarian;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.TableHeaderRow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewLibrarianController implements Initializable {

    @FXML private TableView<Librarian> librarianTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MongoCollection<Librarian> librarians = Database.getInstance().getLibrarianCollection();

        List<Librarian> librarianList = new ArrayList<>();
        MongoCursor<Librarian> cursor = librarians.find().iterator();
        while (cursor.hasNext()){
            librarianList.add(cursor.next());
        }

        ObservableList<Librarian> data = FXCollections.observableArrayList(librarianList);
        createTableColumns();
        librarianTable.setItems(data);
    }

    private void createTableColumns(){
        librarianTable.setEditable(true);
        TableColumn<Librarian, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Librarian, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Librarian, String> contactColumn = new TableColumn<>("Contact Number");
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        librarianTable.getColumns().setAll(nameColumn, emailColumn, contactColumn);
        librarianTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
