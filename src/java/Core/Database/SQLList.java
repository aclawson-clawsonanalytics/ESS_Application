/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel__;
import java.util.*;
import java.util.ArrayList;
import Core.Database.SQLList;
import java.sql.Array;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.ISQLInterface;
import Core.Database.ConnectionManager;
/**
 *
 * @author andrewclawson
 */
public class SQLList extends ArrayList {
    private String tablename;
    public ArrayList Items;
    
    // Constructor method
    public SQLList(){
        
        
    }
    
    public void setTablename(String string){
        this.tablename = string;
    }
    
    public String getTablename(){
        return tablename;
    }
    
    public void Add(SQLModel__ aListItem){
        
    }
    
    public void Delete(SQLModel__ aListItem){
        
    }
    /*
    public ArrayList All(String mode){
        ConnectionManager manager = new ConnectionManager(mode);
        String sqlString = "SELECT * From " + this.getTablename();
    }
*/
}
