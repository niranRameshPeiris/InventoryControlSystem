package sample;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Management.expenditure;
import sample.Management.income;
import sample.UserHandle.user;
import sample.dataHandle.customer;
import sample.dataHandle.product;
import sample.dataHandle.supplier;
//import java.awt.Dialog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    iReport ir=new iReport();
    @FXML
    private Button pr;
    @FXML
    private Button sr;
    @FXML
    private Button cr;


//product table
    @FXML
    private TableView<product> tablep;
    @FXML
    private TableColumn<product, String> p1;
    @FXML
    private TableColumn<product, String> p2;
    @FXML
    private TableColumn<product, String> p3;
    @FXML
    private TableColumn<product, String> p4;
    @FXML
    private TableColumn<product, String> p5;
    @FXML
    private TableColumn<product, String> p6;
    @FXML
    private TableColumn<product, String> p7;
    @FXML
    private TableColumn<product, String> p8;

    //supplier table
    @FXML
    private TableView<supplier> tables;
    @FXML
    private TableColumn<supplier, String> s1;
    @FXML
    private TableColumn<supplier, String> s2;
    @FXML
    private TableColumn<supplier, String> s3;
    @FXML
    private TableColumn<supplier, String> s4;
    @FXML
    private TableColumn<supplier, String> s5;
    @FXML
    private TableColumn<supplier, String> s6;
    @FXML
    private TableColumn<supplier, String> s7;
    @FXML
    private TableColumn<supplier, String> s8;
    @FXML
    private TableColumn<supplier, String> s9;
    @FXML
    private TableColumn<supplier, String> s10;
    //customer table
    @FXML
    private TableView<customer> tablec;
    @FXML
    private TableColumn<customer, String> c1;
    @FXML
    private TableColumn<customer, String> c2;
    @FXML
    private TableColumn<customer, String> c3;
    @FXML
    private TableColumn<customer, String> c4;
    @FXML
    private TableColumn<customer, String> c5;
    @FXML
    private TableColumn<customer, String> c6;
    @FXML
    private TableColumn<customer, String> c7;
    @FXML
    private TableColumn<customer, String> c8;
    @FXML
    private TableColumn<customer, String> c9;
    @FXML
    private TableColumn<customer, String> c10;

    //product text boxz
    @FXML
    private TextField ptxt1;
    @FXML
    private TextField ptxt2;
    @FXML
    private TextField ptxt3;
    @FXML
    private TextField ptxt4;
    @FXML
    private TextField ptxt5;
    @FXML
    private TextField ptxt6;
    @FXML
    private TextField ptxt7;

    //supplier text boxz
    @FXML
    private TextField stxt1;
    @FXML
    private TextField stxt2;
    @FXML
    private TextField stxt3;
    @FXML
    private TextField stxt4;
    @FXML
    private TextField stxt5;
    @FXML
    private TextField stxt6;
    @FXML
    private TextField stxt7;
    @FXML
    private TextField stxt8;
    @FXML
    private TextField stxt9;

    //customer text boxz
    @FXML
    private TextField ctxt1;
    @FXML
    private TextField ctxt2;
    @FXML
    private TextField ctxt3;
    @FXML
    private TextField ctxt4;
    @FXML
    private TextField ctxt5;
    @FXML
    private TextField ctxt6;
    @FXML
    private TextField ctxt7;
    @FXML
    private TextField ctxt8;
    @FXML
    private TextField ctxt9;

    //product add edit and delete buttons
    @FXML
    private Button addp;
    @FXML
    private Button editp;
    @FXML
    private Button deletep;
    @FXML
    //supplier data add edit and delete buttons
    private Button adds;
    @FXML
    private Button edits;
    @FXML
    private Button deletes;
    //customer data add delete and edit buttons
    @FXML
    private Button addc;
    @FXML
    private Button editc;
    @FXML
    private Button deletec;

    @FXML
    private AnchorPane main;

    //product search key value
    @FXML
    private TextField keyp;
    //supplier search key value
    @FXML
    private TextField keys;
    //customer search key value
    @FXML
    private TextField keyc;

    //anchor pane which load the purchase ....... anchor panse on it
    @FXML
    private AnchorPane loadPurchase;


    //////management///////////

    @FXML
    private Label sid;
    @FXML
    private Label sname;
    @FXML
    private Label tot;
    @FXML
    private TextField txtpid;
    @FXML
    private TextField date;
    @FXML
    private ComboBox combop;
    @FXML
    private CheckBox checkp;

    @FXML
    private Button psearch;
    @FXML
    private Button submit;
    @FXML
    private TableView<expenditure> tablee;
    @FXML
    private TableColumn<expenditure, String> e1;
    @FXML
    private TableColumn<expenditure, String> e2;
    @FXML
    private TableColumn<expenditure, String> e3;
    @FXML
    private TableColumn<expenditure, String> e4;
    @FXML
    private TableColumn<expenditure, String> e5;
    @FXML
    private TableColumn<expenditure, String> e6;


    ObservableList<String> paymentType= FXCollections.observableArrayList("Cash","Cheque","Digital");


    //////management///////////
    ///in come//

    @FXML
    private Label sid1;
    @FXML
    private Label sname1;
    @FXML
    private Label tot1;
    @FXML
    private TextField txtpid1;
    @FXML
    private TextField date1;
    @FXML
    private ComboBox combop1;
    @FXML
    private CheckBox checkp1;

    @FXML
    private Button psearch1;
    @FXML
    private Button submit1;
    @FXML
    private TableView<income> tablee1;
    @FXML
    private TableColumn<income, String> e11;
    @FXML
    private TableColumn<income, String> e21;
    @FXML
    private TableColumn<income, String> e31;
    @FXML
    private TableColumn<income, String> e41;
    @FXML
    private TableColumn<income, String> e51;
    @FXML
    private TableColumn<income, String> e61;


    ///report///
    @FXML
    private AnchorPane load1;


    @FXML
    private Tab transaction;
    @FXML
    private Tab management;
    @FXML
    private Tab datahandle;
    @FXML
    private Tab tabs;
    @FXML
    private Tab tabp;
    @FXML
    private Tab tabc;
    @FXML
    private Tab tabmr;
    @FXML
    private Tab tabph;


    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private TabPane headpane;





    public static String userId;
    public static String level;


    //like main->at the very first
    @FXML
    public void initialize()
    {
        ////access
        System.out.print("su" +userId);


        if(level.equals("5"))
        {
            //data entry
            transaction.setDisable(true);
            management.setDisable(true);

            editp.setDisable(true);
            deletep.setDisable(true);
            editc.setDisable(true);
            deletec.setDisable(true);

            edits.setDisable(true);
            deletes.setDisable(true);


        }
        else if(level.equals("2"))
        {
            //accountent
            datahandle.setDisable(true);
            headpane.getSelectionModel().select(management);
            btn2.setDisable(true);
            btn4.setDisable(true);

            editp.setDisable(true);
            deletep.setDisable(true);
            editc.setDisable(true);
            deletec.setDisable(true);

            edits.setDisable(true);
            deletes.setDisable(true);

            try {
                salesT();
            }catch (Exception e){}



        }
        else if(level.equals("4"))
        {
            //salesmen
            management.setDisable(true);
            btn3.setDisable(true);
            btn4.setDisable(true);
            btn5.setDisable(true);
            tabs.setDisable(true);
            addp.setDisable(true);
            addc.setDisable(true);

            editp.setDisable(true);
            deletep.setDisable(true);
            editc.setDisable(true);
            deletec.setDisable(true);

            edits.setDisable(true);
            deletes.setDisable(true);

            try {
                salesT();
            }catch (Exception e){}


        }
        else if(level.equals("3"))
        {
            //purchasmen
            management.setDisable(true);
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn6.setDisable(true);
            tabc.setDisable(true);
            addp.setDisable(true);
            adds.setDisable(true);

            editp.setDisable(true);
            deletep.setDisable(true);
            editc.setDisable(true);
            deletec.setDisable(true);

            edits.setDisable(true);
            deletes.setDisable(true);

            try {
                purchaseT();
            }catch (Exception e){}


        }
        else if (level.equals("6"))
        {
                tabp.setDisable(true);
                editp.setDisable(true);
                addp.setDisable(true);
                deletep.setDisable(true);
                tabs.setDisable(true);
                edits.setDisable(true);
                adds.setDisable(true);
                deletes.setDisable(true);
                 tabc.setDisable(true);
                editc.setDisable(true);
                addc.setDisable(true);
                deletec.setDisable(true);
                tabph.setDisable(true);
                tabmr.setDisable(true);
                btn1.setDisable(true);
                btn6.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn5.setDisable(true);
                btn4.setDisable(true);

                setAccess();

        }

        else{
            editp.setDisable(true);
            deletep.setDisable(true);
            editc.setDisable(true);
            deletec.setDisable(true);

            edits.setDisable(true);
            deletes.setDisable(true);
            try {
                salesT();
            }catch (Exception e){}

        }


        //transaction.setDisable(true);

        ///////////


        //view database details to tables
        viewProduct();
        viewcustomer();
        viewSupplier();

        //clear the tables
        tablep.getSelectionModel().clearSelection();
        tablec.getSelectionModel().clearSelection();
        tables.getSelectionModel().clearSelection();
        //set product text boxz null
        ptxt1.setText(null);
        ptxt2.setText(null);
        ptxt3.setText(null);
        ptxt4.setText(null);
        ptxt5.setText(null);
        ptxt6.setText(null);
        ptxt7.setText(null);
        //set supplier text boxz null
        stxt1.setText(null);
        stxt2.setText(null);
        stxt3.setText(null);
        stxt4.setText(null);
        stxt5.setText(null);
        stxt6.setText(null);
        stxt7.setText(null);
        stxt8.setText(null);
        stxt9.setText(null);
        //set customer text boxz null
        ctxt1.setText(null);
        ctxt2.setText(null);
        ctxt3.setText(null);
        ctxt4.setText(null);
        ctxt5.setText(null);
        ctxt6.setText(null);
        ctxt7.setText(null);
        ctxt8.setText(null);
        ctxt9.setText(null);
        //disable the edit and delete buttons before sselecting a row



        //management expenditure

        txtpid.setText("");
        sid.setText("");
        sname.setText("");
        tot.setText("");
        setDate();
        viewExpenditure();
        combop.setValue("Payment Type");
        combop.setItems(paymentType);
        checkp.setSelected(false);



        txtpid1.setText("");
        sid1.setText("");
        sname1.setText("");
        tot1.setText("");
        setDateI();
        viewIncome();
        combop1.setValue("Payment Type");
        combop1.setItems(paymentType);
        checkp1.setSelected(false);



    }



    public void setAccessId(String uid,String level)
    {
        this.userId=uid;
        this.level=level;
    }

    @FXML
    public void viewProduct()
    {

        ObservableList<product> temp = FXCollections.observableArrayList();
        product p;
        p = new product();

        temp=p.getProduct();

        p1.setCellValueFactory(new PropertyValueFactory<product ,String>("id"));
        p2.setCellValueFactory(new PropertyValueFactory<product ,String>("name"));
        p3.setCellValueFactory(new PropertyValueFactory<product ,String>("specs"));
        p4.setCellValueFactory(new PropertyValueFactory<product ,String>("purchasePrice"));
        p5.setCellValueFactory(new PropertyValueFactory<product ,String>("slePrice"));
        p6.setCellValueFactory(new PropertyValueFactory<product ,String>("stock"));
        p7.setCellValueFactory(new PropertyValueFactory<product ,String>("uom"));
        p8.setCellValueFactory(new PropertyValueFactory<product ,String>("rackNo"));

        tablep.setItems(null);
        tablep.setItems(temp);

    }

    @FXML
    public void viewSupplier()
    {
        ObservableList<supplier> temp2 = FXCollections.observableArrayList();
        supplier s;
        s = new supplier();

        temp2=s.getSupplier();

        s1.setCellValueFactory(new PropertyValueFactory<>("id"));
        s2.setCellValueFactory(new PropertyValueFactory<>("name"));
        s3.setCellValueFactory(new PropertyValueFactory<>("address"));
        s4.setCellValueFactory(new PropertyValueFactory<>("city"));
        s5.setCellValueFactory(new PropertyValueFactory<>("country"));
        s6.setCellValueFactory(new PropertyValueFactory<>("postcode"));
        s7.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        s8.setCellValueFactory(new PropertyValueFactory<>("fax"));
        s9.setCellValueFactory(new PropertyValueFactory<>("email"));
        s10.setCellValueFactory(new PropertyValueFactory<>("name"));

        tables.setItems(null);
        tables.setItems(temp2);

    }

    @FXML
    public void viewcustomer()
    {
        ObservableList<customer> temp3 = FXCollections.observableArrayList();
        customer c;
        c = new customer();

        temp3=c.getCustomer();

        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));
        c3.setCellValueFactory(new PropertyValueFactory<>("address"));
        c4.setCellValueFactory(new PropertyValueFactory<>("city"));
        c5.setCellValueFactory(new PropertyValueFactory<>("country"));
        c6.setCellValueFactory(new PropertyValueFactory<>("postcode"));
        c7.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        c8.setCellValueFactory(new PropertyValueFactory<>("fax"));
        c9.setCellValueFactory(new PropertyValueFactory<>("email"));
        c10.setCellValueFactory(new PropertyValueFactory<>("name"));

        tablec.setItems(null);
        tablec.setItems(temp3);
    }

    @FXML
    public void  pSelect()
    {
                product p = tablep.getSelectionModel().getSelectedItem();

            if(p!=null)
            {
                ptxt1.setText(p.getName());
                ptxt2.setText(p.getSpecs());
                ptxt3.setText(p.getPurchasePrice());
                ptxt4.setText(p.getSlePrice());
                ptxt5.setText(p.getStock());
                ptxt6.setText(p.getUom());
                ptxt7.setText(p.getRackNo());

                boolean bEnable = ptxt1.getText().isEmpty() || ptxt1.getText().trim().isEmpty();
                if((!level.equals("4"))&&(!level.equals("3")) && (!level.equals("6")))
                {
                editp.setDisable(bEnable);
                deletep.setDisable(bEnable);
            }
                if (level.equals("6")) {
                setP();
                }

            }
    }
    @FXML
    public void  sSelect()
    {
        supplier s = tables.getSelectionModel().getSelectedItem();
        if(s!=null) {
            stxt1.setText(s.getName());
            stxt2.setText(s.getAddress());
            stxt3.setText(s.getCity());
            stxt4.setText(s.getCountry());
            stxt5.setText(s.getPostcode());
            stxt6.setText(s.getTelephone());
            stxt7.setText(s.getFax());
            stxt8.setText(s.getEmail());
            stxt9.setText(s.getContact());

            boolean bEnable = stxt1.getText().isEmpty() || stxt1.getText().trim().isEmpty();
            if((!level.equals("3")) && (!level.equals("6"))) {
                edits.setDisable(bEnable);
                deletes.setDisable(bEnable);


                }
            if (level.equals("6")) {
                setS();
            }
        }
    }
    @FXML
    public void  cSelect()
    {
        customer c = tablec.getSelectionModel().getSelectedItem();
        if(c!=null) {
            ctxt1.setText(c.getName());
            ctxt2.setText(c.getAddress());
            ctxt3.setText(c.getCity());
            ctxt4.setText(c.getCountry());
            ctxt5.setText(c.getPostcode());
            ctxt6.setText(c.getTelephone());
            ctxt7.setText(c.getFax());
            ctxt8.setText(c.getEmail());
            ctxt9.setText(c.getContact());

            boolean bEnable = ctxt1.getText().isEmpty() || ctxt1.getText().trim().isEmpty();
            if((!level.equals("4"))&& (!level.equals("6"))) {
                editc.setDisable(bEnable);
                deletec.setDisable(bEnable);
            }
            if (level.equals("6")) {
                setC();
            }
        }
    }
    @FXML
    public void pEdit()
    {
        product p=tablep.getSelectionModel().getSelectedItem();

        ///validate////
        int warning = 0;
        int warning2=0;
        //chech empty fields
        if((ptxt1.getText().isEmpty()) ||( ptxt1.getText().trim().isEmpty()))
        {
            ptxt1.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            ptxt1.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((ptxt3.getText().isEmpty()) ||( ptxt3.getText().trim().isEmpty())) {
            ptxt3.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ptxt3.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ptxt4.getText().isEmpty()) ||( ptxt4.getText().trim().isEmpty()))
        {
            ptxt4.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ptxt4.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ptxt5.getText().isEmpty()) ||( ptxt5.getText().trim().isEmpty()))
        {
            ptxt5.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ptxt5.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ptxt6.getText().isEmpty()) ||( ptxt6.getText().trim().isEmpty()))
        {
            ptxt6.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ptxt6.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ptxt7.getText().isEmpty()) ||( ptxt7.getText().trim().isEmpty()))
        {
            ptxt7.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ptxt7.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        //check numeric fields
        if (!(ptxt3.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            ptxt3.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning2++;
            ptxt3.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(ptxt4.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            ptxt4.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning2++;
            ptxt4.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(ptxt5.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            ptxt5.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            ptxt5.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning2++;
        }
        if (!(ptxt7.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            ptxt7.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            ptxt7.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning2++;
        }

        if(warning2 !=4)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("This Field Only Contain Numbers");

            alert.showAndWait();
        }

        if(warning !=6 ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Selected Fields cannot be Empty !");

            alert.showAndWait();
        }
        if((warning==6) &&(warning2==4))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Change Data ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                String query="UPDATE product SET name='"+ptxt1.getText()+"',specification='"+ptxt2.getText()+"', pricePurchase='"+ptxt3.getText()+"', priceSale='"+ptxt4.getText()+"', stock='"+ptxt5.getText()+"', uom='"+ptxt6.getText()+"', rackNo='"+ptxt7.getText()+"' WHERE idproduct='"+p.getId()+"'";
                p.editP(query);

                initialize();
            }
        }
    }
    @FXML
    public void cEdit()
    {
        customer c=tablec.getSelectionModel().getSelectedItem();
        //validate//////
        int warning = 0;
        int warning2=0;
        boolean warning3=false;
        boolean warning4=false;
        //chech empty fields
        if((ctxt1.getText().isEmpty()) ||( ctxt1.getText().trim().isEmpty()))
        {
            ctxt1.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            ctxt1.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((ctxt2.getText().isEmpty()) ||( ctxt2.getText().trim().isEmpty()))
        {
            ctxt2.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt2.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ctxt3.getText().isEmpty()) ||( ctxt3.getText().trim().isEmpty()))
        {
            ctxt3.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            ctxt3.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((ctxt4.getText().isEmpty()) ||( ctxt4.getText().trim().isEmpty()))
        {
            ctxt4.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt4.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ctxt5.getText().isEmpty()) ||( ctxt5.getText().trim().isEmpty()))
        {
            ctxt5.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt5.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ctxt6.getText().isEmpty()) ||( ctxt6.getText().trim().isEmpty()))
        {
            ctxt6.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt6.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ctxt7.getText().isEmpty()) ||( ctxt7.getText().trim().isEmpty()))
        {
            ctxt7.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt7.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ctxt8.getText().isEmpty()) ||( ctxt8.getText().trim().isEmpty()))
        {
            ctxt8.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt8.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((ctxt9.getText().isEmpty()) ||( ctxt9.getText().trim().isEmpty()))
        {
            ctxt9.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            ctxt9.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check for number
        if (!(ctxt5.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            ctxt5.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning2++;
            ctxt5.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(ctxt7.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            ctxt7.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning2++;
            ctxt7.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check tele no
        if (!((ctxt6.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))&&((ctxt6.getText()).length()==10 )))
        {
            ctxt6.setStyle("-fx-text-box-border: red ; ");
            warning3 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Wrong Telephone No !");

            alert.showAndWait();
        }
        else
        {
            warning3 =false;
            ctxt6.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check email
        Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m=p.matcher(ctxt8.getText());

        if (!(m.find() && m.group().equals(ctxt8.getText())))
        {
            ctxt8.setStyle("-fx-text-box-border: red ; ");
            warning4 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalied email!");

            alert.showAndWait();
        }
        else
        {
            warning4 =false;
            ctxt8.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if(warning2!=2)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("This Field Only Contain Numbers");

            alert.showAndWait();
        }

        if(warning!=9) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Selected Fields Cannot be Empty !");

            alert.showAndWait();
        }

        if((warning==9) && !warning3 && (warning2==2) && !warning4)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Change Data ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                String query="UPDATE customer SET name='"+ctxt1.getText()+"',address='"+ctxt2.getText()+"', city='"+ctxt3.getText()+"', country='"+ctxt4.getText()+"', postcode='"+ctxt5.getText()+"', telephone='"+ctxt6.getText()+"', fax='"+ctxt7.getText()+"', email='"+ctxt8.getText()+"', contactPerson='"+ctxt9.getText()+"' WHERE idcustomer='"+c.getId()+"'" ;
                c.editC(query);

                initialize();
            }
        }
    }
    @FXML
    public void sEdit()
    {
        supplier s=tables.getSelectionModel().getSelectedItem();
        ///validate
        int warning = 0;
        int warning2=0;
        boolean warning3=false;
        boolean warning4=false;

        //chech empty fields
        if((stxt1.getText().isEmpty()) ||( stxt1.getText().trim().isEmpty()))
        {
            stxt1.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            stxt1.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((stxt2.getText().isEmpty()) ||( stxt2.getText().trim().isEmpty()))
        {
            stxt2.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt2.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((stxt3.getText().isEmpty()) ||( stxt3.getText().trim().isEmpty()))
        {
            stxt3.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            stxt3.setStyle("-fx-text-box-border: #d1d6cf ; ");
            warning ++;
        }
        if((stxt4.getText().isEmpty()) ||( stxt4.getText().trim().isEmpty()))
        {
            stxt4.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt4.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((stxt5.getText().isEmpty()) ||( stxt5.getText().trim().isEmpty()))
        {
            stxt5.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt5.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((stxt6.getText().isEmpty()) ||( stxt6.getText().trim().isEmpty()))
        {
            stxt6.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt6.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((stxt7.getText().isEmpty()) ||( stxt7.getText().trim().isEmpty()))
        {
            stxt7.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt7.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((stxt8.getText().isEmpty()) ||( stxt8.getText().trim().isEmpty()))
        {
            stxt8.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt8.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((stxt9.getText().isEmpty()) ||( stxt9.getText().trim().isEmpty()))
        {
            stxt9.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning ++;
            stxt9.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check for number
        if (!(stxt5.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            stxt5.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning2++;
            stxt5.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if (!(stxt7.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")))
        {
            stxt7.setStyle("-fx-text-box-border: red ; ");
        }
        else
        {
            warning2++;
            stxt7.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check tele no
        if (!((stxt6.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))&&((stxt6.getText()).length()==10 )))
        {
            stxt6.setStyle("-fx-text-box-border: red ; ");
            warning3 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Wrong Telephone No !");

            alert.showAndWait();
        }
        else
        {
            warning3 =false;
            stxt6.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        //check email
        Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m=p.matcher(stxt8.getText());

        if (!(m.find() && m.group().equals(stxt8.getText())))
        {
            stxt8.setStyle("-fx-text-box-border: red ; ");
            warning4 =true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalied email!");

            alert.showAndWait();
        }
        else
        {
            warning4 =false;
            stxt8.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if(warning2!=2)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("This Field Only Contain Numbers");

            alert.showAndWait();
        }

        if(warning!=9) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Selected Fields Cannot be Empty !");

            alert.showAndWait();
        }
        if((warning==9) && !warning3 && (warning2==2) && !warning4) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Change Data ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                String query="UPDATE supplier SET name='"+stxt1.getText()+"',Address='"+stxt2.getText()+"', city='"+stxt3.getText()+"', country='"+stxt4.getText()+"', postcode='"+stxt5.getText()+"', telephone='"+stxt6.getText()+"', fax='"+stxt7.getText()+"', email='"+stxt8.getText()+"', contactperson='"+stxt9.getText()+"' WHERE idsupplier='"+s.getId()+"'";
                s.editS(query);

                initialize();
            }
        }
    }
    @FXML
    public void deletep()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Do You Need to Delete This Data ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            product p=tablep.getSelectionModel().getSelectedItem();
            String query="DELETE FROM product WHERE idproduct='"+p.getId()+"'";
            p.editP(query);

            initialize();
        }

    }
    @FXML
    public void deletes()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Do You Need to Delete This Data ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            supplier s=tables.getSelectionModel().getSelectedItem();
            String query="DELETE FROM supplier WHERE idsupplier='"+s.getId()+"'";
            s.editS(query);

            initialize();
        }

    }
    @FXML
    public void deletec()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Do You Need to Delete This Data ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            customer c=tablec.getSelectionModel().getSelectedItem();
            String query="DELETE FROM customer WHERE idcustomer='"+c.getId()+"'";
            c.editC(query);

            initialize();
        }

    }
    @FXML
    public void addP()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dataHandle/addDialog.fxml"));
            Stage s=new Stage();
            s.setTitle("Add New Product");
            s.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            //s.setAlwaysOnTop(true);

            s.setScene(new Scene(root, 353,415));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");
        }

    }
    @FXML
    public void addC()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dataHandle/customerDialog.fxml"));
            Stage s=new Stage();
            s.setTitle("Add New Customer");
            s.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            //s.setAlwaysOnTop(true);

            s.setScene(new Scene(root, 353,415));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");
        }

    }
    @FXML
    public void addS()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dataHandle/supplierdialog.fxml"));
            Stage s=new Stage();
            s.setTitle("Add New Supplier");
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            s.getIcons().add(icon);
            //s.setAlwaysOnTop(true);
            s.setResizable(false);
            s.setScene(new Scene(root, 353,415));
            s.show();
        }catch (Exception e){
            System.out.println("Couldnt load window");
        }

    }
    @FXML
    public void refreshP()
{
    //initialize();
    //view database details to tables
    viewProduct();
    //clear the tables
    tablep.getSelectionModel().clearSelection();
    //set product text boxz null
    ptxt1.setText(null);
    ptxt2.setText(null);
    ptxt3.setText(null);
    ptxt4.setText(null);
    ptxt5.setText(null);
    ptxt6.setText(null);
    ptxt7.setText(null);

    editp.setDisable(true);
    deletep.setDisable(true);
}
    @FXML
    public void refreshS()
    {
        //initialize();
        viewSupplier();

        //clear the tables
        tables.getSelectionModel().clearSelection();

        //set supplier text boxz null
        stxt1.setText(null);
        stxt2.setText(null);
        stxt3.setText(null);
        stxt4.setText(null);
        stxt5.setText(null);
        stxt6.setText(null);
        stxt7.setText(null);
        stxt8.setText(null);
        stxt9.setText(null);

        edits.setDisable(true);
        deletes.setDisable(true);

    }
    @FXML
    public void refreshC()
    {
        //initialize();
        viewcustomer();

        tablec.getSelectionModel().clearSelection();

        ctxt1.setText(null);
        ctxt2.setText(null);
        ctxt3.setText(null);
        ctxt4.setText(null);
        ctxt5.setText(null);
        ctxt6.setText(null);
        ctxt7.setText(null);
        ctxt8.setText(null);
        ctxt9.setText(null);

        editc.setDisable(true);
        deletec.setDisable(true);
    }
    @FXML
    public void searchP()
    {
        String key=keyp.getText();
        if(key!=null) {
            ObservableList<product> temp = FXCollections.observableArrayList();
            product p;
            p = new product();

            temp = p.searchP(key);

            p1.setCellValueFactory(new PropertyValueFactory<product, String>("id"));
            p2.setCellValueFactory(new PropertyValueFactory<product, String>("name"));
            p3.setCellValueFactory(new PropertyValueFactory<product, String>("specs"));
            p4.setCellValueFactory(new PropertyValueFactory<product, String>("purchasePrice"));
            p5.setCellValueFactory(new PropertyValueFactory<product, String>("slePrice"));
            p6.setCellValueFactory(new PropertyValueFactory<product, String>("stock"));
            p7.setCellValueFactory(new PropertyValueFactory<product, String>("uom"));
            p8.setCellValueFactory(new PropertyValueFactory<product, String>("rackNo"));

            tablep.setItems(null);
            tablep.setItems(temp);

            keyp.setText(null);
        }
        else {
            //initialize();
            //view database details to tables
            viewProduct();
            //clear the tables
            tablep.getSelectionModel().clearSelection();
            //set product text boxz null
            ptxt1.setText(null);
            ptxt2.setText(null);
            ptxt3.setText(null);
            ptxt4.setText(null);
            ptxt5.setText(null);
            ptxt6.setText(null);
            ptxt7.setText(null);

            editp.setDisable(true);
            deletep.setDisable(true);
        }
    }
    @FXML
    public void searchS()
    {
        String key=keys.getText();
        if(key!=null) {
            ObservableList<supplier> temp2 = FXCollections.observableArrayList();
            supplier s;
            s = new supplier();

            temp2 = s.searchS(key);

            s1.setCellValueFactory(new PropertyValueFactory<>("id"));
            s2.setCellValueFactory(new PropertyValueFactory<>("name"));
            s3.setCellValueFactory(new PropertyValueFactory<>("address"));
            s4.setCellValueFactory(new PropertyValueFactory<>("city"));
            s5.setCellValueFactory(new PropertyValueFactory<>("country"));
            s6.setCellValueFactory(new PropertyValueFactory<>("postcode"));
            s7.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            s8.setCellValueFactory(new PropertyValueFactory<>("fax"));
            s9.setCellValueFactory(new PropertyValueFactory<>("email"));
            s10.setCellValueFactory(new PropertyValueFactory<>("name"));

            tables.setItems(null);
            tables.setItems(temp2);

            keys.setText(null);
        }
        else {
            //initialize();

            viewSupplier();

            //clear the tables
            tables.getSelectionModel().clearSelection();

            //set supplier text boxz null
            stxt1.setText(null);
            stxt2.setText(null);
            stxt3.setText(null);
            stxt4.setText(null);
            stxt5.setText(null);
            stxt6.setText(null);
            stxt7.setText(null);
            stxt8.setText(null);
            stxt9.setText(null);

            edits.setDisable(true);
            deletes.setDisable(true);
        }
    }
    @FXML
    public void searchC()
    {
        String key=keyc.getText();
        if(key!=null) {
            ObservableList<customer> temp3 = FXCollections.observableArrayList();
            customer c;
            c = new customer();

            temp3 = c.searchC(key);

            c1.setCellValueFactory(new PropertyValueFactory<>("id"));
            c2.setCellValueFactory(new PropertyValueFactory<>("name"));
            c3.setCellValueFactory(new PropertyValueFactory<>("address"));
            c4.setCellValueFactory(new PropertyValueFactory<>("city"));
            c5.setCellValueFactory(new PropertyValueFactory<>("country"));
            c6.setCellValueFactory(new PropertyValueFactory<>("postcode"));
            c7.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            c8.setCellValueFactory(new PropertyValueFactory<>("fax"));
            c9.setCellValueFactory(new PropertyValueFactory<>("email"));
            c10.setCellValueFactory(new PropertyValueFactory<>("name"));

            tablec.setItems(null);
            tablec.setItems(temp3);

            keyc.setText(null);
        }
        else {
            //initialize();

            viewcustomer();

            tablec.getSelectionModel().clearSelection();

            ctxt1.setText(null);
            ctxt2.setText(null);
            ctxt3.setText(null);
            ctxt4.setText(null);
            ctxt5.setText(null);
            ctxt6.setText(null);
            ctxt7.setText(null);
            ctxt8.setText(null);
            ctxt9.setText(null);

            editc.setDisable(true);
            deletec.setDisable(true);
        }

    }
    //load window 1
    @FXML
    public void salesT() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Transaction/salesTable.fxml"));
        loadPurchase.getChildren().setAll(pane);
    }
    //load window 2
    @FXML
    public void salesInvoice() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Transaction/saleTemp.fxml"));
        loadPurchase.getChildren().setAll(pane);
    }

    @FXML
    public void purchaseT() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Transaction/purchaseTable.fxml"));
        loadPurchase.getChildren().setAll(pane);
    }

    @FXML
    public void purchaseInvoice() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Transaction/purchaseTemp.fxml"));
        loadPurchase.getChildren().setAll(pane);
    }

    @FXML
    public void buy() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Transaction/buy.fxml"));
        loadPurchase.getChildren().setAll(pane);
    }

    @FXML
    public void sell() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Transaction/sell.fxml"));
        loadPurchase.getChildren().setAll(pane);
    }






    //****************************//
    ////////       management      //////////


