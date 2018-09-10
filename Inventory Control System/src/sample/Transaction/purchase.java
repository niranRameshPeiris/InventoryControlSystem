package sample.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ramesh on 4/25/2017.
 */
public class purchase extends transaction
{

        private ObservableList<purchase> buy = FXCollections.observableArrayList();

        public purchase()
        {

        }
        public purchase(String transid,String refid,String price,String date)
        {
            super(transid,refid,price,date);
        }

        public ObservableList<purchase> getPurchase()
        {

            Connection con=conE.getConnection();
            try
            {

                st=con.createStatement();
                rs=st.executeQuery("select * from purchase");

                while(rs.next())
                {
                    String idp=rs.getString("idpurchase");
                    String ids=rs.getString("idsupplier");
                    purchase p=new purchase(idp,ids,rs.getString("total"),rs.getString("date"));

                    p.setRefName("select name from supplier where idsupplier='"+ids+"';");
                    p.setNoOfProducts2("select count(idpurchase) from purchase_products where idpurchase='"+idp+"';");
                    buy.add(p);
                }


               con.close();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }



            return buy;
        }

        public ObservableList<purchase> search(String key)
        {


            Connection con=conE.getConnection();
            try
            {

                st=con.createStatement();
                rs=st.executeQuery("select * from purchase");

                while(rs.next())
                {
                    if((key.equals(rs.getString("idpurchase")))||(key.equals(rs.getString("idsupplier")))||(key.equals(rs.getString("total")))||(key.equals(rs.getString("date"))))
                    {

                        String idp=rs.getString("idpurchase");
                        String ids=rs.getString("idsupplier");
                        purchase n=new purchase(idp,ids,rs.getString("total"),rs.getString("date"));
                        n.setRefName("select name from supplier where idsupplier='"+ids+"';");
                        n.setNoOfProducts2("select count(idpurchase) from purchase_products where idpurchase='"+idp+"';");
                        buy.add(n);

                    }
                }


                con.close();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }



            return buy;
        }

        public String getTransactionNo(String query,String id)
        {

            return super.getTransactionNo(query,id);
        }



        public void editPurchase(String Query)
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










    }

















