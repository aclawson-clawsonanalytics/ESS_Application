/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.ModelLayer.Academics;

import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import static com.clawsonanalytics.ESS.App.ModelLayer.User.getTablename;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andrewclawson
 */
public class CourseInstance extends SQLModel {
    
    private int course_id; // Foreign key relationship to course.
    private int term_id; // Foreign key relationship to term which the course is taught.
    private int primary_instructor_id; //Foreign key relationship to the primary instructor the course is assigned to.
    private int secondary_instructor_id; // Foreign key relationship to the secondary instructor assigned to the course.
    
    
    
    
}
