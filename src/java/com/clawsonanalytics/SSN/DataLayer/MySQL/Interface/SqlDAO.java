/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL.Interface;
import java.lang.Object;
import java.sql.ResultSet;
/**
 *
 * @author andrewclawson
 */
public interface SqlDAO {
    //public void SetupTable();
    public Object GetByID(int id);
    public void Insert();
    public void Update();
    public void Delete();
    void WriteObject();
    void MapRowToObject(ResultSet result);
    
}
