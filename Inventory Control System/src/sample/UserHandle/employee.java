package sample.UserHandle;

import sample.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/29/2017.
 */
public class employee
{

    dbconnect conE= new dbconnect();

    Statement st=null;
    ResultSet rs;

    protected String empId;
    protected String empName;
    protected String empAddress;
    protected String empCity;
    protected String empTelephone;

    public employee()
    {

    }
    public employee(String empId,String empName,String empAddress,String empCity,String empTelephone)
    {
        this.empId=empId;
        this.empName=empName;
        this.empAddress=empAddress;
        this.empCity=empCity;
        this.empTelephone=empTelephone;
    }
    public String getId()
    {
        return empId;
    }
    public String getName()
    {
        return empName;
    }
    public String getAddress()
    {
        return empAddress;
    }
    public String getCity()
    {
        return empCity;
    }
    public String getTelephone()
    {
        return empTelephone;
    }


public void setEmployee(String name,String add,String city,String telephone)
{
    Connection con=conE.getConnection();
    try
    {
        st=con.createStatement();
        st.executeUpdate("INSERT INTO employee(name,address,city,telephoneNo) VALUES ('"+name+"', '"+add+"', '"+city+"', '"+telephone+"');");

        con.close();
    } catch (SQLException e) {
        System.out.print(e.getMessage());
    }
}





}
