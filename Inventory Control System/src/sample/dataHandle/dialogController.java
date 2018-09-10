package sample.dataHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.dataHandle.product;

import java.io.IOException;
import java.util.Optional;


/**
 * Created by Ramesh on 4/23/2017.
 */
public class dialogController {


    ObservableList<String> Uom= FXCollections.observableArrayList("Pcs","Kg","Meter","Pack","Unit","Lot","Set","Sheet");
    @FXML
    private ComboBox combop;

    @FXML
    private TextField txtSpecs;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPp;
    @FXML
    private TextField txtSp;
    @FXML
    private TextField txtStock;
    @FXML
    private TextField txtSRack;


@FXML
private javafx.scene.control.Button  closeButton;
@FXML
private Button saveButton;




    public void initialize()
    {
        combop.setValue("Unit of Measure");
        combop.setItems(Uom);


    }

    public void validate() throws IOException {

        int warning = 0;
        int warning2=0;
        boolean warning3=false;

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
        if((txtPp.getText().isEmpty()) ||( txtPp.getText().trim().isEmpty())) {
            txtPp.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            txtPp.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtSp.getText().isEmpty()) ||( txtSp.getText().trim().isEmpty()))
        {
            txtSp.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtSp.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtStock.getText().isEmpty()) ||( txtStock.getText().trim().isEmpty()))
        {
            txtStock.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtStock.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((txtSRack.getText().isEmpty()) ||( txtSRack.getText().trim().isEmpty()))
        {
            txtSRack.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtSRack.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check numeric fields

        if (!(txtPp.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            txtPp.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning2++;
            txtPp.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(txtSp.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            txtSp.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning2++;
            txtSp.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(txtStock.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {

            txtStock.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            txtStock.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning2++;
        }
        if (!(txtSRack.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {

            txtSRack.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            txtSRack.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning2++;
        }


    if(warning2 !=4)
    {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("WARRNING");
        alert.setContentText("This Field Only Contain Numbers");

        alert.showAndWait();
    }

    if(warning !=5 ) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("WARRNING");
        alert.setContentText("Selected Fields cannot be Empty !");

        alert.showAndWait();
    }
        if(combop.getSelectionModel().isEmpty())
        {
            warning3=true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("You Need to select one for UOM!");

            alert.showAndWait();
        }
        else
        {
            warning3=false;
        }


        if((warning==5) && !warning3 && (warning2==4))
        {
            //System.out.print("come");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Add This Data ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                product p = new product();
                String query = "INSERT INTO product(name, specification, pricePurchase, priceSale, stock, uom, rackNo) VALUES ('" + txtName.getText() + "','" + txtSpecs.getText() + "','" + txtPp.getText() + "','" + txtSp.getText() + "','" + txtStock.getText() + "','" + combop.getValue() + "','" + txtSRack.getText() + "')";
                p.editP(query);


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
