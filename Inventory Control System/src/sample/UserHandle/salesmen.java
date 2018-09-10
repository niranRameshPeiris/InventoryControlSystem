package sample.UserHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dataHandle.customer;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/29/2017.
 */
public class salesmen extends employee
{
    ObservableList<salesmen> sales = FXCollections.observableArrayList();
    public salesmen()
    {

    }
    public salesmen(String empId,String empName,String empAddress,String empCity,String empTelephone)
    {
        super(empId,empName,empAddress,empCity,empTelephone);
    }

    public ObservableList<salesmen> getSalesmen()
    {
        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from employee");

            while(rs.next())
            {
                sales.add(new salesmen(rs.getString("idemployee"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("telephoneNo")));
            }


        con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return sales;
    }
    public ObservableList<salesmen> searchS(String key)
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from employee");

            while(rs.next())
            {
                if((key.equals(rs.getString("idemployee")))||(key.equals(rs.getString("name")))||(key.equals(rs.getString("address")))||(key.equals(rs.getString("city")))||(key.equals(rs.getString("telephoneNo"))))
                {
                    sales.add(new salesmen(rs.getString("idemployee"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("telephoneNo")));
                }

            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return sales;
    }


    public ObservableList<salesmen> getSelectedId(String key)
    {

        Connection con=conE.getConnection();

        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from employee");

            while(rs.next())
            {
                if(rs.getString("idemployee").equals(key))
                {
                    sales.add(new salesmen(rs.getString("idemployee"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("telephoneNo")));
                    return sales;
                }

            }



            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return null;


    }



}
