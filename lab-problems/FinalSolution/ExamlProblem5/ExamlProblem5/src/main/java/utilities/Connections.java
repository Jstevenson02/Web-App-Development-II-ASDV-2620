/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import edu.slcc.asdv.suppliersparts.ByName;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A. V. Markou
 */
public class Connections
{
     private static final Logger LOG = Logger.getLogger(Connections.class.getName());

    public static void closeDatabaseConnection(Connection con)
            throws SQLException
    {
        try
        {
            if (con != null)
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            Logger.getLogger(ByName.class.getName()).log(Level.WARNING, null, e);
       
            e.printStackTrace();
            throw e;
        }
    }

    public static Connection getConnection()
    {
        Connection con = null;

        try
        {
            con = getConnection("travel", "root", "root", "localhost", "8889", "com.mysql.cj.jdbc.Driver", "jdbc:mysql");
            System.out.println("abc");

        }
        catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {

            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "database travel cannot be loaded.", "");
            LOG.log(Level.SEVERE, msg + "\n" + e.toString());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, msg);

        }
        return con;
    }

    public static Connection getConnection(
            String databaseName, String userName, String password, String ip, String port, String connector, String driver)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        Connection con = null;

        try
        {// Load Sun's jdbc driver
            Class.forName(connector).newInstance();
            System.out.println("Connector Driver loaded!");
        }
        catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) // driver not found
        {
            Logger.getLogger(ByName.class.getName()).log(Level.SEVERE, null, e);

            throw e;
        }

        String url = driver + "://"
                + ip + ":"
                + port + "/"
                + databaseName
                + "?allowPublicKeyRetrieval=true&useSSL=false";

        try
        {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
        }
        catch (SQLException e)
        {
            Logger.getLogger(ByName.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }

        Logger.getLogger(ByName.class.getName()).log(Level.INFO, null, "Connection successfull.");

        return con;
    }
}
