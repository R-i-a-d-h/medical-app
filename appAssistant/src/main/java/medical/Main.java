package medical;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        Image icon = new Image(getClass().getResourceAsStream("img/care.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();






    }
    public static void main(String[] args) {
        launch(args);
    }
}