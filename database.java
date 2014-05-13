/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author emchepe
 */
public class Database {
    protected Connection conn = null;

    public Connection getConn() {
        return conn;
    }

    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tubespbo", "root", "");

        }
        catch(Throwable ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ResultSet retrieveQuery(String query){
        try {
            PreparedStatement p = conn.prepareStatement(query);
            return p.executeQuery();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int doQuery(String query){//masuk
        try {
            PreparedStatement p = conn.prepareStatement(query);
            return p.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
