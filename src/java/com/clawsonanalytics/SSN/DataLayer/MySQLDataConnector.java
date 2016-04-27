/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer;
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
        
    }
    
    public void setSource(MySQLDataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public MySQLDataSource getSource(){
        return this.dataSource;
    }
    
    public void setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(dataSource.getHost(),
                    dataSource.getUsername(),dataSource.getPassword());
        } catch (Exception e){
            
        }
    }
    
}
