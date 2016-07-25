/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Tests.ModelLayer;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.ESS.Test.ValidAccount;
import com.clawsonanalytics.ESS.Test.ValidUser;
import com.clawsonanalytics.ESS.Test.ValidCampus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author andrewclawson
 */
public class CampusTest {
    private static Campus SUT;
    private static TestEnvironment environment;
    
    // class properties
    private String sutName = "sutName";
    private String sutAddress = "sutAddress";
    private String sutCity = "sutCity";
    private String sutState = "sutState";
    private String sutZip = "sutZip";
    private String sutPO = "sutPO";
    
    private static User accountManager;
    private static String managerFirst = "managerFirst";
    private static String managerLast = "managerList";
    private static String managerEmail = "managerEmail";
    private static String managerPassword = "managerPassword";
    
    private static Account sutAccount;
    private static String sutAccountName = "accountName";
    
    
    public CampusTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        SetupEmptyTestDatabases();
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
    
    
    public void SetupAccountAndManager(){
        sutAccount = new ValidAccount();
        sutAccount.Insert();
        accountManager = new ValidUser();
        accountManager.Insert();
        sutAccount.setManager(accountManager);
        
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(Campus.getTablename(),"CAMPUS");
    }
    
    @Test
    public void CanSetName(){
        SUT.setName(sutName);
        Assert.assertEquals(SUT.getName(), sutName);
       
    }
    
    @Test
    public void CanSetAddress(){
        SUT.setAddress(sutAddress);
        Assert.assertEquals(SUT.getAddress(),sutAddress);
    }
    
    @Test
    public void CanSetCity(){
        SUT.setCity(sutCity);
        Assert.assertEquals(SUT.getCity(), sutCity);
    }
    
    @Test
    public void CanSetState(){
        SUT.setState(sutState);
        Assert.assertEquals(sutState,SUT.getState());
    }
    
    @Test
    public void CanSetZip(){
        SUT.setZip(sutZip);
        Assert.assertEquals(sutZip, SUT.getZip());
    }
    
    @Test
    public void CanSetPO(){
        SUT.setPO(sutPO);
        Assert.assertEquals(sutPO, SUT.getPO());
    }
    
    @Test
    public void MissingPropertiesReturnsMessages(){
        Assert.assertTrue(SUT.GetValidationErrors().contains("Campus must have a name."));
        Assert.assertTrue(SUT.GetValidationErrors().contains("Campus must have an address."));
        Assert.assertTrue(SUT.GetValidationErrors().contains("Campus must have a city."));
        Assert.assertTrue(SUT.GetValidationErrors().contains("Campus must have a state."));
        Assert.assertTrue(SUT.GetValidationErrors().contains("Campus must have a zip code."));
    }
    
    @Test
    public void MissingPropertiesIsInvalid(){
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void CanInsert(){
       SUT = new ValidCampus();
       int  firstCount = Campus.Count();
       SUT.Insert();
       int secondCount = Campus.Count();
       Assert.assertEquals(secondCount,firstCount+1);
        
    }
    
    @Test
    public void CanUpdateName(){
        SUT = new ValidCampus();
        SUT.Insert();
        int sutID = SUT.getID();
        String newName = "newSUTName";
        SUT.setName(newName);
        SUT.Update();
        SUT = null;
        SUT = Campus.GetByID(sutID);
        Assert.assertEquals(SUT.getName(),newName);
        
    }
    
    @Test
    public void CanUpdateAddress(){
        SUT = new ValidCampus();
        SUT.Insert();
        int sutID = SUT.getID();
        String newAddress = "newSUTAddress";
        SUT.setAddress(newAddress);
        SUT.Update();
        SUT = null;
        SUT = Campus.GetByID(sutID);
        Assert.assertEquals(SUT.getAddress(), newAddress);
    }
    
    @Test
    public void CanUpdateCity(){
        SUT = new ValidCampus();
        SUT.Insert();
        int sutID = SUT.getID();
        String newCity = "newSUTCity";
        SUT.setCity(newCity);
        SUT.Update();
        SUT = null;
        SUT = Campus.GetByID(sutID);
        Assert.assertEquals(SUT.getCity(),newCity);
    }
    
    @Test
    public void CanUpdateState(){
        SUT = new ValidCampus();
        SUT.Insert();
        int sutID = SUT.getID();
        String newState = "newSUTState";
        SUT.setState(newState);
        SUT.Update();
        SUT = null;
        SUT = Campus.GetByID(sutID);
        Assert.assertEquals(SUT.getState(),newState);
    }
    
    @Test
    public void CanUpdateZip(){
        SUT =  new ValidCampus();
        SUT.Insert();
        int sutID = SUT.getID();
        String newZip = "newSUTZip";
        SUT.setZip(newZip);
        SUT.Update();
        SUT = null;
        SUT = Campus.GetByID(sutID);
        Assert.assertEquals(SUT.getZip(),newZip);
        
    }
    
    @Test
    public void CanUpdatePO(){
        SUT = new ValidCampus();
        SUT.Insert();
        int sutID = SUT.getID();
        String newPO = "newSUTPO";
        SUT.setPO(newPO);
        SUT.Update();
        SUT = null;
        SUT = Campus.GetByID(sutID);
        Assert.assertEquals(SUT.getPO(),newPO);
    }
    
    @Test
    public void AccountModelIsNotNull(){
        
        Account testAccount = new ValidAccount();
        testAccount.Insert();
        SUT = new ValidCampus();
        SUT.setAccountID(testAccount.getID());
        Assert.assertNotNull(SUT.Account());
        Assert.assertEquals(SUT.Account().getName(), testAccount.getName());
    }
}
