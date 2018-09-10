package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.UserHandle.employee;

/**
 * Created by Ramesh on 5/6/2017.
 */
public class addEmployeeController {

    @FXML
    private TextField name;
    @FXML
    private TextField add;
    @FXML
    private TextField city;
    @FXML
    private TextField tel;
    @FXML
    private Button save;

    @FXML
    public void initialize()
    {
        name.setText("");
        add.setText("");
        city.setText("");
        tel.setText("");
    }
    public void save()
    {
        int warning=0;
        boolean warning2=false;

        if((name.getText().isEmpty()) ||( name.getText().trim().isEmpty()))
        {
            name.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            name.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((add.getText().isEmpty()) ||( add.getText().trim().isEmpty())) {
            add.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            add.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((city.getText().isEmpty()) ||( city.getText().trim().isEmpty()))
        {
            city.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            city.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((tel.getText().isEmpty()) ||( tel.getText().trim().isEmpty()))
        {
            tel.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            tel.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if(warning !=4 ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Selected Fields cannot be Empty !");

            alert.showAndWait();
        }

        if (!((tel.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))&&((tel.getText()).length()==10 )))
        {
            tel.setStyle("-fx-text-box-border: red ; ");
            warning2 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Wrong Telephone No !");

            alert.showAndWait();
        }
        else
        {
            warning2 =false;
            tel.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if( (warning==4) && (!warning2))
        {
            employee e=new employee();
            e.setEmployee(name.getText(),add.getText(),city.getText(),tel.getText());
            Stage stagec = (Stage) save.getScene().getWindow();
            stagec.hide();

        }


    }





}
