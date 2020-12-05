package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import db.connect;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class studentController implements Initializable {

    Connection connection;
    Main main = new Main();
    @FXML
    private Label lblfname;
    @FXML
    private Label lbllname;
    @FXML
    private Label lblemail;
    @FXML
    private Label dob;
    @FXML
    private Button btnprofile;
    @FXML
    private TextField txtmatric;

    @FXML
    private Button backbtn;

    @FXML
    private Button backbutt;
    @FXML
    private Label lbltry;
    @FXML
    private Button back;

    @FXML
    private TableView<timeTableData> timetab;
    @FXML
    private TableColumn<timeTableData, String> mondaycolumn;
    @FXML
    private TableColumn<timeTableData, String> tuesdaycolumn;
    @FXML
    private TableColumn<timeTableData, String> wednesdaycolumn;
    @FXML
    private TableColumn<timeTableData, String> thursdaycolumn;
    @FXML
    private TableColumn<timeTableData, String> fridaycolumn;
    @FXML
    private TableColumn<timeTableData, String> saturdaycolumn;

    private connect dtb;
    private ObservableList<timeTableData> dataInfo;

    String sql = "SELECT * FROM timetable";



    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    private void profile(ActionEvent evt) throws IOException {
        Stage profileStage =  new Stage();
        Parent profileroot = FXMLLoader.load(getClass().getResource("studentProfile.fxml"));
        profileStage.setTitle("Profile");
        profileStage.setScene(new Scene(profileroot, 390, 433));
        profileStage.show();

        Stage stage = (Stage)this.btnprofile.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void timeTable(ActionEvent evt) throws IOException {
        Stage timeTableStage =  new Stage();
        Parent timeTableroot = FXMLLoader.load(getClass().getResource("studentTimetable.fxml"));
        timeTableStage.setTitle("Profile");
        timeTableStage.setScene(new Scene(timeTableroot, 600, 400));
        timeTableStage.show();

        Stage stage = (Stage)this.btnprofile.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadStudentProfile(ActionEvent event) throws SQLException {
        ResultSet rs;
        Statement pst = connect.getConnection().createStatement();

        String q = "SELECT * FROM student WHERE matric ='"+txtmatric.getText()+"'";
        rs = pst.executeQuery(q);
            if (rs.next()){
                lblfname.setText(rs.getString("fname").toUpperCase());
                lbllname.setText(rs.getString("lname").toUpperCase());
                lblemail.setText(rs.getString("email").toUpperCase());
                dob.setText(rs.getString("dob"));
            }else{
                lbltry.setText("TRY AGAIN");
            }

        }

    @FXML
    private void loadTimeTable(ActionEvent event) throws SQLException {
        try {
            Connection conn = connect.getConnection();
            this.dataInfo = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                this.dataInfo.add(new timeTableData(rs.getString(1), rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }catch(SQLException e){
            System.err.println("Error "+ e);
        }
        this.mondaycolumn.setCellValueFactory(new PropertyValueFactory<timeTableData, String>("Monday"));
        this.tuesdaycolumn.setCellValueFactory(new PropertyValueFactory<timeTableData, String>("Tuesday"));
        this.wednesdaycolumn.setCellValueFactory(new PropertyValueFactory<timeTableData, String>("Wednesday"));
        this.thursdaycolumn.setCellValueFactory(new PropertyValueFactory<timeTableData, String>("Thursday"));
        this.fridaycolumn.setCellValueFactory(new PropertyValueFactory<timeTableData, String>("Friday"));
        this.saturdaycolumn.setCellValueFactory(new PropertyValueFactory<timeTableData, String>("Saturday"));

        this.timetab.setItems(null);
        this.timetab.setItems(this.dataInfo);
        }

        @FXML
        private void buttonback(ActionEvent evt) throws IOException {
            Stage studentStage =  new Stage();
            Parent studentroot = FXMLLoader.load(getClass().getResource("studentFX.fxml"));
            studentStage.setTitle("Student");
            studentStage.setScene(new Scene(studentroot, 421,368));
            studentStage.show();

            Stage stage = (Stage)this.backbtn.getScene().getWindow();
            stage.close();
        }

    @FXML
    private void backbutton(ActionEvent evt) throws IOException {
        Stage studentStage =  new Stage();
        Parent studentroot = FXMLLoader.load(getClass().getResource("studentFX.fxml"));
        studentStage.setTitle("Student");
        studentStage.setScene(new Scene(studentroot, 421,368));
        studentStage.show();

        Stage stage = (Stage)this.backbutt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void backButt(ActionEvent evt) throws IOException {
        Stage primaryStage =  new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("School Management");
        primaryStage.setScene(new Scene(root, 449, 400));
        primaryStage.show();

        Stage stage = (Stage)this.back.getScene().getWindow();
        stage.close();
    }
    }
