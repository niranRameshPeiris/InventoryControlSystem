package sample.dataHandle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.dataHandle.supplier;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ramesh on 4/23/2017.
 */
public class customerController {


    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAdd;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtCon;
    @FXML
    private TextField txtPc;
    @FXML
    private TextField txtTn;
    @FXML
    private TextField txtFn;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCp;
    @FXML
    private javafx.scene.control.Button  closeButton;
    @FXML
    private Button saveButton;



    public void validate() throws IOException {

        int warning = 0;
        int warning2=0;
        boolean warning3=false;
        boolean warning4=false;


        //chech empty fields
        if((txtName.getText().isEmpty()) ||( txtName.getText().trim().isEmpty()))
        {
            txtName.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            txtName.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((txtAdd.getText().isEmpty()) ||( txtAdd.getText().trim().isEmpty()))
        {
            txtAdd.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtAdd.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtCity.getText().isEmpty()) ||( txtCity.getText().trim().isEmpty()))
        {
            txtCity.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            txtCity.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((txtCon.getText().isEmpty()) ||( txtCon.getText().trim().isEmpty()))
        {
            txtCon.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtCon.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtPc.getText().isEmpty()) ||( txtPc.getText().trim().isEmpty()))
        {
            txtPc.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtPc.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtTn.getText().isEmpty()) ||( txtTn.getText().trim().isEmpty()))
        {
            txtTn.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtTn.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtFn.getText().isEmpty()) ||( txtFn.getText().trim().isEmpty()))
        {
            txtFn.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtFn.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtEmail.getText().isEmpty()) ||( txtEmail.getText().trim().isEmpty()))
        {
            txtEmail.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtEmail.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtCp.getText().isEmpty()) ||( txtCp.getText().trim().isEmpty()))
        {
            txtCp.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtCp.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check for number
        if (!(txtPc.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            txtPc.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning2++;
            txtPc.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(txtFn.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            txtFn.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning2++;
            txtFn.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }



        //check tele no


        if (!((txtTn.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))&&((txtTn.getText()).length()==10 )))
        {
            txtTn.setStyle("-fx-text-box-border: red ; ");
            warning3 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Wrong Telephone No !");

            alert.showAndWait();
        }
        else
        {
            warning3 =false;
            txtTn.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }


        //check email
        Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m=p.matcher(txtEmail.getText());

        if (!(m.find() && m.group().equals(txtEmail.getText())))
        {
            txtEmail.setStyle("-fx-text-box-border: red ; ");
            warning4 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalied email!");

            alert.showAndWait();
        }
        else
        {
            warning4 =false;
            txtEmail.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }





        if(warning2!=2)
        {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("This Field Only Contain Numbers");

            alert.showAndWait();
        }

        if(warning!=9) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Selected Fields cannot be Empty !");

            alert.showAndWait();
        }



        if((warning==9) && !warning3 && (warning2==2) && !warning4)
        {
            //System.out.print("come");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Add This Data ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {


                supplier s = new supplier();
                String query = "INSERT INTO customer(name, Address,city,country,postcode,telephone,fax,email,contactperson) VALUES ('" + txtName.getText() + "','" + txtAdd.getText() + "','" + txtCity.getText() + "','" + txtCon.getText() + "','" + txtPc.getText() + "','" + txtTn.getText() + "','" + txtFn.getText() + "','" + txtEmail.getText() + "','" + txtCp.getText() + "')";
                s.editS(query);


                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();

            }
        }


    }


    public void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
