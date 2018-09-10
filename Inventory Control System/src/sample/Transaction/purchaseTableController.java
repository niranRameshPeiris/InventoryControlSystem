package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.iReport;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class purchaseTableController {


    @FXML
    private TableView<purchase> purchaseT;
    @FXML
    private TableColumn<purchase, String> p1;
    @FXML
    private TableColumn<purchase, String> p2;
    @FXML
    private TableColumn<purchase, String> p3;
    @FXML
    private TableColumn<purchase, String> p4;
    @FXML
    private TableColumn<purchase, String> p5;
    @FXML
    private TableColumn<purchase, String> p6;
    @FXML
    private TextField keySale;


    @FXML
    public void initialize() {
        viewPurchase();
    }

    public void viewPurchase() {

        ObservableList<purchase> temp = FXCollections.observableArrayList();
        purchase buy;
        buy = new purchase();

        temp = buy.getPurchase();

        //System.out.print(sale.getPrice());

        p1.setCellValueFactory(new PropertyValueFactory<purchase, String>("transid"));
        p2.setCellValueFactory(new PropertyValueFactory<purchase, String>("date"));
        p3.setCellValueFactory(new PropertyValueFactory<purchase, String>("refid"));
        p4.setCellValueFactory(new PropertyValueFactory<purchase, String>("refName"));
        p5.setCellValueFactory(new PropertyValueFactory<purchase, String>("price"));
        p6.setCellValueFactory(new PropertyValueFactory<purchase, String>("noOfProducts"));

        purchaseT.setItems(null);
        purchaseT.setItems(temp);

    }


    public void searchPurchase() {
        String key = keySale.getText();
        if (!key.isEmpty()) {
            ObservableList<purchase> temp2 = FXCollections.observableArrayList();
            purchase p;
            p = new purchase();

            temp2 = p.search(key);
            if(!temp2.isEmpty()) {
                p1.setCellValueFactory(new PropertyValueFactory<purchase, String>("transid"));
                p2.setCellValueFactory(new PropertyValueFactory<purchase, String>("date"));
                p3.setCellValueFactory(new PropertyValueFactory<purchase, String>("refid"));
                p4.setCellValueFactory(new PropertyValueFactory<purchase, String>("refName"));
                p5.setCellValueFactory(new PropertyValueFactory<purchase, String>("price"));
                p6.setCellValueFactory(new PropertyValueFactory<purchase, String>("noOfProducts"));

                purchaseT.setItems(null);
                purchaseT.setItems(temp2);

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
        ir.generateReport("C:\\IMS\\purchase.jrxml");
    }

}




