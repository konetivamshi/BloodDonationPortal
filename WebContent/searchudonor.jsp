					
						<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.src.koneti.MyDb"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="cssfiles/Donor.css">
</head>
<body>

  <header>
    <img src="images/1.jpg" width="70px" height="90px">
    <h3>TEXAS A&M UNIVERSITY-BLOOD DONATION PORTAL </h3></img>
  </header>
    <nav>
      <ul>
          <li> <a href=Homepage.html>Home </a></li>
          <li> <a href=Donate.html>Donate Blood </a></li>
          <li> <a class="active"  href=Donor.html>Find A Donor </a></li>
          <li> <a  href="#About Us">About Us </a></li>
      </ul>
    </nav>

	<%
        try{
              
        	String fbldgrp = request.getParameter("findbloodgroup");
        	String fcity = request.getParameter("findcity");
        	String fstate = request.getParameter("findstate");
        	
        	MyDb db = new MyDb();
        	Connection con = db.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select name,phone,email,bloodgroup,gender,address,city,state from donorlist where bloodgroup = '"+fbldgrp+"' and city = '"+fcity+"' and state = '"+fstate+"' ");
           
            	
            while(rs.next()) {
            String donorname = rs.getString("name");
            String donorphone = rs.getString("phone");
            String donoremail = rs.getString("email");
            String donorbldgrp = rs.getString("bloodgroup");
            String donorgender = rs.getString("gender");
            String donoraddress = rs.getString("address");
            String donorcity = rs.getString("city");
            String donorstate = rs.getString("state");
           
           
           %>
	<div
		style="background-color: #330D0D; color: #ffffff; margin-top: 20px;">
		<div
			style="margin-left: 200px; padding-top: 20px; padding-bottom: 20px;">
			<label>NAME :</label>
			<%out.println(donorname);%>
			<br /> <label>PHONE :</label>
			<%out.println(donorphone);%>
			<br /> <label>EMAIL :</label>
			<%out.println(donoremail);%>
			<br /> <label>Blood Group :</label>
			<%out.println(donorbldgrp);%>
			<br /> <label>GENDER :</label>
			<%out.println(donorgender);%>
			<br /> <label>ADDRESS :</label>
			<%out.println(donoraddress);%>
			<br /> <label>CITY :</label>
			<%out.println(donorcity);%>
			<br /> <label>STATE :</label>
			<%out.println(donorstate);%>


		</div>
	</div>
	<%
	}
            if(rs.next()!=false){
        		out.print("We are sorry to say that, No donor was found for your required Blood Group!");
        	}
        	  
 }
	
	catch(Exception e){}
	
	
        
        %>

</body>
</html>