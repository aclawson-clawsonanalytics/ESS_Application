/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.Tests.ModelLayer;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;

/**
 *
 * @author andrewclawson
 */
public class AccountTest {
    
    private static Account SUT;
    private static User sutManager;
    private static TestEnvironment environment;
    
    //Account member variables;
    private int SUTmanagerID;
    private String sutName = "sutName";
    private Date SUTcreation;
    private Date SUTclose;
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        SetupEmptyTestDatabases();
        sutManager = new User();
        sutManager.setFirstname("managerFirst");
        sutManager.setLastname("managerLast");
        sutManager.setEmail("managerEmail");
        sutManager.setPassword("managerPassword");
        sutManager.Insert();
    }
    
    @AfterClass
    public static void tearDownClass() {
        environment.DropTestTableForModelByTablename(Account.getTablename());
        environment.DropTestTableForModelByTablename(User.getTablename());
        
    }
    
    @Before
    public void setUp() {
        SUT = new Account();
        SetupEmptyTestDatabases();
        sutManager = new User();
        sutManager.setFirstname("managerFirst");
        sutManager.setLastname("managerLast");
        sutManager.setEmail("managerEmail");
        sutManager.setPassword("managerPassword");
        sutManager.Insert();
    }
    
    @After
    public void tearDown() {
        environment.DropRecordsForTestTable(Account.getTablename());
        environment.DropRecordsForTestTable(User.getTablename());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    // Database helpers
    public static void SetupEmptyTestDatabases(){
        environment.Setup();
        try{
            environment.CreateTestTableForModelByTablename(Account.getTablename());
            environment.CreateTestTableForModelByTablename(User.getTablename());
        }catch(Exception e){
            
        }
    }
    
    public static void TearDownTestDatabases(){
        environment.DropRecordsForTestTable(Account.getTablename());
        environment.DropTestTableForModelByTablename(Account.getTablename());
        environment.TearDown();
    }
    
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals("ACCOUNTS", Account.getTablename());
    }
    
    @Test
    public void CanSetManagerID(){
        SUT.setManager(sutManager.getID());
        Assert.assertEquals(SUT.getManagerID(), sutManager.getID());
        
    }
    
    @Test
    public void CanRetreiveManager(){
        SUT.setManager(sutManager.getID());
        Assert.assertNotNull(SUT.Manager());
        Assert.assertEquals(SUT.Manager().getID(), sutManager.getID());
    }
    
    @Test
    public void CanSetName(){
        SUT.setName(sutName);
        Assert.assertEquals(SUT.getName(),sutName);
    }
    @Test
    public void AccountHasCreationDate(){
        Assert.assertNotNull(SUT.getCreationDate());
    }
    
    @Test
    public void DefaultCloseDateIsNull(){
        Assert.assertNull(SUT.getCloseDate());
    }
    
    @Test
    public void CanInsertAccount(){
        int firstCount = Account.Count();
        SUT.setManager(sutManager.getID());
        SUT.setName(sutName);
        SUT.Insert();
        Assert.assertEquals(firstCount + 1,Account.Count());
    }
    
    @Test
    public void MissingNameReturnsMessage(){
        Assert.assertTrue(SUT.GetValidationErrors().contains("Account must have a name."));
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void CanUpdateAccountName(){
        SUT.setManager(sutManager.getID());
        SUT.setName(sutName);
        String secondName = "secondName";
        SUT.Insert();
        int sutID = SUT.getID();
        SUT.setName(secondName);
        SUT.Update();
        SUT = null;
        SUT = Account.GetByID(sutID);
        Assert.assertEquals(SUT.getName(), secondName);
    }
    
    
}
