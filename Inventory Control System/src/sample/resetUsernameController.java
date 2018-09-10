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

import java.util.Optional;

/**
 * Created by Ramesh on 5/2/2017.
 */
public class resetUsernameController
{
    @FXML
    private Button log;
    @FXML
    private TextField cuname;
    @FXML
    private TextField nuname;
    @FXML
    private PasswordField pwd;
   @FXML
   private Button reset;

   @FXML
    public void initialize()
    {


    }


        public void resetName() {
            user u = new user();

            if (u.validateUser(cuname.getText(), pwd.getText())) {
                if (!(nuname.getText().equals(""))) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Do you need to change your username ? ");


                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        try {
                            u.edit("UPDATE user SET userName='" + nuname.getText() + "' WHERE userName='" + cuname.getText() + "';");
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
                    alert.setContentText("Invalid New User Name!");

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