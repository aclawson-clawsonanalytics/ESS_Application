/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Tests.ModelLayer;

import com.clawsonanalytics.ESS.App.ModelLayer.Academics.Course;
import com.clawsonanalytics.ESS.App.ModelLayer.Academics.CourseReference;
import com.clawsonanalytics.ESS.Test.Entity;

import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;

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
    // Static variables
    private static Course SUT;
    private static Entity entity;
    private static TestEnvironment environment;
    
    // Class properties
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        SetupEmptyTestDatabases();
    }
    
    public static void SetupEmptyTestDatabases(){
        environment.Setup();
        try{
            environment.CreateTablesForEntity();
        }catch(Exception e){
            
        }
    }
    
    public static void TearDownTestDatabases(){
        environment.DropForEntity();
    }
    @AfterClass
    public static void tearDownClass() {
        TearDownTestDatabases();
    }
    
    @Before
    public void setUp() {
        SUT = new Course();
    }
    
    @After
    public void tearDown() {
        SUT = null;
        environment.DropRecordsForTestTable(Course.getTablename());
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
    
    public void CanSetReferenceID(){
        
    }
    
    public void CanSetTerm(){
        
    }
    
    
}
