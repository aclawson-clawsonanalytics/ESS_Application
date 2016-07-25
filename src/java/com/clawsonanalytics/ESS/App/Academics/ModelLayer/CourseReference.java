/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.Academics.ModelLayer;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Account;
import static com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User.getTablename;
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
public class CourseReference extends SQLModel {
    private static String tablename = "COURSE_REFERENCES";
    
    private int account_id; // Reference to parentAccount id.
    private Account parentAccount;
    private String department;
    private String title;
    private String description;
    
    public static String MISSING_DEPARTMENT = "Course must have a department.";
    public static String MISSING_TITLE = "Course must have a title.";
    public static String MISSING_DESCRIPTION = "Course must have a description.";
    
    public int TERM_ID;
    
    
    public CourseReference(){
        
    }
    
    public static String getTablename(){
        return CourseReference.tablename;
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
            //TODO Add exception handling and logging support here
        }finally{
            mysqlManager.Connector.CloseResources();
        }
        return count;
    }
    
    public static List<CourseReference> GetAll(){
        List<CourseReference> all = new ArrayList<CourseReference>();
        String selectString = "SELECT * FROM " + CourseReference.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        Statement statement;
        ResultSet results;
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                CourseReference newUser = CourseReference.MapRowToObject(results);
                all.add(newUser);
            }
        }catch(SQLException e){
            //TODO Add exception handling and logging support here.
        }finally{
            mysqlManager.Connector.CloseResources();
        }
        
        return all;
    }
    
    public static CourseReference GetByID(int id){
        List<CourseReference> allCourses = CourseReference.GetAll();
        for (CourseReference course : allCourses){
            if (course.getID() == id){
                return course;
            }
        }
        return null;
        
    }
    @Override
    public void Insert(){
        if(this.IsValid()){
            String insert = "INSERT INTO " + CourseReference.getTablename()
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
                
            }catch(SQLException e){
                //TODO Add exception handling and logging support here.
            }finally{
                mysql.Connector.CloseResources();
            }
        }
    }
    
    @Override
    public void Update(){
        if(this.IsValid()){
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            String update = "UPDATE COURSE_REFERENCES SET "
                    + "account_id = ?, "
                    + "department = ?, "
                    + "title = ?, "
                    + "description = ? WHERE id = ?;";
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForUpdate(preparedStatement);
                preparedStatement.executeUpdate();
            }catch(SQLException e){
                //TODO Add exception handling and loggin support here.
            }finally{
                mysql.Connector.CloseResources();
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
            //e.getMessage();
        }
        return preparedStatement;
    }
    
    public PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1,this.getAccountID());
            preparedStatement.setString(2,this.getDepartment());
            preparedStatement.setString(3,this.getTitle());
            preparedStatement.setString(4,this.getDescription());
            preparedStatement.setInt(5,this.getID());
        }catch(SQLException e){}
        return preparedStatement;
    }
    
    public static CourseReference MapRowToObject(ResultSet results){
        CourseReference newCourse = new CourseReference();
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
            _validationErrors.add(CourseReference.MISSING_DEPARTMENT);
        }
        if(this.getTitle() == null){
            _validationErrors.add(CourseReference.MISSING_TITLE);
            
        }
        if(this.getDescription() == null){
            _validationErrors.add(CourseReference.MISSING_DESCRIPTION);
        }
        return _validationErrors;
    }
}
