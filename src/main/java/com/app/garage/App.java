package com.app.garage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

 

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/login/login-form.fxml"));
        Parent root = loader.load();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/ICONS/AppIcon/main.png"))));
        stage.setTitle("Daragmeh Center");
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.setResizable(false);
        stage.show();
    }
  
    public static void main(String[] args) {
        launch();
    }


}