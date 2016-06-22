/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.Tests.ModelLayer;

import com.clawsonanalytics.ESS.App.ModelLayer.Academics.Course;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.Test.ValidAccount;
import com.clawsonanalytics.ESS.Test.ValidCampus;
import com.clawsonanalytics.ESS.Test.ValidUser;
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
public class CourseTest {
    private static Course SUT;
    private static TestEnvironment environment;
    
    // Class properties
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        SetupEmptyTestDatabases();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        environment.DropRecordsForTestTable(Course.getTablename());
        environment.DropRecordsForTestTable(User.getTablename());
        environment.DropRecordsForTestTable(Account.getTablename());
    }
    
    public static void SetupEmptyTestDatabases(){
        environment.Setup();
        try{
            environment.CreateTestTableForModelByTablename(Account.getTablename());
            environment.CreateTestTableForModelByTablename(User.getTablename());
            environment.CreateTestTableForModelByTablename(Course.getTablename());
        }catch(Exception e){}
    }
    
    public static void TearDownTestDatabases(){
        //Drop records
        environment.DropRecordsForTestTable(User.getTablename());
        environment.DropRecordsForTestTable(Course.getTablename());
        environment.DropRecordsForTestTable(Account.getTablename());
        
        //Drop Tables
        environment.DropTestTableForModelByTablename(User.getTablename());
        environment.DropTestTableForModelByTablename(Course.getTablename());
        environment.DropTestTableForModelByTablename(Account.getTablename());
        
        environment.TearDown();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(Course.getTablename(),"COURSES");
    }
}
