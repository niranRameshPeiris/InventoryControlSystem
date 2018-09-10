package sample.Management;
import sample.Transaction.transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class income extends transaction
{
    private ObservableList<income> ic = FXCollections.observableArrayList();


    protected String paidNot;
    protected String paymentType;
    protected String paymentDate;


    public income()
    {

    }
    public income(String transid,String refid,String price,String date,String paidNot,String paymentType,String paymentDate )
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

    public ObservableList<income> getNotpaidIncome()
    {

        Connection con=conE.getConnection();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from sales where `paid/not` ='notpaid'");

            while(rs.next())
            {
                String idp=rs.getString("idsale");
                String ids=rs.getString("idcustomer");

                income i=new income(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paymentDate"));

                i.setRefName("select name from customer where idcustomer='"+ids+"';");
                ic.add(i);

                //System.out.print(rs.getString("paidDate"));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return  ic;
    }

    public ObservableList<income> getpaidIncome()
    {
        Connection con=conE.getConnection();

        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from sales where `paid/not` ='paid'");

            while(rs.next())
            {
                String idp=rs.getString("idsale");
                String ids=rs.getString("idcustomer");

                income i=new income(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paymentDate"));

                i.setRefName("select name from customer where idcustomer='"+ids+"';");
                ic.add(i);

                //System.out.print(rs.getString("paidDate"));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return  ic;
    }

    public ObservableList<income> searchNotpaidI(String key)
    {

        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from sales where `paid/not` ='notpaid'");

            while(rs.next())
            {
                if((key.equals(rs.getString("idsale"))))             {

                    String idp=rs.getString("idsale");
                    String ids=rs.getString("idcustomer");

                    income i=new income(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paymentDate"));

                    i.setRefName("select name from customer where idcustomer='"+ids+"';");
                    ic.add(i);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return ic;
    }

    public void editIncome(String Query)
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




    public ObservableList<income> searchNotpaidIncome(String key)
    {

        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from sales where `paid/not` ='notpaid'");

            while(rs.next())
            {
                if((key.equals(rs.getString("idcustomer"))))             {

                    String idp=rs.getString("idsale");
                    String ids=rs.getString("idcustomer");

                    income i=new income(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paymentDate"));

                    i.setRefName("select name from customer where idcustomer='"+ids+"';");
                    ic.add(i);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return ic;
    }

    public ObservableList<income> searchpaidI(String key)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from sales where `paid/not` ='paid'");

            while(rs.next())
            {
                if((key.equals(rs.getString("idcustomer"))))             {

                    String idp=rs.getString("idsale");
                    String ids=rs.getString("idcustomer");

                    income i=new income(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paymentDate"));

                    i.setRefName("select name from customer where idcustomer='"+ids+"';");
                    ic.add(i);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return ic;
    }

    public ObservableList<income> searchI(String key)
    {
        Connection con=conE.getConnection();

        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from sales");

            while(rs.next())
            {
                if((key.equals(rs.getString("idcustomer"))))             {

                    String idp=rs.getString("idsale");
                    String ids=rs.getString("idcustomer");

                    income i=new income(idp,ids,rs.getString("total"),rs.getString("date"),rs.getString("paid/not"),rs.getString("paymentType"),rs.getString("paymentDate"));

                    i.setRefName("select name from customer where idcustomer='"+ids+"';");
                    ic.add(i);

                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return ic;
    }


}
