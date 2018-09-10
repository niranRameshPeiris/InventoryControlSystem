package sample.UserHandle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.dataHandle.product;

import java.util.Optional;

/**
 * Created by Ramesh on 5/1/2017.
 */
public class AdminPannelController
{


    ObservableList<String> levels= FXCollections.observableArrayList("1","2","3","4","5","6");
    ObservableList<String> levels2= FXCollections.observableArrayList("1","2","3","4","5");

    @FXML
    private TableView<user> table1;
    @FXML
    private TableColumn<user, String> col1;
    @FXML
    private TableColumn<user, String> col2;
    @FXML
    private TableColumn<user, String> col3;

    @FXML
    private TableView<user> table2;
    @FXML
    private TableColumn<user, String> col11;
    @FXML
    private TableColumn<user, String> col22;
    @FXML
    private TableColumn<user, String> col33;

    @FXML
    private TextField uname1;
    @FXML
    private TextField pwd;
    @FXML
    private ComboBox access1;
    @FXML
    private Button resetname;
    @FXML
    private Button resetpwd;
    @FXML
    private Button resetlevel;


    @FXML
    private CheckBox c1;
    @FXML
    private CheckBox c2;
    @FXML
    private CheckBox c3;
    @FXML
    private CheckBox c4;
    @FXML
    private CheckBox c5;
    @FXML
    private CheckBox c6;
    @FXML
    private CheckBox c7;
    @FXML
    private CheckBox c8;
    @FXML
    private CheckBox c9;
    @FXML
    private CheckBox c10;
    @FXML
    private CheckBox c11;
    @FXML
    private CheckBox c12;
    @FXML
    private CheckBox c13;
    @FXML
    private CheckBox c14;
    @FXML
    private CheckBox c15;
    @FXML
    private CheckBox c16;
    @FXML
    private CheckBox c17;
    @FXML
    private CheckBox c18;


    @FXML
    private TextField uname2;
    @FXML
    private TextField name;
    @FXML
    private ComboBox access2;
    @FXML
    private TextField uname3;

    @FXML
    private Button adduser;
    @FXML
    private Button deleteuser;
    @FXML
    private Button search;



    @FXML
    public void initialize()
    {
        view1();
        view2();

        uname1.setText("");
        pwd.setText("");
        uname3.setText("");
        uname2.setText("");
        name.setText("");

        access1.setValue("Access Levels");
        access1.setItems(levels);

        access2.setValue("Access Levels");
        access2.setItems(levels2);

        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
        c5.setSelected(false);
        c6.setSelected(false);
        c7.setSelected(false);
        c8.setSelected(false);
        c9.setSelected(false);
        c10.setSelected(false);
        c11.setSelected(false);
        c12.setSelected(false);
        c13.setSelected(false);
        c14.setSelected(false);
        c15.setSelected(false);
        c16.setSelected(false);
        c17.setSelected(false);
        c18.setSelected(false);


    }



    public void view1()
    {
        ObservableList<user> temp = FXCollections.observableArrayList();
        user u=new user();
        temp=u.getUser();

        col1.setCellValueFactory(new PropertyValueFactory<user ,String>("userName"));
        col2.setCellValueFactory(new PropertyValueFactory<user ,String>("id"));
        col3.setCellValueFactory(new PropertyValueFactory<user ,String>("level"));

        table1.setItems(null);
        table1.setItems(temp);
    }
    public void view2()
    {
        ObservableList<user> temp = FXCollections.observableArrayList();
        user u=new user();
        temp=u.getUser();

        col11.setCellValueFactory(new PropertyValueFactory<user ,String>("userName"));
        col22.setCellValueFactory(new PropertyValueFactory<user ,String>("id"));
        col33.setCellValueFactory(new PropertyValueFactory<user ,String>("level"));

        table2.setItems(null);
        table2.setItems(temp);
    }



