package sample.Management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Ramesh on 4/30/2017.
 */
public class finalViewTableController1
{

        @FXML
        private TableView<expenditure> table;
        @FXML
        private TableColumn<expenditure, String> c1;
        @FXML
        private TableColumn<expenditure, String> c2;
        @FXML
        private TableColumn<expenditure, String> c3;
        @FXML
        private TableColumn<expenditure, String> c4;
        @FXML
        private TableColumn<expenditure, String> c5;
        @FXML
        private TableColumn<expenditure, String> c6;
        @FXML
        private TableColumn<expenditure, String> c7;
        @FXML
        private TableColumn<expenditure, String> c8;

        @FXML
        private Label tot;






        public void initialize()
        {

            view();
            calTot();

        }


        public void view()
        {

            ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
            expenditure i= new expenditure();
            temp2=i.getNotpaidExpenditure();


            c1.setCellValueFactory(new PropertyValueFactory<>("transid"));
            c2.setCellValueFactory(new PropertyValueFactory<>("date"));
            c3.setCellValueFactory(new PropertyValueFactory<>("refid"));
            c4.setCellValueFactory(new PropertyValueFactory<>("refName"));
            c5.setCellValueFactory(new PropertyValueFactory<>("paidNot"));
            c6.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
            c7.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
            c8.setCellValueFactory(new PropertyValueFactory<>("price"));


            table.setItems(null);
            table.setItems(temp2);

        }

        public void calTot()
        {
            ObservableList<expenditure> temp2 = FXCollections.observableArrayList();
            expenditure i= new expenditure();

            float total=0;
            temp2=i.getNotpaidExpenditure();

            for(int k=0;k<temp2.size();k++)
            {
                total=total+(Float.parseFloat(temp2.get(k).getPrice()));

            }
            tot.setText(String.valueOf(total));
        }

    }
