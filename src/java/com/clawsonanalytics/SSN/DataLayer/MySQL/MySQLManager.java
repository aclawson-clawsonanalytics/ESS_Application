/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL;
import com.clawsonanalytics.SSN.DataLayer.MySQL.StatementManager;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataConnector;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author andrewclawson
 */
public class MySQLManager {
    public MySQLDataConnector Connector = new MySQLDataConnector();
    public StatementManager statementManager = new StatementManager();
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    
    public MySQLManager(){
        this.setStatement();
        
    }
    
    public void SetTestMode(){
        MySQLDataSource.setFocusToTestDB();
        String useString = "USE " + MySQLDataSource.getTestDatabaseName() + ";";
        PrepareStatement(useString);
        try{
            this.getPreparedStatement().execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void SetProductionMode(){
        MySQLDataSource.setFocusToProduction();
    }
    
    public ResultSet getResultSet(){
        return this.resultSet;
    }
    
    public void PrepareStatement(){
        if (this.statementManager.getStatementString()!= null){
            try{
                preparedStatement = Connector.getConnection().prepareStatement(statementManager.getStatementString());
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    // overloaded method for preparing a statement.
    public void PrepareStatement(String aStatement){
        this.statementManager.setStatementString(aStatement);
        try{
            preparedStatement = Connector.getConnection().prepareStatement(statementManager.getStatementString());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private void setStatement(){
        try{
            this.statement = this.Connector.getConnection().createStatement();
        }catch (SQLException e){
            
        }
    }
    
    public Statement getStatement(){
        return this.statement;
    }
    
    public PreparedStatement getPreparedStatement(){
        PrepareStatement();
        return this.preparedStatement;
    }
    
    public void ExecuteQuery(){
        String statementString = statementManager.getStatementString();
        if (this.getPreparedStatement() != null){
            try{
                resultSet = this.getPreparedStatement().executeQuery(statementString);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    public void ExectueUpdate(){
        String statement = statementManager.getStatementString();
        if (this.getPreparedStatement() != null){
            try{
                this.getPreparedStatement().executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void setResultSet(String statementString){
        PrepareStatement(statementString);
        try{
            this.resultSet = this.getPreparedStatement().executeQuery();
        }catch(SQLException e){
            
        }
    }
    
}
