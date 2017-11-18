package oracleDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OracleManager {

    public Connection conn;
    public Statement stmt;

    public OracleManager(){

    }

    public void buildConnection(){
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            //oracle.jdbc.driver.OracleDriver
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug", "ora_m1l0b", "a28488154");
            //stmt = conn.createStatement();
            System.out.println("Connection Success.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection fail");
        }
    }

    //stringForUpdate is the sql command for executing Inserts, Updates, and Deletes in the DBA
    public int execute(String stringForExecute){
        int rowCount = -1;
        try {
            //System.out.println(targetTable + " before execution -->");
            rowCount = stmt.executeUpdate(stringForExecute);
            System.out.println("row " + rowCount + " updated");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(stringForExecute + " : update fails");
        }
        return rowCount;
    }

    //stringForQuery is the sql command for query
    public ResultSet query(String stringForQuery){
        ResultSet rs = null;
        //System.out.println("00000" + stringForQuery);
        if(stmt==null)
            System.out.println("stmt nullllll");
        try {
            rs = stmt.executeQuery(stringForQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(stringForQuery + " : query fails");
        }
        return rs;
    }

    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("disconnect fails");
        }
    }

    public boolean getIsOpen() {
        Statement stmt = null;
        ResultSet rs =null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT 1 FROM Dual");

            if (rs.next())
                return true;
        }
        catch (SQLException e) {
            return false;
        }
        return false;
    }

}