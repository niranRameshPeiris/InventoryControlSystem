package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.UserHandle.user;
import sample.bodyController;

import java.util.Optional;

/**
 * Created by Ramesh on 5/2/2017.
 */
public class resetPasswordController {
    user u = new user();
    ObservableList<user> users = FXCollections.observableArrayList();
    public static String uId;
    public static String level;

    @FXML
    private Button reset;
    @FXML
    private TextField uname;
    @FXML
    private PasswordField cpwd;
    @FXML
    private PasswordField npwd;

    @FXML
    private Label lbl;


    public void initialize() {


    }


    public void resetPwd() {
        user u = new user();

        if (u.validateUser(uname.getText(), cpwd.getText())) {
            if (!(npwd.getText().equals("")) && (npwd.getText().length() >= 4)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Dialog");
                alert.setContentText("Do you need to change your password ?");


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    try {
                        u.edit("UPDATE user SET password='" + npwd.getText() + "' WHERE userName='" + uname.getText() + "';");
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }

                    close();

                } else {
                    initialize();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Invalid New Password!");

                alert.showAndWait();

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalid Username or Password!");

            alert.showAndWait();

            //npwd.setText("");
            // cpwd.setText("");
            // uname.setText("");
            initialize();

        }


    }


    public void close() {

        try {


            Parent root = FXMLLoader.load(getClass().getResource("loggin.fxml"));
            Stage s=new Stage();
            s.setResizable(false);
            s.initStyle(StageStyle.UNDECORATED);
            s.centerOnScreen();
            s.setTitle("Login Window");
            //s.setAlwaysOnTop(true);
            s.setScene(new Scene(root, 462,400));
            s.show();

        }catch (Exception e){
            System.out.println("Couldnt load window");

        }
        Stage stagec = (Stage) reset.getScene().getWindow();
        stagec.close();


    }

}