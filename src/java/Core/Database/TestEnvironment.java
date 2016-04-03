/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Database;
import Core.Database.Settings;
import Core.Database.ConnectionManager;
/**
 *
 * @author andrewclawson
 */
public class TestEnvironment {
    //public static ConnectionManager connectionManager;
    public String host;
    public TestEnvironment(){
        //host = Settings.getHost();
    }
    
    public void Setup(){
        //ConnectionManager.setHost(Settings.getTestHost());
    }
    
}
