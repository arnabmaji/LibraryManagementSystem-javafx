package io.github.arnabmaji19.controller;

import com.jfoenix.controls.JFXButton;
import io.github.arnabmaji19.model.WindowSize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML private JFXButton adminPanelButton;
    @FXML private JFXButton librarianPanelButton;

    @FXML private void onUserSelectionMade(ActionEvent e) throws Exception{
        Object event = e.getSource();
        Stage stage = (Stage) ((Node) event).getScene().getWindow();
        StringBuilder fxmlPath = new StringBuilder("/io/github/arnabmaji19/resources/fxml/");
        //If the user clicks on Admin
        if(event.equals(adminPanelButton)){
            //Set up Admin Login Window
            stage.setTitle("Admin Log In Panel");
            fxmlPath.append("admin_login.fxml");
        } else {
            stage.setTitle("Librarian Log In Panel");
            fxmlPath.append("librarian_login.fxml");
        }

        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath.toString()));
        stage.setScene(new Scene(root, WindowSize.Width, WindowSize.Height));
        stage.show();
    }

}