public void viewExpenditure()
{

    ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
    expenditure e;
    e = new expenditure();

    temp2=e.getNotpaidExpenditure();

    e1.setCellValueFactory(new PropertyValueFactory<>("transid"));
    e2.setCellValueFactory(new PropertyValueFactory<>("date"));
    e3.setCellValueFactory(new PropertyValueFactory<>("price"));
    e4.setCellValueFactory(new PropertyValueFactory<>("refid"));
    e5.setCellValueFactory(new PropertyValueFactory<>("refName"));
    e6.setCellValueFactory(new PropertyValueFactory<>("paidNot"));


    tablee.setItems(null);
    tablee.setItems(temp2);



}
    @FXML
    public void  eSelect()
    {
        expenditure e = tablee.getSelectionModel().getSelectedItem();

        if(e!=null)
        {
            txtpid.setText(e.getTransid());
            sid.setText(e.getRefid());
            sname.setText(e.getRefName());
            tot.setText(e.getPrice());

        }
else {
            initialize();
        }
    }

    public void searchE()
    {
        String key=txtpid.getText();
        if(!key.equals("")) {
            ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
            expenditure e;
            e = new expenditure();

            temp2 = e.searchNotpaidE(key);
            //System.out.print(temp2.get(0).getRefName());

            e1.setCellValueFactory(new PropertyValueFactory<>("transid"));
            e2.setCellValueFactory(new PropertyValueFactory<>("date"));
            e3.setCellValueFactory(new PropertyValueFactory<>("price"));
            e4.setCellValueFactory(new PropertyValueFactory<>("refid"));
            e5.setCellValueFactory(new PropertyValueFactory<>("refName"));
            e6.setCellValueFactory(new PropertyValueFactory<>("paidNot"));



            tablee.setItems(null);
            tablee.setItems(temp2);



            txtpid.setText("");
        }
        else {
            initialize();


        }
    }

    public void setDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        date.setText(dateFormat.format(d));
        System.out.println(dateFormat.format(d));
    }

    public void paymentValidation()
    {
        int warning =0;
        boolean warning2=false;
        boolean warning3=false;

        if((txtpid.getText().isEmpty()) ||( txtpid.getText().trim().isEmpty()))
        {
            txtpid.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtpid.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((date.getText().isEmpty()) ||( date.getText().trim().isEmpty()))
        {
            date.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            date.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((sid.getText().isEmpty()))
        {
            sid.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            sid.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((sname.getText().isEmpty()))
        {
            sname.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            sname.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((tot.getText().isEmpty()))
        {
            tot.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            tot.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if(combop.getSelectionModel().isEmpty() || combop.getValue().equals("Payment Type"))
        {
            warning3=true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("You need to select one for the Payment methods!");

            alert.showAndWait();
        }
        else
        {
            warning3=false;
        }


        if(!(checkp.isSelected()))
        {
            checkp.setStyle("-fx-font-weight: bold;");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Select paid to continue");

            alert.showAndWait();
            warning2=true;
        }
        else
        {
            warning2=false;
        }

        if(warning!=5 ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Check Empty Fields !");

            alert.showAndWait();
        }

        if((warning==5) && !warning3 && !warning2)
        {
            //System.out.print("come");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Paid for this?");


            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                expenditure e=new expenditure();
                String query ="UPDATE purchase SET paymentType='"+combop.getValue()+"', `paid/not`='paid', paidDate='"+date.getText()+"' WHERE `idpurchase`='"+txtpid.getText()+"';";
                e.editExp(query);

            initialize();

            }
        }

    }


    public void viewIncome()
    {

        ObservableList<income> temp2 = FXCollections.observableArrayList();
        income i;
        i = new income();

        temp2=i.getNotpaidIncome();

        e11.setCellValueFactory(new PropertyValueFactory<>("transid"));
        e21.setCellValueFactory(new PropertyValueFactory<>("date"));
        e31.setCellValueFactory(new PropertyValueFactory<>("price"));
        e41.setCellValueFactory(new PropertyValueFactory<>("refid"));
        e51.setCellValueFactory(new PropertyValueFactory<>("refName"));
        e61.setCellValueFactory(new PropertyValueFactory<>("paidNot"));


        tablee1.setItems(null);
        tablee1.setItems(temp2);

    }
    @FXML
    public void  iSelect()
    {
        income i = tablee1.getSelectionModel().getSelectedItem();

        if(i!=null)
        {
            txtpid1.setText(i.getTransid());
            sid1.setText(i.getRefid());
            sname1.setText(i.getRefName());
            tot1.setText(i.getPrice());

        }
        else {
            initialize();
        }
    }

    public void searchI()
    {
        String key=txtpid1.getText();
        if(!key.equals("")) {
            ObservableList<income> temp2 = FXCollections.observableArrayList();
            income i;
            i = new income();

            temp2 = i.searchNotpaidI(key);

            e11.setCellValueFactory(new PropertyValueFactory<>("transid"));
            e21.setCellValueFactory(new PropertyValueFactory<>("date"));
            e31.setCellValueFactory(new PropertyValueFactory<>("price"));
            e41.setCellValueFactory(new PropertyValueFactory<>("refid"));
            e51.setCellValueFactory(new PropertyValueFactory<>("refName"));
            e61.setCellValueFactory(new PropertyValueFactory<>("paidNot"));

            tablee1.setItems(null);
            tablee1.setItems(temp2);

            txtpid1.setText("");
        }
        else {
            initialize();


        }
    }

    public void setDateI()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        date1.setText(dateFormat.format(d));
        System.out.println(dateFormat.format(d));
    }
    public void paymentValidationI()
    {
        int warning =0;
        boolean warning2=false;
        boolean warning3=false;

        if((txtpid1.getText().isEmpty()) ||( txtpid1.getText().trim().isEmpty()))
        {
            txtpid1.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            txtpid1.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((date1.getText().isEmpty()) ||( date1.getText().trim().isEmpty()))
        {
            date1.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            date1.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((sid1.getText().isEmpty()))
        {
            sid1.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            sid1.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((sname1.getText().isEmpty()))
        {
            sname1.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            sname1.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }
        if((tot1.getText().isEmpty()))
        {
            tot1.setStyle("-fx-text-box-border: red ; ");

        }
        else
        {
            warning ++;
            tot1.setStyle("-fx-text-box-border: #d1d6cf ; ");
        }

        if(combop1.getSelectionModel().isEmpty() || combop1.getValue().equals("Payment Type"))
        {
            warning3=true;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("You need to select one for the payment methods!");

            alert.showAndWait();
        }
        else
        {
            warning3=false;
        }


        if(!(checkp1.isSelected()))
        {
            checkp1.setStyle("-fx-font-weight: bold;");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Select paid to continue");

            alert.showAndWait();
            warning2=true;
        }
        else
        {
            warning2=false;
        }

        if(warning!=5 ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Check Empty Fields !");

            alert.showAndWait();
        }

        if((warning==5) && !warning3 && !warning2)
        {
            //System.out.print("come");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do you Paid for this?");


            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                income i=new income();
                String query ="UPDATE sales SET paymentType='"+combop1.getValue()+"', `paid/not`='paid', paymentDate='"+date1.getText()+"' WHERE `idsale`='"+txtpid1.getText()+"';";
                i.editIncome(query);

                initialize();
                //Stage stage = (Stage) saveButton.getScene().getWindow();
                // stage.close();

            }
        }
    }


    ////report///////////


    @FXML
    public void Allpaidpurchase() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/finalViewTable.fxml"));
        load1.getChildren().setAll(pane);
    }

    @FXML
    public void Allnotpaidpurchase() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/finalViewTable1.fxml"));
        load1.getChildren().setAll(pane);
    }

    @FXML
    public void Allpaidsales() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/finalViewTable2.fxml"));
        load1.getChildren().setAll(pane);
    }
    @FXML
    public void Allnotpaidsales() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/finalViewTable3.fxml"));
        load1.getChildren().setAll(pane);
    }
    @FXML
    public void SpecifiedPurchase() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/SpecifiedViewTable.fxml"));
        load1.getChildren().setAll(pane);
    }
    @FXML
    public void SpecifiedSales() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/SpecifiedViewTable1.fxml"));
        load1.getChildren().setAll(pane);
    }

    @FXML
    public void summeryReport() throws IOException {
        System.out.print("done");

        AnchorPane pane=FXMLLoader.load(getClass().getResource("Management/summeryReport.fxml"));
        load1.getChildren().setAll(pane);
    }

    public void a1()
    {
        tabp.setDisable(false);
    }
    public void a2()
    {
        editp.setDisable(false);
    }
    public void a3()
    {
        addp.setDisable(false);
    }
    public void a4()
    {
        deletep.setDisable(false);
    }
    public void a5()
    {
        tabs.setDisable(false);
    }
    public void a6()
    {
        edits.setDisable(false);
    }
    public void a7()
    {
        adds.setDisable(false);
    }
    public void a8()
    {
        deletes.setDisable(false);
    }
    public void a9()
    {
        tabc.setDisable(false);
    }
    public void a10()
    {
        editc.setDisable(false);
    }
    public void a11()
    {
        addc.setDisable(false);
    }
    public void a12()
    {
        deletec.setDisable(false);
    }
    public void a13()
    {
        tabph.setDisable(false);
    }
    public void a14()
    {
        tabmr.setDisable(false);
    }
    public void a15()
    {
        btn1.setDisable(false);
        btn6.setDisable(false);
    }
    public void a16()
    {
        btn2.setDisable(false);
    }
    public void a17()
    {
        btn3.setDisable(false);
        btn5.setDisable(false);
    }
    public void a18()
    {
        btn4.setDisable(false);
    }

    public void setAccess()
    {
         dbconnect conE=new dbconnect();
        Connection con=conE.getConnection();
        Statement st=null;
        ResultSet rs;

        conE = new dbconnect();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select extra from user where iduser='"+userId+"'");

            while(rs.next())
            {
                String code=rs.getString("extra");

                if((code.charAt(0)=='0') && ((code.charAt(1)=='1')))
                {
                    a1();
                }

                if((code.charAt(4)=='0') && ((code.charAt(5)=='3')))
                {
                    a3();
                }

                if((code.charAt(8)=='0') && ((code.charAt(9)=='5')))
                {
                    a5();
                }

                if((code.charAt(12)=='0') && ((code.charAt(13)=='7')))
                {
                    a7();
                }

                if((code.charAt(16)=='0') && ((code.charAt(17)=='9')))
                {
                    a9();
                }

                if((code.charAt(20)=='1') && ((code.charAt(21)=='1')))
                {
                    a11();
                }

                if((code.charAt(24)=='1') && ((code.charAt(25)=='3')))
                {
                    a13();
                }
                if((code.charAt(26)=='1') && ((code.charAt(27)=='4')))
                {
                    a14();
                }
                if((code.charAt(28)=='1') && ((code.charAt(29)=='5')))
                {
                    a15();
                }
                if((code.charAt(30)=='1') && ((code.charAt(31)=='6')))
                {
                    a16();
                }
                if((code.charAt(32)=='1') && ((code.charAt(33)=='7')))
                {
                    a17();
                }
                if((code.charAt(34)=='1') && ((code.charAt(35)=='8')))
                {
                    a18();
                }


            }

        con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }
    //////////////////////////
    public void setS()
    {  dbconnect conE=new dbconnect();
        Connection con=conE.getConnection();
        Statement st=null;
        ResultSet rs;

        conE = new dbconnect();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select extra from user where iduser='"+userId+"'");

            while(rs.next())
            {
                String code=rs.getString("extra");
        if((code.charAt(10)=='0') && ((code.charAt(11)=='6')))
        {
            a6();
        }
        if((code.charAt(14)=='0') && ((code.charAt(15)=='8')))
        {
            a8();
        }
            }

            con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void setP()
    {  dbconnect conE=new dbconnect();
        Connection con=conE.getConnection();
        Statement st=null;
        ResultSet rs;

        conE = new dbconnect();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select extra from user where iduser='"+userId+"'");

            while(rs.next())
            {
                String code=rs.getString("extra");
        if((code.charAt(2)=='0') && ((code.charAt(3)=='2')))
        {
            a2();
        }
        if((code.charAt(6)=='0') && ((code.charAt(7)=='4')))
        {
            a4();
        }
            }

            con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void setC()
    {  dbconnect conE=new dbconnect();
        Connection con=conE.getConnection();
        Statement st=null;
        ResultSet rs;

        conE = new dbconnect();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select extra from user where iduser='"+userId+"'");

            while(rs.next())
            {
                String code=rs.getString("extra");
        if((code.charAt(18)=='1') && ((code.charAt(19)=='0')))
        {
            a10();
        }
        if((code.charAt(22)=='1') && ((code.charAt(23)=='2')))
        {
            a12();
        }
            }

            con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }



    public void productReport()
    {
        ir.generateReport("C:\\IMS\\product.jrxml");
    }
    public void supplierReport()
    {
        ir.generateReport("C:\\IMS\\supplier.jrxml");
    }
    public void customerReport()
    {
        ir.generateReport("C:\\IMS\\customer.jrxml");
    }


    public void ppReport()
    {

        ir.generateReportPass("C:\\IMS\\expenditure.jrxml","select purchase.idpurchase,date,supplier.idsupplier,supplier.name,total,paymentType,paidDate,`paid/not` from purchase join supplier on purchase.idsupplier=supplier.idsupplier where `paid/not`='paid' group by idpurchase");

    }
    public void nppReport()
    {

        ir.generateReportPass("C:\\IMS\\expenditure.jrxml","select purchase.idpurchase,date,supplier.idsupplier,supplier.name,total,paymentType,paidDate,`paid/not` from purchase join supplier on purchase.idsupplier=supplier.idsupplier where `paid/not`='notpaid' group by idpurchase");
    }
    public void psReport()
    {

        ir.generateReportPass("C:\\IMS\\income.jrxml","select sales.idsale,date,customer.idcustomer,customer.name,total,paymentType,paymentDate,`paid/not` from sales join customer on sales.idcustomer=customer.idcustomer where `paid/not`='paid' group by idsale");
    }
    public void npsReport()
    {

        ir.generateReportPass("C:\\IMS\\income.jrxml","select sales.idsale,date,customer.idcustomer,customer.name,total,paymentType,paymentDate,`paid/not` from sales join customer on sales.idcustomer=customer.idcustomer where `paid/not`='notpaid' group by idsale");
    }







}
