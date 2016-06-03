/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer.Interface;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author andrewclawson
 */
public interface ModelMapper {
    public PreparedStatement PrepareStatementForInsert(PreparedStatement ps);
    public PreparedStatement PrepareStatementForUpdate(PreparedStatement ps);
    public Object MapRowToObject(ResultSet rs);
    
}
