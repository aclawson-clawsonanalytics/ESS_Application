/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.util.*;
import java.util.ArrayList;
import Core.Database.SQLList;
import java.sql.Array;
import Core.Database.ISQLModel;
/**
 *
 * @author andrewclawson
 */
public class SQLList<T extends ISQLModel> extends ArrayList {
    public ArrayList Items;
    
    // Constructor method
    public SQLList(){
        
        
    }
    
    public void Add(ISQLModel aListItem){
        
    }
}
