package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Transaction.sales;
import sample.iReport;

/**
 * Created by Ramesh on 4/25/2017.
 */
public class salesTableController

{
    @FXML
    private TableView<sales> saleT;
    @FXML
    private TableColumn<sales, String> s1;
    @FXML
    private TableColumn<sales, String> s2;
    @FXML
    private TableColumn<sales, String> s3;
    @FXML
    private TableColumn<sales, String> s4;
    @FXML
    private TableColumn<sales, String> s5;
    @FXML
    private TableColumn<sales, String> s6;
    @FXML
    private TextField keySale;


    @FXML
    public void initialize()
    {
    viewSale();
    }

    public void viewSale()
    {

        ObservableList<sales> temp = FXCollections.observableArrayList();
        sales sale;
        sale = new sales();

        temp=sale.getSales();

        //System.out.print(sale.getPrice());

        s1.setCellValueFactory(new PropertyValueFactory<sales ,String>("transid"));
        s2.setCellValueFactory(new PropertyValueFactory<sales ,String>("date"));
        s3.setCellValueFactory(new PropertyValueFactory<sales ,String>("refid"));
        s4.setCellValueFactory(new PropertyValueFactory<sales ,String>("refName"));
        s5.setCellValueFactory(new PropertyValueFactory<sales ,String>("price"));
        s6.setCellValueFactory(new PropertyValueFactory<sales ,String>("noOfProducts"));

        saleT.setItems(null);
        saleT.setItems(temp);

    }


    public void searchSale()
    {
        String key=keySale.getText();
        if (!key.isEmpty())  {
            ObservableList<sales> temp2 = FXCollections.observableArrayList();
            sales s;
            s = new sales();

            temp2 = s.search(key);
            if(!temp2.isEmpty()) {
                s1.setCellValueFactory(new PropertyValueFactory<sales, String>("transid"));
                s2.setCellValueFactory(new PropertyValueFactory<sales, String>("date"));
                s3.setCellValueFactory(new PropertyValueFactory<sales, String>("refid"));
                s4.setCellValueFactory(new PropertyValueFactory<sales, String>("refName"));
                s5.setCellValueFactory(new PropertyValueFactory<sales, String>("price"));
                s6.setCellValueFactory(new PropertyValueFactory<sales, String>("noOfProducts"));

                saleT.setItems(null);
                saleT.setItems(temp2);

                keySale.setText("");
            }
            else
                keySale.setText("");
        }
        else
            initialize();
    }

    public void saveData()
    {
        iReport ir=new iReport();
        ir.generateReport("C:\\IMS\\sales.jrxml");
    }





}
