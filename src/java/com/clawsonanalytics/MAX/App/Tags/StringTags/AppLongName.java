/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.Tags.StringTags;
import javax.servlet.jsp.*;
import java.io.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author andrewclawson
 */
public class AppLongName extends SimpleTagSupport{
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("M.A.X. School Solutions");
    }
}
