package sample.Management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.iReport;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class SpecifiedViewTableController1
{


    @FXML
    private TableView<income> table;
    @FXML
    private TableColumn<income, String> c1;
    @FXML
    private TableColumn<income, String> c2;
    @FXML
    private TableColumn<income, String> c3;
    @FXML
    private TableColumn<income, String> c4;
    @FXML
    private TableColumn<income, String> c5;
    @FXML
    private TableColumn<income, String> c6;
    @FXML
    private TableColumn<income, String> c7;
    @FXML
    private TableColumn<income, String> c8;

    @FXML
    private Label tot;
    @FXML
    private Label id;

    @FXML
    private TextField key;

    @FXML
    private Button search;
    @FXML
    private Button paid;
    @FXML
    private Button pnot;

    String keys="";


    public void initialize()
    {
        key.setText("");

    }


    public void  search() {

        keys = key.getText();
        table.getItems().clear();
        if ((key.getText().isEmpty()) || (key.getText().trim().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Check Empty Fields !");

            alert.showAndWait();
            initialize();

        } else {
            ObservableList<income> temp2 = FXCollections.observableArrayList();
            income i = new income();
            temp2 = i.searchI(keys);
            if(temp2.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Invalid id");

                alert.showAndWait();
                initialize();
            }
            else {
                id.setText(keys);

                float total=0;
                for(int k=0;k<temp2.size();k++)
                {
                    total=total+(Float.parseFloat(temp2.get(k).getPrice()));
                }
                tot.setText(String.valueOf(total));


                c1.setCellValueFactory(new PropertyValueFactory<>("transid"));
                c2.setCellValueFactory(new PropertyValueFactory<>("date"));
                c3.setCellValueFactory(new PropertyValueFactory<>("refid"));
                c4.setCellValueFactory(new PropertyValueFactory<>("refName"));
                c5.setCellValueFactory(new PropertyValueFactory<>("paidNot"));
                c6.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
                c7.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
                c8.setCellValueFactory(new PropertyValueFactory<>("price"));


                table.setItems(null);
                table.setItems(temp2);
                key.setText("");
            }

        }
    }

    public void  searchPaid() {

        //keys = key.getText();
        if (keys.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Check Empty Fields !");

            alert.showAndWait();
            initialize();

        } else {
            ObservableList<income> temp2 = FXCollections.observableArrayList();
            income i = new income();
            temp2 = i.searchpaidI(keys);
            if(temp2.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Not Found");

                alert.showAndWait();
                initialize();
            }
            else {
                id.setText(keys);

                float total=0;
                for(int k=0;k<temp2.size();k++)
                {
                    total=total+(Float.parseFloat(temp2.get(k).getPrice()));
                }
                tot.setText(String.valueOf(total));

                c1.setCellValueFactory(new PropertyValueFactory<>("transid"));
                c2.setCellValueFactory(new PropertyValueFactory<>("date"));
                c3.setCellValueFactory(new PropertyValueFactory<>("refid"));
                c4.setCellValueFactory(new PropertyValueFactory<>("refName"));
                c5.setCellValueFactory(new PropertyValueFactory<>("paidNot"));
                c6.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
                c7.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
                c8.setCellValueFactory(new PropertyValueFactory<>("price"));


                table.setItems(null);
                table.setItems(temp2);
                // key.setText("");

            }
        }
    }

    public void  searchNotPaid() {

        // keys = key.getText();
        if (keys.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Check Empty Fields !");

            alert.showAndWait();
            initialize();

        } else {
            ObservableList<income> temp2 = FXCollections.observableArrayList();
            income i = new income();
            temp2 = i.searchNotpaidIncome(keys);
            if (temp2.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Not Found");

                alert.showAndWait();
                //table.getItems().clear();
            } else {
                id.setText(keys);

                float total=0;
                for(int k=0;k<temp2.size();k++)
                {
                    total=total+(Float.parseFloat(temp2.get(k).getPrice()));
                }
                tot.setText(String.valueOf(total));

                c1.setCellValueFactory(new PropertyValueFactory<>("transid"));
                c2.setCellValueFactory(new PropertyValueFactory<>("date"));
                c3.setCellValueFactory(new PropertyValueFactory<>("refid"));
                c4.setCellValueFactory(new PropertyValueFactory<>("refName"));
                c5.setCellValueFactory(new PropertyValueFactory<>("paidNot"));
                c6.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
                c7.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
                c8.setCellValueFactory(new PropertyValueFactory<>("price"));


                table.setItems(null);
                table.setItems(temp2);
                //key.setText("");


            }


        }



    }



public void report()
{

    iReport ir=new iReport();
    ir.generateReportPass("C:\\IMS\\income.jrxml","select sales.idsale,date,customer.idcustomer,customer.name,total,paymentType,paymentDate,`paid/not` from sales join customer on sales.idcustomer=customer.idcustomer where sales.idcustomer='"+id.getText()+"' order by `paid/not`");

}








}
