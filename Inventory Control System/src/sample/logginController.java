package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.UserHandle.user;


import java.io.*;
import java.sql.Connection;


/**
 * Created by Ramesh on 5/1/2017.
 */
public class logginController
{
    @FXML
    private TextField username;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button loggin;

    @FXML
    private AnchorPane login;

    user u=new user();
    ObservableList<user> users = FXCollections.observableArrayList();
    public static String uId;
    public static String level;


    @FXML
    public void initialize()
    {
        username.setText("");
        pwd.setText("");

    }

    @FXML
    public void loggin()
    {
        dbconnect db=new dbconnect();
        Connection con=db.getConnection();
        if(con==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Database Connection Faild!\n Configure Connection Again ");
            alert.showAndWait();
            username.setText("");
            pwd.setText("");
        }
        else {
            if (emptyCheck()) {
                if (validateUsernameAndPassword()) {
                    System.out.print("ela");


                    try {
                        bodyController pass = new bodyController();
                        setuId();
                        //System.out.print(uId);
                        pass.setUserId(uId, level);

                        Parent root = FXMLLoader.load(getClass().getResource("body.fxml"));
                        Stage s = new Stage();
                        s.setTitle("Inventory Management System");
                        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
                        s.getIcons().add(icon);
                        s.setScene(new Scene(root, 1000, 600));
                        s.show();
                    } catch (Exception e) {
                        System.out.println("Couldnt load window");

                    }


                    Stage stagec = (Stage) loggin.getScene().getWindow();
                    stagec.close();


                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setTitle("WARRNING");
                    alert.setContentText("Invalid Username or Password");
                    alert.showAndWait();

                    initialize();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Fill the Empty Fields");
                alert.showAndWait();
            }
        }
    }

    public boolean validateUsernameAndPassword()
    {
        users=u.getUser();
        for(int i=0;i<users.size();i++)
        {
            if(((username.getText()).equals(users.get(i).getUserName()))&& ((pwd.getText()).equals(users.get(i).getPassword())) )
            {
                return true;
            }
        }
        return false;
    }

    public boolean emptyCheck()
    {
        int warning =0;
        if((username.getText().isEmpty()) ||( username.getText().trim().isEmpty()))
        {
            username.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            username.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((pwd.getText().isEmpty()) ||( pwd.getText().trim().isEmpty()))
        {
            pwd.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            pwd.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if(warning ==2)
            return true;
        else
            return false;
    }


    public void setuId()
    {
        users=u.getUser();
        for(int i=0;i<users.size();i++)
        {
            if(((username.getText()).equals(users.get(i).getUserName()))&&((pwd.getText()).equals(users.get(i).getPassword())))
            {
                this.uId=users.get(i).getId();
                this.level=users.get(i).getLevel();

            }
        }

    }

    public void close()
    {
//        Stage stagec = (Stage) login.getScene().getWindow();
//        stagec.close();
        Platform.exit();
    }

    public void connection()
    {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("config.fxml"));
            Stage s = new Stage();
            s.setTitle("Configuration");
            s.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            s.setScene(new Scene(root, 432, 411));
            s.show();
        } catch (Exception e) {
            System.out.println("Couldnt load window");

        }
    }


}
