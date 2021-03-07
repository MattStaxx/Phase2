package com.products;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public Success() {
    	
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
        out.println("<html><body>");
		out.println("<center>Details Added Successfully</center></br>");
		out.println("<center><html><body></center></br>");
		out.println("<center><a href=\"index.jsp\">Back to Add Products Page</a></center></br>");
        out.println("</body></html>");
	}
}
