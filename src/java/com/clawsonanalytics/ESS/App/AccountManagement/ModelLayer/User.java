/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

//import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel__;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SqlDAO;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
/**
 *
 * @author andrewclawson
 */
public class User extends SQLModel {
    private static String tablename = "USERS";
    private static String modelName = "User";
    //public static List<SQLModel> dependencies;
    
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    //private static List foreignKeyRelations;
    //private static List childModelRelations = new ArrayList();
    private int account_id; //Database Foreign key
    private Account account; // Model
    
    private int campus_id; // Database Foreign key
    private Campus campus; // Model
    
    private int is_account_manager;
    private int is_school_admin;
    private int is_instructor;
    
    
    
    
    // Constructor
    public User() {
        //User.setTablename("USERS");
        //User.setModelName(User.class.getSimpleName());
        foreignKeyRelations.add(Account.class);
        foreignKeyRelations.add(Campus.class);
        
        
    }
    
    public static List<SQLModel> getForeignKeyRelations(){
        return foreignKeyRelations;
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
    
    public void setAccountID(int id){
        this.account_id = id;
    }
    
    public int getAccountID(){
        return this.account_id;
    }
    
    private void LoadAccount(){
        this.account = Account.GetByID(this.account_id);
    }
    
    public Account Account(){
        if(this.account == null){
            LoadAccount();
        }
        return this.account;
    }
    
    public void setCampusID(int id){
        this.campus_id = id;
    }
    
    public int getCampusID(){
        return this.campus_id;
    }
    
    private void LoadCampus(){
        this.campus = Campus.GetByID(this.campus_id);
    }
    
    public Campus Campus(){
        if(this.campus == null){
            LoadCampus();
        }
        return this.campus;
    }
    
    public void setAccountManagerValue(int val){
        this.is_account_manager = val;
    }
    
    public int getAccountManagerValue(){
        return this.is_account_manager;
    }
    
    public void SetupAsManager(){
        this.setAccountManagerValue(1);
    }
    public boolean IsAccountManager(){
        if (this.getAccountManagerValue() == 0){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void setSchoolAdminValue(int val){
        this.is_school_admin = val;
    }
    
    public int getSchoolAdminValue(){
        return this.is_school_admin;
    }
    
    public boolean IsSchoolAdmin(){
        if (this.getSchoolAdminValue() == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public void SetupAsSchoolAdmin(){
        this.setSchoolAdminValue(1);
    }
    
    public void setInstructorValue(int val){
        this.is_instructor = val;
    }
    
    public int getInstructorValue(){
        return this.is_instructor;
    }
    
    public void SetupAsInstructor(){
        this.setInstructorValue(1);
    }
    public boolean IsInstructor(){
        if (this.getInstructorValue() == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    //SQL DAO methods
    
    
    public static String getTablename(){
        return User.tablename;
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
            
        }finally{
            mysqlManager.Connector.CloseResources();
        }
        return count;
    }
    
    public static List<User> GetAll(){
        List<User> all = new ArrayList<User>();
        String selectString = "SELECT * FROM " + User.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        Statement statement;
        ResultSet results;
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                User newUser = User.MapRowToObject(results);
                all.add(newUser);
            }
        }catch(SQLException e){
            
        }finally{
            mysqlManager.Connector.CloseResources();
        }
        
        return all;
    }
    
    public static User GetByID(int id){
        List<User> allUsers = User.GetAll();
        for (User user : allUsers){
            if (user.getID() == id){
                return user;
            }
        }
        
        return null;
        
    }
    /*
    public static User GetByID(int id){
        List<User> allUsers = User.GetAll();
        for (User user : allUsers){
            if (user.getID() == id){
                return user;
        }
        return null;
        
    }
*/
        
    @Override
    public void Insert(){
        if (this.IsValid()){
            String insertString = "INSERT INTO " + getTablename()
                    + " VALUES (?,?,?,?,?,?,?,?,?,?);";
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            ResultSet keys;
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(insertString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForInsert(preparedStatement);
                int rowsInserted = preparedStatement.executeUpdate();
                keys = preparedStatement.getGeneratedKeys();
                keys.next();
                int id = keys.getInt(1);
                this.setID(id);
                mysql.Connector.CloseResources();

            }catch(SQLException e){
                e.getMessage();
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

            String updateString = "UPDATE USERS SET "
                    + "first_name = ?, "
                    + "last_name = ?, "
                    + "email = ?, "
                    + "password = ?, "
                    + "account_id = ?, "
                    + "campus_id = ?, "
                    + "isAccountManager = ?, "
                    + "isSchoolAdmin = ?, "
                    + "isInstructor = ? WHERE id = ?;";
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(updateString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForUpdate(preparedStatement);
                preparedStatement.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                mysql.Connector.CloseResources();
            }
        }
                
        
    }
    
    @Override
    public void Delete(){
        
    }
    
    
    private PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1,0); // set id property
            preparedStatement.setString(2, this.getFirstname()); // set firstname
            preparedStatement.setString(3, this.getLastname()); // set lastname
            preparedStatement.setString(4, this.getEmail()); // set email
            preparedStatement.setString(5, this.getPassword()); // set 
            preparedStatement.setInt(6, this.getAccountID());
            preparedStatement.setInt(7,this.getCampusID());
            preparedStatement.setInt(8, this.getAccountManagerValue());
            preparedStatement.setInt(9, this.getSchoolAdminValue());
            preparedStatement.setInt(10, this.getInstructorValue());
            
            
        }catch (SQLException e){
            
        }
        return preparedStatement;
        
    }
    
    private PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
        try{
            preparedStatement.setString(1,this.getFirstname());
            preparedStatement.setString(2, this.getLastname());
            preparedStatement.setString(3, this.getEmail());
            preparedStatement.setString(4,this.getPassword());
            preparedStatement.setInt(5,this.getAccountID());
            preparedStatement.setInt(6, this.getCampusID());
            preparedStatement.setInt(7, this.getAccountManagerValue());
            preparedStatement.setInt(8, this.getSchoolAdminValue());
            preparedStatement.setInt(9, this.getInstructorValue());
            
            preparedStatement.setInt(10,this.getID());
        }catch(SQLException e){
            
        }
        return preparedStatement;
    }
    
    public static User MapRowToObject(ResultSet result){
        User newUser = new User();
        try{
            newUser.setID(result.getInt("id"));
            newUser.setFirstname(result.getString("first_name"));
            newUser.setLastname(result.getString("last_name"));
            newUser.setEmail(result.getString("email"));
            newUser.setPassword(result.getString("password"));
            newUser.setAccountID(result.getInt("account_id"));
            newUser.setCampusID(result.getInt("campus_id"));
            newUser.setAccountManagerValue(result.getInt("isAccountManager"));
            newUser.setSchoolAdminValue(result.getInt("isSchoolAdmin"));
            newUser.setInstructorValue(result.getInt("isInstructor"));
            //newUser.setCampusID(result.getInt("campus_id"));
            return newUser;
        }catch(SQLException e){
            
        }
        return newUser;
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if (this.getFirstname() == null){
            _validationErrors.add("User must have a firstname.");
        }
        if (this.getLastname() == null){
            _validationErrors.add("User must have a lastname.");
        }
        if (this.getEmail() == null){
            _validationErrors.add("User must have an email.");
        }
        if (this.getPassword() == null){
            _validationErrors.add("User must have a password.");
        }
        return _validationErrors;
    }
    
    public boolean IsAuthenticated(String _email, String _password){
        List<User> userList = User.GetAll();
        for (User user : userList){
            if (user.getEmail().equals(_email) && user.getPassword().equals(_password)){
                return true;
            }
        }
        return false;
    }
    
    public static User GetByCredentials(String _email, String _password){
        List<User> allUsers = User.GetAll();
        for (User user:allUsers){
            if (user.getEmail().equals(_email) && user.getPassword().equals(_password)){
                return user;
            }
        }
        return null;
    }
    
    // The model mapper class is responsible for DB interactions.
    private class ModelMapper {
        public ModelMapper() {
            
        }
        
        private PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
            
            return preparedStatement;
        }
        
        private PreparedStatement PrepareStatementForUpdate(PreparedStatement preparedStatement){
            return preparedStatement;
        }
        
        private User MapResultsToUser(ResultSet results){
            User aUser = new User();
            
            return aUser;
        }
    }
    
    
    
    
    
    
}
