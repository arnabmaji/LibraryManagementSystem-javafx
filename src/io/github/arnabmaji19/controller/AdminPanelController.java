package io.github.arnabmaji19.controller;

import io.github.arnabmaji19.model.WindowSize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stage = new Stage();
        stage.setWidth(WindowSize.Width);
        stage.setHeight(WindowSize.Height);
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    @FXML private void addLibrarian(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/add_librarian.fxml"));
            stage.setTitle("Add Librarian");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML private void deleteLibrarian(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/delete_librarian.fxml"));
            stage.setTitle("Delete Librarian");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void viewLibrarian(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/view_librarian.fxml"));
            stage.setTitle("View Librarian");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML private void logout(ActionEvent event){
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
