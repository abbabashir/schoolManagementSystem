package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("School Management");
        primaryStage.setScene(new Scene(root, 449, 400));
        primaryStage.show();
    }

public void staffLogin(Stage staffStage) throws Exception{
        Parent staffroot = FXMLLoader.load(getClass().getResource("staff.fxml"));
        staffStage.setTitle("Staff");
        staffStage.setScene(new Scene(staffroot, 1000, 600));
        staffStage.show();
}

public void studentLogin(Stage studentStage) throws Exception{
        Parent studentroot = FXMLLoader.load(getClass().getResource("studentFX.fxml"));
        studentStage.setTitle("Student");
        studentStage.setScene(new Scene(studentroot, 421,368));
        studentStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
