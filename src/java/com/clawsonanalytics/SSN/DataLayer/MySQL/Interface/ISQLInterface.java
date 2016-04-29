/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL.Interface;
import java.sql.Array;
import Core.Database.ConnectionManager;
import Core.Database.SQLList;
import java.util.List;
//import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public interface ISQLInterface {
    
    // SetID method
    // Sets the primary key for the SQLListItem
    void SetIDBySQL(String mode, String tablename);
    
    // Returns the Item's Primary Key
    int GetID();
    
    /* Returns all objects of the parent class from
    the SQL Database
    */
    public void Save();
    
    public void Save(String mode);
    
    public void Delete();
    
    public List<? extends SQLModel__> GetAll();
    
    public List<? extends SQLModel__> GetByID(int id);
    
    public class RowMapper();
    
    
    //abstract ArrayList GetAll();
    
    
    
    
}
