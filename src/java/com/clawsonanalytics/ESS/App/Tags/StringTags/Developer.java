/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.Tags.StringTags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
/**
 *
 * @author andrewclawson
 */
public class Developer extends SimpleTagSupport{
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Clawson Analytics, LLC");
    }
}
