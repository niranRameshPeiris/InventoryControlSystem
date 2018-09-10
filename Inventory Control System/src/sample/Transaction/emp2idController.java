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
import sample.UserHandle.purchasemen;
import sample.UserHandle.salesmen;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class emp2idController extends purchaseTempController
{


    @FXML
    private TableView<purchasemen> table;
    @FXML
    private TableColumn<purchasemen, String> id;
    @FXML
    private TableColumn<purchasemen, String> name;

    @FXML
    private TextField keys;
    @FXML
    private Button search;
    @FXML
    private Button se;


    public void initialize()
    {
        viewEmployee();

    }

    public void viewEmployee()
    {
        ObservableList<purchasemen> temp3 = FXCollections.observableArrayList();
        purchasemen p;
        p = new purchasemen();

        temp3=p.getPurchasemen();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));


        table.setItems(null);
        table.setItems(temp3);
    }

    @FXML
    public void select()
    {

        purchasemen p = table.getSelectionModel().getSelectedItem();

        if(p!=null)
        {
            keys.setText(p.getId());
        }
    }

    @FXML
    public void search()
    {
        String key = keys.getText();
        if (!key.equals("")) {
            ObservableList<purchasemen> temp3 = FXCollections.observableArrayList();
            purchasemen p;
            p = new purchasemen();

            temp3 = p.searchP(key);

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));


            table.setItems(null);
            table.setItems(temp3);

            keys.setText("");
        }
        else
            initialize();


    }

    @FXML
    public void exit() {

        String key = keys.getText();
        if (!key.equals("")) {
            ObservableList<purchasemen> temp3 = FXCollections.observableArrayList();
            purchasemen p;
            p = new purchasemen();

            temp3 = p.getSelectedId(key);
            if(temp3!=null) {
                p = temp3.get(0);
                if (p != null) {
                    setemployee(p.getId(), p.getName(), p.getTelephone());


                    Stage st = (Stage) se.getScene().getWindow();
                    st.close();
                }
            }
            else
                keys.setText("");
        }


    }







}
