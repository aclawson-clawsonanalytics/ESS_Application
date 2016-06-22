/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.Tests;

import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLDataSource;

//import com.clawsonanalytics.SSN.ModelLayer.RegisteredModel;

import org.junit.Assert;
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
public class TestEvironmentTest {
    public static TestEnvironment SUT;
    public static MySQLManager mysqlManager;
    
    public TestEvironmentTest() {
        mysqlManager = new MySQLManager();
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        SUT = new TestEnvironment();
        SUT.Setup();
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void SetupChangesFocusDB(){
        SUT.Setup();
        Assert.assertEquals(MySQLDataSource.getTestDatabaseName(),MySQLDataSource.getFocusDB());
    }
    
    @Test
    public void TearDownChangesFocusDB(){
        SUT.TearDown();
        String test = MySQLDataSource.getDatabaseName();
        String db = MySQLDataSource.getFocusDB();
        Assert.assertEquals(MySQLDataSource.getDatabaseName(),MySQLDataSource.getFocusDB());
    }
    
    
}
