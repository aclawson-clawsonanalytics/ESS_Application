/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.Tests.ModelLayer;
import com.clawsonanalytics.MAX.App.ModelLayer.Account;
import com.clawsonanalytics.MAX.App.ModelLayer.Term;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.MAX.App.ModelLayer.Campus;
import com.clawsonanalytics.MAX.App.ModelLayer.User;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.clawsonanalytics.MAX.Test.ValidAccount;
import com.clawsonanalytics.MAX.Test.ValidUser;
import com.clawsonanalytics.MAX.Test.ValidCampus;
/**
 *
 * @author andrewclawson
 */
public class TermTest {
    private static Term SUT;
    private static TestEnvironment environment;
    
    private static Account account;
    
    private int accound_id;
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
        
        
        //Drop test tables
        environment.DropTestTableForModelByTablename(Account.getTablename());
    }
    
    @Before
    public void setUp() {
        SUT = new Term();
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
}
