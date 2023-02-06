package medical;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerConsult  implements Initializable {

    public Label fPhone;
    public AnchorPane root;
    public ImageView img;
    public Label fPatient;
    public Label fStats;

    public AnchorPane paneMassage;
    public Label message;
    public JFXButton btn;

    private double x;
    private double y;
    ObservableList<PatientForWaitingRoom> observableList;
    PatientForWaitingRoom patientForWaitingRoom;
    Db db = new Db();

    public ControllerConsult(ObservableList<PatientForWaitingRoom> observableList, PatientForWaitingRoom patientForWaitingRoom) {
        this.observableList = observableList;
        this.patientForWaitingRoom = patientForWaitingRoom;
    }

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
        if (patientForWaitingRoom!=null){

            if(patientForWaitingRoom.getStatus().equals("Waiting")){
                btn.setText("Consult");
            }else if(patientForWaitingRoom.getStatus().equals("Consult")){
                btn.setText("Pass");
            }else if(patientForWaitingRoom.getStatus().equals("Pass")){
                btn.setText("Waiting");
            }
            fPatient.setText("Patient : "+patientForWaitingRoom.getFirstName()+" "+patientForWaitingRoom.getLastName());
            fPhone.setText("Phone : "+patientForWaitingRoom.getPhone());
            fStats.setText("Status : "+patientForWaitingRoom.getStatus());

            if (patientForWaitingRoom.getGender().equals("Female")){
                Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                img.setImage(imProfile);
            }else {
                Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                img.setImage(imProfile);
            }
        }


    }

    public void onConsultPatient(ActionEvent actionEvent) {


            if(patientForWaitingRoom.getStatus().equals("Consult")){
                observableList.remove(patientForWaitingRoom);
                patientForWaitingRoom.setStatus("Pass");
                db.updateStatus(patientForWaitingRoom);
                fStats.setText("Status : "+patientForWaitingRoom.getStatus());
                observableList.add(patientForWaitingRoom.getNumber()-1,patientForWaitingRoom);

            }
            else if(patientForWaitingRoom.getStatus().equals("Waiting")){
                for (int i = 0;i<observableList.size();i++){
                    if(observableList.get(i).getStatus().equals("Consult")){
                        PatientForWaitingRoom p =  observableList.get(i);
                        observableList.remove(p);
                        p.setStatus("Pass");
                        db.updateStatus(p);

                        observableList.add(i,p);
                    }
                }
                observableList.remove(patientForWaitingRoom);
                patientForWaitingRoom.setStatus("Consult");

                db.updateStatus(patientForWaitingRoom);
                observableList.add(patientForWaitingRoom.getNumber()-1,patientForWaitingRoom);
                fStats.setText("Status : "+patientForWaitingRoom.getStatus());

                db.superUpdate(observableList);

            }  else if(patientForWaitingRoom.getStatus().equals("Pass")){
                observableList.remove(patientForWaitingRoom);
                patientForWaitingRoom.setStatus("Waiting");
                db.updateStatus(patientForWaitingRoom);
                fStats.setText("Status : "+patientForWaitingRoom.getStatus());
                observableList.add(patientForWaitingRoom.getNumber()-1,patientForWaitingRoom);
            }




    }
    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();

    }



    public void onWaitingPatient(ActionEvent actionEvent) {





    }
}
