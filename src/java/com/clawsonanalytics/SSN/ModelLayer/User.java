/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.ModelLayer;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel__;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SqlDAO;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLManager;
/**
 *
 * @author andrewclawson
 */
public class User extends SQLModel {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    
    
    // Constructor
    public User() {
        User.setTablename("USERS");
        User.setModelName(User.class.getSimpleName());
    }
    // property getters and setters
    public void setFirstname(String string){
        this.firstname = string;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setLastname(String string){
        this.lastname = string;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public void setEmail(String string){
        this.email = string;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setPassword(String string){
        this.password = string;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    //SQL DAO methods
    @Override
    public SQLModel GetByID(int id){
        MySQLManager mysqlManager = new MySQLManager();
        String selectString = "SELECT * FROM " + User.getTablename()
                +" WHERE id = " + Integer.toString(id) + ";";
        mysqlManager.PrepareStatement(selectString);
        mysqlManager.setResultSet(selectString);
        return this;
    }
    
    @Override
    public void Insert(){
        
    }
    
    @Override
    public void Update(){
        
    }
    
    @Override
    public void Delete(){
        
    }
    
    @Override
    public void WriteObject(){
        
    }
    
    @Override
    public void MapRowToObject(ResultSet result){
        try{
            
            this.setFirstname(result.getString("firstname"));
            this.setLastname(result.getString("lastname"));
        }catch(SQLException e){
            
        }
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = null;
        
        return _validationErrors;
    }
    
    
    
}
