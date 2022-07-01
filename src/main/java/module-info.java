module com.app.garage {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    requires MaterialFX;
    
    opens com.app.garage.controllers.employee to javafx.fxml;
    opens com.app.garage to javafx.fxml;
    opens com.app.garage.controllers.login to javafx.fxml;
    opens com.app.garage.controllers.Owner to javafx.fxml;
    
    exports com.app.garage.controllers.employee;
    exports com.app.garage;
    exports com.app.garage.controllers.login;
    exports com.app.garage.controllers.Owner;
}