    public void  Select1()
    {
        ObservableList<user> temp = FXCollections.observableArrayList();
        user u= table1.getSelectionModel().getSelectedItem();

        if(u!=null)
        {
            uname1.setText(u.getUserName());
            String id=u.getId();

            temp=u.getUser();
            for(int i=0;i<temp.size();i++)
            {
                if(id.equals(temp.get(i).getId()))
                {
                    pwd.setText(temp.get(i).getPassword());
                }
            }

        }


    }


    public void  Select2()
    {

        user u= table2.getSelectionModel().getSelectedItem();

        if(u!=null)
        {
            uname3.setText(u.getId());

        }


    }


    @FXML
    public void search()
    {
        String key=uname1.getText();
        if(!key.equals("")) {
            ObservableList<user> temp2 = FXCollections.observableArrayList();
            user u=new user();
            temp2 = u.search(key);

            col1.setCellValueFactory(new PropertyValueFactory<user ,String>("userName"));
            col2.setCellValueFactory(new PropertyValueFactory<user ,String>("id"));
            col3.setCellValueFactory(new PropertyValueFactory<user ,String>("level"));


            table1.setItems(null);
            table1.setItems(temp2);

            uname1.setText("");
        }
        else
            initialize();
    }

    public void resetUserName()
    {
        user u=new user();
        if(!(uname1.getText().equals("")))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You need to change user name");


            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                ObservableList<user> temp = FXCollections.observableArrayList();
                u = table1.getSelectionModel().getSelectedItem();

                try {
                    u.edit("UPDATE user SET userName='" + uname1.getText() + "' WHERE iduser='" + u.getId() + "';");
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setHeaderText(null);
                    alert1.setTitle("WARRNING");
                    alert1.setContentText("Select Row befor update !");

                    alert1.showAndWait();
                    initialize();
                }


                initialize();
            }
            else
            {
                initialize();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Check Empty Fields !");

            alert.showAndWait();
        }
    }


    public void resetPassword()
    {
        user u=new user();
        if(!(pwd.getText().equals("")) && (pwd.getText().length()>=4) )
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You need to change password ");


            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                ObservableList<user> temp = FXCollections.observableArrayList();
                u = table1.getSelectionModel().getSelectedItem();


                try {
                u.edit("UPDATE user SET password='"+pwd.getText()+"' WHERE iduser='"+u.getId()+"';");
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setHeaderText(null);
                    alert1.setTitle("WARRNING");
                    alert1.setContentText("Select Row befor update !");

                    alert1.showAndWait();
                    initialize();
                }

                initialize();
            }
            else
            {
                initialize();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Invalid Password!");

            alert.showAndWait();
        }
    }



    public void resetLevel()
    {
        user u=new user();

        if(access1.getValue().equals("6"))
        {

            if (c1.isSelected()||c2.isSelected()||c3.isSelected()||c4.isSelected()||c5.isSelected()||c6.isSelected()||c7.isSelected()||c8.isSelected()||c9.isSelected()||c10.isSelected()||c11.isSelected()||c12.isSelected()||c13.isSelected()||c14.isSelected()||c15.isSelected()||c16.isSelected()||c17.isSelected()||c18.isSelected())
            {

                String code = generateCode();

                ObservableList<user> temp = FXCollections.observableArrayList();
                u = table1.getSelectionModel().getSelectedItem();

                try {
                    u.edit("UPDATE user SET level='"+access1.getValue()+"', extra='"+code+"' WHERE iduser='"+u.getId()+"'");
                }

                catch (Exception e) {
                    System.out.print(e.getMessage());
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setHeaderText(null);
                    alert1.setTitle("WARRNING");
                    alert1.setContentText("Select Row befor update !");

                    alert1.showAndWait();
                    initialize();
                }
                initialize();
            }
            else
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("WARRNING");
                    alert.setContentText("Select the custome privilages!");
                    Optional<ButtonType> result = alert.showAndWait();

                    initialize();
            }






        }
        else {

            if (!access1.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Dialog");
                alert.setContentText("Do You need to change user level");


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    ObservableList<user> temp = FXCollections.observableArrayList();
                    u = table1.getSelectionModel().getSelectedItem();

                    try {
                        u.edit("UPDATE user SET level='" + access1.getValue() + "' WHERE iduser='" + u.getId() + "';");
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                        Alert alert1 = new Alert(Alert.AlertType.WARNING);
                        alert1.setHeaderText(null);
                        alert1.setTitle("WARRNING");
                        alert1.setContentText("Select Row befor update !");

                        alert1.showAndWait();
                        initialize();
                    }


                    initialize();
                } else {
                    initialize();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("WARRNING");
                alert.setContentText("Select User Level !");

                alert.showAndWait();
            }
        }
    }

    public String generateCode()
    {
        String code="";

        if(c1.isSelected())
        {
            code=code+"01";
        }
        else
        {
            code=code+"00";
        }
        if(c2.isSelected())
        {
            code=code+"02";
        }
        else
        {
            code=code+"00";
        }
        if(c3.isSelected())
        {
            code=code+"03";
        }
        else
        {
            code=code+"00";
        }
        if(c4.isSelected())
        {
            code=code+"04";
        }
        else
        {
            code=code+"00";
        }
        if(c5.isSelected())
        {
            code=code+"05";
        }
        else
        {
            code=code+"00";
        }
        if(c6.isSelected())
        {
            code=code+"06";
        }
        else
        {
            code=code+"00";
        }
        if(c7.isSelected())
        {
            code=code+"07";
        }
        else
        {
            code=code+"00";
        }
        if(c8.isSelected())
        {
            code=code+"08";
        }
        else
        {
            code=code+"00";
        }
        if(c9.isSelected())
        {
            code=code+"09";
        }
        else
        {
            code=code+"00";
        }
        if(c10.isSelected())
        {
            code=code+"10";
        }
        else
        {
            code=code+"00";
        }
        if(c11.isSelected())
        {
            code=code+"11";
        }
        else
        {
            code=code+"00";
        }
        if(c12.isSelected())
        {
            code=code+"12";
        }
        else
        {
            code=code+"00";
        }
        if(c13.isSelected())
        {
            code=code+"13";
        }
        else
        {
            code=code+"00";
        }
        if(c14.isSelected())
        {
            code=code+"14";
        }
        else
        {
            code=code+"00";
        }
        if(c15.isSelected())
        {
            code=code+"15";
        }
        else
        {
            code=code+"00";
        }
        if(c16.isSelected())
        {
            code=code+"16";
        }
        else
        {
            code=code+"00";
        }
        if(c17.isSelected())
        {
            code=code+"17";
        }
        else
        {
            code=code+"00";
        }
        if(c18.isSelected())
        {
            code=code+"18";
        }
        else
        {
            code=code+"00";
        }

        return code;
    }

    public void delete()
    {
        if(!uname3.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Delete This Data ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                user u = table2.getSelectionModel().getSelectedItem();
                String query = "DELETE FROM user WHERE iduser='" + uname3.getText() + "'";
                try{
                u.edit(query);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setHeaderText(null);
                    alert1.setTitle("WARRNING");
                    alert1.setContentText("Invalid User ID!");

                    alert1.showAndWait();
                    initialize();
                }



                initialize();
            } else {
                initialize();
                ;
            }

        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Fill Empty Field!");

            alert.showAndWait();
            initialize();
        }

    }


    public void addUser()
    {

        if(!(uname2.getText().equals(""))  && !(name.getText().equals(""))  && (!access2.getSelectionModel().isEmpty())   ) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do You Need to Add This user ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                user u = new user();
                String query = "INSERT INTO user (userName, name, password, level) VALUES ('"+uname2.getText()+"', '"+name.getText()+"', '1234', '"+access2.getValue()+"');";
                try{
                    u.edit(query);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setHeaderText(null);
                    alert1.setTitle("WARRNING");
                    alert1.setContentText("Invalid Entry!");

                    alert1.showAndWait();
                    initialize();
                }



                initialize();
            } else {
                initialize();
                ;
            }

        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("WARRNING");
            alert.setContentText("Fill Empty Field!");

            alert.showAndWait();
            initialize();
        }

    }














}
