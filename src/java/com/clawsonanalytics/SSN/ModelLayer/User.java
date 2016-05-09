/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.ModelLayer;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
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
    public void Insert(){
        
        
    }
    
    @Override
    public void Update(){
        
    }
    
    @Override
    public void Delete(){
        
    }
    
    @Override
    public PreparedStatement WriteObject(PreparedStatement preparedStatement){
        return preparedStatement;
        
    }
    
    @Override
    public void MapRowToObject(ResultSet result){
        try{
            this.setID(result.getInt("id"));
            this.setFirstname(result.getString("firstname"));
            this.setLastname(result.getString("lastname"));
            this.setEmail(result.getString("email"));
            this.setPassword(result.getString("password"));
        }catch(SQLException e){
            
        }
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = null;
        
        return _validationErrors;
    }
    
    
    
}
