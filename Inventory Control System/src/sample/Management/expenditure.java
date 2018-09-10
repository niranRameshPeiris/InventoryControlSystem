package sample.Management;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Transaction.purchase;
import sample.Transaction.transaction;
import sample.dbconnect;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class expenditure extends transaction
{
    private ObservableList<expenditure> exp = FXCollections.observableArrayList();


    protected String paidNot;
    protected String paymentType;
    protected String paymentDate;


    public expenditure()
    {

    }
    public expenditure(String transid,String refid,String price,String date,String paidNot,String paymentType,String paymentDate )
    {
        super.transid=transid;
        super.refid=refid;
        super.price=price;
        super.date=date;

        this.paidNot=paidNot;
        this.paymentType=paymentType;
        this.paymentDate=paymentDate;

    }

    public String getPaidNot()
    {
        return this.paidNot;
    }
    public String getPaymentType()
    {
        return this.paymentType;
    }
    public String getPaymentDate()
    {
        return this.paymentDate;
    }

    public ObservableList<expenditure> getNotpaidExpenditure()
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from purchase where `paid/not` ='notpaid'");

            while(rs.next())
            {
                String idp=rs.getString("idpurchase");
                String ids=rs.getString("idsupplier");

                expenditure e=new expenditure(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paidDate"));

                e.setRefName("select name from supplier where idsupplier='"+ids+"';");
                exp.add(e);

                //System.out.print(rs.getString("paidDate"));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return  exp;
    }

    public ObservableList<expenditure> getpaidExpenditure()
    {
        Connection con=conE.getConnection();

        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from purchase where `paid/not` ='paid'");

            while(rs.next())
            {
                String idp=rs.getString("idpurchase");
                String ids=rs.getString("idsupplier");

                expenditure e=new expenditure(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paidDate"));

                e.setRefName("select name from supplier where idsupplier='"+ids+"';");
                exp.add(e);

                //System.out.print(rs.getString("paidDate"));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return  exp;
    }
    public ObservableList<expenditure> searchNotpaidE(String key)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from purchase where `paid/not` ='notpaid'");

            while(rs.next())
            {
                if((key.equals(rs.getString("idpurchase"))))             {

                    String idp=rs.getString("idpurchase");
                    String ids=rs.getString("idsupplier");

                    expenditure e=new expenditure(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paidDate"));

                    e.setRefName("select name from supplier where idsupplier='"+ids+"';");
                    exp.add(e);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return exp;
    }

    public ObservableList<expenditure> searchpaidE(String key)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from purchase where `paid/not` ='paid'");

            while(rs.next())
            {
                if((key.equals(rs.getString("idsupplier"))))             {

                    String idp=rs.getString("idpurchase");
                    String ids=rs.getString("idsupplier");

                    expenditure e=new expenditure(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paidDate"));

                    e.setRefName("select name from supplier where idsupplier='"+ids+"';");
                    exp.add(e);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return exp;
    }

    public ObservableList<expenditure> searchE(String key)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from purchase");

            while(rs.next())
            {
                if((key.equals(rs.getString("idsupplier"))))             {

                    String idp=rs.getString("idpurchase");
                    String ids=rs.getString("idsupplier");

                    expenditure e=new expenditure(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paidDate"));

                    e.setRefName("select name from supplier where idsupplier='"+ids+"';");
                    exp.add(e);

                }
            }

            con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return exp;
    }

    public void editExp(String Query)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            st.executeUpdate(Query);

            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }

    public ObservableList<expenditure> searchNotpaidExpenditure(String key)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from purchase where `paid/not` ='notpaid'");

            while(rs.next())
            {
                if((key.equals(rs.getString("idsupplier"))))             {

                    String idp=rs.getString("idpurchase");
                    String ids=rs.getString("idsupplier");

                    expenditure e=new expenditure(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paidDate"));

                    e.setRefName("select name from customer where idcustomer='"+ids+"';");
                    exp.add(e);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return exp;
    }


}
