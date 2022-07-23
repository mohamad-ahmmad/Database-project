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
    //Mhammad:192.168.18.133
    //Bdair:192.168.86.128
    public void Connect(){
        
    }

<<<<<<< HEAD
    public static final String ip = "jdbc:oracle:thin:@192.168.86.131:1521:xe",
    user= "c##DaraghmehCompany",
    password= "12345" ;
=======
    public static final String ip = "jdbc:oracle:thin:@192.168.18.152:1521:xe",
    user= "c##daraghmeh",
    password= "123456" ;
>>>>>>> 435b6a941888d988830c04f7a6e5b311b9a63a6e


    
    
    private static Stage ss;
    
    public static  Stage getAppStage(){
        return ss;
    }
    public static void setMainScene(Scene temp){
        //hello bdair
        ss.setScene(temp);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/login/login-form.fxml"));
        Parent root = loader.load();
        ss = new Stage();
        ss.getIcons().add(new Image(String.valueOf(getClass().getResource("/ICONS/AppIcon/main.png"))));
        ss.setTitle("Daragmeh Center");
        Scene s = new Scene(root );
        ss.setScene(s);
        ss.setResizable(false);
        ss.show();
    }
  
    public static void main(String[] args)  {
        launch();
    
    }


}
