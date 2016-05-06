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
    
    public void ExecuteSQLScript(String sqlFilename){
        try{
            SQLExecutor executor = new SQLExecutor(sqlFilename);
            executor.ExecuteScript();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public class SQLExecutor {
        private FileReader fileReader;
        private StringBuffer stringBuffer;
        private BufferedReader bufferedReader;
        
        public String filename;
        private String lineString;
        
        public SQLExecutor(String aFilename){
            filename = aFilename;
            try{
                fileReader = new FileReader(new File(filename));
                stringBuffer = new StringBuffer();
                bufferedReader = new BufferedReader(this.fileReader);
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        
        public void ExecuteScript() throws SQLException {
            try{
                while((lineString = bufferedReader.readLine()) != null){
                    stringBuffer.append(lineString);
                }
                String[] inst = stringBuffer.toString().split(";");
                for (int i = 0; i<inst.length; i ++){
                    if (!inst[i].trim().equals("")){
                        getStatement().executeUpdate(inst[i]);
                        System.out.println(">>" + inst[i]);
                    }
                }
            }catch (IOException e){
                System.out.println("**** Error: " + e.toString());
            }
        }
    }
  
    
    
}
