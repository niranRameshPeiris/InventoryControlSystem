package sample.UserHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 5/1/2017.
 */
public class user
{
    protected String id;
    protected String name;
    protected String userName;
    protected String password;
    protected String level;
    dbconnect conE=new dbconnect();

    Statement st=null;
    ResultSet rs;
    ObservableList<user>  users = FXCollections.observableArrayList();
    public user()
    {

    }

    public user(String id,String name,String userName,String password,String level)
    {
        this.id=id;
        this.name=name;
        this.userName=userName;
        this.password=password;
        this.level=level;
    }
    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public String getUserName(){return this.userName;}
    public String getPassword(){return this.password;}
    public String getLevel(){return this.level;}

    public ObservableList<user> getUser()
    {
        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from user");

            while(rs.next())
            {
                users.add(new user(rs.getString("iduser"),rs.getString("name"),rs.getString("userName"),rs.getString("password"),rs.getString("level")));
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return users;
    }

    public ObservableList<user> search(String key)
    {
        Connection con=conE.getConnection();
        try
        {

            st=con.createStatement();
            rs=st.executeQuery("select * from user");

            while(rs.next())
            {
                if(key.equals(rs.getString("userName"))) {
                    users.add(new user(rs.getString("iduser"), rs.getString("name"), rs.getString("userName"), rs.getString("password"), rs.getString("level")));
                }
                }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return users;
    }


    public void edit(String Query)
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


    public boolean validateUser(String name,String pwd)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from user");

            while(rs.next())
            {
                if((name.equals(rs.getString("userName"))) && (pwd.equals(rs.getString("password"))))
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

    public ObservableList<user> getUserDetails(String key)
    {
        Connection con=conE.getConnection();
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from user");

            while(rs.next())
            {
                if(key.equals(rs.getString("iduser"))) {
                    users.add(new user(rs.getString("iduser"), rs.getString("name"), rs.getString("userName"), rs.getString("password"), rs.getString("level")));
                }
            }


            con.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }



        return users;
    }








}
