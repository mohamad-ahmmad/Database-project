module com.app.garage {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    requires MaterialFX;
    requires java.sql;
 
    exports com.app.garage.controllers to javafx.fxml;
    opens com.app.garage.controllers to javafx.fxml;
    opens com.app.garage.controllers.derpartmentmanager to javafx.fxml;
    opens com.app.garage.controllers.employee to javafx.fxml;
    opens com.app.garage to javafx.fxml;
    opens com.app.garage.controllers.login to javafx.fxml;
    opens com.app.garage.controllers.Owner to javafx.fxml;
    opens com.app.garage.controllers.departmentManager to javafx.fxml;
    opens com.app.garage.controllers.warehouseManager to javafx.fxml;
    
    //opens com.app.garage.controllers to javafx.base;
   
    
    exports com.app.garage.controllers.employee;
    exports com.app.garage;
    exports com.app.garage.controllers.derpartmentmanager;
    exports com.app.garage.controllers.login;
    exports com.app.garage.controllers.Owner;
    exports com.app.garage.controllers.departmentManager;
    exports com.app.garage.controllers.warehouseManager;
    
}
