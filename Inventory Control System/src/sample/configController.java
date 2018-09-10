package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ramesh on 5/5/2017.
 */
public class configController {

    @FXML
    private TextField uname;
    @FXML
    private TextField port;
    @FXML
    private PasswordField pwd;
    @FXML
    public void initialize()
    {

    }

    public void save() {
        if(validate())
        {
        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("C:/IMS/setup.txt"))) {
            bw.write(port.getText());
            bw.newLine();
            bw.write(uname.getText());
            bw.newLine();
            bw.write(pwd.getText());
        } catch (IOException e) {
            e.printStackTrace();

        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("INFORMATION");
        alert.setContentText("Restart the Application again");

        alert.showAndWait();
        Platform.exit();


    }
    else
        initialize();
    }

public boolean validate()
{
    int warning=0;

    if((uname.getText().isEmpty()) ||( uname.getText().trim().isEmpty()))
    {
        uname.setStyle("-fx-text-box-border: red ; ");
    }
    else
    {
        uname.setStyle("-fx-text-box-border: #d1d6cf ; ");
        warning ++;
    }
    if((port.getText().isEmpty()) ||( port.getText().trim().isEmpty())) {
        port.setStyle("-fx-text-box-border: red ; ");
    }
    else
    {
        warning ++;
        port.setStyle("-fx-text-box-border: #d1d6cf ; ");
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

    if(warning !=3 ) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("WARRNING");
        alert.setContentText("Selected Fields cannot be Empty !");

        alert.showAndWait();
        return false;
    }
    else
    {
        return true;
    }








}





}
