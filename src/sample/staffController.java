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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class staffController implements Initializable {
    @FXML
    private TextField txtmatric;
    @FXML
    private TextField txtfname;
    @FXML
    private TextField txtlname;
    @FXML
    private TextField txtemail;
    @FXML
    private DatePicker dob;
    @FXML
    private TableView<studentData> studenttable;

    @FXML
    private TableColumn<studentData, String> matriccolumn;

    @FXML
    private TableColumn<studentData, String> firstnamecolumn;

    @FXML
    private TableColumn<studentData, String> lastnamecolumn;

    @FXML
    private TableColumn<studentData, String> emailcolumn;

    @FXML
    private TableColumn<studentData, String> dobcolumn;

    @FXML
    private Button entrybutton;
    @FXML
    private Button clearbutton;
    @FXML
    private Button loadbutton;
    @FXML
    private Button btnback;

    private connect dc;
    private ObservableList<studentData> data;
    private String sql = "SELECT * FROM student";

    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    private void loadStudentData(ActionEvent event){
        try {
            Connection conn = connect.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                this.data.add(new studentData(rs.getString(1), rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        }catch(SQLException e){
            System.err.println("Error "+ e);
        }
        this.matriccolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("ID"));
        this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("firstName"));
        this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("lastName"));
        this.emailcolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("email"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("DOB"));

        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }

    @FXML
    private void addStudent(ActionEvent event){
        String sqlInsert = "INSERT INTO student(matric,fname,lname,email,dob) VALUES (?,?,?,?,?)";

        try {
            Connection conn = connect.getConnection();
            PreparedStatement pst = conn.prepareStatement(sqlInsert);

            pst.setString(1, this.txtmatric.getText());
            pst.setString(2,this.txtfname.getText());
            pst.setString(3,this.txtlname.getText());
            pst.setString(4,this.txtemail.getText());
            pst.setString(5,this.dob.getEditor().getText());

            pst.execute();
            //con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clearForm(ActionEvent event){
        this.txtmatric.setText("");
        this.txtfname.setText("");
        this.txtlname.setText("");
        this.txtemail.setText("");
        this.dob.setValue(null);
    }

    @FXML
    private void backButton(ActionEvent evt) throws IOException {
        Stage primaryStage =  new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("School Management");
        primaryStage.setScene(new Scene(root, 449, 400));
        primaryStage.show();

        Stage stage = (Stage)this.btnback.getScene().getWindow();
        stage.close();
    }
}
