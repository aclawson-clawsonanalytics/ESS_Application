/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Test;

import com.clawsonanalytics.ESS.App.ModelLayer.Academics.Course;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
/**
 *
 * @author andrewclawson
 */
public class ValidCourse extends Course {
    private static String COURSE_DEPARTMENT = "validCourseDepartement";
    private static String COURSE_TITLE = "validCourseTitle";
    private static String COURSE_DESCRIPTION = "validCourseDescription";
    
    public ValidCourse(){
        this.setDepartment(ValidCourse.COURSE_DEPARTMENT);
        this.setTitle(ValidCourse.COURSE_TITLE);
        this.setDescription(ValidCourse.COURSE_DESCRIPTION);
        
    }
}
