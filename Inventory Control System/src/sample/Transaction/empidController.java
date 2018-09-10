package sample.Transaction;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import sample.UserHandle.salesmen;

/**
 * Created by Ramesh on 4/28/2017.
 */
public class empidController extends saleTempController
{


    @FXML
    private TableView<salesmen> table;
    @FXML
    private TableColumn<salesmen, String> id;
    @FXML
    private TableColumn<salesmen, String> name;

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
        ObservableList<salesmen> temp3 = FXCollections.observableArrayList();
        salesmen s;
        s = new salesmen();

        temp3=s.getSalesmen();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));


        table.setItems(null);
        table.setItems(temp3);
    }

    @FXML
    public void select()
    {

        salesmen s = table.getSelectionModel().getSelectedItem();

        if(s!=null)
        {
            keys.setText(s.getId());
        }
    }

    @FXML
    public void search()
    {
        String key = keys.getText();
        if (!key.equals("")) {
            ObservableList<salesmen> temp3 = FXCollections.observableArrayList();
            salesmen s;
            s = new salesmen();

            temp3 = s.searchS(key);

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
            ObservableList<salesmen> temp3 = FXCollections.observableArrayList();
            salesmen s;
            s = new salesmen();

            temp3 = s.getSelectedId(key);
            if(temp3!=null) {
                s = temp3.get(0);

                setemployee(s.getId(), s.getName(), s.getTelephone());


                Stage st = (Stage) se.getScene().getWindow();
                st.close();
            }
            else
                keys.setText("");
        }


    }







}
