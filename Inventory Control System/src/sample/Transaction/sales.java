package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/25/2017.
 */
public class sales extends transaction
{

    private ObservableList<sales> sale = FXCollections.observableArrayList();

    public sales()
    {

    }
    public sales(String transid,String refid,String price,String date)
    {
        super(transid,refid,price,date);
    }

    public ObservableList<sales> getSales()
    {
        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from sales");

            while(rs.next())
            {
                String ids=rs.getString("idsale");
                String idc=rs.getString("idcustomer");
                sales e=new sales(ids,idc,rs.getString("total"),rs.getString("date"));

                e.setRefName("select name from customer where idcustomer='"+idc+"';");
                e.setNoOfProducts("select count(idsale) from sale_products where idsale='"+ids+"';");
                sale.add(e);
            }

           con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());

        }


        return sale;
    }

    public ObservableList<sales> search(String key)
    {


        Connection con=conE.getConnection();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from sales");

            while(rs.next())
            {
            if((key.equals(rs.getString("idsale")))||(key.equals(rs.getString("idcustomer")))||(key.equals(rs.getString("total")))||(key.equals(rs.getString("date"))))
            {

                    String ids=rs.getString("idsale");
                    String idc=rs.getString("idcustomer");
                    sales e=new sales(ids,idc,rs.getString("total"),rs.getString("date"));
                e.setRefName("select name from customer where idcustomer='"+idc+"';");
                e.setNoOfProducts("select count(idsale) from sale_products where idsale='"+ids+"';");
                    sale.add(e);

            }
            }

          con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return sale;
    }

    public String getTransactionNo(String query,String id)
    {
        return super.getTransactionNo(query,id);
    }



    public void editSale(String Query)
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












    }



