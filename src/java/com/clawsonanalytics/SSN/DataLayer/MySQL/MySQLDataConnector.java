/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL;
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
public class MySQLDataConnector {
    
    private Connection connection;
    private MySQLDataSource dataSource;
    
    public MySQLDataConnector(MySQLDataSource dataSource){
        this.setSource(dataSource);
        this.getConnection();
    }
    
    public void setSource(MySQLDataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public MySQLDataSource getSource(){
        return this.dataSource;
    }
    
    private void setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.getSource().getHost(),
                    this.getSource().getUsername(),this.getSource().getPassword());
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.connection = null;
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
