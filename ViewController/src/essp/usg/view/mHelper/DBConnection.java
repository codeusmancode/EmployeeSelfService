package essp.usg.view.mHelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author usmanriaz
 */
public class DBConnection {

    /**
     *
     * private static DBConnection _instance; private static String driverClass
     * = "oracle.jdbc.driver.OracleDriver"; private static String
     * connectionString = "jdbc:oracle:thin:@193.168.0.26:1521:PROD"; private
     * static Connection connection;
     *
     * public static Connection getConnection() throws Exception{ if (connection
     * == null){ Class.forName(driverClass); connection =
     * DriverManager.getConnection(connectionString, "custusg", "custusg"); }
     * return connection; }
     *
     */
    private static DBConnection _instance;
    private static String driverClass = "oracle.jdbc.driver.OracleDriver";
    private String connectionString;
    private static Connection connection;
    private String username,password;
    
    public static DBConnection getInstance(String conString,String username,String password) {
        if (_instance == null) {
            _instance = new DBConnection(conString,username,password);
        }
        return _instance;
    }

    private DBConnection(String conString,String username,String password) {
        this.connectionString = conString;
        this.username = username;
        this.password = password;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection Closed.");
            } catch (Exception ex) {
                System.out.println("Error Closing Connection:"+ex.getMessage());
            } finally {
                connection = null;
                System.out.println("Connection nullified.");
            }

        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                System.out.println("CONNECTION OPENED");
                Class.forName(driverClass);
                connection = DriverManager.getConnection(connectionString, username, password);
            } catch (Exception ex) {
                System.out.println("Error Opening Connection:"+ex.getMessage());
            }

        }
        return connection;
    }


}
