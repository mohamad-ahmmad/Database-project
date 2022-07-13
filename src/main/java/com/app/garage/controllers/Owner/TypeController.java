package com.app.garage.controllers.Owner;

import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

public class TypeController implements Initializable{

    @FXML
    private JFXRadioButton radioDepM;
    ToggleGroup tg = new ToggleGroup();

    @FXML
    private JFXRadioButton radioWareM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioDepM.setToggleGroup(tg);
        radioWareM.setToggleGroup(tg);
       
    }

}
