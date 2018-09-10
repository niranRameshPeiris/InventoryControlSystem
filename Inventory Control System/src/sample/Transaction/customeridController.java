package sample.Transaction;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.scene.control.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.dataHandle.customer;

/**
 * Created by Ramesh on 4/28/2017.
 */
public class customeridController extends saleTempController
{



    @FXML
    private TableView<customer> table;
    @FXML
    private TableColumn<customer, String> id;
    @FXML
    private TableColumn<customer, String> name;

    @FXML
    private TextField keyc;
    @FXML
    private Button search;
    @FXML
    private Button s;


    public void initialize()
    {
        viewProdect();

    }

    public void viewProdect()
    {
        ObservableList<customer> temp3 = FXCollections.observableArrayList();
        customer c;
        c = new customer();

        temp3=c.getCustomer();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));


        table.setItems(null);
        table.setItems(temp3);
    }
    @FXML
    public void select()
    {

        customer c = table.getSelectionModel().getSelectedItem();

        if(c!=null)
        {
            keyc.setText(c.getId());
        }
    }
    @FXML
    public void search()
    {
        String key = keyc.getText();
        if (!key.equals("")) {
            ObservableList<customer> temp3 = FXCollections.observableArrayList();
            customer c;
            c = new customer();

            temp3 = c.searchC(key);

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
            ObservableList<customer> temp3 = FXCollections.observableArrayList();
            customer c;
            c = new customer();

            temp3 = c.getSelectedId(key);
            if(temp3!=null) {
                c = temp3.get(0);

                setCustomer(c.getId(), c.getName(), c.getAddress(), c.getCity(), c.getTelephone());

                Stage stage = (Stage) s.getScene().getWindow();
                stage.close();
            }
            else
                keyc.setText("");
        }


    }

}
