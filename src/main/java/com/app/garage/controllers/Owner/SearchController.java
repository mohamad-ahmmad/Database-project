package com.app.garage.controllers.Owner;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchController {
    private AnchorPane Pane;
    Stage stage;
    Scene scene;

    @FXML
    void Done(ActionEvent event) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/UI/OwnerPage/DepartmentsPage.fxml"));
        Parent root = loader.load();
        DepartmentController dc;
        Pane=loader.getRoot();
        Pane.getChildren().remove(3);
    }

}
