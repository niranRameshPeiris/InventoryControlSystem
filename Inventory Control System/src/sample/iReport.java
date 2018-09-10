package sample;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;

/**
 * Created by Ramesh on 5/10/2017.
 */
public class iReport
{
    public void generateReport(String path)
    {
        dbconnect conE=new dbconnect();
        Connection con=conE.getConnection();
        try{
            String rpath=path;

            JasperReport jr= JasperCompileManager.compileReport(rpath);
            JasperPrint jp= JasperFillManager.fillReport(jr,null,con);
            JasperViewer.viewReport(jp,false);

            con.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }


    }

    public void generateReportPass(String path,String q)
    {
        dbconnect conE=new dbconnect();
        Connection con=conE.getConnection();
        try{
            String rpath=path;
            JasperDesign jasd= JRXmlLoader.load(rpath);
            String query=q;
            JRDesignQuery Query=new JRDesignQuery();
            Query.setText(query);
            jasd.setQuery(Query);
            JasperReport jr= JasperCompileManager.compileReport(jasd);
            JasperPrint jp= JasperFillManager.fillReport(jr,null,con);
            JasperViewer.viewReport(jp,false);

            con.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }


    }



}
