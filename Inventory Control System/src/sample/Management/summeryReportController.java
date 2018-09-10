package sample.Management;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 5/1/2017.
 */
public class summeryReportController
{

    protected dbconnect conE;
    protected Statement st=null;
    protected ResultSet rs;

    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Label lbl7;
    @FXML
    private Label lbl8;
    @FXML
    private Label lbl9;



    public void initialize()
    {

setValues();

    }
    public void setValues()
    {
        double q1=0;
        double q2=0;
        double q3=0;
        double q4=0;
        double q5=0;
        double q6=0;

        double i1=0;
        double i2=0;
        double i3=0;


        conE = new dbconnect();
        Connection con=conE.getConnection();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select sum(total) from purchase");
            while(rs.next())
            {
               q1=rs.getDouble("sum(total)");
            }

            rs=st.executeQuery("select sum(total) from sales");
            while(rs.next())
            {
                q2=rs.getDouble("sum(total)");
            }

            rs=st.executeQuery("select sum(total) from purchase where `paid/not`='notpaid'");
            while(rs.next())
            {
                q3=rs.getDouble("sum(total)");
            }

            rs=st.executeQuery("select sum(total) from sales where `paid/not`='notpaid'");
            while(rs.next())
            {
                q4=rs.getDouble("sum(total)");
            }

            rs=st.executeQuery("select sum(total) from purchase where `paid/not`='paid'");
            while(rs.next())
            {
                q5=rs.getDouble("sum(total)");
            }

            rs=st.executeQuery("select sum(total) from sales where `paid/not`='paid'");
            while(rs.next())
            {
                q6=rs.getDouble("sum(total)");
            }

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



        i1=q2-q1;
        i2=q4-q3;
        i3=q6-q5;


        lbl1.setText(String.valueOf(q1));
        lbl2.setText(String.valueOf(q2));
        lbl4.setText(String.valueOf(q3));
        lbl5.setText(String.valueOf(q4));
        lbl7.setText(String.valueOf(q5));
        lbl8.setText(String.valueOf(q6));

        lbl3.setText(String.valueOf(i1));
        lbl6.setText(String.valueOf(i2));
        lbl9.setText(String.valueOf(i3));



    }





}
