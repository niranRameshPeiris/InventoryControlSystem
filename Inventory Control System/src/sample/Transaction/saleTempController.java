package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.dataHandle.product;
import sample.dataHandle.sellProduct;
import sample.dbconnect;
import sample.iReport;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Ramesh on 4/25/2017.
 */
public class saleTempController {
    dbconnect conE= new dbconnect();

    Statement st=null;

    public static String id;
    public static String name;
    public static String add;
    public static String city;
    public static String tel;

    public static String eid;
    public static String ename;
    public static String etel;

    public  float totf=0;
    public  float totg=0;




    @FXML
    private TextField d;
    @FXML
    private Label orderno;

    @FXML
    public Label cid;
    @FXML
    public Label cname;
    @FXML
    public Label cadd;
    @FXML
    public Label ccity;
    @FXML
    public Label ctel;


    @FXML
    public Label sid;
    @FXML
    public Label sname;
    @FXML
    public Label stel;


    @FXML
    private TableView<sellProduct> tablep;
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



    @FXML
    private TextField txtid;
    @FXML
    private Label lbln;
    @FXML
    private Label lblp;
    @FXML
    private Label lblt;
    @FXML
    private TextField txtq;
    @FXML
    private Button addpro;


    @FXML
    private Label ftot;
    @FXML
    private Label gtot;
    @FXML
    private TextField dis;

    product p=new product();
   ObservableList<product> temp = FXCollections.observableArrayList();
    private  float sellPrice;

    sellProduct sp= new sellProduct();
    ObservableList<sellProduct> pro = FXCollections.observableArrayList();

    //twoooooooo





    public void initialize()

    {
        //tablep.setEditable(true);

        setCurrentDate();
        setOrderNo();

         id=null;
         name=null;
        add=null;
      city=null;
        tel=null;

        eid=null;
       ename=null;
        etel=null;



        tablep.getSelectionModel().clearSelection();

        addpro.setDisable(true);
        txtq.setDisable(true);

    }
    public void setOrderNo()
    {
        sales ob=new sales();
        String no=ob.getTransactionNo("select MAX(idsale) from sales;","MAX(idsale)");
        if(no!=null) {
            int on = Integer.parseInt(no) + 1;
            String id = "" + on;
            orderno.setText(id);
        }
        else
            orderno.setText("1");
    }
    public void getCustomerID()
    {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("customerID.fxml"));
            Stage s=new Stage();
            s.setTitle("Select Customer");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            //s.setAlwaysOnTop(true);

