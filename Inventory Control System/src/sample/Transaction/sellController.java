package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Management.expenditure;
import sample.UserHandle.purchasemen;
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
public class sellController
{
    protected dbconnect conE=new dbconnect();

    protected Statement st=null;
    protected ResultSet rs;

    @FXML
    private TextField key;
    @FXML
    private Label date;
    @FXML
    private Label sid;
    @FXML
    private Label eid;
    @FXML
    private Label cid;
    @FXML
    private Label cname;
    @FXML
    private Label ename;

    @FXML
    private TableView<sellProduct> table;
    @FXML
    private TableColumn<sellProduct, String> colid;
    @FXML
    private TableColumn<sellProduct, String> colname;
    @FXML
    private TableColumn<sellProduct, String> colprice;
    @FXML
    private TableColumn<sellProduct, String> colquantity;
    @FXML
    private TableColumn<sellProduct, String> coltotal;

    sellProduct sp= new sellProduct();
    sales s=new sales();
    ObservableList<sellProduct> pro = FXCollections.observableArrayList();




    public void initialize()

    {
    key.setText("");
        date.setText("");
        eid.setText("");
        ename.setText("");
        cid.setText("");
        cname.setText("");

    }


    public void search()
    {
        if(s.validateID("select idsale from sales ",key.getText()))
        {
        if(key.getText()!=null) {
            pro = sp.getSellProduct(key.getText());

            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            colname.setCellValueFactory(new PropertyValueFactory<>("name"));
            colprice.setCellValueFactory(new PropertyValueFactory<>("slePrice"));
            colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            coltotal.setCellValueFactory(new PropertyValueFactory<>("total"));

            table.setItems(null);
            table.setItems(pro);

            sid.setText(key.getText());
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
            sid.setText(key.getText());
            table.getItems().clear();


        }
    }


    public void setDetails()
    {

        Connection con=conE.getConnection();
            try
            {

                st=con.createStatement();
                rs=st.executeQuery("select * from sales");

                while(rs.next())
                {
                    if(((key.getText()).equals(rs.getString("idsale"))))
                    {
                        date.setText(rs.getString("date"));
                        cid.setText(rs.getString("idcustomer"));
                        eid.setText(rs.getString("empId"));
                    }
                }
                rs=st.executeQuery("select * from customer where idcustomer='"+cid.getText()+"'");
                    while (rs.next())
                    {
                        cname.setText(rs.getString("name"));
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





        }

        public void printInvoice()
        {
            iReport ir=new iReport();
            String query="select sales.idsale,sales.idcustomer,customer.name as cname,sales.empId,employee.name as ename,sales.total,sales.date,product.idproduct,product.name as pname,product.specification,product.priceSale,product.priceSale*sale_products.quantity as tot,product.uom,sale_products.quantity from sale_products join sales on sale_products.idsale=sales.idsale join product on sale_products.idproduct=product.idproduct join customer on customer.idcustomer=sales.idcustomer join employee on sales.empId=employee.idemployee where sale_products.idsale='"+sid.getText()+"'";
            ir.generateReportPass("C:\\IMS\\sell.jrxml",query);
        }





}
