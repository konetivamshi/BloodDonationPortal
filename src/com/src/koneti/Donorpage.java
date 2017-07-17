package com.src.koneti;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Donorpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
        	
        	String fbldgrp = request.getParameter("findbloodgroup");
        	String fcity = request.getParameter("findcity");
        	String fstate = request.getParameter("findstate");
        	
        	MyDb db = new MyDb();
        	Connection con = db.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select name,phone,email,bloodgroup,gender,address,city,state from donorlist where bloodgroup = '"+fbldgrp+"' and city = '"+fcity+"' and state = '"+fstate+"' ");
            out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
            		"<html>\r\n" + 
            		"<head>\r\n" + 
            		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
            		"<title>Insert title here</title>\r\n" + 
            		"<link rel=\"stylesheet\" href=\"cssfiles/Donor.css\">\r\n" + 
            		"</head>\r\n" + 
            		"<body>\r\n" + 
            		"\r\n" + 
            		"  <header>\r\n" + 
            		"    <img src=\"images/1.jpg\" width=\"70px\" height=\"90px\">\r\n" + 
            		"    <h3>TEXAS A&M UNIVERSITY-BLOOD DONATION PORTAL </h3></img>\r\n" + 
            		"  </header>\r\n" + 
            		"    <nav>\r\n" + 
            		"      <ul>\r\n" + 
            		"          <li> <a href=Homepage.html>Home </a></li>\r\n" + 
            		"          <li> <a href=Donate.html>Donate Blood </a></li>\r\n" + 
            		"          <li> <a class=\"active\"  href=Donor.html>Find A Donor </a></li>\r\n" + 
            		"          <li> <a  href=\"#About Us\">About Us </a></li>\r\n" + 
            		"      </ul>\r\n" + 
            		"    </nav>\r\n");
            
            
            while(rs.next()) {
            String donorname = rs.getString("name");
            String donorphone = rs.getString("phone");
            String donoremail = rs.getString("email");
            String donorbldgrp = rs.getString("bloodgroup");
            String donorgender = rs.getString("gender");
            String donoraddress = rs.getString("address");
            String donorcity = rs.getString("city");
            String donorstate = rs.getString("state");
            
            out.print("<div\r\n" + 
            		"		style=\"background-color: #330D0D; color: #ffffff; margin-top: 20px;\">\r\n" + 
            		"		<div\r\n" + 
            		"			style=\"margin-left: 200px; padding-top: 20px; padding-bottom: 20px;\">\r\n" + 
            		"			<label>NAME :</label>\r\n" + donorname +
            		"			 \r\n" + 
            		"			<br /> <label>PHONE :</label>\r\n" + donorphone +
            		"			\r\n" + 
            		"			<br /> <label>EMAIL :</label>\r\n" + donoremail +
            		"			\r\n" + 
            		"			<br /> <label>Blood Group :</label>\r\n" + donorbldgrp +
            		"			\r\n" + 
            		"			<br /> <label>GENDER :</label>\r\n" + donorgender +
            		"			\r\n" + 
            		"			<br /> <label>ADDRESS :</label>\r\n" + donoraddress +
            		"			\r\n" + 
            		"			<br /> <label>CITY :</label>\r\n" + donorcity +
            		"			\r\n" + 
            		"			<br /> <label>STATE :</label>\r\n" + donorstate +
            		"			");
           
            }

        
        }catch(SQLException ex) {
            Logger.getLogger(Donorpage.class.getName()).log(Level.SEVERE, null, ex);

        	System.out.println(ex);
        	
        }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);	
		 }

}