            s.setScene(new Scene(root, 450,456));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");
        }


    }
    public void getempID()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("empID.fxml"));
            Stage emp=new Stage();
            emp.setTitle("Select Employee");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            emp.getIcons().add(icon);
            //s.setAlwaysOnTop(true);

            emp.setScene(new Scene(root, 500,456));
            emp.show();
        }catch (Exception ex){
            System.out.println("Couldnt load window");
        }
    }

    public void setCurrentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        d.setText(dateFormat.format(date));
        System.out.println(dateFormat.format(date));
    }

    public void setCustomer(String id,String name,String add,String city,String tel)
    {

        this.id=id;
        this.name=name;
        this.add=add;
        this.city=city;
        this.tel=tel;


    System.out.print(id);

    }


    public void setValues()
    {
        cid.setText(id);
        cname.setText(name);
        cadd.setText(add);
        ccity.setText(city);
        ctel.setText(tel);

        sid.setText(eid);
        sname.setText(ename);
        stel.setText(etel);
    }

    public void setemployee(String id,String name,String tel)
    {

        this.eid=id;
        this.ename=name;
        this.etel=tel;


        System.out.print(eid);

    }



    public void FillTable()
    {

        colid.setCellValueFactory(new PropertyValueFactory<sellProduct ,String>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<sellProduct ,String>("name"));
        colprice.setCellValueFactory(new PropertyValueFactory<sellProduct ,String>("slePrice"));
        colquantity.setCellValueFactory(new PropertyValueFactory<sellProduct ,String>("quantity"));
        coltotal.setCellValueFactory(new PropertyValueFactory<sellProduct ,String>("total"));

        tablep.setItems(null);
        tablep.setItems(pro);



    }




    public void addProduct()
    {
        if(validationId() && validationQ()) {

            pro.add(new sellProduct(txtid.getText(),lbln.getText(),lblp.getText(),txtq.getText(),lblt.getText()));
            totf=totf+(Float.parseFloat(lblt.getText()));
            txtid.setText(null);
            txtq.setText(null);
            lbln.setText(null);
            lblp.setText(null);
            lblt.setText(null);
            addpro.setDisable(true);
           // System.out.print(pid);
            FillTable();
            txtq.setDisable(true);

            //}


            ftot.setText(String.valueOf(totf));
        }

    }

    public void fillFields()
    {

        boolean val=validationId();
        if(val) {
            if (p.validateId(txtid.getText())) {
                temp = p.serchFromID(txtid.getText());
                p = temp.get(0);
                lbln.setText(p.getName());
                lblp.setText(p.getSlePrice());
                sellPrice = Float.parseFloat(p.getSlePrice());
                txtq.setDisable(false);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("ID not Found on Database");

                alert.showAndWait();
                txtq.setDisable(true);
            }


        }




    }

    public void fillTotal()
    {

        boolean val = validationQ();
        if (val) {
            if(p.validateQuantity(txtq.getText(),txtid.getText())) {
                lblt.setText(String.valueOf((sellPrice) * (Integer.parseInt(txtq.getText()))));
                addpro.setDisable(false);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Not enough quantity available right now");

                alert.showAndWait();

            }
        }




    }


    public boolean validationId()
    {
        int warning=0;
        int warning2=0;
        boolean warning3=false;

        if ((txtid.getText().isEmpty()) || (txtid.getText().trim().isEmpty())) {
            txtid.setStyle("-fx-text-box-border: red ; ");
        } else {
            txtid.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning++;
        }
///////////////////////////////
        if (!(txtid.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))) {
            txtid.setStyle("-fx-text-box-border: red ; ");
        } else {
            warning2++;
            txtid.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        ///////////////
        for(int k=0; k<pro.size(); k++)
        {
            if(pro.get(k).getId().equals(txtid.getText()))
            {
                warning3=true;
            }
            else
            {
                warning3=false;
            }
        }


        if((warning2 != 1) || (warning != 1)||(warning3))
        {

            if(warning3)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("This Product Already Added ! ");

                alert.showAndWait();

            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Invalid ID or Empty Field");

                alert.showAndWait();
            }
            txtq.setDisable(true);
            return false;

        }
        else {
            return true;
        }




    }

    public boolean validationQ()
    {
        int warning=0;
        int warning2=0;

        if ((txtq.getText().isEmpty()) || (txtq.getText().trim().isEmpty())) {
            txtq.setStyle("-fx-text-box-border: red ; ");
        } else {
            txtq.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning++;
        }

///////////////////////////////
        if (!(txtq.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))) {
            txtq.setStyle("-fx-text-box-border: red ; ");
        } else {
            warning2++;
            txtq.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if((warning2 != 1) || (warning != 1))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalid Quantity or Empty Field");

            alert.showAndWait();
            return false;
        }
        else {
            return true;
        }
    }

    public void DeletePro()
    {
         sp = tablep.getSelectionModel().getSelectedItem();

        if(sp!=null)
        {
            totf=totf-(Float.parseFloat(sp.getTotal()));
            ftot.setText(String.valueOf(totf));

            pro.remove(pro.indexOf(sp));

            FillTable();

        }
        FillTable();
    }

 public void calculateGTot()
 {

    if ((dis.getText().isEmpty()) || (dis.getText().trim().isEmpty())) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("WARRNING");
        alert.setContentText("You need to add some value to Discount");
        alert.showAndWait();
    } else {

        totg = totf-((totf *(Float.parseFloat(dis.getText())))/100);
        gtot.setText(String.valueOf(totg));

    }

 }


 public void saveSale() {
     int warning = 0;

     if (orderno.getText().isEmpty()) {
         orderno.setStyle("-fx-text-box-border: red ; ");
     } else {
         orderno.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if ((d.getText().isEmpty()) || (d.getText().trim().isEmpty())) {
         d.setStyle("-fx-text-box-border: red ; ");
     } else {
         d.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (sid.getText()==null) {
         sid.setStyle("-fx-text-box-border: red ; ");
     } else {
         sid.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }


     if (sname.getText()==null) {
         sname.setStyle("-fx-text-box-border: red ; ");
     } else {
         sname.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (stel.getText()==null) {
         stel.setStyle("-fx-text-box-border: red ; ");
     } else {
         stel.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (cid.getText()==null) {
         cid.setStyle("-fx-text-box-border: red ; ");
     } else {
         cid.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }


     if (cname.getText()==null) {
         cname.setStyle("-fx-text-box-border: red ; ");
     } else {
         cname.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (cadd.getText()==null) {
         cadd.setStyle("-fx-text-box-border: red ; ");
     } else {
         cadd.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (ccity.getText()==null) {
         ccity.setStyle("-fx-text-box-border: red ; ");
     } else {
         ccity.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (ctel.getText()==null) {
         ctel.setStyle("-fx-text-box-border: red ; ");
     } else {
         ctel.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (ftot.getText().isEmpty()) {
         ftot.setStyle("-fx-text-box-border: red ; ");
     } else {
         ftot.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if (gtot.getText().isEmpty()) {
         gtot.setStyle("-fx-text-box-border: red ; ");
     } else {
         gtot.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }

     if ((dis.getText().isEmpty()) || (dis.getText().trim().isEmpty())) {
         dis.setStyle("-fx-text-box-border: red ; ");
     } else {
         dis.setStyle("-fx-text-box-border: #d1d6cf ; ");
         warning++;
     }


     if (warning != 13) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setHeaderText(null);
         alert.setTitle("WARRNING");
         alert.setContentText("You need to fill Empty fields");
         alert.showAndWait();
     } else {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setHeaderText(null);
         alert.setTitle("Confirmation Dialog");
         alert.setContentText("Do You Need to Save ?");

         Optional<ButtonType> result = alert.showAndWait();
         if (result.get() == ButtonType.OK)
         {


             Alert alert1 = new Alert(Alert.AlertType.WARNING);
             alert1.setHeaderText(null);
             alert1.setTitle("Message");
             alert1.setContentText("Your data saved ");
             alert1.showAndWait();
            //save pdf
            editSale();
             seNull();
             iReport ir=new iReport();
             ir.generateReport("C:\\IMS\\SaleInvoice.jrxml");

             totf=0;
             initialize();

         }


         else
            {
                totf=0;
               //seNull();
                initialize();
            }


 }
     }

     public void editSale()
     {

         sales s = new sales();
         String query = "INSERT INTO sales(date,idcustomer,total,empId) VALUES ('" + d.getText() + "','" + cid.getText() + "','" + gtot.getText() + "','" + sid.getText() + "')";
         s.editSale(query);




         //decrese stock in product
         for(int i=0;i<pro.size();i++) {
            sp=pro.get(i);
             String stock = p.getStock(sp.getId());
             int ans=(Integer.parseInt(stock))-(Integer.parseInt(sp.getQuantity()));
             String query1 = "UPDATE product SET stock='" +ans+ "' WHERE idproduct='" + sp.getId() + "'";
             p.editP(query1);

             try
             {
                 Connection con=conE.getConnection();
                 st=con.createStatement();
                 st.executeUpdate("INSERT INTO sale_products(idsale,idproduct,quantity) VALUES ('" + orderno.getText() + "','" + sp.getId() + "','" + sp.getQuantity() + "')");
                con.close();
             } catch (SQLException e) {
                 System.out.print(e.getMessage());
             }



         }

         //edit sale product

         //adit sale


     }

     public void seNull()
     {
         ftot.setText(null);
         gtot.setText(null);
         dis.setText(null);

         cid.setText(null);
         cname.setText(null);
         cadd.setText(null);
         ccity.setText(null);
         ctel.setText(null);

         sid.setText(null);
         sname.setText(null);
         stel.setText(null);


         tablep.getItems().clear();


     }



 }








