package medical;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLimit implements Initializable {


   int a=-1;
   int b=0;
   public AnchorPane root;
    public TextField f1;
    public TextField f2;

    Db db = new Db();
    private  double x;
    private  double y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(e->{
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX()-x);
            stage.setY(e.getScreenY()-y);
        });

        a=  db.getLimitWaiting();
        b= db.getLimitApp();
        f1.setText(a+"");
        f2.setText(b+"");
    }

    public void onPlus(ActionEvent actionEvent) {
        if(a!=50){

            a++;
            f1.setText(a+"");
            db.updateLimitWaiting(a);

        }

    }

    public void OnMuns(ActionEvent actionEvent) {
        if(a!=0){
            a--;
            f1.setText(a+"");
            db.updateLimitWaiting(a);
        }
    }
    public void onPlus1(ActionEvent actionEvent) {
        if(b!=50){
            b++;
            f2.setText(b+"");
            db.updateLimitApp(b);
        }

    }

    public void OnMuns1(ActionEvent actionEvent) {
        if(b!=0){
            b--;
            f2.setText(b+"");
            db.updateLimitApp(b);
        }
    }

    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}
