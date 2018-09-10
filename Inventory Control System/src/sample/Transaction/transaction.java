package sample.Transaction;

import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/25/2017.
 */
public class transaction
{
    protected dbconnect conE= new dbconnect();

    protected Statement st=null;
    protected ResultSet rs;

    protected String transid;
    protected String refid;
    protected String refName;
    protected String price;
    protected String date;
    protected String noOfProducts;

    protected String transNo;

    public transaction()
    {

    }
    public transaction(String transid,String refid,String price,String date)
    {
        this.transid=transid;
        this.refid=refid;
        this.price=price;
        this.date=date;
    }
    public void setRefName(String query)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery(query);

            while(rs.next()) {
                this.refName = rs.getString("name");
                //System.out.print(this.refName);
            }

            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


    }
    public void setNoOfProducts(String query)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery(query);

            while(rs.next()) {
                this.noOfProducts = rs.getString("count(idsale)");
                //System.out.print(this.noOfProducts);
            }

            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }
    public void setNoOfProducts2(String query)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery(query);

            while(rs.next()) {
                this.noOfProducts = rs.getString("count(idpurchase)");
                //System.out.print(this.noOfProducts);
            }

            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }

    public String getTransactionNo(String query,String id)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery(query);

            while(rs.next()) {
                this.transNo =  rs.getString(id);
                //System.out.print(this.refName);

            }

           con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return this.transNo;
    }

    public boolean validateID(String query,String id)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery(query);

            while(rs.next()) {
                if(id.equals(rs.getString("idsale")))
                {
                    return true;
                }
            }

           con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return false;
    }


    public boolean validateID2(String query,String id)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery(query);

            while(rs.next()) {
                if(id.equals(rs.getString("idpurchase")))
                {
                    return true;
                }
            }
           con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return false;
    }






    public String getTransid(){return transid;}
    public String getRefid(){return refid;}
    public String getRefName(){return refName;}
    public String getPrice(){return price;}
    public String getDate(){return date;}
    public String getNoOfProducts(){return noOfProducts;}


}
