/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Tests.ModelLayer;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.Term;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.ESS.App.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.ModelLayer.User;


import java.sql.Date;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import com.clawsonanalytics.ESS.Test.ValidAccount;
import com.clawsonanalytics.ESS.Test.ValidUser;
import com.clawsonanalytics.ESS.Test.ValidCampus;
/**
 *
 * @author andrewclawson
 */
public class TermTest {
    private static Term SUT;
    private static TestEnvironment environment;
    
    private static Account account;
    
    private int accound_id;
    private String year;
    private String sutLabel;
    private Date startDate;
    private Date endDate;
    
    public TermTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        
        SetupEmptyTestDatabases();
        account = new ValidAccount();
        account.Insert();
    }
    
    @AfterClass
    public static void tearDownClass() {
        TearDownTestDatabases();
    }
    
    
    // SETUP DATABASES
    public static void SetupEmptyTestDatabases(){
        environment.Setup();
        try{
            environment.CreateTestTableForModelByTablename(Account.getTablename());
            environment.CreateTestTableForModelByTablename(Term.getTablename());
        }catch(Exception e){
            
        }
    }
    
    public static void TearDownTestDatabases(){
        //Drop records from test tables
        
        environment.DropRecordsForTestTable(Account.getTablename());
        environment.DropRecordsForTestTable(Term.getTablename());
        
        
        //Drop test tables
        environment.DropTestTableForModelByTablename(Account.getTablename());
        environment.DropTestTableForModelByTablename(Term.getTablename());
    }
    
    @Before
    public void setUp() {
        SUT = new Term();
        year = "2015-2016";
        sutLabel = "sutLabel";
        startDate = new Date(new java.util.Date().getTime());
        endDate = new Date(startDate.getTime() + 10*24*60*60*1000);
    }
    
    @After
    public void tearDown() {
        SUT = null;
        environment.DropRecordsForTestTable(Term.getTablename());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals("TERMS", Term.getTablename());
    }
    
    
    @Test
    public void CanSetYear(){
        year = "2015-2016";
        SUT.setYear(year);
        Assert.assertEquals(SUT.getYear(),year);
        
    }
    
    @Test
    public void CanSetLabel(){
        sutLabel = "testLabel";
        SUT.setLabel(sutLabel);
        Assert.assertEquals(SUT.getLabel(),sutLabel);
    }
    @Test
    public void CanSetStartDate(){
        startDate = new Date(Calendar.getInstance().getTime().getTime());
        SUT.setStartDate(startDate);
        Assert.assertEquals(SUT.getStartDate(), startDate);
    }
    
    @Test
    public void CanSetEndDate(){
        endDate = new Date(Calendar.getInstance().getTime().getTime());
        SUT.setCloseDate(endDate);
        Assert.assertEquals(SUT.getCloseDate(),endDate);
    }
    
    @Test
    public void CanSetAccountID(){
        SUT.setAccountID(account.getID());
        Assert.assertEquals(SUT.getAccountID(), account.getID());
    }
    
    @Test
    public void CanLoadAccount(){
        SUT.setAccountID(account.getID());
        Assert.assertNotNull(SUT.Account());
        Assert.assertEquals(SUT.Account().getID(),account.getID());
    }
    
    // Validation Methods
    @Test
    public void MissingSchoolYearReturnsMessage(){
        SUT.setAccountID(account.getID());
        SUT.setLabel(sutLabel);
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        Assert.assertTrue(SUT.GetValidationErrors().contains("Academic term must have a school year."));
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void MissingLabel(){
        SUT.setAccountID(account.getID());
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        SUT.setYear(year);
        Assert.assertTrue(SUT.GetValidationErrors().contains("Academic term must have a label."));
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void StartAndEndDateOutOfSequence(){
        
        SUT.setAccountID(account.getID());
        SUT.setYear(year);
        SUT.setLabel(sutLabel);
        SUT.setStartDate(endDate);
        SUT.setCloseDate(startDate);
        Assert.assertTrue(SUT.GetValidationErrors().contains("Check academic term dates."));
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void CanInsert(){
        int termCount = Term.Count();
        SUT.setAccountID(account.getID());
        SUT.setLabel(sutLabel);
        SUT.setYear(year);
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        SUT.Insert();
        Assert.assertEquals(Term.Count(),termCount+1);
    }
    
    
    public void CanUpdateAccount(){
        
        
        
    }
    
    @Test
    public void CanUpdateLabel(){
        String secondLabel = "newSUTLabel";
        SUT.setAccountID(account.getID());
        SUT.setYear(year);
        SUT.setLabel(sutLabel);
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        SUT.Insert();
        int sutID = SUT.getID();
        SUT.setLabel(secondLabel);
        SUT.Update();
        SUT = null;
        SUT = Term.GetByID(sutID);
        Assert.assertEquals(SUT.getLabel(),secondLabel);
    }
    
    @Test
    public void CanUpdateSchoolYear(){
        String newYear = "2016-2017";
        SUT.setAccountID(account.getID());
        SUT.setYear(year);
        SUT.setLabel(sutLabel);
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        SUT.Insert();
        int sutID = SUT.getID();
        SUT.setYear(newYear);
        SUT.Update();
        SUT = null;
        SUT = Term.GetByID(sutID);
        Assert.assertEquals(SUT.getYear(),newYear);
    }
    
    @Test
    public void CanUpdateStart(){
        Date newStart = new Date(startDate.getTime() + 24*60*60*1000);
        SUT.setAccountID(account.getID());
        SUT.setYear(year);
        SUT.setLabel(sutLabel);
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        SUT.Insert();
        int sutID = SUT.getID();
        SUT.setStartDate(newStart);
        SUT.Update();
        SUT = null;
        SUT = Term.GetByID(sutID);
        Assert.assertEquals(SUT.getStartDate().toString(),newStart.toString());
        
    }
    
    public void CanUpdateEnd(){
        Date newEnd = new Date(endDate.getTime() + 24*60*60*1000);
        SUT.setAccountID(account.getID());
        SUT.setYear(year);
        SUT.setLabel(sutLabel);
        SUT.setStartDate(startDate);
        SUT.setCloseDate(endDate);
        SUT.Insert();
        int sutID = SUT.getID();
        SUT.setStartDate(newEnd);
        SUT.Update();
        SUT = null;
        SUT = Term.GetByID(sutID);
        Assert.assertEquals(SUT.getStartDate().toString(),newEnd.toString());
        
    }
    
}


