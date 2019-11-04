package io.github.arnabmaji19.controller;

import io.github.arnabmaji19.model.WindowSize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibrarianPanelController implements Initializable {
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stage = new Stage();
        stage.setHeight(WindowSize.Height);
        stage.setWidth(WindowSize.Width);
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    @FXML private void onAddBook(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/add_book.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Add Book");
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void onViewBook(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/view_book.fxml"));
            stage.setTitle("View Book");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void onIssueBook(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/issue_book.fxml"));
            stage.setTitle("Issue Book");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void onViewIssuedBooks(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/view_issued_books.fxml"));
            stage.setTitle("View Issued Book");
            stage.setScene(new Scene(root, WindowSize.Width, WindowSize.Height));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void onReturnBook(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/return_book.fxml"));
            stage.setTitle("Return Book");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void onLogOut(ActionEvent event){
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/main_window.fxml"));
            primaryStage.setTitle("Main Window");
            primaryStage.setScene(new Scene(root, WindowSize.Width, WindowSize.Height));
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
