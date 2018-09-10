package sample.dataHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/22/2017.
 */
public class product extends data {


    ObservableList<product> products = FXCollections.observableArrayList();
    //products.add(new product("nn","nn","nn","nn","nn","nn","nn","nn"));
    dbconnect conE= new dbconnect();

    Statement st=null;
    ResultSet rs;



    protected String specs;
    protected String purchasePrice;
    protected String slePrice;
    protected String stock;
    protected String uom;
    protected String rackNo;
public product()
{

}
    public product(String id,String name,String specs,String pp,String sp,String stock,String uom,String rn)
    {
        super.id=id;
        super.name=name;
        this.specs=specs;
        this.purchasePrice=pp;
        this.slePrice=sp;
        this.stock=stock;
        this.uom=uom;
        this.rackNo=rn;
    }

    public String getSpecs()
    {
        return specs;
    }
    public String getPurchasePrice()
    {
        return purchasePrice;
    }
    public String getSlePrice()
    {
        return slePrice;
    }
    public String getStock()
    {
        return stock;
    }
    public String getUom()
    {
        return uom;
    }
    public String getRackNo()
    {
        return rackNo;
    }

    public ObservableList<product> getProduct()
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from product");

            while(rs.next())
            {
                products.add(new product(rs.getString("idproduct"),rs.getString("name"),rs.getString("specification"),rs.getString("pricePurchase"),rs.getString("priceSale"),rs.getString("stock"),rs.getString("uom"),rs.getString("rackNo")));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


    return products;
    }

    public void editP(String Query)
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

    public ObservableList<product> searchP(String key)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from product");

            while(rs.next())
            {
                if((key.equals(rs.getString("idproduct")))||(key.equals(rs.getString("name")))||(key.equals(rs.getString("specification")))||(key.equals(rs.getString("pricePurchase")))||(key.equals(rs.getString("priceSale")))||(key.equals(rs.getString("stock")))||(key.equals(rs.getString("uom")))||(key.equals(rs.getString("rackNo"))))
                {
                    products.add(new product(rs.getString("idproduct"),rs.getString("name"),rs.getString("specification"),rs.getString("pricePurchase"),rs.getString("priceSale"),rs.getString("stock"),rs.getString("uom"),rs.getString("rackNo")));
                }

            }
            con.close();
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return products;
    }


    public boolean validateId(String id)
    {
        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select idproduct from product where idproduct='"+id+"';");

            while(rs.next())
            {
                if((id.equals(rs.getString("idproduct"))))
                {
                    return true;
                }

            }
            con.close();
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return false;
    }


    public ObservableList<product> serchFromID(String key)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from product");

            while(rs.next())
            {
                if((key.equals(rs.getString("idproduct"))))                {
                    products.add(new product(rs.getString("idproduct"),rs.getString("name"),rs.getString("specification"),rs.getString("pricePurchase"),rs.getString("priceSale"),rs.getString("stock"),rs.getString("uom"),rs.getString("rackNo")));
                }

            }
            con.close();
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return products;
    }

    public boolean validateQuantity(String key,String id)
    {

        Connection con=conE.getConnection();

        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select stock from product where idproduct='"+id +"';");

            while(rs.next())
            {
                if((key.equals(rs.getString("stock"))) || ((rs.getInt("stock")> (Integer.parseInt(key)))))
                {
                    return true;

                }

            }
            con.close();
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }


    return false;
    }


    public String getStock(String id)
    {

        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select stock from product where idproduct='"+id+"';");

            while(rs.next())
            {

                    return rs.getString("stock");
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return null;
    }


}
