package com.petshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public PetServlet() {
    	
        super();
    }
    
    // doGet() method creates a connection object to access the database, then creates a sql query to retrieve data
    // after data retrieval, the relevant statements are iterated over in the context of html outputs and sent as a response 
    // to the index.html request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	try {
			PrintWriter out = response.getWriter();
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			DbConnection conn = new DbConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			Statement stmt1 = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
			Statement stmt2 = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
	    	String idNum = request.getParameter("idNum");
			String regex = "([1-4]{1,1})";
			response.setContentType("text/html");
			if(idNum.matches(regex ) == false) {
				out.println("<b>NO SELECTION MADE!!</b>");
				out.println("<a href = 'index.html'>click here to try again...</a>");
			}
			out.println("<html><body style=\"background-color:#009966;\">");
	    	ResultSet pros = stmt1.executeQuery("select id, name from products");
			ResultSet rst = stmt2.executeQuery("select name,color,price from products where id =" + idNum);
			
			out.println("<h1>The Pets Database</h1>");
			out.println("<table border=\"1\"><tr><th>ID</th><th>NAME</th></tr>");
	        while(pros.next()){
	        	out.println("<tr><td>" + pros.getString("id") + "</td>" + "<td>" + pros.getString("name"));
	        }
	        out.println("</table></body></html>");
	    	out.println("Retrieving details for pet # " + idNum);
			out.println("<table border=\"1\"><tr><th>NAME</th><th>COLOR</th><th>PRICE</th></tr>");
	        while(rst.next()){
	        	out.println("<tr><td>" + rst.getString("name") + "</td>" + "<td>" + rst.getString("color")
	        				+ "</td><td>" + rst.getBigDecimal("price") + "</td></tr>");
	        }
	        out.println("</table></body></html>");
			out.println("</table>");
	    	out.println("<a href = 'index.html'>Return to Main Screen</a>");
			stmt1.close();
			stmt2.close();
			out.println("</body></html>");
			conn.closeConnection();
		
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    // doPost() method is sent a request from the index.html file, then that request is sent to the do Get() method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
	}

}
