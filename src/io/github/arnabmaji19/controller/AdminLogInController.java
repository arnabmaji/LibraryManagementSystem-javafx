package io.github.arnabmaji19.controller;

import com.jfoenix.controls.*;
import io.github.arnabmaji19.model.WindowSize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminLogInController {
    private static final String FAKE_EMAIL = "admin@mail";
    private static final String FAKE_PASSWORD = "admin";

    @FXML private StackPane stackPane;
    @FXML private JFXTextField adminEmailTextField;
    @FXML private JFXPasswordField adminPasswordField;

    @FXML
    private void onAdminLogIn(ActionEvent e) throws Exception{
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        String email = adminEmailTextField.getText();
        String password = adminPasswordField.getText();
        if(email.equals(FAKE_EMAIL) && password.equals(FAKE_PASSWORD)){
            //Navigate to admin Panel
            Parent root = FXMLLoader.load(getClass().getResource("/io/github/arnabmaji19/resources/fxml/admin_panel.fxml"));
            stage.setTitle("Admin Panel");
            stage.setScene(new Scene(root, WindowSize.Width, WindowSize.Height));
            stage.show();
        } else {
            //Show Log In Failed
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Text("Error"));
            layout.setBody(new Text("Invalid Log In or Password"));
            JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
            dialog.show();
        }
    }
}
