/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.ModelLayer.Academics;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import static com.clawsonanalytics.ESS.App.ModelLayer.User.getTablename;
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
    
    private int account_id; // Reference to parentAccount id.
    private Account parentAccount;
    private String department;
    private String title;
    private String description;
    
    public static String MISSING_DEPARTMENT = "Course must have a department.";
    public static String MISSING_TITLE = "Course must have a title.";
    public static String MISSING_DESCRIPTION = "Course must have a description.";
    
    
    public Course(){
        
    }
    
    public static String getTablename(){
        return Course.tablename;
    }
    
    public void setAccountID(int id){
        this.account_id = id;
        LoadAccount();
    }
    
    public int getAccountID(){
        return this.account_id;
    }
    
    private void LoadAccount(){
        this.parentAccount = Account.GetByID(this.getAccountID());
    }
    
    public Account Account(){
        if (this.parentAccount == null){
            try{
                LoadAccount();
            }catch(Exception e){
                
            }
        }
        return this.parentAccount;
    }
    
    // Property accessors
    public void setDepartment(String string){
        this.department = string;
    }
    
    public String getDepartment(){
        return this.department;
    }
    
    public void setTitle(String string){
        this.title = string;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setDescription(String string){
        this.description = string;
    }
    
    public String getDescription(){
        return this.description;
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
    
    @Override
    public void Insert(){
        if(this.IsValid()){
            String insert = "INSERT INTO " + Course.getTablename()
                    + " VALUES(?,?,?,?,?);";
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
                
            }
        }
    }
    public PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, this.getAccountID());
            preparedStatement.setString(3,this.getDepartment());
            preparedStatement.setString(4,this.getTitle());
            preparedStatement.setString(5,this.getDescription());
            
        }catch(SQLException e){
            e.getMessage();
        }
        return preparedStatement;
    }
    
    public PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        
        return preparedStatement;
    }
    
    public static Course MapRowToObject(ResultSet results){
        Course newCourse = new Course();
        try{
            newCourse.setID(results.getInt("id"));
            newCourse.setAccountID(results.getInt("account_id"));
            newCourse.setDepartment(results.getString("department"));
            newCourse.setTitle(results.getString("title"));
            newCourse.setDescription(results.getString("description"));
        }catch(SQLException e){}
        
        return newCourse;
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if(this.getDepartment() == null){
            _validationErrors.add(Course.MISSING_DEPARTMENT);
        }
        if(this.getTitle() == null){
            _validationErrors.add(Course.MISSING_TITLE);
            
        }
        if(this.getDescription() == null){
            _validationErrors.add(Course.MISSING_DESCRIPTION);
        }
        return _validationErrors;
    }
}
