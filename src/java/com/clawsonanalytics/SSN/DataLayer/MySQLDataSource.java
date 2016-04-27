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
public class MySQLDataSource {
    
    
    private String host;
    private String username;
    private String password;
    private Connection connection;
    
    private static String database;
    private static String testDatabase;
    
    public MySQLDataSource(){
        setHost("jdbc:mysql://localhost:3306/SSN_Application");
        setUsername("SSN_DB_Admin");
        setPassword("ssndbsdmin");
        
    }
    
    public void setHost(String string){
        this.host = string;
    }
    
    public String getHost(){
        return this.host;
    }
    
    public void setUsername(String string){
        this.username = string;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String string){
        this.password = string;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    
    public void setDatabase(String string){
        this.database = string;
    }
    
    public String getDatabaseName(){
        return this.database;
    }
    
    public void setTestDatabase(String string){
        this.testDatabase = string;
    }
    
    public String getTestDatabase(){
        return this.testDatabase;
    }
    
    
}
