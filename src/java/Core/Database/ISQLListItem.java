/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import java.sql.Array;
import Core.Database.ConnectionManager;
/**
 *
 * @author andrewclawson
 */
public class ISQLListItem {
    public int ID;
    public Array Table;
    private ConnectionManager ConnectionManager;
    
    public ISQLListItem (){
        this.ConnectionManager = new ConnectionManager();
        this.Table = 
    }
    
}
