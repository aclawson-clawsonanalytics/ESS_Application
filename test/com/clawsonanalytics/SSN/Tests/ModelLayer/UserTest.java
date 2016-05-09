/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.Tests.ModelLayer;

import com.clawsonanalytics.SSN.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;
import com.clawsonanalytics.SSN.ModelLayer.User;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrewclawson
 */
public class UserTest {
    private static User SUT;
    private static TestEnvironment environment;
    private String first = "sutFirst";
    private String last = "sutLast";
    private String email = "sutEmail";
    private String password = "sutPassword";
    
    public UserTest() {
        environment = new TestEnvironment();
        environment.Setup("No Data");
        environment.CreateTestTableForModelByTablename(User.getTablename());
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        environment.DropTestTableForModelByTablename(User.getTablename());
        environment.TearDown();
    }
    
    @Before
    public void setUp() {
        SUT = new User();
    }
    
    @After
    public void tearDown() {
        SUT = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals("USERS",User.getTablename());
        
    }
    
    @Test
    public void CanSetModelName(){
        Assert.assertEquals(User.getModelName(), User.class.getSimpleName());
    }
    
    @Test
    public void CanSetFirstName(){
        SUT.setFirstname(first);
        Assert.assertEquals(SUT.getFirstname(),first);
        
    }
    
    @Test
    public void CanSetLastName(){
        SUT.setLastname(last);
        Assert.assertEquals(SUT.getLastname(),last);
    }
    
    @Test
    public void CanSetEmail(){
        SUT.setEmail(email);
        Assert.assertEquals(SUT.getEmail(), email);
    }
    
    @Test
    public void CanSetPassword(){
        SUT.setPassword(password);
        Assert.assertEquals(SUT.getPassword(),password);
    }
    
    
    
    
}
