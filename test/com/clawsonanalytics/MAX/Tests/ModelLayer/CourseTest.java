/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.Tests.ModelLayer;

import com.clawsonanalytics.MAX.App.ModelLayer.Academics.Course;
import com.clawsonanalytics.MAX.App.ModelLayer.Account;
import com.clawsonanalytics.MAX.App.ModelLayer.Campus;

import com.clawsonanalytics.MAX.App.DataLayer.MySQL.TestEnvironment;

import com.clawsonanalytics.MAX.Test.ValidAccount;
import com.clawsonanalytics.MAX.Test.ValidCampus;
import com.clawsonanalytics.MAX.Test.ValidUser;
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
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
}
