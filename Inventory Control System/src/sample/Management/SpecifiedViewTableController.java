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
public class SpecifiedViewTableController
{

    @FXML
    private TableView<expenditure> table;
    @FXML
    private TableColumn<expenditure, String> c1;
    @FXML
    private TableColumn<expenditure, String> c2;
    @FXML
    private TableColumn<expenditure, String> c3;
    @FXML
    private TableColumn<expenditure, String> c4;
    @FXML
    private TableColumn<expenditure, String> c5;
    @FXML
    private TableColumn<expenditure, String> c6;
    @FXML
    private TableColumn<expenditure, String> c7;
    @FXML
    private TableColumn<expenditure, String> c8;

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
            ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
            expenditure i = new expenditure();
            temp2 = i.searchE(keys);
            if(temp2.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Invalid id");

                alert.showAndWait();
                //initialize();

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
            ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
            expenditure i = new expenditure();
            temp2 = i.searchpaidE(keys);
            if(temp2.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Not Found");

                alert.showAndWait();

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
            ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
            expenditure i = new expenditure();
            temp2 = i.searchNotpaidExpenditure(keys);
            if (temp2.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Not Found");

                alert.showAndWait();
                initialize();
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
        ir.generateReportPass("C:\\IMS\\expenditure.jrxml","select purchase.idpurchase,date,supplier.idsupplier,supplier.name,total,paymentType,paidDate,`paid/not` from purchase join supplier on purchase.idsupplier=supplier.idsupplier where purchase.idsupplier='"+id.getText()+"' order by `paid/not`");


    }









}
