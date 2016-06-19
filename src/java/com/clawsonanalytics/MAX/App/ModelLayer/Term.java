/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andrewclawson
 */
public class Term extends SQLModel {
    private static String tablename = "TERMS";
    private String school_year;
    private int account_id;
    private String label;
    private Date start_date;
    private Date close_date;
    
    public Term(){
        
    }
    
    public static String getTablename(){
        return Term.tablename;
    }
    public void setYear(String year){
        this.school_year = year;
    }
    
    public String getYear(){
        return this.school_year;
    }
    public void setStartDate(Date date){
        this.start_date = date;
    }
    
    public Date getStartDate(){
        return this.start_date;
    }
    
    public void setCloseDate(Date date){
        this.close_date = date;
    }
    
    public Date getCloseDate(){
        return this.close_date;
    }
    
    public void setAccountID(int id){
        this.account_id = id;
    }
    
    public int getAccountID(){
        return this.account_id;
    }
    
    public void setLabel(String string){
        this.label = string;
    }
    
    public String getLabel(){
        return this.label;
    }
    public Account Account(){
        return Account.GetByID(this.account_id);
    }
    
    public static List<Term> GetAll(){
        List<Term> allTerms = new ArrayList<Term>();
        MySQLManager mysql = new MySQLManager();
        Statement statement;
        ResultSet results;
        String select = "SELECT * FROM " + Term.getTablename() +";";
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(select);
            while(results.next()){
                Term newTerm = Term.MapRowToObject(results);
                allTerms.add(newTerm);
            }
        }catch(SQLException e){}
        return allTerms;
    }
    
    public static Term GetByID(int id){
        List<Term> allTerms = Term.GetAll();
        for(Term term : allTerms){
            if (term.getID() == id){
                return term;
            }
        }
        return null;
    }
    public static int Count(){
        int count = 0;
        Statement statement;
        ResultSet results;
        String select = "SELECT * FROM " + Term.getTablename();
        MySQLManager mysql = new MySQLManager();
        
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(select);
            while(results.next()){
                count = count + 1;
            }
            
        }catch(SQLException e){
            
        }
        return count;
    }
    
    
    public void Insert(){
        if(this.IsValid()){
            String insert = "INSERT INTO " + Term.getTablename() 
                    + " VALUES (?,?,?,?,?,?);";
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            ResultSet keys;
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForInsert(preparedStatement);
                int rowsInserted = preparedStatement.executeUpdate();
                keys = preparedStatement.getGeneratedKeys();
                keys.next();
                int id = keys.getInt(1);
                this.setID(id);
                mysql.Connector.CloseResources();
            }catch(SQLException e){
                e.getMessage();
                
            }
        }
        
    }
    
    
    @Override
    public void Update(){
        if(this.IsValid()){
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            String updateString = "UPDATE TERMS SET "
                    + "account_id = ?, "
                    + "label = ?, "
                    + "year = ?, "
                    + "start_date = ?, "
                    + "close_date = ? WHERE id = ?;";
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(updateString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForUpdate(preparedStatement);
                preparedStatement.executeUpdate();
            }catch(SQLException e){
                e.getMessage();
            }
        }
    }
    
    public PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1, 0); // Set id
            preparedStatement.setInt(2,this.getAccountID()); // Set account_id
            preparedStatement.setString(3,this.getLabel()); // Set label
            preparedStatement.setString(4,this.getYear());
            preparedStatement.setDate(5,this.getStartDate()); // Set start date
            preparedStatement.setDate(6,this.getCloseDate()); // Set end date
        }catch(SQLException e){
            
        }
        return preparedStatement;
    }
    
    public PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1,this.getAccountID());
            preparedStatement.setString(2,this.getLabel());
            preparedStatement.setString(3, this.getYear());
            preparedStatement.setDate(4,this.getStartDate());
            preparedStatement.setDate(5,this.getCloseDate());
            preparedStatement.setInt(6,this.getID());
        }catch(SQLException e){
            
        }
        return preparedStatement;
    }
    
    public static Term MapRowToObject(ResultSet results){
        Term newTerm = new Term();
        try{
            newTerm.setID(results.getInt("id"));
            newTerm.setAccountID(results.getInt("account_id"));
            newTerm.setLabel(results.getString("label"));
            newTerm.setYear(results.getString("year"));
            newTerm.setStartDate(results.getDate("start_date"));
            newTerm.setCloseDate(results.getDate("close_date"));
            return newTerm;
        }catch(SQLException e){}
        return newTerm;
    }
    // Validation Methods
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if (null == this.getYear()){
            _validationErrors.add("Academic term must have a school year.");
        }
        
        if (this.getLabel() ==  null){
            _validationErrors.add("Academic term must have a label.");
        }
        
        if ( !this.getStartDate().before(this.getCloseDate())){
            _validationErrors.add("Check academic term dates.");
        }
        return _validationErrors;
    }
    
    
}
