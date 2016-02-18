/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author andrewclawson
 */
public class ConnectionManager {
    public String host = "jdbc:mysql://localhost:3306/SSN_SchoolManagement_Master";
    public String userName = "SSN_DB_Admin";
    public String password = "ssndbadmin";
    public Connection connection = this.GetConnection();
    public Statement statement = null;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    public String errorMessage = null;
    
    public ConnectionManager(){
        
    }
    
    public Connection GetConnection (){
        try {
            connection = DriverManager.getConnection(host, userName, password);
        } catch (SQLException err){
            errorMessage = err.getMessage()+"\n";
            errorMessage = errorMessage + "Connection set to null value.";
            System.out.println(errorMessage);
            connection = null;
        }
        return connection;
    }
    
    public void CloseResources (){
        try {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e){
            errorMessage = "Error Code: " + e.getErrorCode() + "\n"
                    + e.getMessage();
            System.out.println(errorMessage);
        }
    }

}
