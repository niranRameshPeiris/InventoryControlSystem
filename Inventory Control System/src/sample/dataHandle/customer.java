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
public class customer extends data
{

    ObservableList<customer> customers = FXCollections.observableArrayList();

    dbconnect conE= new dbconnect();

    Statement st=null;
    ResultSet rs;




    public customer()
    {

    }
    public customer(String id,String name,String add,String city,String con,String pc,String tel,String fax,String email,String contact)
    {
        super(id,name,add,city,con,pc,tel,fax,email,contact);

    }


    public ObservableList<customer> getCustomer()
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from customer");

            while(rs.next())
            {
                customers.add(new customer(rs.getString("idcustomer"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("country"),rs.getString("postcode"),rs.getString("telephone"),rs.getString("fax"),rs.getString("email"),rs.getString("contactPerson")));
            }


        con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return customers;
    }

    public void editC(String Query)
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

    public ObservableList<customer> searchC(String key)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from customer");

            while(rs.next())
            {
                if((key.equals(rs.getString("idcustomer")))||(key.equals(rs.getString("name")))||(key.equals(rs.getString("address")))||(key.equals(rs.getString("city")))||(key.equals(rs.getString("country")))||(key.equals(rs.getString("postcode")))||(key.equals(rs.getString("telephone")))||(key.equals(rs.getString("fax")))||(key.equals(rs.getString("email")))||(key.equals(rs.getString("contactPerson"))))
                {
                    customers.add(new customer(rs.getString("idcustomer"), rs.getString("name"), rs.getString("address"), rs.getString("city"), rs.getString("country"), rs.getString("postcode"), rs.getString("telephone"), rs.getString("fax"), rs.getString("email"), rs.getString("contactPerson")));
                }

            }

            con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return customers;
    }

    public ObservableList<customer> getSelectedId(String key)
    {
        Connection con=conE.getConnection();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from customer");

            while(rs.next())
            {
                if(rs.getString("idcustomer").equals(key))
                {
                    customers.add(new customer(rs.getString("idcustomer"), rs.getString("name"), rs.getString("address"), rs.getString("city"), rs.getString("country"), rs.getString("postcode"), rs.getString("telephone"), rs.getString("fax"), rs.getString("email"), rs.getString("contactPerson")));
                    return customers;
                }

            }



            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



return null;

    }




}
