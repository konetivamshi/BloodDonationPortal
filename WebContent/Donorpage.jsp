<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%Class.forName("com.mysql.jdbc.Driver");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor Results</title>
</head>
<body>
	<H1>Donor Results are listed below:</H1>
	<%
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddonationportaldb", "root", "root");
Statement statement = con.createStatement();
ResultSet resultset = statement.executeQuery("select * from donorlist WHERE findbloodgroup=bloodgroup AND findcity=city AND findstate=state");
%>
<TABLE BORDER="1">
           <TR>
                 <TH>Name</TH>
                 <TH>Phone</TH>
                 <TH>Email</TH>
                 <TH>Bloodgroup</TH>
                 <TH>Gender</TH>
                 <TH>Address</TH>
                 <TH>City</TH>
                 <TH>State</TH>
                 
                 
          </TR>
           <% while(resultset.next()){ %>
           <TR>
                <TD> <%= resultset.getString(1) %></TD>
               <TD> <%= resultset.getString(2) %></TD>
               <TD> <%= resultset.getString(3) %></TD>
               <TD> <%= resultset.getString(4) %></TD>
               <TD> <%= resultset.getString(5) %></TD>
               <TD> <%= resultset.getString(7) %></TD>
               <TD> <%= resultset.getString(8) %></TD>
               <TD> <%= resultset.getString(9) %></TD>
          </TR>
           <% } %>
               </TABLE>
</body>
</html>