package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;



/**
 * Created by Ramesh on 5/1/2017.
 */
public class bodyController
{
    @FXML
    private AnchorPane coreload;
    @FXML
    private Menu admin;
    @FXML
    private MenuItem user;
    @FXML
    private MenuItem emp;
    @FXML
    private MenuItem empr;



    public static String userId;
    public static String level;




    public void initialize()throws IOException
    {

        if(level.equals("1"))
        {
            adminPannel();
            user.setDisable(true);
            emp.setDisable(true);
            empr.setDisable(true);
        }
        else {
            if(level.equals("0"))
            {
                admin.setDisable(false);
            }
            else {

                admin.setDisable(true);
            }
            System.out.print("done");

            Controller c = new Controller();
            c.setAccessId(userId, level);
            AnchorPane pane = FXMLLoader.load(getClass().getResource("core.fxml"));
            coreload.getChildren().setAll(pane);

        }
    }

    public void setUserId(String uid,String level)
    {
        this.userId=uid;
        this.level=level;
    }


    @FXML
    public void userProfile()
    {
        try {

            profileController pc=new profileController();
            pc.setId(userId,level);
            Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
            Stage s=new Stage();
            s.setTitle("User Profile");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            s.setResizable(false);
            s.setScene(new Scene(root, 457,470));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");

        }

    }




    public void logout()
    {
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
        Stage stagec = (Stage) coreload.getScene().getWindow();
//        stagec.close();
        stagec.hide();


    }

    public void close()
    {
//        Stage stagec = (Stage) coreload.getScene().getWindow();
//        stagec.close();

        Platform.exit();
    }

    @FXML
    public void adminPannel() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("UserHandle/AdminPannel.fxml"));
        coreload.getChildren().setAll(pane);
    }

    @FXML
    public void userPannel() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("core.fxml"));
        coreload.getChildren().setAll(pane);

    }

    @FXML
    public void resetPassword()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("resetPassword.fxml"));
            Stage s=new Stage();
            s.setTitle("Reset Password");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            s.setResizable(false);
            s.setScene(new Scene(root, 432,411));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");

        }

        Stage stagec = (Stage) coreload.getScene().getWindow();
        stagec.hide();



    }

    @FXML
    public void resetName()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("resetUsername.fxml"));
            Stage s=new Stage();
            s.setTitle("Reset User Name");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            s.setResizable(false);
            s.setScene(new Scene(root, 432,411));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");

        }
        Stage stagec = (Stage) coreload.getScene().getWindow();
        stagec.hide();

    }

    public void addEmployee()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addEmployee.fxml"));
            Stage s=new Stage();
            s.setTitle("Add Employee");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            s.setResizable(false);
            s.setScene(new Scene(root, 360,401));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");

        }
    }

    public void empReport()
    {
        iReport ir=new iReport();
        ir.generateReport("C:\\IMS\\employee.jrxml");

    }

    public void userRep()
    {
        iReport ir=new iReport();
        ir.generateReport("C:\\IMS\\user.jrxml");

    }

}
