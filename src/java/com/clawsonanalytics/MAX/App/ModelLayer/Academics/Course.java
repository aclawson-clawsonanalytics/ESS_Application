/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer.Academics;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.MAX.App.ModelLayer.User;
import static com.clawsonanalytics.MAX.App.ModelLayer.User.getTablename;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andrewclawson
 */
public class Course extends SQLModel {
    private static String tablename = "COURSES";
    
    private String department;
    private String title;
    private String description;
    
    
    public Course(){
        
    }
    
    public static String getTablename(){
        return Course.tablename;
    }
    
    public static int Count(){
        int count = 0;
        ResultSet results;
        Statement statement;
        String selectString = "SELECT * FROM " + getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        
        //mysqlManager.PrepareStatement(selectString);
        try{
            statement = mysqlManager.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            
            while(results.next()){
                count = count+1;
            }
            
        }catch(SQLException e){
            
        }
        return count;
    }
    
    public static List<Course> GetAll(){
        List<Course> all = new ArrayList<Course>();
        String selectString = "SELECT * FROM " + Course.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        Statement statement;
        ResultSet results;
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                Course newUser = Course.MapRowToObject(results);
                all.add(newUser);
            }
        }catch(SQLException e){
            
        }
        
        return all;
    }
    
    public PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        
        return preparedStatement;
    }
    
    public PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        
        return preparedStatement;
    }
    
    public static Course MapRowToObject(ResultSet results){
        Course newCourse = new Course();
        
        return newCourse;
    }
}
