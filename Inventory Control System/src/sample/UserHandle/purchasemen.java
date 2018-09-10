package sample.UserHandle;

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
public class purchasemen extends employee
{
    ObservableList<purchasemen> buy = FXCollections.observableArrayList();
    public purchasemen()
    {

    }
    public purchasemen(String empId, String empName, String empAddress, String empCity, String empTelephone)
    {
        super(empId,empName,empAddress,empCity,empTelephone);
    }

    public ObservableList<purchasemen> getPurchasemen()
    {

        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from employee");

            while(rs.next())
            {
                buy.add(new purchasemen(rs.getString("idemployee"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("telephoneNo")));
            }


        con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return buy;
    }
    public ObservableList<purchasemen> searchP(String key)
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
                    buy.add(new purchasemen(rs.getString("idemployee"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("telephoneNo")));
                }

            }

con.close();

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return buy;
    }


    public ObservableList<purchasemen> getSelectedId(String key)
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
                    buy.add(new purchasemen(rs.getString("idemployee"),rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("telephoneNo")));
                    return buy;
                }

            }



    con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }




return null;
    }



}
