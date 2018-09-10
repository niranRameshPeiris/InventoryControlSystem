package sample.dataHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/29/2017.
 */
public class sellProduct extends product

{
    protected String quantity;
    protected String total;


    public sellProduct()
    {

    }
    public sellProduct(String id,String name,String price,String quantity,String total)
    {
        super.id=id;
        super.name=name;
        super.slePrice=price;
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




    public ObservableList<sellProduct> getSellProduct(String key)
    {

        ObservableList<sellProduct> sp = FXCollections.observableArrayList();
        //products.add(new product("nn","nn","nn","nn","nn","nn","nn","nn"));
        dbconnect conE;
        conE = new dbconnect();
        Connection con=conE.getConnection();
        Statement st=null;
        ResultSet rs;

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("\n" +
                    "select product.idproduct,product.name,product.priceSale,sale_products.quantity from product join sale_products on product.idproduct=sale_products.idproduct where idsale='"+key+"'");

            while(rs.next())
            {
                String tot= String.valueOf(((rs.getInt("priceSale"))*(rs.getInt("quantity"))));

                sp.add(new sellProduct(rs.getString("idproduct"),rs.getString("name"),rs.getString("priceSale"),rs.getString("quantity"),tot ));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return sp;
    }



}
