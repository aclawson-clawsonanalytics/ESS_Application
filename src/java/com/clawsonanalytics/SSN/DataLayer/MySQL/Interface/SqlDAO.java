/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL.Interface;
import java.util.List;
import java.lang.Object;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author andrewclawson
 */
public interface SqlDAO {
    //public void SetupTable();
    public void setID(int id);
    public void SetIDBySQL();
    
    //public List GetAll();
    
    public void Insert();
    public void Update();
    public void Delete();
    PreparedStatement WriteObject(PreparedStatement preparedStatement);
    void MapRowToObject(ResultSet result);
    
}
