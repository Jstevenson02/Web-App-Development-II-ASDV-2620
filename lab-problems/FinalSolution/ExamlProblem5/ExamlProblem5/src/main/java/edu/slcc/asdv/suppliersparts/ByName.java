package edu.slcc.asdv.suppliersparts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Connections;

/**
 *
 * @author a. v. markou
 */
@Named(value = "byName")
@SessionScoped
public class ByName implements Serializable
{



    private static final Logger LOG = Logger.getLogger(ByName.class.getName());

    String pname = "";
    String result = "";

    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }
    
    

        public String getConnectionResponse()
    {
        Connection con = Connections.getConnection();

        if (con != null)
        {
            return "<p style=\"color:green\">Connection succesfull! <br />";
        }
        else
        {

            return "<p style=\"color:red\">Connection failed! <br />";
        }

    }

    public void clear()
    {
        pname = "";
        result = "";
    }

    public void viewAll()
    {
        Connection con = Connections.getConnection();
        if (con == null)
        {
            result = "cannot connect to database";
            return;
        }
        String table = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlStr = "SELECT  *  FROM passenger";
        try
        {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
            while (rs.next())
            {

                String pid = rs.getInt(1) + " ";
                String pname = rs.getString(2) + " ";
                String age = rs.getInt(3) + " ";
             
                table += pid + pname + age + "</br>";
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(ByName.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                Connections.closeDatabaseConnection(con);
                // close the resources 
                if (ps != null)
                {
                    ps.close();
                }
            }
            catch (SQLException sqle)
            {
                Logger.getLogger(ByName.class.getName()).log(Level.WARNING, null, sqle);
                sqle.printStackTrace();
            }
        }
        result = table;
    }

    public void viewByName()
    {
        Connection con = Connections.getConnection();
        if (con == null)
        {
            result = "cannot connect to database";
            return;
        }
        String ret = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String s = "%" + pname  ;
        
        String sqlStr = "SELECT *  FROM passenger WHERE pname LIKE ?";
        
        try
        {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            ps.setString(1, s);
            //execute
            rs = ps.executeQuery();
            boolean b = false;
            while (rs.next())
            {
                b = true;
                String s1 = rs.getInt("pid") + " ";
                ret += s1 + " ";
                s1 = rs.getString("pname") + " ";;
                ret += s1;
                s1 = rs.getString("age") + " ";
                ret += s1;
                
                ret += "</br>";
                
            }
            if ( !b)
            {
               ret = this.pname + " doesn't exist.";
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(ByName.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                Connections.closeDatabaseConnection(con);
                if (ps != null)
                {
                    ps.close();
                }
            }
            catch (SQLException sqle)
            {
                Logger.getLogger(ByName.class.getName()).log(Level.WARNING, null, sqle);

                sqle.printStackTrace();
            }
        }
        this.result = ret;
    }


 



    private java.sql.Date stringDateToSqlDate(String sDate)
    {
        java.util.Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            date = sdf.parse(sDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());

    }

    public String getResult()
    {
        return "<p style=\"color:green\">Passengers <br />" + result;

    }

}
