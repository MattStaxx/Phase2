package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Generic success page to keep user informed of trancation staus and provide a healthy flow to the application behavior 
public class Success extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public Success() {
    	
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
        out.println("<html><body style='background-color:#EFF5FB;'>");
		out.println("<h2 style='text-align:center'>Pet Added Successfully</h2>");
		out.println("<html><body style='text-align:center'></br>");
		out.println("<p style='text-align:center;'><a href='index.jsp'>Back to Add Pet Page</a></p><br/>");
        out.println("</body></html>");
	}
}
