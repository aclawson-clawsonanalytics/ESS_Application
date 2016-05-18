/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.DataLayer.MySQL;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author andrewclawson
 */
public final class MySQLDataConnector {
    
    private Connection connection;
    //private MySQLDataSource dataSource;
    
    public MySQLDataConnector(){
        try{
            this.connectToFocusDB();
        }catch(SQLException e){
            
        }
        //this.ConnectToMySQLSource();
        /*
        try{
            connectToFocusDB();
        }catch(SQLException e){
            
        }
*/
    }
    
    private void ConnectToMySQLSource(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(MySQLDataSource.getHost(),
                    MySQLDataSource.getUsername(),MySQLDataSource.getPassword());
        } catch (SQLException | ClassNotFoundException e){
            //e.printStackTrace();
            this.connection = null;
        }
    }
    
    private void ConnectToMySQLTestSource(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(MySQLDataSource.getTestHost(),
                    MySQLDataSource.getUsername(),MySQLDataSource.getPassword());
        }catch(SQLException | ClassNotFoundException e){
            
        }
        
    }
    
    public void connectToFocusDB() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(MySQLDataSource.getFocusHost(),MySQLDataSource.getUsername(),MySQLDataSource.getPassword());
        }catch(SQLException | ClassNotFoundException e){
            
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void CloseResources(){
        String errorMessage;
        try {
            if (this.getConnection() != null){
                this.getConnection().close();
            }
        } catch (SQLException e){
            errorMessage = "Error Code: " + e.getErrorCode() + "\n"
                    + e.getMessage();
            System.out.println(errorMessage);
        }
    }
    
}
