package sample.dataHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class buyProduct extends product
{
    protected String quantity;
    protected String total;

    public buyProduct() {}

    public buyProduct(String id,String name,String price,String quantity,String total)
    {
        super.id=id;
        super.name=name;
        super.purchasePrice=price;
        this.quantity=quantity;
        this.total=total;
    }
    public String getQuantity()
    {
        return this.quantity;
    }
    public String getTotal()
    {
        return this.total;
    }

    //return observablelist which contains details of products
    public ObservableList<buyProduct> getBuyProduct(String key)
    {
        ObservableList<buyProduct> bp = FXCollections.observableArrayList();
        dbconnect conE;
        conE = new dbconnect();
        Statement st = null;
        ResultSet rs;
        Connection con=conE.getConnection();

        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select product.idproduct,product.name,product.pricePurchase,purchase_products.quantity from product join purchase_products on product.idproduct=purchase_products.idproduct where idpurchase='"+key+"'");
            while(rs.next())
            {
                String tot= String.valueOf(((rs.getInt("pricePurchase"))*(rs.getInt("quantity"))));

                bp.add(new buyProduct(rs.getString("idproduct"),rs.getString("name"),rs.getString("pricePurchase"),rs.getString("quantity"),tot ));
            }
            con.close();
        }
        catch (SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return bp;
    }



}