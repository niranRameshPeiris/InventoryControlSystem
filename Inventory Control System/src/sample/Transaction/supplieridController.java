package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.dataHandle.customer;
import sample.dataHandle.supplier;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class supplieridController extends purchaseTempController

{



    @FXML
    private TableView<supplier> table;
    @FXML
    private TableColumn<supplier, String> id;
    @FXML
    private TableColumn<supplier, String> name;

    @FXML
    private TextField keyc;
    @FXML
    private Button search;
    @FXML
    private Button se;


    public void initialize()
    {
        viewProdect();

    }

    public void viewProdect()
    {
        ObservableList<supplier> temp3 = FXCollections.observableArrayList();
        supplier s;
        s = new supplier();

        temp3=s.getSupplier();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));


        table.setItems(null);
        table.setItems(temp3);
    }
    @FXML
    public void select()
    {

        supplier s = table.getSelectionModel().getSelectedItem();

        if(s!=null)
        {
            keyc.setText(s.getId());
        }
    }
    @FXML
    public void search()
    {
        String key = keyc.getText();
        if (!key.equals("")) {
            ObservableList<supplier> temp3 = FXCollections.observableArrayList();
            supplier s;
            s = new supplier();

            temp3 = s.searchS(key);

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));


            table.setItems(null);
            table.setItems(temp3);

            keyc.setText("");
        }
        else
            initialize();


    }

    @FXML
    public void exit() {

        String key = keyc.getText();
        if (!key.equals("")) {
            ObservableList<supplier> temp3 = FXCollections.observableArrayList();
            supplier s;
            s = new supplier();

            temp3 = s.getSelectedId(key);

            if(temp3!=null) {
                s = temp3.get(0);

                setSupplier(s.getId(), s.getName(), s.getAddress(), s.getCity(), s.getTelephone());

                Stage stage = (Stage) se.getScene().getWindow();
                stage.close();
            }
            else
                keyc.setText("");
        }


    }

}
