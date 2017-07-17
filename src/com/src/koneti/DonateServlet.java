package com.src.koneti;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DonateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
		
		String Name = request.getParameter("name");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		String Bloodgroup = request.getParameter("bloodgroup");
		String Gender = request.getParameter("gender");
		String Dateofbirth = request.getParameter("dateofbirth");
		String Address = request.getParameter("address");
		String City = request.getParameter("city");
		String State = request.getParameter("state");
		String Zipcode = request.getParameter("zipcode");
		String Country=request.getParameter("country");
		String Lastdonated = request.getParameter("lastdonated");
		String Smoke = request.getParameter("smoke");
		String Drink = request.getParameter("drink");
		
		MyDb db = new MyDb();
		Connection con = db.getCon();
		PreparedStatement ps = con.prepareStatement("insert into donorlist values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		    ps.setString(1, Name);
		    ps.setString(2, Phone);
		    ps.setString(3, Email);
		    ps.setString(4, Bloodgroup);
		    ps.setString(5, Gender);
		    ps.setString(6, Dateofbirth);
		    ps.setString(7, Address);
		    ps.setString(8, City);
		    ps.setString(9, State);
		    ps.setString(10, Zipcode); 
		    ps.setString(11, Country);
		    ps.setString(12, Lastdonated);
		    ps.setString(13, Smoke);
		    ps.setString(14, Drink);
		    
		    int i =  ps.executeUpdate();
		    if(i>0) {
		    	out.println("Thank you for donating your blood!");
		    }
		}catch(Exception e2) {
			System.out.println(e2);
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
