package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.UserHandle.user;

/**
 * Created by Ramesh on 5/2/2017.
 */
public class profileController

{
    @FXML
    private Label name;
    @FXML
    private Label uname;
    @FXML
    private Label alevel;


    public static String userId;
    public static String level;

    @FXML
    public void initialize()
    {

        setValues();
    }

    public void setId(String id,String level)
    {
        this.userId=id;
        this.level=level;
    }

    public void setValues()
    {
        ObservableList<user> users = FXCollections.observableArrayList();
        user u=new user();
        users=u.getUserDetails(userId);

        name.setText(users.get(0).getName());
        uname.setText(users.get(0).getUserName());
        alevel.setText(users.get(0).getLevel());







    }



}
