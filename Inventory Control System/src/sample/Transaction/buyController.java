package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.UserHandle.purchasemen;
import sample.UserHandle.salesmen;
import sample.dataHandle.buyProduct;
import sample.dataHandle.customer;
import sample.dataHandle.sellProduct;
import sample.dbconnect;
import sample.iReport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 5/1/2017.
 */
public class buyController
{
    protected dbconnect conE;
    protected Statement st=null;
    protected ResultSet rs;

    @FXML
    private TextField key;
    @FXML
    private Label date;
    @FXML
    private Label pid;
    @FXML
    private Label eid;
    @FXML
    private Label sid;
    @FXML
    private Label sname;
    @FXML
    private Label ename;

    @FXML
    private TableView<buyProduct> table;
    @FXML
    private TableColumn<buyProduct, String> colid;
    @FXML
    private TableColumn<buyProduct, String> colname;
    @FXML
    private TableColumn<buyProduct, String> colprice;
    @FXML
    private TableColumn<buyProduct, String> colquantity;
    @FXML
    private TableColumn<buyProduct, String> coltotal;

    buyProduct bp= new buyProduct();
    purchase p=new purchase();
    ObservableList<buyProduct> pro = FXCollections.observableArrayList();



    public void initialize()

    {
        key.setText("");

        date.setText("");
        eid.setText("");
        ename.setText("");
        sid.setText("");
        sname.setText("");

    }


    public void search()
    {
        if(p.validateID2("select idpurchase from purchase ",key.getText()))
        {

            if(key.getText()!=null) {
                pro = bp.getBuyProduct(key.getText());

                colid.setCellValueFactory(new PropertyValueFactory<>("id"));
                colname.setCellValueFactory(new PropertyValueFactory<>("name"));
                colprice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
                colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                coltotal.setCellValueFactory(new PropertyValueFactory<>("total"));

                table.setItems(null);
                table.setItems(pro);

                pid.setText(key.getText());
                setDetails();
                key.setText("");
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalid Invoice ID!");

            alert.showAndWait();
            initialize();
            pid.setText(key.getText());

            table.getItems().clear();


        }
    }


    public void setDetails()
    {
        conE = new dbconnect();
        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from purchase");

            while(rs.next())
            {
                if(((key.getText()).equals(rs.getString("idpurchase"))))
                {
                    date.setText(rs.getString("date"));
                    sid.setText(rs.getString("idsupplier"));
                    eid.setText(rs.getString("empId"));
                }
            }
            rs=st.executeQuery("select * from supplier where idsupplier='"+sid.getText()+"'");
            while (rs.next())
            {
                sname.setText(rs.getString("name"));
            }

            rs=st.executeQuery("select * from employee where idemployee='"+eid.getText()+"'");
            while (rs.next())
            {
                ename.setText(rs.getString("name"));
            }


con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        finally
        {
            try{    if(st !=null){ st.close(); }   }
            catch(SQLException se){se.getMessage();}
            try{    if(con!=null){ con.close(); }   }
            catch(SQLException se){se.getMessage();}
        }



    }

    public void printInvoice()
    {
        iReport ir=new iReport();
        String query="select purchase.idpurchase,purchase.idsupplier,supplier.name as sname,purchase.empId,employee.name as ename,purchase.total,purchase.date,product.idproduct,product.name as pname,product.specification,product.pricePurchase,pricePurchase*purchase_products.quantity as tot, product.uom,purchase_products.quantity from purchase_products join purchase on purchase_products.idpurchase=purchase.idpurchase join product on purchase_products.idproduct=product.idproduct join supplier on purchase.idsupplier=supplier.idsupplier join employee on purchase.empId=employee.idemployee where purchase_products.idpurchase='"+pid.getText()+"'";
        ir.generateReportPass("C:\\IMS\\buy.jrxml",query);
    }




}
