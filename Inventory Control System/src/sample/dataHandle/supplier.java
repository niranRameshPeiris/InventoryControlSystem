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

public class supplier extends data
{

    ObservableList<supplier> suppliers = FXCollections.observableArrayList();
    //suppliers.add(new supplier("nn","nn","nn","nn","nn","nn","nn","nn","nn","nn"));

    dbconnect conE= new dbconnect();


    Statement st=null;
    ResultSet rs;


    public supplier()
    {

    }
    public supplier(String id,String name,String add,String city,String con,String pc,String tel,String fax,String email,String contact)
    {
        super(id,name,add,city,con,pc,tel,fax,email,contact);

    }


    public ObservableList<supplier> getSupplier()
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from supplier");

            while(rs.next())
            {
                suppliers.add(new supplier(rs.getString("idsupplier"),rs.getString("name"),rs.getString("Address"),rs.getString("city"),rs.getString("country"),rs.getString("postcode"),rs.getString("telephone"),rs.getString("fax"),rs.getString("email"),rs.getString("contactperson")));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return suppliers;
    }
    public void editS(String Query)
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

    public ObservableList<supplier> searchS(String key)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from supplier");

            while(rs.next()) {
                if ((key.equals(rs.getString("idsupplier")))||(key.equals(rs.getString("name")))||(key.equals(rs.getString("Address")))||(key.equals(rs.getString("city")))||(key.equals(rs.getString("country")))||(key.equals(rs.getString("postcode")))||(key.equals(rs.getString("telephone")))||(key.equals(rs.getString("fax")))||(key.equals(rs.getString("contactperson")))||(key.equals(rs.getString("email"))))
                {
                    suppliers.add(new supplier(rs.getString("idsupplier"), rs.getString("name"), rs.getString("Address"), rs.getString("city"), rs.getString("country"), rs.getString("postcode"), rs.getString("telephone"), rs.getString("fax"), rs.getString("email"), rs.getString("contactperson")));

                }
            }
            con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return suppliers;
    }


    public ObservableList<supplier> getSelectedId(String key)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from supplier");

            while(rs.next())
            {
                if(rs.getString("idsupplier").equals(key))
                {
                    suppliers.add(new supplier(rs.getString("idsupplier"), rs.getString("name"), rs.getString("Address"), rs.getString("city"), rs.getString("country"), rs.getString("postcode"), rs.getString("telephone"), rs.getString("fax"), rs.getString("email"), rs.getString("contactperson")));
                    return suppliers;
                }

            }



            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



return null;

    }




















}
