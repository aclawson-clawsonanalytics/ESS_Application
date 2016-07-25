/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer;

import com.clawsonanalytics.ESS.App.ModelLayer.Interface.IValidatable;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public class Campus extends SQLModel {
    
    // class properties
    private static String tablename = "CAMPUS";
    private static String modelname = "Campus";
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String po_box;
    
    private int account_id; // Foreign key reference to account
    private int principal_id; // Foreign key reference to user who is principal
    private int assistantPrincipal_id; // Foreign key reference ot user who is assistant principal.
    
    private Date creation_date;
    private Date close_date;
    
    //Model layer relations
    private Account parentAccount;
    
    public Campus() {
        foreignKeyRelations.add(Account.class);
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public void setName(String string){
        this.name = string;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setCity(String string){
        this.city = string;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public void setState(String string){
        this.state = string;
    }
    
    public String getState(){
        return this.state;
    }
    
    public void setZip(String string){
        this.zip = string;
    }
    
    public String getZip(){
        return this.zip;
    }
    
    public void setPO(String string){
        this.po_box = string;
    }
    
    public String getPO(){
        return this.po_box;
    }
    
    public void setAccountID(int id){
        this.account_id = id;
        LoadAccount();
    }
    
    public int getAccountID(){
        return this.account_id;
    }
    
    private void LoadAccount(){
        parentAccount = Account.GetByID(this.account_id);
        
    }
    
    public Account Account(){
        if(this.parentAccount == null){
            LoadAccount();
        }
        return this.parentAccount;
    }
    
    public static Campus CreateNullCampus(int accountID){
        Campus nullCampus = new Campus();
        nullCampus.setName("Null");
        nullCampus.setAddress("Null");
        nullCampus.setCity("Null");
        nullCampus.setState("Null");
        nullCampus.setZip("Null");
        nullCampus.setPO("Null");
        nullCampus.setAccountID(accountID);
        return nullCampus;
    }
    
    public static int Count(){
        int count = 0;
        ResultSet results;
        Statement statement;
        String selectString = "SELECT * FROM "+  getTablename() + ";";
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while (results.next()){
                count = count + 1;
            }
        }catch(SQLException e){
            
        }
        return count;
    }
    
    public static List<Campus> GetAll(){
        List<Campus> all = new ArrayList<Campus>();
        String selectString = "SELECT * FROM " + Campus.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        Statement statement;
        ResultSet results;
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                Campus newCampus = Campus.MapRowToObject(results);
                all.add(newCampus);
            }
        }catch(SQLException e){
            //TODO Add exception handling and logging support here.
        }finally{
            mysqlManager.Connector.CloseResources();
        }
        
        return all;
    }
    
    public static Campus GetByID(int id){
        List<Campus> allCampuses = Campus.GetAll();
        for (Campus campus : allCampuses){
            if (campus.getID() == id){
                return campus;
            }
        }
        return null;
        
    }
    @Override
    public void Insert(){
        if(this.IsValid()){
            String insertString = "INSERT INTO " + getTablename()
                    + " VALUES (?,?,?,?,?,?,?,?);";
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            ResultSet keys;
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(insertString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForInsert(preparedStatement);
                int rowsUpdated = preparedStatement.executeUpdate();
                keys = preparedStatement.getGeneratedKeys();
                keys.next();
                int id = keys.getInt(1);
                this.setID(id);
                //mysql.Connector.CloseResources();
            }catch(SQLException e){
                //TODO Add more exception handling and logging support here.
            }finally{
                mysql.Connector.CloseResources();
            }
        }
    }
    
    @Override
    public void Update(){
        if (this.IsValid()){
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            String updateString = "UPDATE CAMPUS SET "
                    + "name = ?, "
                    + "address = ?, "
                    + "city = ?, "
                    + "state = ?, "
                    + "zip = ?, "
                    + "po = ?, "
                    + "account_id = ? WHERE id = ?;";
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(updateString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForUpdate(preparedStatement);
                preparedStatement.executeUpdate();
            }catch(SQLException e){
                //TODO Add exception handling and logging support here.
                
            }finally{
                mysql.Connector.CloseResources();
            }
                    
        }
    }
    
    private PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,this.getName());
            preparedStatement.setString(3,this.getAddress());
            preparedStatement.setString(4,this.getCity());
            preparedStatement.setString(5,this.getState());
            preparedStatement.setString(6,this.getZip());
            preparedStatement.setString(7,this.getPO());
            preparedStatement.setInt(8, this.getAccountID());
        }catch(SQLException e){
            
        }
        
        return preparedStatement;
    }
    
    private PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        try{
            
            preparedStatement.setString(1,this.getName());
            preparedStatement.setString(2,this.getAddress());
            preparedStatement.setString(3,this.getCity());
            preparedStatement.setString(4,this.getState());
            preparedStatement.setString(5, this.getZip());
            preparedStatement.setString(6, this.getPO());
            preparedStatement.setInt(7,this.getAccountID());
            preparedStatement.setInt(8, this.getID());
        }catch(SQLException e){
            
        }
        return preparedStatement;
    }
     
    public static Campus MapRowToObject(ResultSet results){
        Campus newCampus = new Campus();
        try{
            newCampus.setID(results.getInt("id"));
            newCampus.setName(results.getString("name"));
            newCampus.setAddress(results.getString("address"));
            newCampus.setCity(results.getString("city"));
            newCampus.setState(results.getString("state"));
            newCampus.setZip(results.getString("zip"));
            newCampus.setPO(results.getString("po"));
            newCampus.setAccountID(results.getInt("account_id"));
        }catch(SQLException e){
           //TODO Add exception handling and logging support here.
        }
        return newCampus;
    }
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if (this.getName() == null){
            _validationErrors.add("Campus must have a name.");
        }
        if (this.getAddress() == null){
            _validationErrors.add("Campus must have an address.");
        }
        
        if (this.getCity() == null){
            _validationErrors.add("Campus must have a city.");
        }
        
        if(this.getState() == null){
            _validationErrors.add("Campus must have a state.");
        }
        
        if (this.getZip() == null){
            _validationErrors.add("Campus must have a zip code.");
        }
        return _validationErrors;
    }
}
