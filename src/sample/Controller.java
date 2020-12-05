package sample;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    MainModel mainModel = new MainModel();
    Main main = new Main();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> cmboption;
    @FXML
    private Button loginb;
    @FXML
    private Label loginstatus;

    public void initialize(URL url, ResourceBundle rb){
        if(this.mainModel.dataBaseStatus()){
            this.dbstatus.setText("Connected");
        }else{
            this.dbstatus.setText("DataBase Off");
        }
        this.cmboption.setItems(FXCollections.observableArrayList(option.values()));
    }

    @FXML
    public void Login(ActionEvent event){

        try {
            if (this.mainModel.thelogin(this.username.getText(), this.password.getText(),((option)this.cmboption.getValue()).toString())){
                Stage stage = (Stage)this.loginb.getScene().getWindow();
                stage.close();

                switch (((option)this.cmboption.getValue()).toString()){
                    case "Staff":
                        main.staffLogin(stage);
                        break;
                    case "Student":
                        main.studentLogin(stage);
                     break;
                }
                }else{
                this.loginstatus.setText("TRY AGAIN");
                }
        }catch (Exception localException){
            localException.printStackTrace();
        }
    }


}