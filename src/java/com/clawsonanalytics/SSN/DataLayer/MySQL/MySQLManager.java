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
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author andrewclawson
 */
public class MySQLManager {
    public MySQLDataConnector Connector = new MySQLDataConnector();
    public StatementManager statementManager = new StatementManager();
    public Statement statement;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    
    public MySQLManager(){
        this.setStatement();
        
    }
    
    public void SetTestMode(){
        MySQLDataSource.setFocusToTestDB();
        String useString = "USE " + MySQLDataSource.getFocusDB() + ";";
        try{
            Statement aStatement = Connector.getConnection().createStatement();
            aStatement.execute(useString);
        }catch(SQLException e){
            
        }
    }
    
    public void SetProductionMode(){
        MySQLDataSource.setFocusToProduction();
        String useString = "USE " + MySQLDataSource.getFocusDB() + ";";
        try{
            Statement aStatement = Connector.getConnection().createStatement();
            aStatement.execute(useString);
        }catch(SQLException e){
            
        }
        
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
    
    public void Execute(String sql) throws SQLException {
        if (this.getPreparedStatement() != null){
            try{
                resultSet = this.Connector.getConnection().prepareStatement(sql).executeQuery(sql);
            }catch (SQLException e){
                
            }
        }
    }
    
    public void setResultSet(ResultSet results){
        this.resultSet = results;
    }
    public void ExecuteQuery() throws SQLException {
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
    
    public void runInsert(String sqlString) throws SQLException {
        Connection connection = Connector.getConnection();
        
        
        try{
            statementManager.setStatement(Connector.getConnection().createStatement());
            statementManager.getStatement().executeUpdate(sqlString);
            Connector.CloseResources();
        }catch(SQLException e){
            
        }
        
    }
    
    
    
    public ResultSet runSelectAll(String sqlString) throws SQLException {
        ResultSet results = null;
        Connection connection = Connector.getConnection();
        try{
            Statement statement = connection.createStatement();
            results = statement.executeQuery(sqlString);
        }catch(SQLException e){
            
        }
        return results;
    }
    
    public void setResultSet(String statementString)throws SQLException {
        PrepareStatement(statementString);
        try{
            this.resultSet = this.getPreparedStatement().executeQuery();
        }catch(SQLException e){
            
        }
    }
    
}
