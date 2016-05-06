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
public class MySQLDataSource {
    
    
    private static String host = "jdbc:mysql://localhost:3306/SSN_Application";
    private static String username = "SSN_DB_Admin";
    private static String password = "ssndbadmin";
    //private Connection connection;
    
    private static String database = "SSN_Application";
    private static String testDatabase = "SSN_Application_Test";
    private static String focusDB = database;
    
    public MySQLDataSource(){
        
    }
    
    public void setHost(String string){
        host = string;
    }
    
    public static String getHost(){
        return host;
    }
    
    public static void setUsername(String string){
        username = string;
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static void setPassword(String string){
        password = string;
    }
    
    public static String getPassword(){
        return password;
    }
    
    
    public static void setDatabaseName(String string){
        database = string;
    }
    
    public static String getTestDatabaseName(){
        return testDatabase;
    }
    public static void setFocusToTestDB(){
        MySQLDataSource.focusDB = MySQLDataSource.getTestDatabaseName();
    }
    
    public static void setFocusToProduction(){
        MySQLDataSource.focusDB = MySQLDataSource.getDatabaseName();
    }
    public static String getDatabaseName(){
        return database;
    }
    
    public static String getFocusDB(){
        return MySQLDataSource.focusDB;
    }
}
