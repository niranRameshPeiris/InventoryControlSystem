package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
    Connection con=null;
    //String url="jdbc:mysql://localhost:3306/inventory";
    //String user="root";
    //String password="1996";
    private static String url="";
    private static String user="";
    private static String password="";



    public Connection getConnection(){

        try {
            FileInputStream fstream = new FileInputStream("C:/IMS/setup.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            url = "jdbc:mysql://localhost:"+br.readLine()+"/inventory";
            user = br.readLine();
            password= br.readLine();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            try {
                con = DriverManager.getConnection(url, user, password);

            } catch (SQLException se) {
                System.out.println(se.getMessage());

            }
        return con;
    }



}
