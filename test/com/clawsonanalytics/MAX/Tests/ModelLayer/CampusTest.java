/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.Tests.ModelLayer;
import com.clawsonanalytics.MAX.App.ModelLayer.Account;
import com.clawsonanalytics.MAX.App.ModelLayer.User;
import com.clawsonanalytics.MAX.App.ModelLayer.Campus;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.TestEnvironment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrewclawson
 */
public class CampusTest {
    private static Campus SUT;
    private static TestEnvironment environment;
    
    // class properties
    private String sutName;
    private String sutAddress;
    private String sutState;
    private String sutZip;
    
    public CampusTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        
    }
    
    public static void SetupEmptyTestDatabases(){
        environment.Setup();
        try{
            environment.CreateTestTableForModelByTablename(Campus.getTablename());
            environment.CreateTestTableForModelByTablename(User.getTablename());
            environment.CreateTestTableForModelByTablename(Account.getTablename());
        }catch(Exception e){
            
        }
        
    }
    
    public static void TearDownTestDatabases(){
        //Drop records from test tables
        environment.DropRecordsForTestTable(Campus.getTablename());
        environment.DropRecordsForTestTable(Account.getTablename());
        environment.DropRecordsForTestTable(User.getTablename());
        
        //Drop test tables
        environment.DropTestTableForModelByTablename(Campus.getTablename());
    }
    @AfterClass
    public static void tearDownClass() {
        TearDownTestDatabases();
    }
    
    @Before
    public void setUp() {
        SUT = new Campus();
    }
    
    @After
    public void tearDown() {
        SUT = null;
        environment.DropRecordsForTestTable(Campus.getTablename());
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
